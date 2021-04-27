package stream.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import day6.task2.Employee;

public class StreamDemo {

	public static void main(String[] args) {
		StreamDemo obj = new StreamDemo();
		//obj.creationOfStreams();
		//obj.terminalOperations();
		//obj.terminal_minMax();
		//obj.intermediate_FilterOperation();
		obj.intermediate_map();
	}
	
	
	void creationOfStreams()
	{
		//#1 ---- stream of collection
		List<Integer> list = new ArrayList<>();
		list.add(15);
		list.add(115);
		list.add(105);
		
		
		Stream<Integer> stream = list.stream();
		
	
		//#2 ---- stream of array
		list = Arrays.asList(15,48,75,69);
		
		// ----
		Stream<Integer> s = Stream.of(15,78,689,15);
		
		Stream<String> s2 = Stream.of("vcer","ever","erfgerger");
		
		
	}
	
	// create Stream of Employees using all 3 above approaches 
	
	
	void terminalOperations()
	{
		List<Integer> list = new ArrayList<>();
		list.add(15);
		list.add(115);
		list.add(105);
		
		
		Stream<Integer> stream = list.stream();
		//stream.forEach((i)->System.out.println(i));
		
		/*
		stream.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
				
			}
			
		});
		
		*/
		// -------- count terminal operation
		
		long x = stream.count();
		System.out.println(x);
		
	}
	
	
	void terminal_minMax()
	{
		List<Integer> list = Arrays.asList(15,8,-2,65,96,78,151,32,85);
		
		int x = list.stream().min((i,j)->i.compareTo(j)).get();
		System.out.println(x);
	}
	
	void terminal_MinMaxEmployee()
	{
		Employee e1 = new Employee("A", 101, 5000, "p1");
		Employee e2 = new Employee("B", 102, 15000, "p1");
		Employee e3 = new Employee("C", 103, 2000, "p1");
		Employee e4 = new Employee("D", 104, 4000, "p1");
		Employee e5 = new Employee("E", 105, 6000, "p1");
		
		Stream<Employee> stream = Stream.of(e1,e2,e3,e4,e5);
		
		Comparator<Employee> bySalaryComparator = (emp1,emp2)->emp1.getSalary()-emp2.getSalary();
	
		
		Employee e = stream.min(bySalaryComparator).get();
		System.out.println(e);
	}
	
	void intermediate_FilterOperation()
	{
		List<Integer> list = Arrays.asList(15,8,-2,65,96,178,151,32,85);
		
		List<Integer> list2 = list.stream().filter(x-> x>40 && x<100).collect(Collectors.toList());
		System.out.println(list2);
		
		//-----------------------------------
		       // 178,151
		for (Integer data : list) {
			
			if(data>40 && data<100) // 96 ,178
			{
				list2.add(data);  // 65 , 96
			}
			
		}
		
		
		System.out.println("------------------------ Employee ---------------------");
		
		Employee e1 = new Employee("A", 101, 5000, "p1");
		Employee e2 = new Employee("B", 102, 15000, "p1");
		Employee e3 = new Employee("C", 103, 2000, "p2");
		Employee e4 = new Employee("D", 104, 4000, "p1");
		Employee e5 = new Employee("E", 105, 6000, "p3");
		
		Stream<Employee> stream = Stream.of(e1,e2,e3,e4,e5);
		
		Comparator<Employee> bySalaryComparator = (emp1,emp2)->emp1.getSalary()-emp2.getSalary();
		
		Employee e = stream.filter((employee)->employee.getProjectName().equals("p1")).min(bySalaryComparator).get();
		
		System.out.println(e);
		
	}
	
	
	public void intermediate_map()
	{
		List<Integer> list = Arrays.asList(2,5,8);
		/* 
		 list.stream().map((x)->{
		 
			return x+=2;
		}).forEach(x->System.out.println(x));
		*/
		
		
		list.stream().map((x)->x+=2).forEach((x)->System.out.println(x));
		//------------------------------------------
		
		Employee e1 = new Employee("A", 101, 5000, "p1");
		Employee e2 = new Employee("B", 102, 15000, "p1");
		Employee e3 = new Employee("C", 103, 2000, "p2");
		Employee e4 = new Employee("D", 104, 4000, "p1");
		Employee e5 = new Employee("E", 105, 6000, "p3");
		
		Stream<Employee> stream = Stream.of(e1,e2,e3,e4,e5);
		
		List<Employee> empList = stream.
				filter((employee)->employee.getProjectName().equals("p1")).				
				map((employee)->{
			int oldSalary = employee.getSalary();
			int newSalary = (int)(oldSalary+oldSalary*0.10);
			employee.setSalary(newSalary);
			return employee;
		}).collect(Collectors.toList());
		
		System.out.println("List "+empList);
		
		System.out.println("p1 e1 "+e1);
		System.out.println("p3 e5 "+e5);
		
	}
	
}//end of class



























