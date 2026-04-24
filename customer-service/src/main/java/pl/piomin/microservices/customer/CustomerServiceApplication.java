package pl.piomin.microservices.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.netflix.discovery.shared.transport.jersey3.Jersey3TransportClientFactories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
	 @Bean
	 public Jersey3TransportClientFactories jersey3TransportClientFactories() {
	        return new Jersey3TransportClientFactories();
	    }

}
