package guru.springframework.msscbreweryclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

//@ConfigurationProperties(prefix = "sfg.brewery", ignoreInvalidFields = false)
//@ConstructorBinding
public class ClientConfig {
	private final String apiHost;

	public ClientConfig(String apiHost) {
		super();
		this.apiHost = apiHost;
	}

	public String getApiHost() {
		return apiHost;
	}
	
	
}
