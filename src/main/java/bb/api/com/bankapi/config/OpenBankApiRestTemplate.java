package bb.api.com.bankapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenBankApiRestTemplate {

	private RestTemplate openBankServiceTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add((request, body, execution) -> {
			
			
			
			return execution.execute(request, body);
		});
		return restTemplate;
	}
	

	@Bean(name = "default")
	public RestTemplate createBean() {		
		return openBankServiceTemplate();
	}
	
	/*
	 * @Bean(name = "!default") public RestTemplate createBean1() {
	 * System.out.println("another redskyApiRestTemplate"); return
	 * openBankServiceTemplate(); }
	 */
}
