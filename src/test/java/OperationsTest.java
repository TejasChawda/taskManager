import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class OperationsTest {

    Operations ops;

    @BeforeAll
    public static void setUp(){
        System.out.println("Starting Tests");
    }

    @BeforeEach
    public void instantiate(){
        ops = new Operations();
    }

    @Test
    public void testAddTaskAndGetTaskDetails() {

        Task_Data task = new Task_Data(1, "Study Java", 5);

        ops.addTask(task);

        Task_Data result = ops.getTaskDetails("Study Java");

        assertNotNull(result);
        assertEquals(1, result.getTaskId());
        assertEquals("Study Java", result.getTaskName());
        assertEquals(5, result.getHoursPlanned());
    }

    @Test
    public void shouldUpdateHoursSpentForExistingTask(){

        Task_Data task = new Task_Data(1, "Jenkins", 3);

        ops.addTask(task);

        assertEquals(0, ops.getTaskDetails("Jenkins").getHoursSpent());

        int hoursSpent = 4;
        ops.updateTask("Jenkins", hoursSpent);

        assertEquals(hoursSpent, ops.getTaskDetails("Jenkins").getHoursSpent());
    }

    @Test
    public void shouldReturnExactIdOfLastTask(){

        String[] tasks = new String[]{"Java", "js", "ts", "jenkins", "ci/cd"};

        int count = tasks.length;

        for(int i = 0 ; i < count ; i++){
            Task_Data data = new Task_Data(i+1, tasks[i], 3);
            ops.addTask(data);
        }

        assertEquals(count ,ops.getLastTaskId());
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("Tests Executed..... :)");
    }
}