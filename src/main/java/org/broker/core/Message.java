package org.broker.core;

import java.util.Map;

/**
 * Interface, which is a message passed between the broker components.
 */
public interface Message {

    /**
     * Returns the unique identifier of the message.  This identifier must be unique.
     * within the entire message broker.
     *
     * @return is the unique identifier of the message.
     */
    String getId();

    /**
     * Returns the body of the message. The message body contains the data that needs to be transmitted.
     * The type of the message body can be any (Object), but it is recommended to use
     * Serializable types to support persistent message storage.
     *
     * @return Message body.
     */
    Object getPayload();

    /**
     * Sets the message body.
     *
     * @param payload Message body.
     */
    void setPayload(Object payload);


    /**
     * Returns a map of the message headers.  Headers are used to transmit metadata.
     * about the message (for example, message type, priority, sender ID).
     *
     * @return Message header map. The key is the header name (String), the value is the header value (Object).
     */
    Map<String, Object> getHeaders();

    /**
     * Adds a title to the message. If a header with that name already exists, its value will be overwritten.
     *
     * @param key is the name of the header.
     * @param value is the value of the header.
     */
    void addHeader(String key, Object value);

    /**
     * Sets all message headers. The headers will overwrite the existing ones.
     *
     * @param headers Message headers.
     */
    void setHeaders(Map<String, Object> headers);

    /**
     * Returns the value of the header by its name.
     *
     * @param key is the name of the header.
     * @return The header value or null if the header is not found.
     */
    Object getHeader(String key);
}