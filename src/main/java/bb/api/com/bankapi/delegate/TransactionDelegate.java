package bb.api.com.bankapi.delegate;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import bb.api.com.bankapi.config.OpenBankApiProperties;
import bb.api.com.bankapi.model.OpenBankAPIResponse;

@Component
public class TransactionDelegate {
	
	@Autowired	
	private OpenBankApiProperties properties;
	
	@Autowired	
	RestTemplate openBankApiRestTemplate;	
	
	private static final String SERVICE_URL_PATTERN = "{serviceUrl}/{bankId}/accounts/{accountId}/public/transactions";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionDelegate.class);
	
	public OpenBankAPIResponse getTransactions(String bankId,String accountId) {
		//OpenBankAPIResponse openBankAPIResponse = new OpenBankAPIResponse();
		
		//String docpath = new File("E:\\bankapi\\src\\main\\resources\\TransactionList.json").getPath();
		ResponseEntity<OpenBankAPIResponse> openBankAPIResponse = ResponseEntity.ok()
				  .body(new OpenBankAPIResponse());
		//try {
			
			
			   URI serviceURI = buildDynamicServiceURI(bankId,accountId);
			   LOGGER.info("url: " + serviceURI);
			  openBankAPIResponse = openBankApiRestTemplate.getForEntity(serviceURI,OpenBankAPIResponse.class);
			  //return OpenBankAPIResponse;
			  
			
			/*
			 * URI serviceURI = buildDynamicServiceURI(bankId,accountId);
			 * LOGGER.info("url: " + service.URI);
			 * 
			 * openBankAPIResponse = new ObjectMapper().readValue(new File(docpath),
			 * OpenBankAPIResponse.class);
			 */
		//}
			  /*catch(IOException e) {
			 LOGGER.error("url: " + e.getMessage());
		}*/
		return openBankAPIResponse.getBody();
		
	}
	
	
	private URI buildDynamicServiceURI(String bankId,String accountId) {
		String serviceUrl = properties.getBankserviceurl();
		return UriComponentsBuilder.fromUriString(SERVICE_URL_PATTERN).buildAndExpand(serviceUrl, bankId, accountId).toUri();
	}	
	
}
