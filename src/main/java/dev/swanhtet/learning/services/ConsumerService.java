package dev.swanhtet.learning.services;

import dev.swanhtet.learning.dao.ConsumerDAQ;
import dev.swanhtet.learning.models.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @Autowired
    private ConsumerDAQ consumerDAQ;


    private Consumer consumer;
    public void SaveConsumer(Consumer consumer){
        consumerDAQ.save(consumer);
    }
}
