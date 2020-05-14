package pl.haladyj.RabbitMQ_intro.publisher;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.haladyj.RabbitMQ_intro.model.JobRequest;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class PublisherMq {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/addMessage")
    public String get(@RequestBody JobRequest request) {

        //message = "'" + message + "'";
        String job = request.getJob();
        BigDecimal salaryLevel = request.getSalary();


        String response = "job,salary" + System.lineSeparator() + job + "," + salaryLevel;

        rabbitTemplate.convertAndSend("profession", response);
        return "sent";
    }

    @GetMapping("/addFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

        byte[] fileData = file.getBytes();
        String fileType = file.getContentType();

        Message message = MessageBuilder.withBody(fileData).setHeader("ContentType", fileType).build();

        rabbitTemplate.send("file", message);

        return "received";
    }

}
