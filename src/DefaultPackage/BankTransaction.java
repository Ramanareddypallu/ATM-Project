package DefaultPackage;

public class BankTransaction {

	private String pSaccountNum = "396892137663";
	private String pCaccountNum = "918555904072";
	
	public void bTransaction(IAccount bank, BankTransaction bt, int account, int amount) {
		
		if(account == 1 && bank.sGetBalance() >= amount) {
			System.out.println("Transferring Money...");
			bank.sTransfer(bt, amount);
		}else {
			System.out.println("Insufficient balance to trasfer money!!");
		}
	}
		
		
		public String getSAccountNum() {
			return pSaccountNum;
		}
		
		public String getCAccountNum() {
			return pCaccountNum;
		
	}


}
