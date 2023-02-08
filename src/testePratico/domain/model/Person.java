package testePratico.domain.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

//solve the item 1
public class Person {
	 
	private String name;
	private LocalDate birthDate;
	
	private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Person() {
		
	}

	public Person(String name, int birthYear, int birthMonth, int dayOfMonth) {
		
		this.birthDate = LocalDate.of(birthYear, birthMonth, dayOfMonth);
		this.name = name;
	
	}
	
	public String toStringDate() {
		String formatedDate = birthDate.format(dateFormatter);
		
		return formatedDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthDate, dateFormatter, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(dateFormatter, other.dateFormatter)
				&& Objects.equals(name, other.name);
	}
}
