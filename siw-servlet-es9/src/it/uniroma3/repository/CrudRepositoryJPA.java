package it.uniroma3.repository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



public class CrudRepositoryJPA <T> implements CrudRepository<T> {

    private EntityManager em;
    private Class<T> entityClass;


    public CrudRepositoryJPA(EntityManager em,Class <T> entityClass) {
        this.em = em;
        this.entityClass=entityClass;
    }


    @Override
    public T save(T entity) {

        // riflessione
        Method getId = null;
        try {
            getId = this.entityClass.getMethod("getId");
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            if(getId.invoke(entity)==null)
                em.persist(entity);
            else
                return em.merge(entity);		// perché altimenti l'oggetto non è managed
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return entity;
    }


    @Override
    public T findOne(Long id) {
        return em.find(this.entityClass, id);
    }



    @Override
    public List<T> findAll() {
        String className = this.entityClass.getSimpleName();
        // risolve il problema della lista di oggetti typedquery
        TypedQuery <T> query = em.createQuery("SELECT a FROM "+className+" a",this.entityClass);
        return query.getResultList();
    }


    @Override
    public void delete(T entity) {
        em.remove(entity);

    }

    @Override
    public void deleteAll(){
        String className = this.entityClass.getCanonicalName();
        Query query=em.createQuery("DELETE FROM " + className);
        query.executeUpdate();		// la eseguo facendo un agg del database
    }

    protected EntityManager getEm(){
        return this.em;
    }
}