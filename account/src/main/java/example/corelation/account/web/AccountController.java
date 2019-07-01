package example.corelation.account.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.corelation.account.database.Account;
import example.corelation.account.database.AccountRepository;
import example.corelation.account.database.Address;
import example.corelation.account.database.AddressRepository;
import example.corelation.account.database.Member;
import example.corelation.account.database.MemberRepository;
import example.corelation.account.database.TransactionRecord;
import example.corelation.account.database.TransactionRecordRepository;
import example.corelation.account.database.User;
import example.corelation.account.database.UserRepository;

@RestController
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private TransactionRecordRepository transactionRecordRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/accounts")
	public Iterable<Account> getAccounts() {
		return accountRepository.findAll();
	}
	
	@RequestMapping("/addresses")
	public Iterable<Address> getAddresses() {
		return addressRepository.findAll();
	}
	
	@RequestMapping("/members")
	public Iterable<Member> getMembers() {
		return memberRepository.findAll();
	}
	
	@RequestMapping("/transactions")
	public Iterable<TransactionRecord> getTransactions() {
		return transactionRecordRepository.findAll();
	}
	
	@RequestMapping("/users")
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}
}
