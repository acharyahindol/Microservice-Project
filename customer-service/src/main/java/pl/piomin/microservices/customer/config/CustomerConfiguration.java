package pl.piomin.microservices.customer.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.netflix.discovery.AbstractDiscoveryClientOptionalArgs;

@Configuration
@ComponentScan("pl.piomin.microservices.customer")
public class CustomerConfiguration {

	@Bean
    public AbstractDiscoveryClientOptionalArgs<?> discoveryClientOptionalArgs() {
        return new AbstractDiscoveryClientOptionalArgs<Object>() {};
    }
	
}
