package bb.api.com.bankapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionAttributes {

	private String transaction_attribute_id;
	private String name;
	private String type;
	private String value;
}
