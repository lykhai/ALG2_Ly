package app;
import java.util.ArrayList;

import bank.Client;
import bank.Company;
import bank.Person;

public class Main {

	public static void main(String[] args) {
		
		Person p1 = new Person("Pekar");
		p1.addAcc(1000);
		p1.addAcc(500);
		Person p2 = new Person("Svecova");
		p2.addAcc(1200);
		Company c1 = new Company("Skoda");
		c1.addAcc(120);
		
		ArrayList<Client> client = new ArrayList<Client>();
		client.add(p1);
		client.add(p2);
		client.add(c1);
		
		for (Client c : client) {
			System.out.println(c.getName() + " ma na ucte " + c.totalBalance());
		}
	}

}
