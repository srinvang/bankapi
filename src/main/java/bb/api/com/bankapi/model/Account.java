package bb.api.com.bankapi.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {

	private String id;
	private BankRouting bank_routing;
	private List<BankRouting> account_routings;
	//private List<AccountRoutings> account_routings;
	private List<Holder> holders;
}
