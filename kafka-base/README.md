注意：
1、kafka版本 kafka_2.11-2.0.1.tgz，如果版本偏低的话会造成程序启动失败，错误信息：
    Failed to start bean 'org.springframework.kafka.config.internalKafkaListenerEndpointRegistry'
2、springboot版本 2.1.3.RELEASE

Kafka中有几个概念比较重要：

Producer: 发送消息者
Consumer: 消息消费者
Consumer Group: 消费者团体
Broker: Kafka处理消息的节点，一个集群可以包含多个Brokers
Topic : 发送和消费消息主题
Partition: 储存Topic消息的分区， 每个Topic可以有多个Partitions
Partition Replica: 每个消息分区的副本, 每个Partition可以有多个副本，一般是2-3个

