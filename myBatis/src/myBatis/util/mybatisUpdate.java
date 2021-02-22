package myBatis.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import myBatis.pojo.Student;

public class mybatisUpdate { 

   public static void main(String args[]) throws IOException{
      
	   //connect to the config xml, open the session
      Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
      SqlSession session = sqlSessionFactory.openSession();
      
      //select a particular student using id		
      Student student = (Student) session.selectOne("Student.getById", 1);
      System.out.println("Current details of the student are" );
      System.out.println(student.toString());  
      
      //Set new values to the mail and phone number of the student
      student.setEmail("mohamad456@yahoo.com");
      student.setPhone(90000000);
      
      //Update the student record
      session.update("Student.update",student); //pagkatapos ng setter method, iuupdate natin according sa sinet
      System.out.println("Record updated successfully");   
      session.commit();   
      //session.close();	  
	  
      //verifying the record 
      Student std = (Student) session.selectOne("Student.getById", 1);
      System.out.println("Details of the student after update operation" );
      System.out.println(std.toString());   
      session.commit();   
      session.close();
			
   }
}