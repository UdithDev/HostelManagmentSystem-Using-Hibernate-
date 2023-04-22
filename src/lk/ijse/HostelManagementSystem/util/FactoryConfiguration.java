package lk.ijse.HostelManagementSystem.util;

import lk.ijse.HostelManagementSystem.Entity.Reservation;
import lk.ijse.HostelManagementSystem.Entity.Room;
import lk.ijse.HostelManagementSystem.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private static SessionFactory sessionFactory;

    private FactoryConfiguration(){
        sessionFactory=new Configuration().mergeProperties(Utility.getProperties()).addAnnotatedClass(Student.class)
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(Reservation.class)
                .buildSessionFactory();
    }

    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration==null) ? factoryConfiguration=new FactoryConfiguration():
                factoryConfiguration;
    }

    public Session getSession(){
        return  sessionFactory.openSession();
    }
}
