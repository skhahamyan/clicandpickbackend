package fr.clicandpick.dao;

/**
 * Created by Marc on 13/08/2015.
 */
public abstract class DAO<T> {

    public abstract T find(long id) throws DAOException;

    public abstract T create(T obj) throws DAOException;

    public abstract T update(T obj) throws DAOException;

    public abstract void delete(T obj) throws DAOException;
}
