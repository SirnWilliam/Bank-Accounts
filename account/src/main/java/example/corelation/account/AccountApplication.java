package example.corelation.account;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

@SpringBootApplication
public class AccountApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder application) {
		return application.sources(AccountApplication.class);
	}
	private static final Logger logger = 
			LoggerFactory.getLogger(AccountApplication.class);

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private TransactionRecordRepository transactionRecordRepository;
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
		logger.info("Hello Sirn William");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			
			// Encrypt user passwords using BCryptPasswordEncoder
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
			String userPassword = passwordEncoder.encode("sirn");
			
			// Saving transactions date and time
			Date dateTime = new Date();
			
			// Create new account for a new member and save the member information in the database table call it member
			Member member = new Member("Sirn", "Hirmeza", 29, "sirn.william@gmail.com", "6199873624");
			memberRepository.save(member);
			
			// Getting the member address and saving it in the database table call it address
			Address address = new Address("123 Coleen Ct", "El Cajon", "CA", 92020);
			addressRepository.save(address);
			
			// User information (username, password, role)
			User user = new User("sirn", userPassword, "SIRN");
			userRepository.save(user);
			
			// Save the account to the database table call it account
			Account account = new Account(member, address, user);
			accountRepository.save(account);
			
			// First transaction for the created account 
			TransactionRecord transactionRecord = new TransactionRecord(0, 1500, true, false, dateTime,account);
			transactionRecordRepository.save(transactionRecord);
			
			// Second transaction for the same account
			transactionRecord = new TransactionRecord(1500,500,false,true,dateTime,account);
			transactionRecordRepository.save(transactionRecord);
			
			// New member
			member = new Member("Robina", "Alyadako", 27, "alyadakorobina@yahoo.com", "6193333333");
			memberRepository.save(member);
			
			// Address of the new member
			address = new Address("333 Coleen Ct", "El Cajon", "CA", 92020);
			addressRepository.save(address);
			
			// Username and encrypted password for the new member
			userPassword = passwordEncoder.encode("sam");
			user = new User("sam", userPassword, "SAM");
			userRepository.save(user);
			
			// Insert new account to the database
			account = new Account(member, address, user);
			accountRepository.save(account);
			
			// First transaction for the new account
			transactionRecord = new TransactionRecord(0, 1300, true, false, dateTime,account);
			transactionRecordRepository.save(transactionRecord);
		};	
	}
}
