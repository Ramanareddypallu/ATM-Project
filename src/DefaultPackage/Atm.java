package DefaultPackage;

import java.util.Scanner;

interface IServices {

	void atmServices();
}
class Servicesimpl implements IServices {

	@Override
	public void atmServices() {
		//security limitation
		 int limit  = 1;
		 //user choice
		 int choice = 0;
		 int amount = 0;
		
		 
		 System.out.println("\n*******Welcome TO SBI ATM*******");
		 
		
		 
//		 Taking input from user
		 @SuppressWarnings("resource")
		 Scanner scan = new Scanner(System.in);
//		 Creating required Objects
//		 tight Coupling
		 AccountHolder ah = new AccountHolder();
		 BankTransaction bt = new BankTransaction();
//		 loosing coupling
		 IAccount bank = new Bank();
		 
		 while(limit <= 3) {
			 
//			 For security reason, limiting the access by keeping a counter
			 System.out.print("\nEnter userId: ");
			 String userId = scan.next();
			 
			 System.out.print("\nEnter pin: ");
			 String userPin = scan.next();
			 
			 if(userId.equals(ah.getId()) && userPin.equals(ah.getPin())) {
//				 Increasing the limit to 3 if the user types correct details
				 limit = 4;
				 
				 System.out.println("\n************************************");
				 System.out.println("Welcome to State Bank of India");
				 System.out.println("************************************\n");
				 
//				 Account type selection
				 System.out.println("Select Your Account type: ");
				 System.out.println("_________________________________________");
				 
				 System.out.println("\n1.   SAVINGS ACCOUNT\n2.   CURRENT ACCOUNT\n");
				 System.out.print("\nchoice:");
				 int account = scan.nextInt();
				 
//				 value checking
				 if(account == 1 || account == 2) {
			 
		        }else {
		        	System.out.println("Please!   enter correct input");
		        	System.exit(0);
		        }
		 
//				 ATM functionalities 
				 while(true) {
					 System.out.println("\n\t\tATM FUNCTIONALITIES");
					 System.out.println("\t______________________________________\n");
					 System.out.println("1.   Deposit  \t   2.  WITHDRAWAL\n");
					 System.out.println("3.   TRANSFER  \t   4.  TRANSACTIONS HISTORY\n");
					 System.out.println("5.   BALANCE INQ  \t   6.  QUIT\n");
					 System.out.println("************************************\n");
					 System.out.println("************************************\n");
					 System.out.println("Enter your choice:");
					 choice = scan.nextInt();
					 
					 switch(choice) {
					 
					 case 1:System.out.print("Enter amount to be deposited:");
					 if (account == 1) {
//						 saving account
						 amount = scan.nextInt();
						 bank.sDeposit(amount);
						 
					 }else {
//						 current account
						 amount = scan.nextInt();
						 bank.cDeposit(amount);
					 }break;
					 
					 
					 
					 
					 
					 case 2: System.out.print("Enter amount to be withdrawn:");
					 if(account == 1) {
//						 saving account
//						 checking condition that balance request is valid or not
						 amount = scan.nextInt();
						 if(amount <= bank.sGetBalance()) {
							 bank.sWithdraw(amount);
						 }else 
							 System.out.println("insufficient balance");
						 
					 }
						  else {
//							 current account
//							 checking condition that balance request is valid or not
							 amount = scan.nextInt();
							 if(amount <= bank.cGetBalance()) {
								 bank.cWithdraw(amount);
							 }else
								 System.out.println("insufficient balance");
						 }break;
						 
//						 Auto account number
						 
						 
						 
						 
					 case 3: if(bt.getSAccountNum().equals("396892137663") && account == 1) {
						 System.out.print("Enter amount to be transferred: ");
						 amount = scan.nextInt();
						 bt.bTransaction(bank, bt, account, amount);
					 }else if(bt.getCAccountNum().equals("918555904072")&& account == 2) {
						 System.out.println("enter amount to be transferred: ");
						 amount = scan.nextInt();
						 bt.bTransaction(bank, bt, account, amount);
						 
					 }else 
						 System.out.println("Wrong details! provided. please, try again.");
						 break;
						 
						 
						 
					
					 case 4: bank.sTranscHistory();
					 break;
					 
					 
					 
					 
				     case 5: if(account == 1)
							 System.out.println("\nAccount Balance is:"+bank.sGetBalance());
						 else if(account == 2)
							 System.out.println("\nAccount Balance is:"+bank.cGetBalance());
					 break;
					 
					 
					 
						 
						 
				     case 6:  System.out.println("_________________________________________");
				     System.out.println("\nMESSAGE: THANK YOU FOR USING SBI ATM");
				     System.out.println("_________________________________________");
				     System.exit(0);
						  
					 }
					 
					 }
				 }
			 else if (limit == 3) {
				 limit++;
				 System.out.println("_________________________________________");
				 System.out.println("\nMESSAGE: YOUR ATM services has been blocked for 24 hrs.please try again later...");
				 System.out.println("_________________________________________");
			 }else {
				 limit++;
				 System.out.println("_________________________________________");
				 System.out.println("\nMESSAGE : incorrect user credentials, please enter correct credentails...!!");
				 System.out.println("_________________________________________");
			 }
				 
		 } 
			 
		 
	}
	
}


 class Atm {

	public static void main(String[] args) {
	//	Interface promoting loose coupling
		IServices services = new Servicesimpl();
		services.atmServices();
//		Calling ATm services of Atmimpl which is implimentaion class of Interface IAtm 

	}

}
