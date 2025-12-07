package org.learning.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MediumStreamsProblems {

    public static void main(String[] args) {

        /*
            1️⃣ Problem 1 — Find the longest string

        Find the longest name from the list.

                Input:
         */

        List<String> names = Arrays.asList("Harish", "Alexander", "Bob", "Christopher");

        //Soln-1
        Optional<String> longestName = names.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst();
        System.out.println(longestName.get());
        //Soln-2
        Optional<String> maxLength = names.stream().max(Comparator.comparing(String::length));
        System.out.println(maxLength.get());

        /*
            2️⃣ Problem 2 — Flatten list of lists

        Convert List<List<Integer>> into List<Integer>.

        Input:
         */

        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        //Soln-1
        List<Integer> singleList = lists.stream().flatMap(list -> list.stream()).toList();
        //Soln-2
        List<Integer> flattenList = lists.stream().flatMap(List::stream).toList();



        /*
            3️⃣ Problem 3 — Sum all numbers

        Find the total sum of numbers.

        Input:
         */

        List<Integer> nums = Arrays.asList(5, 10, 15, 20);

        //Soln-1
        int total = nums.stream().reduce(0,Integer::sum);
        System.out.println(total);

        //Soln-2
        int numsSum = nums.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println(numsSum);

        //Soln-3
        int SumNums = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println(SumNums);

        /*
             4️⃣ Problem 4 — Group employees by department

        Group employees by department name.

                Input:
         */

        class Employee {
            String name;
            String dept;
            Employee(String name, String dept) { this.name = name; this.dept = dept; }

            public String getDept(){
                return this.dept;
            }
        }

        List<Employee> employees = Arrays.asList(
                new Employee("A", "IT"),
                new Employee("B", "HR"),
                new Employee("C", "IT"),
                new Employee("D", "HR"),
                new Employee("E", "Finance")
        );

        //Soln-1
        Map<String,List<Employee>> deptMap = employees.stream().collect(Collectors.groupingBy(Employee::getDept));

        //Soln-2

        Map<String,List<Employee>> deptMap2 = employees.stream().collect(Collectors.toMap(emp -> emp.getDept(),
                e-> new ArrayList<>(Arrays.asList(e)),
                (existing,replacement) -> {
                    existing.addAll(replacement);
                    return  existing;
                }
                ));
        /*
            5️⃣ Problem 5 — Partition numbers into even and odd

        Split the list into even and odd groups.

        Input:
         */

        List<Integer> data = Arrays.asList(1,2,3,4,5,6,7,8);

        Map<String,List<Integer>> map=data.stream().collect(Collectors.groupingBy(x->x%2==0 ? "Even" : "Odd"
        ));

        for(String keys : map.keySet()){
            System.out.println( keys + " : "  + map.get(keys));
        }

        /*
            6️⃣ Problem 6 — Get average age

        Find the average value of ages.

        Input:
         */

        List<Integer> ages = Arrays.asList(20, 30, 25, 35, 40);

        //Soln-1
        Double avgAge = ages.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(avgAge);

        //Soln-2
        OptionalDouble average = ages.stream().mapToInt(Integer::intValue).average();
        System.out.println(average);

        //Soln-3
        Double average2=ages.stream().reduce(0,Integer::sum) / (double)ages.size();
        System.out.println(average2);

        /*
            7️⃣ Problem 7 — Debug the pipeline

        Print each number during processing, then calculate total sum.

                Input:
         */

        List<Integer> nums2 = Arrays.asList(1,2,3,4,5);

        int totalsum = nums2.stream().peek(System.out::println).reduce(0,Integer::sum);

        System.out.println(totalsum);

        /*
            8️⃣ Problem 8 — Sort employees by salary

        Sort employees by salary in descending order.

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

        List<Emp> sortedEmp = emps.stream().sorted(Comparator.comparing(Emp::getSalary).reversed()).toList();

        System.out.println();
        for(Emp e : sortedEmp){
            System.out.print(e.getSalary() + " ");
        }

        System.out.println();

        /*
            9️⃣ Problem 9 — Find minimum number

        Find and return the minimum value.

        Input:
         */

        List<Integer> nums3 = Arrays.asList(10, 3, 7, 1, 9);

        Optional<Integer> minValue = nums3.stream().min(Comparator.comparing(Integer::intValue));

        System.out.println(minValue);

        /*
            🔟 Problem 10 — Names starting with A

        Return all names that start with the letter "A".

                Input:
         */

        List<String> names2 = Arrays.asList("Arun", "Bala", "Anita", "Charles", "Akash","Ezhil");

        List<String> namesStr =names2.stream().filter(x->x.charAt(0)=='A').toList();
        System.out.println(namesStr);

        List<String> vowelsName = names2.stream().filter(x->x.toUpperCase().matches("^[AEIOU].*")).toList();
        System.out.println(vowelsName);
    }
}
