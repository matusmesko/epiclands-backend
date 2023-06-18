package sk.meski.epiclands;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@SpringBootApplication
public class EpiclandsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpiclandsApplication.class, args);
	}

}
