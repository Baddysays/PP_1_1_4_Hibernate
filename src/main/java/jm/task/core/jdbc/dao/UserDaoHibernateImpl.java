package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private Transaction transaction;
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String query = "create table if not exists users\n" +
                    "(\n" + "    id       INT auto_increment not null,\n" +
                    "    name     TEXT not null,\n" +
                    "    lastName TEXT not null,\n" +
                    "    age      INT  null,\n" +
                    "    constraint users_pk\n" +
                    "        primary key (id)\n" + ");";
            session.createSQLQuery(query).addEntity(User.class)
                    .executeUpdate();
            transaction.commit();
            System.out.println("Table created");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String sql = "DROP TABLE IF EXISTS users;";
            session.createSQLQuery(sql).addEntity(User.class)
                    .executeUpdate();
            transaction.commit();
            System.out.println("Table deleted");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(new User(name, lastName, age));
            transaction.commit();
            System.out.println("User saved");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(session.load(User.class, id));
            transaction.commit();
            System.out.println("User deleted");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            result = session.createQuery("from User", User.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return result;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("DELETE FROM User").executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}