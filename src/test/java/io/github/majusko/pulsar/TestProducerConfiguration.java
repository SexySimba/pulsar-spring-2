package io.github.majusko.pulsar;

import io.github.majusko.pulsar.constant.Serialization;
import io.github.majusko.pulsar.msg.AvroMsg;
import io.github.majusko.pulsar.msg.MyMsg;
import io.github.majusko.pulsar.msg.MyMsg2;
import io.github.majusko.pulsar.msg.ProtoMsg;
import io.github.majusko.pulsar.producer.ProducerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestProducerConfiguration {

    @Bean
    public ProducerFactory producerFactory() {
        return new ProducerFactory()
            .addProducer("topic-for-error", String.class)
            .addProducer("topic-one", MyMsg.class)
            .addProducer("topic-two", MyMsg2.class, Serialization.JSON)
            .addProducer("topic-avro", AvroMsg.class, Serialization.AVRO)
            .addProducer("topic-async", MyMsg.class)
            .addProducer("topic-message", MyMsg.class)
            .addProducer("topic-retry", MyMsg.class)
            .addProducer("topic-string", String.class, Serialization.STRING)
            .addProducer("topic-byte")
            .addProducer("topic-proto", ProtoMsg.class, Serialization.PROTOBUF);
    }
}
