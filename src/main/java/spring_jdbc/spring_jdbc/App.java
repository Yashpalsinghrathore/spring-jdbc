package spring_jdbc.spring_jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.dao.StudentDao;
import com.spring.modal.Student;

import sun.management.jdp.JdpBroadcaster;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "code is started" );
        
        //with xml 
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring_jdbc/spring_jdbc/config.xml");
        
        //without xml configuration
        
        ApplicationContext context =  new AnnotationConfigApplicationContext(JdbcConfig.class);
        
        
        StudentDao dao = context.getBean("dao",StudentDao.class);
        
        Student student = new Student();
        
        //this is for inserting
        
       /* student.setId(103);
        student.setName("mahesh");
        student.setCity("bhopal");
   
        int res = dao.insert(student);*/
        
        
        
        //this is for deleting data
        
       /* student.setId(103);
        student.setName("pawan");
        student.setCity("ahemdabad");
        
        int res = dao.change(student);*/
        
        
        //this is for delete operation
        
        //int res = dao.delete(103);
        
        
        //this for selecting one object 
        
        
       /* Student s1 = dao.getStudent(102);
        
        System.out.println(s1);*/
        
        
        
        //this is for selecting all object
        
        List<Student> l = dao.getAllStudent();
        
        for(Student s1 : l)
        {
        	
        	System.out.println(s1);
        	
        }
        
       //System.out.println("inserted successfully  "+res+" rows affected");
        
        
    }
}
