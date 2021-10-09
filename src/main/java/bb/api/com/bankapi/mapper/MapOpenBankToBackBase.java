package bb.api.com.bankapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import bb.api.com.bankapi.model.OpenBankAPIResponse;
import bb.api.com.bankapi.model.TransactionDetailsResponse;

@Mapper(componentModel="spring")
public interface MapOpenBankToBackBase {
	
	@Mapping(target = "id", source = "transactions.id")
	@Mapping(target = "accountId", source = "transactions.this_account.id")
	//@Mapping(target = "counterpartyAccount", source = "transactions.other_account.holder.name")
	@Mapping(target = "counterpartyName", source = "transactions.other_account.holder.name")
	//@Mapping(target = "counterPartyLogoPath", source = "")
	@Mapping(target = "instructedAmount", source = "transactions.details.value.amount")
	@Mapping(target = "instructedCurrency", source = "transactions.details.value.currency")
	@Mapping(target = "transactionAmount", source = "transactions.details.value.amount")
	@Mapping(target = "transactionCurrency", source = "transactions.details.value.currency")
	@Mapping(target = "transactionType", source = "transactions.details.type")
	@Mapping(target = "description", source = "transactions.details.description")	
	TransactionDetailsResponse mapBackBaseResponse(OpenBankAPIResponse openBankAPIResponse);
}
