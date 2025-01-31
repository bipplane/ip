package chaewon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tasks.*;

public class TaskListTest {

    private TaskList taskList;

    @BeforeEach
    public void setUp() {
        taskList = new TaskList();
    }

    @Test
    public void addTask_todoTask_success() {
        Task task = new TodoTask("Test todo task");
        taskList.addTask(task);
        assertEquals(1, taskList.getNumTasks());
        assertEquals(task, taskList.getTasks().get(0));
    }

    @Test
    public void addTask_nullTask_exceptionThrown() {
        ChaewonException e = assertThrows(ChaewonException.class, () -> taskList.addTask(null));
        assertEquals("Gurl what? Task cannot be null.", e.getMessage());
    }

    @Test
    public void removeTask_todoTask_success() {
        Task task = new TodoTask("Test task");
        taskList.addTask(task);
        taskList.removeTask(0);
        assertEquals(0, taskList.getNumTasks());
    }

    @Test
    public void removeTask_invalidIndex_exceptionThrown() {
        ChaewonException e = assertThrows(ChaewonException.class, () -> taskList.removeTask(0));
        assertEquals("Invalid task number. Please try again.", e.getMessage());
    }

    @Test
    public void testGetTask() {
        Task task = new TodoTask("Test task");
        taskList.addTask(task);
        Task retrievedTask = taskList.getTasks().get(0);
        assertEquals(task, retrievedTask);
    }

    @Test
    public void testSize() {
        assertEquals(0, taskList.getNumTasks());
        taskList.addTask(new TodoTask("Test task 1"));
        taskList.addTask(new TodoTask("Test task 2"));
        assertEquals(2, taskList.getNumTasks());
    }
}
