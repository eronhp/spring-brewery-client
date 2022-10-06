package guru.springframework.msscbreweryclient.config;

import java.time.Duration;

import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import io.netty.channel.ChannelOption;
import reactor.netty.http.client.HttpClient;

@Component
public class DefaultWebClientCustomizer implements WebClientCustomizer {

	private ClientHttpConnector clientHttpConnector() {

		HttpClient httpClient = HttpClient.create().secure(spec -> {
		});
		httpClient.responseTimeout(Duration.ofSeconds(5));
		httpClient.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);

		return new ReactorClientHttpConnector(httpClient);
	}

	@Override
	public void customize(Builder webClientBuilder) {
		webClientBuilder.clientConnector(this.clientHttpConnector());

	}

}
