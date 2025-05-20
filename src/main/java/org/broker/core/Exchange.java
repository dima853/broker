package org.broker.core;

/**
 * An interface that defines the basic operations for messaging.
 * Exchange receives messages from producers and forwards them to one or more queues
 * based on routing rules.
 */
public interface Exchange {

    /**
     * Returns the exchange name.  The exchange name must be unique within the broker.
     *
     * @return is the name of the exchange.
     */
    String getName();

    /**
     * Routes the message to the appropriate queues. The routing logic depends on the type of exchange
     * (direct, fanout, topic, etc.).
     *
     * @param message is a message that needs to be routed. The message must not be null.
     */
    void route(Message message);
}