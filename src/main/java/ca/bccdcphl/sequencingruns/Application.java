package ca.bccdcphl.sequencingruns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


@SpringBootApplication()
@ComponentScan({"ca.bccdcphl.sequencingruns"})
@EntityScan(basePackages = {"ca.bccdcphl.sequencingruns.model"})
@EnableJpaRepositories("ca.bccdcphl.sequencingruns.repositories")
@EnableGlobalMethodSecurity(securedEnabled = true)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
