package tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Represents a deadline task test.
 */
public class DeadlineTaskTest {

    /**
     * Tests the creation of a deadline task.
     */
    @Test
    public void createDeadlineTask_success() {
        DeadlineTask task = new DeadlineTask("return book", "2/12/2019 1800");
        assertEquals("[D][ ] return book (by: 2 Dec 2019 18:00)", task.toString());
    }

    /**
     * Tests the marking of a deadline task.
     */
    @Test
    public void testMarkAsDone() {
        DeadlineTask task = new DeadlineTask("return book", "2/12/2019 1800");
        task.markAsDone();
        assertTrue(task.isDone());
    }

    /**
     * Tests the unmarking of a deadline task.
     */
    @Test
    public void testMarkAsUndone() {
        DeadlineTask task = new DeadlineTask("return book", "2/12/2019 1800");
        task.markAsDone();
        task.markAsUndone();
        assertFalse(task.isDone());
    }
}
