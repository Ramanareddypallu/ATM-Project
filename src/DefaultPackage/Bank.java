package DefaultPackage;

import java.util.ArrayList;


public class Bank implements IAccount {
	
	private int sBalance, cBalance;
	private ArrayList<String> transcHistory = new ArrayList<String>();

	//Saving account balance store
	
	public void sDeposit(int amount) {
		
		sBalance=sBalance+amount;
		System.out.println("Amount  credited: "+amount);
		transcHistory.add("Amount  credited: "+amount);
		
	}

	public void cDeposit(int amount) {
		
		cBalance = cBalance+amount;
		System.out.println("Amount  credited: "+amount);
		transcHistory.add("Amount  credited: "+amount);
		
	}

	//Withdrawal amount(self-service)
	
	public void sWithdraw(int amount) {
		
		sBalance = sBalance-amount;
		System.out.println("Amount  debited(self): "+amount);
		transcHistory.add("Amount  debited(self): "+amount);
		
	}

	//Withdrawal amount(self-service)
	
	public void cWithdraw(int amount) {
		
		cBalance = cBalance-amount;
		System.out.println("Amount  debited(self): "+amount);
		transcHistory.add("Amount  debited(self): "+amount);
		
	}
	
	//Transferring to a Bank Account

	public void sTransfer(BankTransaction bt, int amount) {
		
		sBalance = sBalance-amount;
		System.out.println("Amount Transferred Succussfully....!: ");
		transcHistory.add("Amount "+amount+"debited to :"+bt.getSAccountNum());
		
	}

	public void cTransfer(BankTransaction bt, int amount) {

		cBalance = cBalance-amount;
		System.out.println("Amount Transferred Succussfully....!: ");
		transcHistory.add("Amount "+amount+"debited to :"+bt.getCAccountNum());
	}
	
//	Transaction (S)

	public void sTranscHistory() {
		
		for(String x:transcHistory) {
			System.out.println(x);
		}
		
	}
	
//	Transaction (S)

	public void cTranscHistory() {
		
		for(String x:transcHistory) {
			System.out.println(x);
		}
		
	}
	
//Get Balance
	
	public int sGetBalance() {
		
		return sBalance;
		
	}

	public int cGetBalance() {
		
		return cBalance;
	}
	
	


}
