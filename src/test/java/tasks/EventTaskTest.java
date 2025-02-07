package tasks;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chaewon.ChaewonException;
import chaewon.TaskList;

public class EventTaskTest {
    private TaskList taskList;

    /**
     * Sets up the task list for testing.
     */
    @BeforeEach
    public void setUp() {
        taskList = new TaskList();
    }

    /**
     * Tests the addTask method WITH clashing event tasks.
     */
    @Test
    public void addEventTask_conflict_throwsException() {
        EventTask event1 = new EventTask("meeting", "3/1/2019 1400", "3/1/2019 1700");
        EventTask event2 = new EventTask("fortnite", "3/1/2019 1600", "3/1/2019 1800");

        taskList.addTask(event1);
        assertThrows(ChaewonException.class, () -> taskList.addTask(event2));
    }

    /**
     * Tests the addTask method with back-to-back event tasks.
     */
    @Test
    public void addMultipleEventTasks_noConflict_success() {
        EventTask event1 = new EventTask("watch a tv show", "3/1/2019 1400", "3/1/2019 1500");
        EventTask event2 = new EventTask("team meeting", "3/1/2019 1500", "3/1/2019 1600");
        EventTask event3 = new EventTask("client meeting", "3/1/2019 1600", "3/1/2019 1700");

        taskList.addTask(event1);
        taskList.addTask(event2);
        assertDoesNotThrow(() -> taskList.addTask(event3));
    }

    /**
     * Tests the addTask method with an event task starting when another ends.
     */
    @Test
    public void addEventTask_startsWhenAnotherEnds_success() {
        EventTask event1 = new EventTask("touch grass", "3/1/2019 1400", "3/1/2019 1500");
        EventTask event2 = new EventTask("jane street interview", "3/1/2019 1500", "3/1/2019 1600");

        taskList.addTask(event1);
        assertDoesNotThrow(() -> taskList.addTask(event2));
    }

    /**
     * Tests the addTask method with an event task ending before another starts.
     */
    @Test
    public void addEventTask_endsWhenAnotherStarts_success() {
        EventTask event1 = new EventTask("project meeting", "3/1/2019 1400", "3/1/2019 1500");
        EventTask event2 = new EventTask("team meeting", "3/1/2019 1300", "3/1/2019 1400");

        taskList.addTask(event1);
        assertDoesNotThrow(() -> taskList.addTask(event2));
    }
}
