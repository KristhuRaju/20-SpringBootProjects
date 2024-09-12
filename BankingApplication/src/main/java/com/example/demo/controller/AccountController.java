package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping
	public Account createAccount(@RequestBody Account account) {
		return accountService.creaAccount(account);
	}
	
	@GetMapping("/{id}")
	public Account getAccount(@PathVariable long id) {
		return accountService.getAccount(id).orElseThrow(()-> new RuntimeException("Account not found "));
	}
	 @PostMapping("/{id}/deposit")
	public Account deposit(@PathVariable long id, @RequestBody Map<String, Double> request) {
		Double ammount = request.get("Ammount ");
		return accountService.deposit(id, ammount);
	}

	    @PostMapping("/{id}/withdraw")
	 public Account withdraw(@PathVariable long id, @RequestBody Map<String, Double> request) {
		Double amount= request.get("Ammount");
		return accountService.withdraw(id, amount);
	 }
}
