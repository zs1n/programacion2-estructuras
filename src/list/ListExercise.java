package List;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ListExercise {
    private int currentPhase = 0;
    private List<String> list;
    private Scanner scanner;
    private boolean firstTime = true;
    private boolean running = true;

    public ListExercise(Scanner scnr) {
        this.scanner = scnr;
        list = new ArrayList<>();
    }
    
    // Método que inicia la ejecución del ejercicio
    public void run() {
        while(running) {
            exerciseLogic();
        }
    }

    protected void exerciseLogic() {
        switch(currentPhase) {
            case 0:
                menuLogic();
                break;
            case 1:
                addLogic();
                break;
            case 2:
                removeByIndexLogic();
                break;
            case 3:
                removeByReferenceLogic();
                break;
            case 4:
                clearLogic();
                break;
        }
    }

    private void menuLogic() {
        if(firstTime) {
            firstTime = false;
            System.out.println("\nWelcome to the List Exercise.");
        } else {
            printList();
            printStatus();
        }

        System.out.println("\nChoose an option:"
            + "\nadd - Add element."
            + "\nremoveIndex - Remove element by index."
            + "\nremoveRef - Remove element by reference."
            + "\nclear - Clear list."
            + "\nmm - Main Menu (exit)");

        String userInput = scanner.nextLine().toLowerCase();
        switch(userInput) {
            case "add":
                currentPhase = 1;
                break;
            case "removeindex":
                currentPhase = 2;
                break;
            case "removeref":
                currentPhase = 3;
                break;
            case "clear":
                currentPhase = 4;
                break;
            case "mm":
                running = false;
                break;
            default:
                System.out.println("Invalid input, try again.");
                break;
        }
    }

    private void addLogic() {
        System.out.println("\nEnter a String to add:");
        list.add(scanner.nextLine());

        printList();

        boolean validInput = false;

        while(!validInput) {
            System.out.println("\nAdd another element? y/n");
            String userInput = scanner.nextLine().toLowerCase();
            switch(userInput) {
                case "y":
                    validInput = true;
                    break;
                case "n":
                    validInput = true;
                    currentPhase = 0;
                    break;
                default:
                    System.out.println("Invalid input, try again.");
                    break;
            }
        }
    }

    private void printList() {
        String fullList = String.join(", ", list);
        System.out.println("\nCurrent List: " + fullList);
    }

    private void printStatus() {
        System.out.println("List has " + list.size() + " element(s).");
    }

    private void removeByIndexLogic() {
        printList();
        System.out.println("\nEnter the index to remove (0 to " + (list.size()-1) + "):");
        try {
            int index = Integer.parseInt(scanner.nextLine());
            if(index >= 0 && index < list.size()) {
                String removed = list.remove(index);
                System.out.println("Removed: " + removed);
            } else {
                System.out.println("Invalid index.");
            }
        } catch(NumberFormatException e) {
            System.out.println("Invalid input.");
        }
        currentPhase = 0;
    }

    private void removeByReferenceLogic() {
        printList();
        System.out.println("\nEnter the element to remove by reference:");
        String element = scanner.nextLine();
        if(list.remove(element)) {
            System.out.println("Removed: " + element);
        } else {
            System.out.println("Element not found.");
        }
        currentPhase = 0;
    }

    private void clearLogic() {
        list.clear();
        System.out.println("List cleared.");
        currentPhase = 0;
    }
}
