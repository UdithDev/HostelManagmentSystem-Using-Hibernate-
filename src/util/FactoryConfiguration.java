package util;

import Entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private static SessionFactory sessionFactory;

    private FactoryConfiguration(){
        sessionFactory=new Configuration().mergeProperties(Utility.getProperties()).addAnnotatedClass(Student.class).buildSessionFactory();
    }

    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration==null) ? factoryConfiguration=new FactoryConfiguration():
                factoryConfiguration;
    }
}
