package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import edu.esprit.game.utils.Data;
//import static jdk.nashorn.internal.objects.NativeArray.map;

public class Level3 {
	public static void main(String[] args) {
		List<Employee> employees = Data.employees();


		/* TO DO 1: Retourner une chaine de caract�re qui contient tous les noms des employ�s */
		String names = employees.stream()
				.map(
						employee -> employee.getName()
				)
				.reduce("", (name1, name2) -> name1 + " " + name2);
		System.out.println("TO DO 1: Retourner une chaine de caract�re qui contient tous les noms des employ�s");
		System.out.println(names);

		/* TO DO 2: Retourner une chaine de caract�re qui contient tous les noms des employ�s en majuscule separ�s par # */
		String namesMajSplit = employees.stream()
				.map(
						employee -> employee.getName().toUpperCase()
				)
				.reduce("", (name1, name2) -> name1 + "#" + name2);
		System.out.println("TO DO 2: Retourner une chaine de caract�re qui contient tous les noms des employ�s en majuscule separ�s par #");
		System.out.println(namesMajSplit);

		/* TO DO 3: Retourner une set d'employ�s*/
		Set<Employee> emps = employees.stream().
				collect(Collectors.toSet());
		System.out.println("TO DO 3: Retourner une set d'employ�s");
		System.out.println(emps);

		/* TO DO 4: Retourner une TreeSet d'employ�s (tri par nom) */
		TreeSet<Employee> emps2 = employees.stream()
				.collect(Collectors.toCollection(
						() -> new TreeSet<Employee>((e1, e2) -> e1.getName().compareTo(e2.getName()))
				));
		System.out.println("TO DO 4: Retourner une TreeSet d'employ�s (tri par nom)");
		System.out.println(emps2);

		/* TO DO 5: Retourner une Map qui regroupe les employ�s par salaire */
		Map<Integer, List<Employee>> map = employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalary));
		System.out.println("TO DO 5: Retourner une Map qui regroupe les employ�s par salaire");
		System.out.println(map);

		/* TO DO 6: Retourner une Map qui regroupe les nom des employ�s par salaire */
		Map<Integer, String> mm = employees.stream()
				.collect(Collectors.toMap(
						Employee::getSalary,
						Employee::getName,
						(name1, name2) -> name1 + ", " + name2
				));
		System.out.println("TO DO 6: Retourner une Map qui regroupe les nom des employ�s par salaire");
		System.out.println(mm);


		/* TO DO 7: Retourner le  min, max,average, sum,count des salaires */
		String s = employees.stream().
				collect(Collectors.summarizingInt(Employee::getSalary)).toString();
		System.out.println("TO DO 7: Retourner le  min, max,average, sum,count des salaires");
		System.out.println(s);


	}
}
