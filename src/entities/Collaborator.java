package entities;

/*    Class Collaborator implementing Generic Interface Comparable parameterized with the Collaborator type
	  In order to override the compareTo Method and thus ensure the Collections.sort(list) implementation,
	  once the object "list" used as parameter is from the type List <Collaborator>
*/
public class Collaborator implements Comparable<Collaborator> {
	private String name;
	private Double wage;

	// Empty Standard Constructor in order it is required for entities:
	
	public Collaborator() {
	
	}
	// Complete Generated Constructor
	public Collaborator(String name, Double salary) {
		this.name = name;
		this.wage = salary;
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return wage;
	}

	public void setSalary(Double salary) {
		this.wage = salary;
	}

	//Override compareTo Method, from the Comparable Interface
	
	@Override
	public int compareTo(Collaborator other) {
		return name.compareTo(other.getName());
	}
}