package it.uniroma3.repository;

import javax.persistence.EntityManager;

import it.uniroma3.model.Prodotto;

public class ProductRepository extends CrudRepositoryJPA<Prodotto> {

    public ProductRepository(EntityManager em, Class<Prodotto> entityClass) {
        super(em, Prodotto.class);

    }


}
