package enterprise;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5848584724462451447L;
	
	@Id
	private long aadhaar;
	
	private String fname, lname;

	
	public Person() {
		super();
	}

	public Person(long aadhaar, String fname, String lname) {
		super();
		this.aadhaar= aadhaar;
		this.fname = fname;
		this.lname = lname;
	}

	public long getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(long aadhaar) {
		this.aadhaar = aadhaar;
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
		return "Person [aadhaar=" + aadhaar + ", fname=" + fname + ", lname=" + lname + "]";
	}
	
}
