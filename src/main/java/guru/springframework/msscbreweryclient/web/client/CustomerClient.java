package guru.springframework.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import guru.springframework.msscbreweryclient.config.ClientConfig;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;

//@Component
public class CustomerClient {
	private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
	private final RestTemplate restTemplate;
	private final ClientConfig config;

	public CustomerClient(RestTemplateBuilder builder, ClientConfig config) {
		super();
		this.restTemplate = builder.build();
		this.config = config;
	}
	
	public CustomerDto getCustomerById(UUID id) {
		return restTemplate.getForObject(url() + id.toString() , CustomerDto.class);
	}
	
	public URI createNewCustomer(CustomerDto customer) {
		return restTemplate.postForLocation(url(), customer);
	}
	
	public void updateCustomerById(UUID id, CustomerDto dto) {
		restTemplate.put(url() + id.toString(), dto);
	}
	
	public void deleteCustomerById(UUID id) {
		restTemplate.delete(url() + id.toString());
	}
	
	private String url() {
		return config.getApiHost() + CUSTOMER_PATH_V1;
	}
	
	

}
