import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskManager {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<Task> incompleteTasks = new ArrayList<>();

    private final String Q_WHAT_TO_DO = "What would you like to do?";

    private final String ERR_MUST_BE_A_NUMBER = "Error: Entry must be a number.";

    private final String NEW_LINE = "\n";

    private final String TASK_1 = "1. Add a task";
    private final String TASK_2 = "2. Remove a task";
    private final String TASK_3 = "3. Mark a task complete";
    private final String TASK_4 = "4. List the tasks";

    private final String MAIN_MENU = TASK_1 + NEW_LINE +
            TASK_2 + NEW_LINE +
            TASK_3 + NEW_LINE +
            TASK_4 + NEW_LINE +
            NEW_LINE + Q_WHAT_TO_DO;

    public void start() {

    }

    private void printMenu() {

    }

    private int inputInt(String prompt, Scanner scanner) {
        System.out.println(prompt);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(ERR_MUST_BE_A_NUMBER);
            scanner.next();
            return inputInt(prompt, scanner);
        }
    }

    private String inputString(String prompt, Scanner scanner) {
        System.out.println(prompt);
        String input = "";
        scanner.nextLine();
        if (scanner.hasNext()) {
            input = scanner.nextLine();
        }
        return input;
    }

}