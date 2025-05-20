package org.broker.core;

/**
 * The interface representing the connection between exchange and queue.  Binding defines the rules,
 * which messages from exchange are sent to a specific queue.
 */
public interface Binding {

    /**
     * Returns the name of the exchange to which the queue is linked.
     *
     * @return is the name of the exchange.
     */
    String getExchangeName();

    /**
     * Returns the name of the queue associated with exchange.
     *
     * @return Queue name.
     */
    String getQueueName();

    /**
     * Returns the routing key for binding. The routing key is used to filter messages.,
     * being sent to the queue.  The value of the routing key depends on the type of exchange.
     *
     * @return routing key. It can be null if binding does not use the routing key.
     */
    String getRoutingKey();

    /**
     * Checks whether the message meets the binding conditions.  This method is used
     * exchange to determine if a message needs to be sent to a given queue.
     *
     * @param message is a message that needs to be checked. The message must not be null.
     * @return true if the message meets the binding conditions, otherwise false.
     */
    boolean match(Message message);
}