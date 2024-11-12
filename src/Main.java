import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayList();
            System.out.println("\nMenu Options:");
            System.out.println("A - Add an item to the list");
            System.out.println("D - Delete an item from the list");
            System.out.println("I - Insert an item into the list");
            System.out.println("P - Print the list");
            System.out.println("Q - Quit the program");
            String choice = SafeInput.getRegExString(scanner, "Choose an option: ", "[AaDdIiPpQq]").toUpperCase();

            switch (choice) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    displayList();
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(scanner, "Are you sure you want to quit? (Y/N): ")) {
                        running = false;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addItem() {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter the item to add: ");
        list.add(item);
        System.out.println("Item added.");
    }

    private static void deleteItem() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        displayListWithNumbers();
        int index = SafeInput.getRangedInt(scanner, "Enter the number of the item to delete: ", 1, list.size()) - 1;
        list.remove(index);
        System.out.println("Item deleted.");
    }

    private static void insertItem() {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter the item to insert: ");
        int index = SafeInput.getRangedInt(scanner, "Enter the position to insert at (1 to " + (list.size() + 1) + "): ", 1, list.size() + 1) - 1;
        list.add(index, item);
        System.out.println("Item inserted.");
    }

    private static void displayList() {
        System.out.println("\nCurrent List:");
        for (String item : list) {
            System.out.println("- " + item);
        }
    }

    private static void displayListWithNumbers() {
        System.out.println("\nNumbered List:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}

