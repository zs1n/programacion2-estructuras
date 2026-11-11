package application;

import java.util.Scanner;
import list.ListExercise;

public class MainProgram {
    private Exercise exercise;
    public static void main(String[] args) {
        new MainProgram().run();
        }

public void run() {
        selectExercise(new Scanner(System.in));
        exercise.run();

        ListExercise exerciseList = new ListExercise(new Scanner(System.in));
        exerciseList.run();
        
    }

    void selectExercise(Scanner scanner){
        System.out.println("Select exercise:\n 1. Test Exercise\n 2. List Exercise\n 3. Exercise 3\n 0. Exit");

    String userInput = scanner.nextLine();
    if (userInput.equals("0")){
        System.out.println("Exiting...");
        System.exit(0);
    } else if (userInput.equals("1")){
        System.out.println("Running Test Exercise...");
        exercise = new TestExercise(scanner);
    } else if (userInput.equals("2")){
        System.out.println("Running List Exercise...");
        exercise = new ListExercise(scanner);
    } else if (userInput.equals("3")){
        System.out.println("Running Exercise 3...");
        exercise = new TestExercise(scanner);
    } else {
        System.out.println("Invalid input, try again.");
        selectExercise(scanner);
    }
    }
}


