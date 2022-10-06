package guru.springframework.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreInvalidFields = false)
public class BreweryClient {
	public final String BEER_PATH_V1 = "/api/v1/beer/";
	private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
	
	private String apiHost;
	private final RestTemplate restTemplate;
	
	public BreweryClient(RestTemplateBuilder restBuilder) {
		super();
		this.restTemplate = restBuilder.build();
	}
	
	public BeerDto getBeerById(UUID id) {
		return restTemplate.getForObject(beerURL() + id.toString(), BeerDto.class);
	}
	
	public URI saveNewBeer(BeerDto beerDto) {
		return restTemplate.postForLocation(beerURL(), beerDto);
	}
	
	public void updateBeer(UUID id, BeerDto dto) {
		restTemplate.put(beerURL() + id.toString(), dto);
	}
	
	public void deleteBeer(UUID id) {
		restTemplate.delete(beerURL() + id.toString());
	}
	
	public CustomerDto getCustomerById(UUID id) {
		return restTemplate.getForObject(customerURL() + id.toString() , CustomerDto.class);
	}
	
	public URI createNewCustomer(CustomerDto customer) {
		return restTemplate.postForLocation(customerURL(), customer);
	}
	
	public void updateCustomerById(UUID id, CustomerDto dto) {
		restTemplate.put(customerURL() + id.toString(), dto);
	}
	
	public void deleteCustomerById(UUID id) {
		restTemplate.delete(customerURL() + id.toString());
	}

	public void setApiHost(String host) {
		this.apiHost = host;
	}
	
	public String beerURL() {
		return apiHost + BEER_PATH_V1;
	}
	
	public String customerURL() {
		return apiHost + CUSTOMER_PATH_V1;
	}

}
