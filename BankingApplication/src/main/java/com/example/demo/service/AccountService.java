package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.repo.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	public Account creaAccount(Account account) {
		return accountRepository.save(account);
	}
	
	public Optional<Account> getAccount(Long id){
		return accountRepository.findById(id);	
	}
	
	public Account deposit(long id , double amount) {
		Account account=getAccount(id).orElseThrow(()-> new RuntimeException("Account not Found"));
		account.setBalance(account.getBalance()+ amount);
		return accountRepository.save(account);
	}
	
	public Account withdraw(long id , double amount) {
		Account account=getAccount(id).orElseThrow(()-> new RuntimeException("Account not Found"));
		if(account.getBalance() < amount) {
			throw new RuntimeException("Insufficent Balanace");
		}
		account.setBalance(account.getBalance() - amount);
		return accountRepository.save(account);
		}
		
	}
	
