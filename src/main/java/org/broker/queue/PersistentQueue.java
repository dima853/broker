package org.broker.queue;

import org.broker.core.Message;
import org.broker.core.Queue;

import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PersistentQueue implements Queue {

    private final String name;
    private final File queueDirectory;
    private final BlockingQueue<Message> inMemoryQueue = new LinkedBlockingQueue<>();

    public PersistentQueue(String name, String directoryPath) {
        this.name = name;
        this.queueDirectory = new File(directoryPath, name);
        if (!queueDirectory.exists()) {
            queueDirectory.mkdirs();
        }
        loadMessagesFromDisk();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void enqueue(Message message) throws InterruptedException {
        inMemoryQueue.put(message);
        saveMessageToDisk(message);
    }

    @Override
    public Message dequeue() throws InterruptedException {
        Message message = inMemoryQueue.take();
        // TODO: Remove message from disk after successful processing (acks)
        return message;
    }

    @Override
    public int size() {
        return inMemoryQueue.size();
    }

    @Override
    public boolean isEmpty() {
        return inMemoryQueue.isEmpty();
    }

    private void saveMessageToDisk(Message message) {
        File messageFile = new File(queueDirectory, message.getId() + ".msg");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(messageFile))) {
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception properly
        }
    }

    private void loadMessagesFromDisk() {
        File[] messageFiles = queueDirectory.listFiles();
        if (messageFiles != null) {
            for (File messageFile : messageFiles) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(messageFile))) {
                    Message message = (Message) ois.readObject();
                    inMemoryQueue.add(message);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace(); // Handle the exception properly
                }
            }
        }
    }
}
