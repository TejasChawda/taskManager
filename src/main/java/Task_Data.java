public class Task_Data {

    private final int taskId;
    private final String taskName;
    private int hoursSpent;
    private final int hoursPlanned;

    public Task_Data(int taskId, String taskName, int hoursPlanned) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.hoursPlanned = hoursPlanned;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getHoursSpent() {
        return hoursSpent;
    }

    public int getHoursPlanned() {
        return hoursPlanned;
    }

    public void setHoursSpent(int hoursSpent) {
        this.hoursSpent = hoursSpent;
    }
}
