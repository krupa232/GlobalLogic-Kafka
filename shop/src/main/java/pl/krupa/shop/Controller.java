package pl.krupa.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka/")
public class Controller
{
    @Autowired
    KafkaProducer kafkaProducer;


    @PostMapping("/producer")
    public String sendMessage(@RequestBody Vehicle vehicle)
    {
        kafkaProducer.send(vehicle);
        return "Message sent successfully! It works!";
    }

}
