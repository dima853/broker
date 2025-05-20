package org.broker.queue;

import org.broker.core.Message;
import org.broker.core.Queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class InMemoryQueue implements Queue {

    private final String name;
    private final BlockingQueue<Message> queue; // Используем BlockingQueue

    public InMemoryQueue(String name) {
        this(name, new LinkedBlockingQueue<>());
    }

    public InMemoryQueue(String name, BlockingQueue<Message> queue) {
        this.name = name;
        this.queue = queue;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void enqueue(Message message) throws InterruptedException {
        queue.put(message); // Блокируется, если очередь заполнена
    }

    @Override
    public Message dequeue() throws InterruptedException {
        return queue.take(); // Блокируется, если очередь пуста
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}