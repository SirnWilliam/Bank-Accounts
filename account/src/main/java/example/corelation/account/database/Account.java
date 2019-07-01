package example.corelation.account.database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accountId;
	
	@OneToOne
	@JoinColumn(name = "member")
	private Member member;
	
	@OneToOne
	@JoinColumn(name = "address")
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
	private List<TransactionRecord> transactionRecord = new ArrayList<TransactionRecord>();
	
	@OneToOne
	@JoinColumn(name = "user")
	private User user;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Member member, Address address, User user) {
		super();
		this.member = member;
		this.address = address;
		this.user = user;
	}

	public long getAccountid() {
		return accountId;
	}

	public void setAccountid(long accountid) {
		this.accountId = accountid;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<TransactionRecord> getTransactionRecord() {
		return transactionRecord;
	}

	public void setTransactionRecord(List<TransactionRecord> transactionRecord) {
		this.transactionRecord = transactionRecord;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
