package ca.bccdcphl.sequencingruns.entrypoints;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication()
@ComponentScan("ca.bccdcphl.sequencingruns.config")
@EntityScan(basePackages = {"ca.bccdcphl.sequencingruns.infrastructure.persistence.mapping"})
public class SequencingrunsSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SequencingrunsSpringBootApplication.class, args);
	}

}
