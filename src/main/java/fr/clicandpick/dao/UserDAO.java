package fr.clicandpick.dao;

import fr.clicandpick.model.User;
import fr.clicandpick.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Marc on 13/08/2015.
 */
public class UserDAO extends DAO<User> {


    @Override
    public User find(long id) {
        Session session = HibernateUtil.currentSession();
        return  (User) session.get(User.class, id);
    }

    @Override
    public User create(User obj) {
        Session session = HibernateUtil.currentSession();
        session.beginTransaction();

        //Save the employee in database
        session.save(obj);

        //Commit the transaction
        session.getTransaction().commit();
        HibernateUtil.closeSession();

        return obj;
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
        Session session = HibernateUtil.currentSession();

        Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("email", email));

        return (User) criteria.uniqueResult();

    }
}
