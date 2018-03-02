import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<Task> incompleteTasks = new ArrayList<>();

    private final String Q_WHAT_TO_DO = "What would you like to do?";

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

}