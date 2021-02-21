package myBatis.pojo;

public class StudentInsert {
	   private int id;
	   private String name;
	   private String branch;
	   private int percentage;
	   private int phone;
	   private String email;

	   public StudentInsert(String name, String branch, int percentage, int phone, String email) {
	      super();
	      this.name = name;
	      this.branch = branch;
	      this.percentage = percentage;
	      this.phone = phone;
	      this.email = email;
	   }
	   
	}