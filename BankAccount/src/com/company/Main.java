package com.company;

public class Main {

    public static void main(String[] args) {
	BankAccount acount = new BankAccount();
	acount.setBalance(2891234.12);
	acount.deposit(-100);
	acount.deposit(100000);
	acount.withdraw(12939999999999.1);
	acount.withdraw(0);
	acount.withdraw(12353);
    }

    VIPCustomer vip1 = new VIPCustomer("John", 2000.2, "abc@123.com");
    VIPCustomer vip2 = new VIPCustomer("Jack","aac@222.com");
    VIPCustomer vip3 = new VIPCustomer();
}
