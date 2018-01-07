package app;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Employee")
@XmlRootElement
public class User {
   
   @Column(name = "Username")	
   private String user;
   @Column(name = "firstName")	   
   private String first;
   @Column(name = "lastName")		   
   private String last;
   @Column(name = "Email")	   
   private String email;
   @Column(name = "phoneNumber")	   
   private String phone;
   @Id
   @Column(name = "LID")	   
   private long id;
   @Column(name = "DOB")	   
   private Date dob;
   @Column(name = "Password")	   
   private String password;
   @Column(name = "createdOn")	   
   private Timestamp created;
   @Column(name = "FKLID")	   
   private long fklid; 
   
   public User()
   {
  	   
   }
   
   public User(String usr, String f, String l, String em, String ph, Date d_ob, String pass)
   {
	  this.fklid = 1; 
      this.user = usr;
      this.first = f;
      this.last = l;
      this.phone = ph;
      this.email = em;
      this.dob = null;
      this.password = pass;
      this.created = new Timestamp(System.currentTimeMillis());
      
   }
   
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}  
	public long getFklid() {
		return fklid;
	}
	public void setFklid(long fklid) {
		this.fklid = fklid;
	}
   
}
