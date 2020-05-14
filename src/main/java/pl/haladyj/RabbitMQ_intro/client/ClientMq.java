package pl.haladyj.RabbitMQ_intro.client;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientMq {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/receiveMessage")
    public String receive(){
        Object message = rabbitTemplate.receiveAndConvert("pawel");
        return message.toString();
    }
}
