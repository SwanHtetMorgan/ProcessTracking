package dev.swanhtet.learning.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private  String password;

    private String ConsumerName;

    public Consumer() {
    }

    public Consumer(String password, String consumerName) {
        this.password = password;
        this.ConsumerName = consumerName;
    }

    public String getPassword() {
        return password;
    }


    public String getConsumerName() {
        return ConsumerName;
    }
}
