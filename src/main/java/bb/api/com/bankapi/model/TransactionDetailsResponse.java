package bb.api.com.bankapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDetailsResponse {
	
	private String id;
	private String accountId;
	private String counterpartyAccount;
	private String counterpartyName;
	private String counterPartyLogoPath;
	private String instructedAmount;
	private String instructedCurrency;
	private String transactionAmount;
	private String transactionCurrency;
	private String transactionType;
	private String description;

}
