package com.example.atm.serdes;

import com.example.atm.event.AmountWasDepositedEvent;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.ByteBuffer;
import java.util.Map;

public class AmountWasDepositedEventSerializer implements Serializer<AmountWasDepositedEvent> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String s, AmountWasDepositedEvent data) {
        if (data == null) {
            return null;
        }

        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.putLong(data.getBankAccountId());
        buffer.putLong(data.getAmount());

        return buffer.array();
    }

    @Override
    public byte[] serialize(String topic, Headers headers, AmountWasDepositedEvent data) {
        return Serializer.super.serialize(topic, headers, data);
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
