package one2many.jsp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class findQuestionByQuestionId {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
//	EntityTransaction tx = manager.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter Question Id:");
		Question find = manager.find(Question.class, sc.nextInt());
		if (find != null) {
			System.out.println(find.getQuestion_id());
			System.out.println(find.getQuestion());
			System.err.println(find.getAnswers());
			for (Answer a : find.getAnswers()) {
				System.out.println(a.getAnswer_id());
				System.out.println(a.getAnswer());
				System.out.println("___________");
			}
		} else {
			System.err.println(" Invalid Question Id");
		}
	}
}
