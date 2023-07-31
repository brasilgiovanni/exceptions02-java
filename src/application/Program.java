package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		/*
		 * Fazer um programa para ler os dados de uma conta bancária e depois realizar
		 * um saque nesta conta bancária, mostrando o novo saldo. Um saque não pode
		 * ocorrer ou se não houver saldo na conta, ou se o valor do saque for superior
		 * ao limite de saque da conta. Implemente a conta bancária conforme projeto
		 * abaixo:
		 */
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			Account conta01 = new Account(1001, "Giovanni", 5000.00, 1500.00);
			System.out.println("Abaixo são apresentados os dados da conta");
			System.out.println(conta01);
			System.out.println();
			conta01.queryAccount();
		}
		
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		
		
		sc.close();
		
		
	}

}
