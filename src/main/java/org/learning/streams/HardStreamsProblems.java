package org.learning.streams;

import java.util.*;
import java.util.stream.Collectors;

public class HardStreamsProblems {

    public static void main(String[] args) {

        /*
            1️⃣ Problem 1 — Find employee with second highest salary

        Given a list of employees, return the employee with the second highest salary.

        Input:
         */

        class Emp {
            String name;
            int salary;
            Emp(String name, int salary) { this.name = name; this.salary = salary; }

            public int getSalary(){
                return this.salary;
            }
        }

        List<Emp> emps = Arrays.asList(
                new Emp("A", 30000),
                new Emp("B", 45000),
                new Emp("C", 25000),
                new Emp("D", 50000)
        );

        Optional<Emp> secondSalary =emps.stream().sorted(Comparator.comparing(Emp::getSalary).reversed()).skip(1).findFirst();
        System.out.println(secondSalary.get().name + " : " + secondSalary.get().getSalary());
        /*
             2️⃣ Problem 2 — Multi-level grouping

        Group employees first by department, then by salary level:

        "High" if salary > 40000

        "Medium" if 30000 ≤ salary ≤ 40000

        "Low" if salary < 30000

        Input:
         */

        class Employee {
            String name;
            String dept;
            int salary;
            Employee(String name, String dept, int salary) { this.name=name; this.dept=dept; this.salary=salary; }

            public int getSalary(){
                return this.salary;
            }

            public String getName(){
                return this.name;
            }

            public String getDept(){
                return this.dept;
            }
        }

        List<Employee> employees = Arrays.asList(
                new Employee("A", "IT", 30000),
                new Employee("B", "HR", 45000),
                new Employee("C", "IT", 25000),
                new Employee("D", "HR", 38000),
                new Employee("E", "Finance", 50000)
        );

        Map<String,List<Employee>> deptGroup = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept));

        Map<String,List<Employee>> salaryGroup = employees.stream()
                .collect(Collectors.groupingBy(
                        (emp) -> {
                            if(emp.getSalary() > 40000)
                                return "High";
                            else if(emp.getSalary() >=30000 && emp.getSalary() <= 40000)
                                return "Medium";
                            else
                                return "Low";
                        }));
        Map<String,Map<String,List<Employee>>> deptSalaryWise =
                employees.stream().collect(Collectors.groupingBy(Employee::getDept,
                        Collectors.groupingBy(
                                emp -> {
                            if(emp.getSalary() > 40000)
                                return "High";
                            else if(emp.getSalary() >=30000 && emp.getSalary() <= 40000)
                                return "Medium";
                            else
                                return "Low";
                                })
                        ));


        for(String dept : deptSalaryWise.keySet()){
            System.out.println(dept);
            Map<String,List<Employee>> deptMap = deptSalaryWise.get(dept);

            for(String salaryLevel : deptMap.keySet()){
                System.out.print("        " + salaryLevel + " - ");
                List<Employee> salaryLevelList = deptMap.get(salaryLevel);

                for(Employee e : salaryLevelList)
                    System.out.print("              " + e.getName() + " : " + e.salary);

                System.out.println();
            }

            System.out.println();
        }


        /*3️⃣ Problem 3 — Find duplicate elements in list

        Return all elements that occur more than once from a list of integers.

                Input:*/

        List<Integer> numbers = Arrays.asList(1,2,2,3,4,4,5,6,6,6);

        Map<Integer,Long> intermediateMap = numbers.stream().collect(
                Collectors.groupingBy(Integer::intValue,Collectors.counting()));

        List<Integer> dupList  = intermediateMap.entrySet().stream().filter(x->x.getValue()>1).map(Map.Entry::getKey).toList();

        System.out.println(dupList);
       /* 4️⃣ Problem 4 — Longest word in each sentence

        Given a list of sentences, return a map of sentence → longest word.

        Input:*/

        List<String> sentences = Arrays.asList(
                "Java streams are powerful",
                "I love programming",
                "Functional programming is interesting"
        );

//        sentences.stream().collect(Collectors.groupingBy(String::valueOf,
//                Collectors.groupingBy()));

       /* 5️⃣ Problem 5 — Count frequency of characters

        Given a string, count the frequency of each character.

                Input: */

        String str = "hello world";

       /* 6️⃣ Problem 6 — Find first non-repeated element

        Find the first non-repeating element in a list.

        Input:*/

        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");

       /* 7️⃣ Problem 7 — Sum of squares of distinct even numbers

        From a list of integers, calculate the sum of squares of all distinct even numbers.

                Input:*/

        List<Integer> nums = Arrays.asList(2,3,4,2,5,6,4);

        /*8️⃣ Problem 8 — Partition employees by salary > 40000 and get names

        Partition employees into two groups based on salary > 40000, but store only names in the resulting map.

                Input:*/

        List<Employee> employees2 = Arrays.asList(
                new Employee("A", "IT", 30000),
                new Employee("B", "HR", 45000),
                new Employee("C", "IT", 25000),
                new Employee("D", "HR", 50000)
        );

       /* 9️⃣ Problem 9 — Join all employee names

        Return a comma-separated string of all employee names in uppercase.

                Input:*/

        List<Employee> employees3 = Arrays.asList(
                new Employee("A", "IT", 30000),
                new Employee("B", "HR", 45000),
                new Employee("C", "IT", 25000)
        );

/*
🔟 Problem 10 — Generate first N Fibonacci numbers

        Generate a list of first N Fibonacci numbers using streams.

        Input: int N = 10
*/

    }
}
