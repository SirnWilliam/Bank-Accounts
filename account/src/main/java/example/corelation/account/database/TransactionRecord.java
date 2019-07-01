package example.corelation.account.database;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TransactionRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionRecordId;
	private double balance;
	private double amount;
	private boolean deposit;
	private boolean withdrawal;
	@Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
	
	
	public TransactionRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionRecord(double balance, double amount, boolean deposit, boolean withdrawal, Date dateTime, Account account) {
		super();
		this.balance = balance;
		this.amount = amount;
		this.deposit = deposit;
		this.withdrawal = withdrawal;
		this.dateTime = dateTime;
		this.account = account;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account")
	private Account account;

	
	public long getTransactionRecordId() {
		return transactionRecordId;
	}

	public void setTransactionRecordId(long transactionRecordId) {
		this.transactionRecordId = transactionRecordId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isDeposit() {
		return deposit;
	}

	public void setDeposit(boolean deposit) {
		this.deposit = deposit;
	}

	public boolean isWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(boolean withdrawal) {
		this.withdrawal = withdrawal;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
