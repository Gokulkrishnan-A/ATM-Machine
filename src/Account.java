import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
	Scanner sc=new Scanner(System.in);
	private int customerNumber;
	private int pinNumber;
	private double savingsBalance=500;
	private double checkingBalance=500;
	DecimalFormat moneyformat=new DecimalFormat("'$'###,##0.00");
	Account(){
	}
	Account(Integer customerNumber,Integer pinNumber){
		this.customerNumber=customerNumber;
		this.pinNumber=pinNumber;
	}
	Account(Integer customerNumber,Integer pinNumber,double savingsBalance, double checkingBalance){
		this.customerNumber=customerNumber;
		this.pinNumber=pinNumber;
		this.savingsBalance=savingsBalance;
		this.checkingBalance=checkingBalance;
	}
	public int setCustomerNumber(int customerNumber) { 
		this.customerNumber=customerNumber;
		return customerNumber;
		}
		
	public int getCustomerNumber() {
		return customerNumber;
		}
	
	public int setPinNumber(int pinNumber) {
		this.pinNumber=pinNumber;
		return customerNumber;
		}
		
	public int getPinNumber() {
		return pinNumber;
		}
	
   public double getamount() {
		return sc.nextDouble();
		}
	
	public double getSavingsBalance() {
		return savingsBalance;
		}
	public double getCheckingBalance() {
		return  checkingBalance;
		}
	
	public double transfertochecking(double amount) {
		savingsBalance+=-amount;
		checkingBalance+=amount;
		return checkingBalance;
	}
	public double transfertosavings(double amount) {
		savingsBalance+=+amount;
		checkingBalance+=-amount;
		return savingsBalance;
	}
	public double savingsBalanceWithraw(double amount){
		savingsBalance+=-amount;
		return savingsBalance;
		}
	
	public double CheckingBalanceWithraw(double amount){
		checkingBalance-=amount;
		return checkingBalance;
		}
	
	public double savingsDeposit(double n) {
		savingsBalance+=n;
		return savingsBalance;
		}
	
	public double checkingDeposit(double n) {
		checkingBalance+=n;
		return checkingBalance;
		}
	
	public void getCheckingWithdrawInput() {
		try {
			System.out.println("\n Current Account Balance "+moneyformat.format(getCheckingBalance()));
			System.out.println(" Enter Amount to Withdraw ");
			amount=sc.nextDouble();
			if(getCheckingBalance()-amount<500 || amount<0)  {
				System.out.println("Insufficent Balance or amount cannot be negative");
			}
			else {
				System.out.println(" Withdrawn Successfully!!! ");
				System.out.println("Your Current Account Balance is "+moneyformat.format(CheckingBalanceWithraw(amount)));	
			}
		}
		catch(InputMismatchException e) {
		System.out.println("You Entered incorrect number format");
		sc.next();
		}
	}
	
	public void getSavingsWithdrawInput() {
			try{
				System.out.println("Savings Account Balance "+moneyformat.format(getSavingsBalance()));
				System.out.println("Enter Amount to Withdraw");
				 amount=sc.nextDouble();
				if(getSavingsBalance()-amount<500 || amount<0) {
					System.out.println("Insufficent Balance or amount cannot be negative");
				}
				else {
					System.out.println(" Withdrawn Successfully!!! ");
					System.out.println("Your Savings Account Balance is "+moneyformat.format(savingsBalanceWithraw(amount)));	
				}
			}
			catch(InputMismatchException e) {
				System.out.println("You Entered incorrect number format");
				sc.next();
			}
		}
	public void getCheckingDepositInput() {
			try {
				System.out.println("Current Account Balance "+moneyformat.format(getCheckingBalance()));
				System.out.println("Enter the amount to deposit");
				amount=getamount();
				if(getCheckingBalance()+amount<500 || amount<0)
				{
					System.out.println("Insufficent Balance or amount cannot be negative");
			}
				else {
					System.out.println(moneyformat.format(amount)+" Deposit successfully!!!");
					System.out.println("Your Current Account Balance is "+moneyformat.format(checkingDeposit(amount)));	
				}
			}
			catch(InputMismatchException e) {
				System.out.println("You Entered incorrect number format");
				sc.next();
			}
		}
	public void getSavingsDepositInput() {
			try {
				System.out.println(" Savings Account Balance "+moneyformat.format(getSavingsBalance()));
				System.out.println("Enter the amount to deposit ");
				amount=getamount();
				if(getSavingsBalance()+amount<500 || amount<0) {
					System.out.println("Insufficent Balance or amount cannot be negative");
				}
				else {
					System.out.println(moneyformat.format(amount)+" Deposit successfully!!!");
					System.out.println("Your Savings Account Balance is "+moneyformat.format(savingsDeposit(amount)));	
				}
			}
			catch(InputMismatchException e) {
				System.out.println("\n You Entered incorrect number format");
				sc.next();
			}	
		}

	public void getAccTransfer() {
			System.out.println("Enter 1 for Transfer form Savings to Current account");
			System.out.println("Enter 2 for Transfer form Current to Savings account ");
			try {
			int number=sc.nextInt();
			if(number==1)
			{
				System.out.println("Enter amount you want to tranfer");
				amount=sc.nextDouble();
				if(getSavingsBalance()-amount<500 || amount <0)
				{
					System.out.println("Insufficent Balance or amount cannot be negative");
				}
				else
				{
					System.out.println(moneyformat.format(amount) +" transferred to current account successfully");
					System.out.println("Your Current Account Balance is "+moneyformat.format(transfertochecking(amount)));	
				}	
			}
			else
			{
				System.out.println("Enter amount you want to tranfer");
				amount=sc.nextDouble();
				if(getCheckingBalance()-amount<500 || amount <=0)
				{
					System.out.println("Insufficent Balance or amount cannot be negative");
				}
				else
				{
					System.out.println(moneyformat.format(amount) +" transferred to Savings account successfully");
					System.out.println("Your Savings Account Balance is "+moneyformat.format(transfertosavings(amount)));	
				}
			}
		}
			catch(InputMismatchException e) {
				System.out.println("\n You Entered incorrect number format");
				sc.next();
			}
		}
	double amount;
}
