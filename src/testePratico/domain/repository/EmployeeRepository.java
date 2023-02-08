package testePratico.domain.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import testePratico.domain.model.Employee;
import testePratico.doman.service.EmployeeService;

public class EmployeeRepository {

	//Serve como camada de dados
	private static List<Employee> employees = new ArrayList<>();
	private EmployeeService employeService;
	
	public EmployeeRepository(EmployeeService employeService) {
		this.employeService = employeService;
	}
	public EmployeeRepository() {
		
	}

	public EmployeeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeeService employeService) {
		this.employeService = employeService;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		EmployeeRepository.employees = employees;
	}
	
public void insertInitialEmployees() {
		
		employees.add(new Employee(0, "Maria", 18, 10, 2000, 2009.44, "Operador"));  
		employees.add(new Employee(1, "João", 12, 5, 1990, 2284.38, "Operador"));
		employees.add(new Employee(2, "Caio", 2, 5, 1961, 9836.14, "Coordenador"));  
		employees.add(new Employee(3, "Miguel", 14, 10, 1988, 19119.88, "Diretor"));
		employees.add(new Employee(4, "Alice", 5, 1, 1995, 2234.68, "Recepcionista"));
		employees.add(new Employee(5, "Heitor", 19 , 11, 1999, 1582.72, "Operador"));
		employees.add(new Employee(6, "Arthur", 31, 3, 1993, 4071.84, "Contador"));
		employees.add(new Employee(7, "Laura", 8, 7, 1994, 3017.45, "Gerente"));
		employees.add(new Employee(8, "Heloísa", 24,05, 2003, 1696.85, "Eletricista"));
		employees.add(new Employee(9, "Helena", 2, 9, 1996, 2799.93, "Gerente"));
		
	}
	
	public void getAllEmployees() {
		for(Employee emps: employees) {
			
			System.out.println("Nome: " + emps.getName());
			System.out.println("Nascimento: " + emps.toStringDate());
			System.out.println("Salário: " + emps.formatedWage());
			System.out.println("Função: " + emps.getOccupation());
			System.out.println("------------------------------------------------------------");
		}
	}
	
	public List<Employee> getAllEmployeesList() {
		return employees;
	}
	
	public List<Employee> getByBirthMonth(int month){
		
		List<Employee> emp1 = new ArrayList<>();
		
		for(Employee employee: employees) {
			if(employee.getBirthDate().getMonth().getValue() == month) {
				emp1.add(employee);
			}
		}
		
		
		return emp1;
	}
	public Map<String, List<Employee>> getByOccupation() {
		
		List<Employee> diretores = new ArrayList<>();
		List<Employee> gerentes = new ArrayList<>();
		List<Employee> coordenadores = new ArrayList<>();
		List<Employee> contadores = new ArrayList<>();
		List<Employee> operadores = new ArrayList<>();
		List<Employee> eletricistas = new ArrayList<>();
		List<Employee> recepcionistas = new ArrayList<>();
		
		//Solve the item 3.5
		Map<String, List<Employee>> employeesMaped = new HashMap<>();
		
		for(Employee employee: employees) {
			
			if(employee.getOccupation().equalsIgnoreCase("Diretor")) {
				diretores.add(employee);
			}
			if(employee.getOccupation().equalsIgnoreCase("Gerente")) {
				gerentes.add(employee);
			}
				
			if(employee.getOccupation().equalsIgnoreCase("Coordenador")) {
				coordenadores.add(employee);
			}
					
			if(employee.getOccupation().equalsIgnoreCase("Contador")) {
				contadores.add(employee);
			}
						
			if(employee.getOccupation().equalsIgnoreCase("Operador")) {
				operadores.add(employee);
			}
							
			if(employee.getOccupation().equalsIgnoreCase("Eletricista")) {
				eletricistas.add(employee);
			}
								
			if(employee.getOccupation().equalsIgnoreCase("Recepcionista")) {
				recepcionistas.add(employee);
			}
		}
		
		employeesMaped.put("Diretor", diretores);
		employeesMaped.put("Gerente", gerentes);
		employeesMaped.put("Coordenador", coordenadores);
		employeesMaped.put("Contador", contadores);
		employeesMaped.put("Operador", operadores);
		employeesMaped.put("Eletricista", eletricistas);
		employeesMaped.put("Recepcionista", recepcionistas);
		
		return employeesMaped;
	}
	
	public Employee getEmployeeByOlderAge() {
		
		LocalDate[] years = new LocalDate[employees.size()];
		
		int iterator = 0;
		
		for(Employee emp: employees) {
			years[iterator] = emp.getBirthDate();
			
			iterator++;
		}
		
		LocalDate passage = null;
		
		for(int i = 0;i < years.length; i++) {
			for(int z = 0;z < years.length; z++) {
				
				int x = years[i].compareTo(years[z]);
				
				if(x > 0) {
					passage = years[i];
					years[i] = years[z];
					years[z] = passage;
				}
			}
		}
		
		Employee empTransit = null;
		
		for(Employee emp: employees) {
			
			if(emp.getBirthDate().equals(years[employees.size() - 1])) {
				empTransit = emp;
			}
			
		}
		return empTransit;
	}
	
	
	public void updateWage(int id,int percent) {
				
		for(Employee employee: employees) {
			
			if(id == employee.getId()) {
			 double current = employee.getWage().doubleValue();
			 double result = current + ((percent / 100.00) * current);
			 
				employee.setWage(result);
			}
		}
	}
	
	//Solve the item 3.4
	public void removeByName(String removedByName) {
		
		Employee empTransit = null;
		
		for(Employee emps: employees) {
			if(emps.getName().equalsIgnoreCase(removedByName)) {
				empTransit = emps;
			}
		}
		employees.remove(empTransit);
		System.out.println("Funcionário " + removedByName + " removido!");
	}
	
	public String wageSumAll() {
		
		Employee transitional = new Employee();
		
		BigDecimal wageAll = new BigDecimal(0);
		
		for(Employee e: employees) {
			wageAll = wageAll.add(e.getWage());
		}
		
		transitional.setWage(wageAll);
		
		return transitional.formatedWage();
	}
	
	@SuppressWarnings("deprecation")
	public List<Employee> amountOfMinWage(){
		
		List<Employee> emps = new ArrayList<Employee>(); 
		
		for(Employee e: employees) {
			
			Employee emp = new Employee();
			BigDecimal wg = new BigDecimal(0);
			BigDecimal divisor = new BigDecimal(1212.00);
			
			emp.setName(e.getName());
			
			wg = e.getWage();
			
			emp.setWage(wg.divide(divisor, 10, 2));
			
			emps.add(emp);
		}
		
		return emps;
	}
}
