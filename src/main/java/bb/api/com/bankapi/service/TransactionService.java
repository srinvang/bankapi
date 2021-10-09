package bb.api.com.bankapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import bb.api.com.bankapi.delegate.TransactionDelegate;
import bb.api.com.bankapi.mapper.MapOpenBankToBackBase;
import bb.api.com.bankapi.model.OpenBankAPIResponse;
import bb.api.com.bankapi.model.TransactionDetailsResponse;

@Component
public class TransactionService {
	
	
	@Autowired
	TransactionDelegate transactionDelegate;
	
	
	 // @Autowired MapOpenBankToBackBase mapOpenBankToBackBase;
	 
	
	public TransactionDetailsResponse retrieveTransactions(String bankId,String accountId) {	
		OpenBankAPIResponse openBankAPIResponse = transactionDelegate.getTransactions(bankId, accountId);
		return mapResponse(openBankAPIResponse);
		
		//return mapOpenBankToBackBase.mapBackBaseResponse(openBankAPIResponse);
		
	}
	
	private TransactionDetailsResponse mapResponse(OpenBankAPIResponse openBankAPIResponse) {
		TransactionDetailsResponse transactionDetailsResponse = new TransactionDetailsResponse();
		if(!CollectionUtils.isEmpty(openBankAPIResponse.getTransactions())) {
			transactionDetailsResponse.setId(openBankAPIResponse.getTransactions().get(0).getId());
			transactionDetailsResponse.setAccountId(openBankAPIResponse.getTransactions().get(0).getThis_account().getId());
			transactionDetailsResponse.setCounterpartyName(openBankAPIResponse.getTransactions().get(0).getOther_account().getHolder().getName());
			transactionDetailsResponse.setInstructedAmount(openBankAPIResponse.getTransactions().get(0).getDetails().getValue().getAmount());
			transactionDetailsResponse.setInstructedCurrency(openBankAPIResponse.getTransactions().get(0).getDetails().getValue().getCurrency());
			transactionDetailsResponse.setTransactionAmount(openBankAPIResponse.getTransactions().get(0).getDetails().getValue().getAmount());
			transactionDetailsResponse.setTransactionCurrency(openBankAPIResponse.getTransactions().get(0).getDetails().getValue().getCurrency());
			transactionDetailsResponse.setTransactionType(openBankAPIResponse.getTransactions().get(0).getDetails().getType());
			transactionDetailsResponse.setDescription(openBankAPIResponse.getTransactions().get(0).getDetails().getDescription());
		}
		
		return transactionDetailsResponse;
	} 	

}
