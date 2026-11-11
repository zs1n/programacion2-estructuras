package application;

import java.util.Scanner;

public class TestExercise extends Exercise {
    public TestExercise(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected void exerciseLogic() {
        System.out.println("This is a Exercise test.\nType 'exit' to stop the exercise.");
        
        String userInput = scanner.nextLine().toLowerCase();
        if (userInput.equals("exit")) {
            System.out.println("Exiting from test exercise...");
            running = false;
        }
    }
}