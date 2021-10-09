package bb.api.com.bankapi.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transactions {

	private String id;
	private Account this_account;	
	private OtherAccount other_account;
	private Details details;
	private List<TransactionAttributes> transaction_attributes;	
	
}
