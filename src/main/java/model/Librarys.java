package model;

import java.util.Set;

public class Librarys implements Comparable<Librarys> {

	private int id;
	private String name;


	public Librarys() {
		super();

	}

	public Librarys(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		
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



	@Override
	public String toString() {
		return "Librarys [id=" + id + ", name=" + name + "]";
	}

	public int compareTo(Librarys o) {
		if(name.equals(o.getName())) 
			
			return -1;
		else 
			return 1;
	}

}
