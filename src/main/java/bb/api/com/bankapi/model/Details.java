package bb.api.com.bankapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Details {

	private String type;
	private String description;
	private String posted;
	private String completed;
	private Balance new_balance;
	private Balance value;
	
}
