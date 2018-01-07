package app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Store")
@XmlRootElement
public class Store {

	@Id 
	@Column(name = "LID")
	private int id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Slogan")
	private String slogan;

	@Column(name = "Greeting")
	private String greeting;  
   
   public Store(String n, String s, String g)
   {
      this.name = n;
      this.slogan = s;
      this.greeting = g;
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

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
}
