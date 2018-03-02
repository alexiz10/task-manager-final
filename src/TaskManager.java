import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskManager {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<Task> incompleteTasks = new ArrayList<>();

    private final String Q_WHAT_TO_DO = "What would you like to do?";

    private final String ERR_MUST_BE_A_NUMBER = "Error: Entry must be a number.";
    private final String ERR_NO_SUCH_OPTION = "Error: There is no such option.";
    private final String ERR_NO_TASKS = "Error: There are no tasks.";

    private final String NEW_LINE = "\n";
    private final String ADD_TASK = "Add task:";
    private final String COMPLETE = " (COMPLETE)";

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
        printMenu();
        scanner.close();
    }

    private void printMenu() {
        int selection = inputInt(MAIN_MENU, scanner);
        while (selection != 9) {
            switch (selection) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    markTaskComplete();
                    break;
                case 4:
                    listTasks(false);
                    break;
                default:
                    System.out.println(ERR_NO_SUCH_OPTION);
            }
            selection = inputInt(MAIN_MENU, scanner);
        }
    }

    private void addTask() {
        String task = inputString(ADD_TASK, scanner);
        tasks.add(new Task.TaskBuilder(task, false).build());
        incompleteTasks.add(tasks.get(tasks.size() - 1));
    }

    private void removeTask() {

    }

    private void markTaskComplete() {

    }

    private void listTasks(boolean onlyIncomplete) {
        StringBuilder outputBuilder = new StringBuilder();
        if (onlyIncomplete) {
            if (incompleteTasks.size() == 0) {
                outputBuilder.append(ERR_NO_TASKS + NEW_LINE);
            } else {
                for (int i = 0; i < incompleteTasks.size(); i++) {
                    outputBuilder.append(i + 1).append(". ");
                    outputBuilder.append(incompleteTasks.get(i).getName());
                    outputBuilder.append(NEW_LINE);
                }
            }
        } else {
            if (tasks.size() == 0) {
                outputBuilder.append(ERR_NO_TASKS + NEW_LINE);
            } else {
                for (int i = 0; i < tasks.size(); i++) {
                    outputBuilder.append(i + 1).append(". ");
                    outputBuilder.append(tasks.get(i).getName());
                    if (tasks.get(i).isCompleted()) {
                        outputBuilder.append(COMPLETE);
                    }
                    outputBuilder.append(NEW_LINE);
                }
            }
        }
        System.out.println(outputBuilder.toString());
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