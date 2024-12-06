package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import edu.esprit.game.utils.Data;

import java.util.Comparator;
import java.util.List;

public class Level1 {
    public static void main(String[] args) {
        List<Employee> employees = Data.employees();

        /* TO DO 1: Afficher tous les employ�s */
		System.out.println("TO DO 1: Afficher tous les employ�s");
        employees.stream().forEach(
                System.out::println
        );

        /*
         * TO DO 2: Afficher les employ�s dont le nom commence par la lettre n
         */
		System.out.println("TO DO 2: Afficher les employ�s dont le nom commence par la lettre n");
        employees.stream().filter(
                employee -> employee.getName().startsWith("n")
        ).forEach(
				System.out::println
        );

        /*
         * TO DO 3: Afficher les employ�s dont le nom commence par la lettre n
         * et le salaire> 1000
         */
		System.out.println("TO DO 3: Afficher les employ�s dont le nom commence par la lettre n et le salaire> 1000");
        employees.stream()
				.filter(
                        employee -> employee.getName().startsWith("n")
                )
				.filter(
                        employee -> employee.getSalary() > 1000
                )
                .forEach(
						System.out::println
                );

        /*
         * TO DO 4: Afficher les employ�s dont le nom commence par la lettre s
         * tri�s par salaire
         */
		System.out.println("TO DO 4: Afficher les employ�s dont le nom commence par la lettre s tri�s par salaire");
        employees.stream()
				.filter(
						employee -> employee.getName().startsWith("s")
				)
				.sorted(
						(employee1, employee2) -> employee1.getSalary() - employee2.getSalary()
				)
				.forEach(
						System.out::println
				);

        /*
         * TO DO 5: Afficher les noms des employ�s dont le salaire > 600 avec 2
         * mani�res diff�rentes
         */
        /* First Way */
		System.out.println("TO DO 5: Afficher les noms des employ�s dont le salaire > 600 avec 2 mani�res diff�rentes");
		System.out.println("First Way");
        employees.stream()
				.filter(
						employee -> employee.getSalary() > 600
				)
				.forEach(
						employee -> System.out.println(employee.getName())
				);
        /* Second Way */
		System.out.println("Second Way");
        employees.stream()
				.filter(
						employee -> employee.getSalary() > 600
				)
				.map(
						Employee::getName
				)
                .forEach(
						employee -> System.out.println(employee)
				);

        /*
         * TO DO 6: Ajouter 200 D pour les employ�s dont le nom commence avec m
         * et les affich�s ensuite
         */
		System.out.println("TO DO 6: Ajouter 200 D pour les employ�s dont le nom commence avec m et les affich�s ensuite");
        employees.stream().filter(
				employee -> employee.getName().startsWith("m")
		).forEach(
				employee -> {
					employee.setSalary(employee.getSalary() + 200);
					System.out.println(employee);
				}
		);

    }
}