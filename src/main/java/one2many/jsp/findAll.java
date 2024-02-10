package one2many.jsp;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class findAll {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		String query = "select q from Question q";
		Query createQuery = manager.createQuery(query);
		List<Question> resultList = createQuery.getResultList();
		for (Question ob : resultList) {
			System.out.println(ob.getQuestion_id());
			System.out.println(ob.getQuestion());
			for (Answer ob1 : ob.getAnswers()) {
				System.out.println(ob1.getAnswer_id());
				System.out.println(ob1.getAnswer());
			}
		}
	}
}
