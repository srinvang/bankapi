package bb.api.com.bankapi.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenBankAPIResponse {
	
	private List<Transactions> transactions; 

}
