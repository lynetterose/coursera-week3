package myBatis.util;

import java.io.IOException;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import myBatis.pojo.Student;
import myBatis.pojo.StudentInsert;

public class MybatisInsert { 

   public static void main(String args[]) throws IOException{
      
      Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
      SqlSession session = sqlSessionFactory.openSession();
      
      //Create a new student object
      StudentInsert student = new StudentInsert("juan","It", 75, 984800000, "juan@gmail.com" ); //ipapasa ito sa seesion.insert
            
      //Insert student data      
      session.insert("Student.insert", student); //.insert is yung id ng sql statement sa student.xml mapper
      System.out.println("record inserted successfully");
      session.commit();
      session.close();
		
   }
   
}
