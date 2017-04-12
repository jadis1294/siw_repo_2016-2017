package it.uniroma3.db.products;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductMain {

    public static void main(String[] args) {

        // 1. create an instance of the Product entity
        Product product = new Product("KRIDDIG", 3.5F, "A wonderful …", "9781853262715-AA");
    	Address address = new Address("via via","roma","italia", "00001","anguillara");
        Customer customer = new Customer("primo","cognome","pippo@ciao");


    	customer.setAddress(address);

        // 2. get an EntityManager and a Transaction
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        

       // 3. Persist the product to the db
        tx.begin();
        em.persist(product);
        em.persist(customer);
        tx.commit();

        em.close();
        emf.close();
    }
}
