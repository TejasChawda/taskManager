import java.util.*;

public class Operations {

    List<Task_Data> tasks = new ArrayList<>();

    public void addTask(Task_Data t){
        tasks.add(t);
    }

    public void showAllTasks(){
        if (!tasks.isEmpty()) {
            for (Task_Data task : tasks) {
                System.out.println(
                        "TASK -> ID: " + task.getTaskId() +
                                ", Name: " + task.getTaskName() +
                                ", Planned: " + task.getHoursPlanned() +
                                ", Spent: " + task.getHoursSpent()
                );
            }
        } else {
            System.out.println("No tasks found !");
        }
    }

    public void updateTask(String taskName, int hours){
        for (Task_Data task : tasks) {
            if (task.getTaskName().equals(taskName)) {
                task.setHoursSpent(hours);
                break;
            }
        }
    }

    public Task_Data getTaskDetails(String taskName){
        for (Task_Data task : tasks) {
            if (task.getTaskName().equals(taskName)) {
                return task;
            }
        }
        return null;
    }

    public int getLastTaskId(){
        if(tasks.isEmpty()){
            return 0;
        }

        int max = 0;

        for (Task_Data task : tasks) {
            if (task.getTaskId() > max) {
                max = task.getTaskId();
            }
        }

        return max;
    }

    public void getTasksOverSpent(){
        for(Task_Data task : tasks){
            if(task.getHoursSpent() > task.getHoursPlanned()){
                System.out.println("TASK -> " +"ID: " + task.getTaskId() +
                                             ", Name: " + task.getTaskName() +
                                             ", Planned: " + task.getHoursPlanned() +
                                             ", Spent: " + task.getHoursSpent()
                );
            }
        }
    }
}