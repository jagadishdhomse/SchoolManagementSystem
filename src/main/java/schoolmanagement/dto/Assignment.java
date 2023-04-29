package schoolmanagement.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Assignment {
   @Id
   private int id;
   private int sid;
   private String name;
   private double marks;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getMarks() {
	return marks;
}
public void setMarks(double marks) {
	this.marks = marks;
}
   
}
