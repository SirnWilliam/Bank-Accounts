package example.corelation.account;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
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

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TransactionRecordRepository transactionRecordRepository;

	@Test
	public void saveAccount() {

		// Encrypt user passwords using BCryptPasswordEncoder
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
		String userPassword = passwordEncoder.encode("sirn");

		// Saving transactions date and time
		Date dateTime = new Date();

		// Create new account for a new member and save the member information in the database table call it member
		Member member = new Member("Sirn", "Hirmeza", 29, "sirn.william@gmail.com", "6199873624");
		entityManager.persistAndFlush(member);
		assertThat(member.getMemberid()).isNotNull();

		// Getting the member address and saving it in the database table call it address
		Address address = new Address("123 Coleen Ct", "El Cajon", "CA", 92020);
		entityManager.persistAndFlush(address);
		assertThat(address.getAddressid()).isNotNull();

		// User information (user name, password, role)
		User user = new User("sirn", userPassword, "SIRN");
		entityManager.persistAndFlush(user);
		assertThat(user.getId()).isNotNull();

		// Save the account to the database table call it account
		Account account = new Account(member, address, user);
		// First transaction for the created account 
		TransactionRecord transactionRecord = new TransactionRecord(0, 1500, true, false, dateTime,account);
		entityManager.persistAndFlush(transactionRecord);
		assertThat(transactionRecord.getTransactionRecordId()).isNotNull();
		entityManager.persistAndFlush(account);
		assertThat(account.getAccountid()).isNotNull();
	}
}
