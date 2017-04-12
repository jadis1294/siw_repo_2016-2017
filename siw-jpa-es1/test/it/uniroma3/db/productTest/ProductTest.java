package it.uniroma3.db.productTest;

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

import it.uniroma3.db.products.Product;

public class ProductTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction tx;
    
    @BeforeClass
    public static void initEntityManager() throws Exception {
        emf = Persistence.createEntityManagerFactory("products-unit-test");
        em = emf.createEntityManager();
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
        Product product = new Product();
        product.setName("SLANGAN");
        product.setCode("4321423131-AA");
        // Persists the book to the database
        tx.begin();
        em.persist(product);
        tx.commit();
        extracted(product);
        // Retrieves all the products from the database
        List<Product> products = em.createNamedQuery("findAllProducts").getResultList();
        assertEquals(1, products.size());
    }

	private void extracted(Product product) {
		assertFalse("ID should not be null", product.getId()==null);
	}
}
