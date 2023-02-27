package org.etsntesla.it.spring;

import org.etsntesla.it.Emocije;
import org.etsntesla.it.EmocijeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmocijeManager implements EmocijeRepository, DisposableBean {

    static SessionFactory factory;

    {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Emocije.class);
        factory = configuration.buildSessionFactory();
    }

    @Override
    public List<Emocije> getAll() {
        List<Emocije> result = null;
        Transaction transaction = null;
        Session session = factory.openSession();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            result = session.createQuery("FROM Emocije", Emocije.class).list();
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }
        finally {
            session.close();
            return result;
        }

    }

    @Override
    public Emocije getById(int id) {
        Emocije result = null;
        Transaction transaction = null;
        Session session = factory.openSession();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            result = session.get(Emocije.class,id);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }
        finally {
            session.close();
            return result;
        }
    }

    @Override
    public void create(Emocije item) {
        Transaction transaction = null;
        Session session = factory.openSession();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.persist(item);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }
        finally {
            session.close();
        }
    }

    @Override
    public void update(Emocije item) {
        Transaction transaction = null;
        Session session = factory.openSession();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Emocije persistItem = session.get(Emocije.class, item.getId());
            persistItem.setVrstaEmocije(item.getVrstaEmocije());
            persistItem.setPoruka(item.getPoruka());
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }
        finally {
            session.close();
        }
    }

    @Override
    public void delete(Emocije item) {
        Transaction transaction = null;
        Session session = factory.openSession();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.remove(item);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }
        finally {
            session.close();
        }
    }

    @Override
    public void destroy() throws Exception {
        factory.close();
    }
}
