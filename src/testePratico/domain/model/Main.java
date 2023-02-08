package testePratico.domain.model;

import testePratico.doman.service.EmployeeService;

//Solve the item 3
public class Main {
	
	public static void main(String[] args) {
		
		EmployeeService service = new EmployeeService();
		
		System.out.println("A aplicação foi inicializada com os funcionarios iniciais da base! Seguem abaixo: \n");
		//Solve the item 3.1
		service.initializer();
		service.getAllEmplyees();
		
		System.out.println("Removendo o funcionário João da base... \n");
		//Solve the item 3.2
		service.removeByName("João");
		
		System.out.println("Demonstrando todos os funcionarios na base atual...\n");
		//Solve the item 3.3
		service.getAllEmplyees();
		
		System.out.println("\n");
		
		System.out.println("Todos os salarios atualizados em 10%... \n");
		//Solve the item 3.4
		service.salaryIncreaseAll(10);
		service.getAllEmplyees();
		
		System.out.println("\n");
		
		//Solve the item 3.6 ( & 3.5)
		System.out.println("Retornando os funcionarios agrupados por cada função...\n");
		service.orderByOccupationAll();
		
		//Solve the item 3.8
		System.out.println("Imprimindo apenas os funcionarios que fazem aniversário nos meses 10 e 12: \n");
		service.getByBithMonth(10);
		service.getByBithMonth(12);
		
		System.out.println("\n");
		
		//Solve the item 3.9
		System.out.println("Retornando o funcionário com maior idade (Data de nascimento mais antiga): ");
		service.getOlderBirthDate();
		
		/* item 3.10
		 * Não consegui desenvolver a ordenação alfabética, conheço um pouco sobre o 
		 * método compareTo, mas tentei não consultar... fiz algumas tentativas de implementar
		 * com lógica própria, mas deixou o código sujo demais e não funcionou
		 * :(
		 * 
		 * */
		
		//Solve the item 3.11
		System.out.println("O somatório de todos os salários é: ");
		service.getWageAllSum();
	
		System.out.println("\n");
		
		//Solve the item 3.12
		System.out.println("Quantidade de salário mínimo pago a cada funcionário - Base de R$ 1212.00: ");
		System.out.println("--------------------------------------------------");
		service.getAmountOfMinWage();
	}
	
	
	
}
