package MVC;

import java.util.ArrayList;

public class Passengers {
	String name;
	int age;
	String gender;
	ArrayList<Passengers> pass;

	Passengers(String pn, int pa, String pg) {
		this.name = pn;
		this.age = pa;
		this.gender = pg;
	}

	Passengers(ArrayList<Passengers> pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public int getage() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setage(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public ArrayList<Passengers> getPass() {
		return pass;
	}


	}

	

	
	

