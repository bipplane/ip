package tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DeadlineTaskTest {

    @Test
    public void createDeadlineTask_success() {
        DeadlineTask task = new DeadlineTask("return book", "2/12/2019 1800");
        assertEquals("[D][ ] return book (by: 2 Dec 2019 18:00)", task.toString());
    }

    @Test
    public void testMarkAsDone() {
        DeadlineTask task = new DeadlineTask("return book", "2/12/2019 1800");
        task.markAsDone();
        assertTrue(task.isDone());
    }

    @Test
    public void testMarkAsUndone() {
        DeadlineTask task = new DeadlineTask("return book", "2/12/2019 1800");
        task.markAsDone();
        task.markAsUndone();
        assertFalse(task.isDone());
    }
}
