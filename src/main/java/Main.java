import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("HELLO WELCOME TO TASK MANAGER");

        Operations operations = new Operations();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("__________MENU___________");
            System.out.println("1. Add tasks");
            System.out.println("2. Show a task");
            System.out.println("3. Show All Tasks");
            System.out.println("4. Update a task");
            System.out.println("5. Show tasks where time is over spent");
            System.out.println("6. Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter the task name you want to do");
                    String name = sc.next();
                    Task_Data reading = new Task_Data(operations.getLastTaskId() + 1, name, 3);
                    operations.addTask(reading);
                    break;
                case 2:
                    System.out.println("Which task details do u want to see");
                    String task = sc.next();
                    System.out.println("Task Details - > \n" + operations.getTaskDetails(task));
                    break;
                case 3:
                    operations.showAllTasks();
                    break;
                case 4:
                    System.out.println("Which task do you want to update");
                    String t = sc.next();
                    System.out.println("What is the hours spent after previous update");
                    int h = sc.nextInt();
                    operations.updateTask(t, h);
                    break;
                case 5:
                    operations.getTasksOverSpent();
                    break;
                case 6:
                    System.out.println("OK");
                    sc.close();
                    return;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }
}
