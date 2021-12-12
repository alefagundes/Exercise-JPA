package Application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Person;

public class Program {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("estudo-jpa");
		EntityManager em = emf.createEntityManager();
		
		  	//Person p1 = new Person(null, "salle", "salle@gmail.com");
		//Person p2 = new Person(null, "gui", "gui@gmail.com");
		//Person p3 = new Person(null, "mailson", "mailson@gmail.com");
		 
	
		/*em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		System.out.println("Ready");*/
		
		Person p = em.find(Person.class, 4);
		
		try {
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println(p + "\nRemoved");
		
		}catch(IllegalArgumentException e) {
			System.out.println("Id not existy!");
		}
	
		em.close();
		emf.close();
	}

}
