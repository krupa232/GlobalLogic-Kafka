package pl.krupa.shop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@Slf4j
public class ShopApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(ShopApplication.class, args);
	}

	@KafkaListener(topics = "vehicles-topic", groupId = "vehicles-group")
	public void listen(Vehicle vehicle)
	{
		log.info("Received vehicle: {}", vehicle);
	}
}
