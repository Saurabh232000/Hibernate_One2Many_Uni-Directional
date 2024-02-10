package one2many.jsp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class updateQuestion {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		Scanner sc = new Scanner(System.in);
		Question q = new Question();
		System.out.println("Enter Question Id To Update:");
		int qid = sc.nextInt();
		sc.nextLine();
		q.setQuestion_id(qid);

		System.out.println(" Enter New Question:");
		String ques = sc.nextLine();
		q.setQuestion(ques);
		tx.begin();
		manager.merge(q);
		tx.commit();
	}
}
