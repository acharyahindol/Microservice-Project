package pl.piomin.microservices.gateway;

import java.util.Optional;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

@Configuration
public class RateLimitingConfig {

	@Bean
	KeyResolver clientIpKeyResolver() {
		return exchange -> Mono.just(Optional.ofNullable(exchange.getRequest().getRemoteAddress())
				.map(address -> address.getAddress().getHostAddress())
				.orElse("anonymous"));
	}
}
