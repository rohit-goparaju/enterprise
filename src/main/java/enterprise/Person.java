package enterprise;

import java.io.Serializable;


public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5848584724462451447L;
	
	private int id;
	
	private String fname, lname;

	
	
	public Person() {
		super();
	}

	public Person(int id, String fname, String lname) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
	}
	
}
