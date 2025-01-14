package org.hbrs.se1.ws24.uebung10;


public class CheckPersonTest {
    public static void main(String[] args) {
        CheckPerson checker = new CheckPerson();

        // Test Case 1: Negatives Alter
        try {
            Person person = new Person("Test", -5);
            checker.checkSolvency(person);
        } catch (ArithmeticException e) {
            System.out.println("TC1 passed: " + e.getMessage());
        }

        // Test Case 2: Alter = 0
        try {
            Person person = new Person("Test", 0);
            checker.checkSolvency(person);
        } catch (ArithmeticException e) {
            System.out.println("TC2 passed: " + e.getMessage());
        }

        // Test Case 3: Kind
        Person child = new Person("Child", 10);
        int result = checker.checkSolvency(child);
        System.out.println("TC3 passed: " + (result == 0));

        // Test Case 4: Erwachsener
        Person adult = new Person("Adult", 30);
        result = checker.checkSolvency(adult);
        System.out.println("TC4 passed: " + (result == 1));

        // Test Case 5: Senior
        Person senior = new Person("Senior", 70);
        result = checker.checkSolvency(senior);
        System.out.println("TC5 passed: " + (result == 2));
    }
}
