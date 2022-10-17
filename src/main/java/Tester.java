
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class Tester {



   public static void main(String[] args)
    {
        Configuration configuration = new Configuration();
        configuration.configure("Hibernate.cfg.xml");
        System.out.println("Sucessfull");
        SessionFactory factory = configuration.buildSessionFactory();
      Session session=factory.openSession();
        System.err.println("2");
        Student1 student = new Student1();
        student.setId(2);
        System.out.println("2");
        student.setName("Sunil");
        session.save(student);
        session.beginTransaction().commit();
    }

}
