import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class AccountChecker extends Account {
	HashMap<Integer,Account> map=new HashMap<Integer,Account>();
	public void getMainMenu() {
		boolean end=false;
		while(!end) {
		map.put(7904664, new Account(7904664,951,500,500));
		map.put(7094177, new Account(7094177,663,1000,1000));
			try {
				System.out.println(" ");
				System.out.println("~~~~~~~~~~~~Welcome to AGk ATM Service~~~~~~~~~~~");
				System.out.println("Enter 1 for login");
				System.out.println("Enter 2 to create Account");
				System.out.println("Your Choice: ");
				number=sc.nextInt();
				switch(number) {
				case 1:
					getLogin();
					end=true;
					break;
				case 2:
					getCreateAccount();
					end=true;
					break;
				default:
					System.out.println("\n Invalid Choice");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("\n Wrong Input Format");
				sc.next();
			}
		}
	}
	public void getCreateAccount() {
		int cos_no=0;
		boolean end=false;
		while(!end) {
				try {
					System.out.println("Enter Customer number for registration");
					cos_no=sc.nextInt();
					Iterator it=map.entrySet().iterator();
					while(it.hasNext())
					{
						Map.Entry pair = (Map.Entry) it.next();
						if (!map.containsKey(cos_no)) {
							end = true;
						}
					}
					if(!end) {
						System.out.println("\nThis Customer Number is already registred try another");
						getCreateAccount();
					}
				}
				catch(InputMismatchException e) {
					System.out.println("\n Wrong Input Format");
					sc.next();
			}
		}
		System.out.println("Enter Pin number to register");
		int pin=sc.nextInt();
		map.put(cos_no, new Account(cos_no,pin));
		System.out.println("Your Account Registered Successfully!!!!");
		System.out.println("Redirecting to login........");
		System.out.println(" ");
		getLogin();
	}
	
	public void getLogin() {
		int customerName=0;
		int pinNumber=0;
		int flag=0;
		do {
				try {	
					System.out.println("Enter the Account Number");
					customerName=setCustomerNumber(sc.nextInt());
					System.out.println("Enter the pin Number");
					pinNumber=setPinNumber(sc.nextInt());
				}
				catch(InputMismatchException e) {
					System.out.println("\n You Entered incorrect number format");
					sc.next();
				}
			
			Iterator it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				Account acc = (Account) pair.getValue();
				if (map.containsKey(customerName) && pinNumber == acc.getCustomerNumber()) {
						System.out.println("Login successfully");
						flag=1;
						getProcess();
						getLogin();
					}	
				}
				if(flag==0)
				System.out.println("\n You Entered Wrorng Account Pin Number");
		}while(flag==0);
	}
		public void getProcess()
		{
			boolean end=false;
			while(!end) {
			System.out.println(" ");
			System.out.println("----Options-----");
			System.out.println("Enter 1 for Savings Account ");
			System.out.println("Enter 2 for Current Account ");
			System.out.println("Enter 3 for Money Tranfer ");
			System.out.println("Enter 4 for Exit");
			System.out.println("Your Choice: ");
			try {
				number=sc.nextInt();
				switch(number) {
				
				case 1:
						getSavingsAccount();
						end=true;
						break;
				case 2: 
						getCheckingAccount();
						end=true;
						break;
				case 3:
						getAccTransfer();
						break;
				case 4:
						System.out.println("*****Thank you for using AGK ATM Service*****");
						getMainMenu();
						end=true;
						break;
				default:
						System.out.println("\n Invalid option ");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("\n You Entered Incorrect Number Format");
				sc.next();
			}
		}
	}
			public void getSavingsAccount() {
				System.out.println(" ");
				System.out.println("-----Savings Account-----");
				System.out.println("Enter 1 for Balance Check");
				System.out.println("Enter 2 for Withdraw");
				System.out.println("Enter 3 for Deposit");
				System.out.println("Enter 4 for Exit");
				System.out.println("Your Choice: ");
				try {
					number=sc.nextInt();
					switch(number)
					{
					case 1:
							System.out.println("Your Savings Account Balance is "+moneyformat.format(getSavingsBalance()));
							getProcess();
							break;
					case 2:
							getSavingsWithdrawInput();
							getProcess();
							break;
					case 3:
							getSavingsDepositInput();
							getProcess();
							break;
					case 4:
							getProcess();
							break;
					default:
						System.out.println("\n Invalid option ");
						getProcess();
					}
			}
				catch(InputMismatchException e) {
					System.out.println("\n You Entered incorrect number format");
					sc.next();
				}
		}
		public void getCheckingAccount() {
				System.out.println(" ");
				System.out.println("-----Current Account-----");
				System.out.println("Enter 1 for Balance Check");
				System.out.println("Enter 2 for Withdraw");
				System.out.println("Enter 3 for Deposit ");
				System.out.println("Enter 4 for Exit ");
				System.out.println("Your Choice: ");
				try {
					number=sc.nextInt();
					switch(number)
					{
					case 1:
							System.out.println("Your Current Account Balance is "+moneyformat.format(getCheckingBalance()));
							getProcess();
							break;
					case 2:
							getCheckingWithdrawInput();
							getProcess();
							break;
					case 3:
							getCheckingDepositInput();
							getProcess();
							break;
					case 4:
						getProcess();
						break;
					default:
						System.out.println("\n Invalid option ");
						getProcess();
					}
				}
				catch(InputMismatchException e) {
					System.out.println("\n You Entered incorrect number format");
					sc.next();
				}
		}
		int number;
}

		
