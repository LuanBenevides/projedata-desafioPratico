package testePratico.doman.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import testePratico.domain.model.Employee;
import testePratico.domain.repository.EmployeeRepository;

public class EmployeeService {

	//Serve para implementar outras regras de negócio
	private EmployeeRepository employeeRepository = new EmployeeRepository();
	
	public EmployeeService(){
		employeeRepository.setEmployeService(this);
	}
	
	public void initializer() {
		employeeRepository.insertInitialEmployees();
	}
	public void getAllEmplyees() {
		employeeRepository.getAllEmployees();
	}

	public void getByBithMonth(int month) {
		List<Employee> emps = employeeRepository.getByBirthMonth(month);
		
		System.out.println("Mês: " + month);
		System.out.println("--------------------------------------------------");
		if(emps.size() > 0) {
			for(Employee emp: emps) {
				System.out.println("Nome: " + emp.getName());
				System.out.println("Nascimento: " + emp.toStringDate());
				System.out.println("Salário: " + emp.formatedWage());
			}
		}else {
			System.out.println("Nenhum funcionário faz aniversário no mês " +  month + "...");
		}
	}
	//3.6
	public void orderByOccupationAll() {
		Map<String, List<Employee>> ordenedEmployees = employeeRepository.getByOccupation();
		
		String [] occupations = new String[7];
		occupations[0] = "Diretor";
		occupations[1] = "Gerente";
		occupations[2] = "Coordenador";
		occupations[3] = "Contador";
		occupations[4] = "Eletricista";
		occupations[5] = "Recepcionista";
		occupations[6] = "Operador";
														
		List<Employee> emp1 = new ArrayList<>();
		
		for(int x = 0; x < occupations.length; x++) {
			
			emp1 =  ordenedEmployees.get(occupations[x]);
			
			System.out.println("--------------------------------------------------");
			System.out.println("Função: " + occupations[x]);
			
			for(Employee employees: emp1) {
				System.out.println("Nome: " + employees.getName());
				System.out.println("Nascimento: " + employees.toStringDate());
				System.out.println("Salário: " + employees.formatedWage());
			}
		}
	}
	
	public void getOlderBirthDate() {
		Employee em = employeeRepository.getEmployeeByOlderAge();
		
		System.out.println("Funcioário mais antigo: ");
		System.out.println("Idade: " + em.toStringDate());
		System.out.println("Nome: " + em.getName());
		
	}
	public void salaryIncreaseAll(int percentage) {
		int sizeList = employeeRepository.getEmployees().size();
		
		for(int iterator = 0;iterator <= sizeList;iterator++) {
			employeeRepository.updateWage(iterator, percentage);
		}
		System.out.println("Todo os salarios foram atualizados em " + percentage + "%...");
	}

	public void removeByName(String name) {
		employeeRepository.removeByName(name);
	}
	
	public void getWageAllSum() {
		System.out.println(employeeRepository.wageSumAll());
	}
	
	public void getAmountOfMinWage() {
		List<Employee> emps =  employeeRepository.amountOfMinWage();
		
		for(Employee e: emps) {
			System.out.println("Funcionário: " + e.getName());
			System.out.println("Salários mínimos pagos: " + e.formatedWage());
			System.out.println("--------------------------------------------------");
		}
	}
}
