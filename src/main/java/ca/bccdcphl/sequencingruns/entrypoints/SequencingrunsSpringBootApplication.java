package ca.bccdcphl.sequencingruns.entrypoints;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication()
@ComponentScan({"ca.bccdcphl.sequencingruns"})
@EntityScan(basePackages = {"ca.bccdcphl.sequencingruns.domain.model.entities"})
@EnableJpaRepositories("ca.bccdcphl.sequencingruns.repositories")
public class SequencingrunsSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SequencingrunsSpringBootApplication.class, args);
	}

}
