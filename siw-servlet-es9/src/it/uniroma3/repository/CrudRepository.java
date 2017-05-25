package it.uniroma3.repository;

// per ogni entità mi devo creare un repository quindi conviene utilizzare i generics

import java.util.List;


public interface CrudRepository<T> {

    public T save(T entity);

    public T findOne(Long id);

    public List<T> findAll();

    public void delete(T enitity);

    public void deleteAll();

}
