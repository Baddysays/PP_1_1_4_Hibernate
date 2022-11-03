package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory = Util.getSessionFactory();
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try (Session session = sessionFactory.openSession()) {
             session.beginTransaction();
            String sql = "CREATE TABLE IF NOT EXISTS USER " +
                    "(ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "name varchar(40) NOT NULL, " +
                    "lastname varchar(40) NOT NULL, age TINYINT);";


            Query query = session.createSQLQuery(sql);
            query.executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void dropUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            String sql = "DROP TABLE IF NOT EXISTS USER;";
            Query query = session.createSQLQuery(sql);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    @Override
    public void removeUserById(long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
        List<User> list = session.createQuery("from User").getResultList();
        for(User e: list)
            System.out.println(e);
        session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createQuery("delete User").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
