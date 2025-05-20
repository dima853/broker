# Additional Materials
- https://kino.7-gor.ru/Hohpe%20G.%20Enterprise%20Integration%20Patterns.%20Designing%2C%20Building%2C...Solutions%202023/Hohpe%20G.%20Enterprise%20Integration%20Patterns.%20Designing%2C%20Building%2C...Solutions%202023.pdf
# Messaging Patterns

## Basic patterns of interaction
- **Message (66)** - Information exchange between applications via channel
- **Message Channel (60)** is the basic method of communication between applications
- **Message Endpoint (95)** - Connecting the application to the messenger system
- **Messaging (53)** is a fundamental application integration pattern

## Message routing
- **Content-Based Router (230)** - Content-based routing
- **Message Router (78)** - Decentralized Routing
- **Dynamic Router (243)** - Dynamic routing without hard dependencies
- **Recipient List (249)** - Routing to a dynamic list of recipients
- **Routing Slip (301)** - Sequential routing through unknown steps
- **Publish-Subscribe Channel (106)** - Broadcast of events

## Message transformation
- **Message Translator (85)** - Conversion between different data formats
- **Content Enricher (336)** - Adding missing data to the message
- **Content Filter (342)** - Filtering unnecessary data from a message
- **Normalizer (352)** - Processing of semantically equivalent messages in different formats
- **Envelope Wrapper (330)** - Adapting messages to system requirements

## Processing of composite messages
- **Splitter (259)** - Division of a composite message into elements
- **Aggregator (268)** - Combining related messages
- **Resequencer (283)** - Restoring the correct sequence
- **Composed Message Processor (294)** - Processing of composite messages
- **Scatter-Gather (297)** - Parallel processing with aggregation of results

## Flow control
- **Process Manager (312)** - Managing complex process flows
- **Pipes and Filters (70)** - Sequential processing via independent filters
- **Message Dispatcher (508)** - Coordination of processing between consumers

## Reliability and guarantees
- **Guaranteed Delivery (122)** - Guaranteed message delivery
- **Durable Subscriber (522)** - Non-transmission of messages in case of temporary unavailability
- **Idempotent Receiver (528)** - Handling duplicate messages
- **Dead Letter Channel (119)** - Processing of undelivered messages
- **Transactional Client (484)** - Transactional interaction

## Special mechanisms
- **Claim Check (346)** - Optimization of the volume of transmitted data
- **Correlation Identifier (163)** - Comparison of requests and responses
- **Return Address (159)** - Specifying the response address
- **Message Expiration (176)** - Setting the expiration date of the message
- **Format Indicator (180)** - Support for the evolution of data formats

## Testing and debugging
- **Wire Tap (547)** - Inspection of messages in P2P channels
- **Message History (551)** - Message flow analysis
- **Message Store (555)** - Storing messages for reporting
- **Test Message (569)** - Checking the correctness of the processing
- **Channel Purger (572)** - Channel cleaning before tests

## Integration bridges
- **Messaging Bridge (133)** - Connection of different messaging systems
- **Channel Adapter (127)** - Connecting applications to the messenger system
- **Service Activator (532)** - Integration of services via messaging
- **Messaging Gateway (468)** - Encapsulation of access to the messenger system
- **Messaging Mapper (477)** - Mapping of domain objects and messages

## Alternative approaches
- **Command Message (145)** - Calling procedures via messages
- **Document Message (147)** - Data transfer between applications
- **Event Message (151)** - Event transmission
- **Request-Reply (154)** - Request-response via messaging
- **Remote Procedure Invocation (50)** - Remote Procedure Invocation
- **Shared Database (47)** - Integration via a shared database
- **File Transfer (43)** - Integration via files