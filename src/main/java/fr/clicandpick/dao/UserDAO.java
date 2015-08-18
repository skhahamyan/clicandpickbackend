package fr.clicandpick.dao;

import fr.clicandpick.model.User;

/**
 * Created by Marc on 13/08/2015.
 */
public class UserDAO extends DAO<User> {


    public UserDAO(DAOFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public User find(long id) {
        //TODO
        return null;
    }

    @Override
    public User create(User obj) {
        //TODO
        return null;
    }

    @Override
    public User update(User obj) {
        //TODO
        return null;
    }

    @Override
    public void delete(User obj) {
        //TODO
    }

    public User findByEmail(String email) {
        //TODO
        return null;
    }
}
