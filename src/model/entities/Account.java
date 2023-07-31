package model.entities;

import java.util.Scanner;

import model.exceptions.DomainException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) throws DomainException {
		this.number = number;
		this.holder = holder;
		this.withdrawLimit = withdrawLimit;
		this.balance = 0.00;
		deposit (balance);
	}
	
	

	public Integer getNumber() {
		return number;
	}


	
	public String getHolder() {
		return holder;
	}



	public void setHolder(String holder) {
		this.holder = holder;
	}



	public Double getBalance() {
		return balance;
	}




	public Double getWithdrawLimit() {
		return withdrawLimit;
	}



	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}



	public void deposit (double amount) throws DomainException {
		if (amount < 0.00) {
			throw new DomainException("Erro: não é possível digitar um valor menor que 0.00");
		}
		this.balance += amount;
	}
	
	
	
	public void withdraw (double amount) throws DomainException {
		if (amount > this.withdrawLimit) {
			throw new DomainException("Erro: o limite de saque da conta é de: R$" + this.withdrawLimit);
		}
		else if (amount < 0.00) {
			throw new DomainException("Erro: não é possível digitar um valor menor que 0.00");
		}
		else if (amount > this.balance) {
			throw new DomainException("Erro: a conta não possui saldo suficiente.");
		}
		
		this.balance -= amount;
	}
	
	
	Scanner sc = new Scanner(System.in);
	
	public void queryAccount() throws DomainException {
		System.out.print("Por favor, indique se você deseja fazer um depósito, saque ou encerrar consulta (d/s/e): ");
		char asw = sc.next().charAt(0);
		switch (asw) {
		case 'd': 
			System.out.print("Informe a quantia a ser depositada: "); double amountDeposit = sc.nextDouble();
			deposit(amountDeposit);
			System.out.println("Você depositou na conta: R$" + amountDeposit);
			System.out.println("-----------------------------");
			System.out.println("Saldo final da conta: R$" + getBalance());
			break;
		case 's':
			System.out.print("Informe a quantia a ser sacada: "); double amountWithdraw = sc.nextDouble();
			withdraw(amountWithdraw);
			System.out.println("Você sacou da conta: R$" + amountWithdraw);
			System.out.println("-----------------------------");
			System.out.println("Saldo final da conta: R$" + getBalance());
			break;
		case 'e':
			System.out.print("A consulta bancária está encerrada.");
			break;
		default: 
			System.out.println("Desculpe, mas você digitou um caracter inválido.");
			System.out.println("---------------------------------------------------------------------------");
			queryAccount();
		}
	}
	
	public String finalBalance() {
		return "|Balance: R$ "
				+ getBalance();
	}
	
	@Override
	public String toString() {
		return "Account data: "
				+ "|Nº: "
				+ this.number
				+ "|Holder: "
				+ this.holder
				+ "|Balance: R$"
				+ this.balance
				+ "|";
	}
}
