package org.broker;

import java.util.concurrent.*;

public class SimpleMessageBroker {

    private final ConcurrentHashMap<String, BlockingQueue<String>> queues = new ConcurrentHashMap<>();

    // Метод для создания очереди
    public void createQueue(String queueName) {
        queues.putIfAbsent(queueName, new LinkedBlockingQueue<>());
    }

    // Метод для отправки сообщения в очередь
    public void sendMessage(String queueName, String message) throws InterruptedException {
        BlockingQueue<String> queue = queues.get(queueName);
        if (queue == null) {
            System.out.println("Queue not found: " + queueName);
            return;
        }
        queue.put(message);  // put() блокируется, пока не появится место в очереди
        System.out.println("Sent message to queue " + queueName + ": " + message);
    }

    // Метод для получения сообщения из очереди
    public String receiveMessage(String queueName) throws InterruptedException {
        BlockingQueue<String> queue = queues.get(queueName);
        if (queue == null) {
            System.out.println("Queue not found: " + queueName);
            return null;
        }
        String message = queue.take(); // take() блокируется, пока в очереди не появится сообщение
        System.out.println("Received message from queue " + queueName + ": " + message);
        return message;
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleMessageBroker broker = new SimpleMessageBroker();
        broker.createQueue("myQueue");

        // Producer
        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    broker.sendMessage("myQueue", "Message " + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Consumer
        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    String message = broker.receiveMessage("myQueue");
                    System.out.println("Consumer received: " + message);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(2000); // Даем время поработать producer и consumer
    }
}