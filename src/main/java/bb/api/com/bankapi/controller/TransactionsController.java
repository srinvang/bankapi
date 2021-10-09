package bb.api.com.bankapi.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import bb.api.com.bankapi.model.TransactionDetailsResponse;
import bb.api.com.bankapi.service.TransactionService;


@RestController
public class TransactionsController {
	
	@Autowired
	TransactionService transactionService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionsController.class);
	
	@GetMapping("banks/{bankId}/accounts/{accountId}/transactions")	
	public ResponseEntity<TransactionDetailsResponse> retrieveProducts(@PathVariable String bankId,
			@PathVariable String accountId,HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.OK).body(transactionService.retrieveTransactions(bankId,accountId));
	}



}
