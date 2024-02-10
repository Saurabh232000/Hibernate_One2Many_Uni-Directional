package one2many.jsp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class deleteByQuestionId {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter Question Id to Find First:");
		Question find = manager.find(Question.class, sc.nextInt());
		if (find != null) {
			manager.remove(find);
			tx.begin();
			tx.commit();
			System.out.println(" 1 Record deleted Successfully:");
		} else {
			System.err.println(" Invalid Question Id");
		}
	}
}
