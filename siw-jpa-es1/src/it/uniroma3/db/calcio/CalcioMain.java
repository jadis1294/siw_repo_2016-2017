package it.uniroma3.db.calcio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CalcioMain {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 2. get an EntityManager and a Transaction
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("calcio-unit");
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
	}

}
