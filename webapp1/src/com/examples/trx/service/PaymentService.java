package com.examples.trx.service;

public abstract class PaymentService {
	public abstract void pay(int payerAccountNumber, int payeeAccountnumber, int amount);
	public abstract void payJdbc(int payerAccountNumber, int payeeAccountnumber, int amount);
}
