package testePratico.domain.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

//solve the item 2
public class Employee extends Person{

	private int id = 0; 
	private BigDecimal wage;
	private String occupation;
	
	public Employee(int id, String name, int dayOfMonth, int birthMonth, int birthYear, double wage, String occupation){
		super(name, birthYear, birthMonth, dayOfMonth);
		this.id = id;
		this.wage = new BigDecimal(wage);
		this.occupation = occupation;
	}
	
	public Employee() {
		
	}
	public BigDecimal getWage() {
		return wage;
	}
	public void setWage(BigDecimal wage) {
		this.wage = wage;
	}
	public void setWage(double wage) {
		this.wage = new BigDecimal(wage);
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String formatedWage() {
		DecimalFormat fmt = new DecimalFormat("##,000.00");
		String formatedWage = fmt.format(this.wage);
		
		return formatedWage;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(occupation, wage);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(occupation, other.occupation) && Objects.equals(wage, other.wage);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
