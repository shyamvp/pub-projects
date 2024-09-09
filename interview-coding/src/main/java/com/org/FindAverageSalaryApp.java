package com.org;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class FindAverageSalaryApp {

    public void findAverageSalary(List<Employee> employees) {
        // group employee by office location and collect it in list
        Map<String, List<Employee>> employeesGroupedByLocation = employees.parallelStream()
                .collect(Collectors.groupingByConcurrent(Employee::getOfficeLocation));

        //group by designation collected in list
        employeesGroupedByLocation.forEach((location, employeeList) -> {
            Map<String, Double> employeeMap = employeeList.parallelStream()
                    // group employee by designation and calculate average salary
                    .collect(Collectors.groupingByConcurrent(Employee::getDesignation, Collectors.averagingDouble(Employee::getSalary)));
            employeeMap.forEach((k, v) -> System.out.printf("%s --> %s --> %s \n",location,k,printDouble(v)));
        });
    }

    /*
    * it will print double if amount has decimal value otherwise it will print without decimal value.
    */
    private String printDouble(Double amount){
        return amount%10==0? String.format("%.0f",amount):String.format("%.2f",amount);
    }
}

class SampleApp {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Ashish", "A", "IT", "Pune", "Software Engineer", Double.valueOf(10000)));
        employees.add(new Employee("Amit", "R", "HR", "Pune", "Recruiter", Double.valueOf(12000)));
        employees.add(new Employee("Ramesh", "D", "HR", "Pune", "Senior Recruiter", Double.valueOf(14000)));
        employees.add(new Employee("Jaya", "S", "IT", "Pune", "Tech Lead", Double.valueOf(15000)));
        employees.add(new Employee("Smita", "M", "IT", "Bangalore", "Recruiter", Double.valueOf(16000)));
        employees.add(new Employee("Umesh", "A", "IT", "Bangalore", "Software Engineer", Double.valueOf(12000)));
        employees.add(new Employee("Pooja", "R", "HR", "Bangalore", "Software Engineer", Double.valueOf(12000)));
        employees.add(new Employee("Ramesh", "D", "HR", "Pune", "Recruiter", Double.valueOf(16000)));
        employees.add(new Employee("Bobby", "S", "IT", "Bangalore", "Tech Lead", Double.valueOf(20000)));
        employees.add(new Employee("Vipul", "M", "IT", "Bangalore", "Software Engineer", Double.valueOf(14000)));

        FindAverageSalaryApp app = new FindAverageSalaryApp();
        app.findAverageSalary(employees);

    }

}
