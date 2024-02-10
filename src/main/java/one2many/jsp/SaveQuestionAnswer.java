package one2many.jsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveQuestionAnswer {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		Scanner sc = new Scanner(System.in);

		// Question Object:
		Question q = new Question();
//		System.out.println("Enter Question_id:");
//		int Qid = sc.nextInt();
//		q.setQuestion_id(Qid);
		q.setQuestion_id(103);
//		System.out.println("Enter Question:");
//		String ques = sc.nextLine();
//		q.setQuestion(ques);
		q.setQuestion("What is hibernate?");

		// Answer 1 Object:
		Answer a1 = new Answer();
//		System.out.println("Enter Answer_id");
//		a1.setAnswer_id(sc.nextInt());
		a1.setAnswer_id(401);
//		System.out.println("Enter Answer_1:");
//		a1.setAnswer(sc.nextLine());
		a1.setAnswer("hibernate is framework");

		// Answer 2 Object:-
		Answer a2 = new Answer();
//		System.out.println("Enter Answer_id");
//		a2.setAnswer_id(sc.nextInt());
		a2.setAnswer_id(402);
//		System.out.println("Enter Answer_2:");
//		a2.setAnswer(sc.nextLine());
		a2.setAnswer(" Hibernate is non-invasive framework");

		// Storing All Answer in One List
		List<Answer> answers = new ArrayList<Answer>();
		answers.add(a1);
		answers.add(a2);
		// Setting Answer in Question
		q.setAnswers(answers);
		manager.persist(q);
		tx.begin();
		tx.commit();

	}
}
