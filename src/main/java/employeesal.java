

import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.Statement;

import antlr.collections.List;
//import firtspring.springcode.Product;




public class employeesal 
{

    static Scanner sc = new Scanner(System.in);
	private static Object emp_salary;
public static void curd()
{
    Scanner sc=new Scanner(System.in);
    System.out.println("Please Select the Bellow Options");
    System.out.println("1 Insert.\n2.Display\n3.Delete\n4.Update");
    int a =sc.nextInt();
    
    if (a==1)
    {
    	ArrayList< emp_salary> list= new ArrayList<emp_salary>();
    	Configuration configuration = new Configuration();
        configuration.configure("empsalary.cfg.xml");
        System.out.println("Suceessfull");
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
     emp_salary emp = new emp_salary();
     System.out.println("enter your id");
        emp.setId(sc.nextInt());
        System.out.println("enter your name");
       emp.setName(sc.next());
       System.out.println("Enter emp salary");
       emp.setSalary(sc.nextFloat());
       System.out.println("enter emp exp");
       emp.setExp(sc.nextFloat());
     //System.out.println("Enter name and id");
        session.save(emp);
        session.beginTransaction().commit();
        curd();
    }
    else if(a==2)
    {
    	ArrayList< emp_salary> list= new ArrayList<emp_salary>();
        Configuration configuration = new Configuration();
        configuration.configure("empsalary.cfg.xml");
        System.out.println("Suceessfull");
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
     emp_salary emp = new emp_salary();
     list=(ArrayList<emp_salary>) session.createQuery("from emp_salary",emp_salary.class).list();
    // list.add((emp_salary) emp_salary);
      System.out.println("id"+"\t"+"name"+"\t"+"salary"+"\t"+"exp");
      for (emp_salary obj : list) {
          System.out.println(obj.getId()+"    "+obj.getName()+"    "+obj.getSalary()+"   "+obj.getExp());
       
   }
        
        session.beginTransaction().commit();
        curd();
    }
    else if(a==3)
    {
    	ArrayList< emp_salary> list= new ArrayList<emp_salary>();
        Configuration configuration = new Configuration();
        configuration.configure("empsalary.cfg.xml");
        System.out.println("Suceesfull");
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        emp_salary emp = new emp_salary();
        emp=(emp_salary)session.get(emp_salary.class,6);
        System.out.println("emp_salary object having  emp_salary name as:"+emp.getName());
        
        
        session.delete(emp);
        session.getTransaction().commit();
        session.close();
        curd();
    }
    else if(a==4)

    {
    	ArrayList< emp_salary> list= new ArrayList<emp_salary>();
        Configuration configuration = new Configuration();
        configuration.configure("empsalary.cfg.xml");
        System.out.println("Suceesfull");
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        emp_salary emp = new emp_salary();
        emp=(emp_salary)session.get(emp_salary.class,3);
        System.out.println("emp_salary object having emp_salary name as:"+emp.getName());
        System.out.println("enter emp name");
        emp.setName(sc.next());
        session.update(emp);
        session.getTransaction().commit();
        session.close();
        curd();
    }
    else
    {
        System.out.println("invalide selection");
    }
}



public static void meth1()
{
    Scanner s=new Scanner(System.in);
    System.out.println("press 1 if u continue or press any number if u want to exit");
    int k=s.nextInt();
    if(k==1)
     {
    	curd ();
     }
    else
    {
        System.out.println("");
    }}
    public static void main(String[] args)
    {
        Configuration configuration = new Configuration();
        configuration.configure("empsalary.cfg.xml");
        System.out.println("Suceesfull");
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        emp_salary emp = new emp_salary();
        curd();
        meth1();
    

}
}
