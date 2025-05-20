package org.broker.core;

/**
 * An interface that defines the basic operations for working with a message queue.
 * A queue is used to store messages waiting to be processed by consumers.
 */
public interface Queue {

    /**
     * Returns the queue name.  The queue name must be unique within the broker.
     *
     * @return Queue name.
     */
    String getName();

    /**
     * Adds a message to the end of the queue. If the queue has a limited size, this method may be blocked.,
     * until there is a free place in the queue.
     *
     * @param message A message to add. The message must not be null.
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    void enqueue(Message message) throws InterruptedException;

    /**
     * Retrieves and deletes a message from the front of the queue.  If the queue is empty, this method should be blocked.,
     * until a message appears in the queue.
     *
     * @return Message from queue. The message cannot be null.
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    Message dequeue() throws InterruptedException;

    /**
     * Returns the current queue size (the number of messages in the queue).
     *
     * @return Queue size.
     */
    int size();

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, otherwise false.
     */
    boolean isEmpty();
}