package guru.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;

@SpringBootTest
class BreweryClientTest {
	@Autowired
	BreweryClient client;
	
	@Test
	void getBeerById() {
		BeerDto dto = client.getBeerById(UUID.randomUUID());
		assertNotNull(dto);
	}
	
	@Test
	void testSaveNewBeer() {
		BeerDto dto  = BeerDto.builder().beerName("Eron Lagger").build();
		URI uri = client.saveNewBeer(dto);
		assertNotNull(uri);
		System.out.println(uri.toString());
	}
	
	@Test
	void testUpdateBeer() {
		BeerDto dto  = BeerDto.builder().beerName("Eron Lagger").build();
		client.updateBeer(UUID.randomUUID(), dto);
	}
	
	@Test
	void testDelete() {
		client.deleteBeer(UUID.randomUUID());
	}
	
	@Test
	void testGetCustomerById() {
		CustomerDto dto = client.getCustomerById(UUID.randomUUID());
		assertNotNull(dto);
	}
	
	@Test
	void testCreateNewCustomer() {
		URI customerLocation = client.createNewCustomer(CustomerDto.builder().build());
		assertNotNull(customerLocation);
	}
	
	@Test
	void testUpdateCustomerById() {
		UUID id = UUID.randomUUID();
		CustomerDto dto = CustomerDto.builder().build();
		client.updateCustomerById(id, dto);
	}
	
	@Test
	void testDeleteCustomerById() {
		UUID id = UUID.randomUUID();
		client.deleteCustomerById(id);
	}

}
