package pl.piomin.microservices.account.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.netflix.discovery.AbstractDiscoveryClientOptionalArgs;

@Configuration
@ComponentScan("pl.piomin.microservices.account")
public class AccountConfiguration {

	    @Bean
	    public AbstractDiscoveryClientOptionalArgs<?> discoveryClientOptionalArgs() {
	        return new AbstractDiscoveryClientOptionalArgs<Object>() {};
	    }
	
}
