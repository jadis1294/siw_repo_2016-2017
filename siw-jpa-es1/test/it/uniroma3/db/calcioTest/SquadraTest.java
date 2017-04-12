package it.uniroma3.db.calcioTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.uniroma3.db.calcio.Squadra;

public class SquadraTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;

	
	@BeforeClass
	public static void initEntityMenager() throws Exception{
		emf= Persistence.createEntityManagerFactory("calcio-unit-test");
		em=emf.createEntityManager();
				
	}
	
    @AfterClass
    public static void closeEntityManager() {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }

    @Before
    public void initTransaction() {
        tx = em.getTransaction();
    }
    @Test
    public void shouldCreateAproduct() throws Exception {
        // Creates an instance of Product
        Squadra squadra = new Squadra();
        squadra.setName("SLANGAN");
        squadra.setAllenatore("tiziocaio");
        // Persists the book to the database
        tx.begin();
        em.persist(squadra);
        tx.commit();
        extracted(squadra);
        // Retrieves all the products from the database
        List<Squadra> squadre = em.createNamedQuery("findAllSquadre").getResultList();
        assertEquals(1, squadre.size());
    }
	private void extracted(Squadra squadra) {
		assertFalse("ID should not be null", squadra.getId()==null);
	}
    
    
}
