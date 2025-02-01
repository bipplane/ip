package chaewon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tasks.Task;
import tasks.TodoTask;

/**
 * Represents a task list test.
 */
public class TaskListTest {

    private TaskList taskList;

    /**
     * Sets up the task list for testing.
     */
    @BeforeEach
    public void setUp() {
        taskList = new TaskList();
    }

    /**
     * Tests the addTask method.
     */
    @Test
    public void addTask_todoTask_success() {
        Task task = new TodoTask("Test todo task");
        taskList.addTask(task);
        assertEquals(1, taskList.getNumTasks());
        assertEquals(task, taskList.getTasks().get(0));
    }

    /**
     * Tests the addTask method with a null task.
     */
    @Test
    public void addTask_nullTask_exceptionThrown() {
        ChaewonException e = assertThrows(ChaewonException.class, () -> taskList.addTask(null));
        assertEquals("Gurl what? Task cannot be null.", e.getMessage());
    }

    /**
     * Tests the removeTask method.
     */
    @Test
    public void removeTask_todoTask_success() {
        Task task = new TodoTask("Test task");
        taskList.addTask(task);
        taskList.removeTask(0);
        assertEquals(0, taskList.getNumTasks());
    }

    /**
     * Tests the removeTask method with an invalid index.
     */
    @Test
    public void removeTask_invalidIndex_exceptionThrown() {
        ChaewonException e = assertThrows(ChaewonException.class, () -> taskList.removeTask(0));
        assertEquals("Invalid task number. Please try again.", e.getMessage());
    }

    /**
     * Tests the getTask method.
     */
    @Test
    public void testGetTask() {
        Task task = new TodoTask("Test task");
        taskList.addTask(task);
        Task retrievedTask = taskList.getTasks().get(0);
        assertEquals(task, retrievedTask);
    }

    /**
     * Tests the getNumTasks method.
     */
    @Test
    public void testSize() {
        assertEquals(0, taskList.getNumTasks());
        taskList.addTask(new TodoTask("Test task 1"));
        taskList.addTask(new TodoTask("Test task 2"));
        assertEquals(2, taskList.getNumTasks());
    }
}
