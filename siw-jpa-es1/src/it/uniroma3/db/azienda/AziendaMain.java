package it.uniroma3.db.azienda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AziendaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("azienda-unit");
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
	}

}
