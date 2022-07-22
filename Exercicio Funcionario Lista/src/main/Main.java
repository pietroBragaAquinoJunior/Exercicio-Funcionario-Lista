package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionario;

public class Main {

	public static void main(String[] args) {
		
		/* O programa recebe id, nome e salário de n funcionários. */
		/* O programa em seguida realiza uma busca pelo ID e aumenta o salário em porcentagem. */
		/* Exercício em Java para treinamento de Listas (com stream, filter, lambda) */
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> lista = new ArrayList<>();
		
		System.out.println("Quantos funcionários serão registrados?");
		int nFuncionarios = sc.nextInt();
		
		for(int i=0;i<nFuncionarios;i++) {
			System.out.println("Dados do funcionário número: "+i+":");
			System.out.print("ID: ");
			int id = sc.nextInt();
			System.out.print("Nome: ");
			String nome = sc.next();
			System.out.print("Salário: ");
			double salario = sc.nextDouble();
			lista.add(new Funcionario(id, nome, salario));
		}
		
		System.out.print("Digite o ID do funcionário que deseja aumentar o salário: ");
		int idFuncionario = sc.nextInt();
		
		/* Pegar o funcionário com stream, filter, expressão lambda. nesse caso não preciso transformar em lista novamente */
		Funcionario funcionario = lista.stream().filter(x -> x.getId() == idFuncionario).findFirst().orElse(null);
		
		if(funcionario == null) {
			System.out.println("Não existe esse funcionário.");
		}else {
			System.out.println("Digite a porcentagem para aumento de salário: ");
			funcionario.aumentarSalario(sc.nextDouble());
		}
		System.out.println("=====================");
		System.out.println("Nova lista:");
		for(Funcionario x : lista) {
			System.out.println(x);
		}

	}

}
