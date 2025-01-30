package chaewon;

import tasks.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Storage {
    protected final String filePath;
    protected TaskList tasks;
    protected Ui ui;

    public Storage(String filePath, TaskList tasks) {
        this.filePath = filePath;
        this.tasks = tasks;

    }

    public void loadTasks() throws FileNotFoundException {
    File file = new File(filePath);
    Scanner fileScanner = new Scanner(file);
    DateTimeFormatter formatTo = DateTimeFormatter.ofPattern("d MMM yyyy HH:mm");
    while (fileScanner.hasNextLine()) {
        String taskString = fileScanner.nextLine();
        String taskType = taskString.substring(1, 2);
        boolean isDone = taskString.substring(4, 5).equals("X");
        String taskName;
        switch (taskType) {
        case "T":
            taskName = taskString.substring(7);
            tasks.addTask(new TodoTask(taskName, isDone));
            break;
        case "D":
            int byIndex = taskString.indexOf("(by: ");
            taskName = taskString.substring(7, byIndex - 1);
            String by = taskString.substring(byIndex + 5, taskString.length() - 1);
            LocalDateTime byDateTime = LocalDateTime.parse(by, formatTo);
            tasks.addTask(new DeadlineTask(taskName, byDateTime, isDone));
            break;
        case "E":
            int fromIndex = taskString.indexOf("(from: ");
            int toIndex = taskString.indexOf(" to: ");
            taskName = taskString.substring(7, fromIndex - 1);
            String from = taskString.substring(fromIndex + 7, toIndex);
            String to = taskString.substring(toIndex + 5, taskString.length() - 1);
            LocalDateTime fromDateTime = LocalDateTime.parse(from, formatTo);
            LocalDateTime toDateTime = LocalDateTime.parse(to, formatTo);
            tasks.addTask(new EventTask(taskName, fromDateTime, toDateTime, isDone));
            break;
        default:
            break;
        }
    }
}

    public void saveTasks() {
    try {
        File file = new File(filePath);
        FileWriter fileWriter = new FileWriter(file);
        for (Task task : tasks.getTasks()) {
            String taskType = "";
            if (task instanceof TodoTask) {
                taskType = "T";
            } else if (task instanceof DeadlineTask) {
                taskType = "D";
            } else if (task instanceof EventTask) {
                taskType = "E";
            }
            String isDone = task.isDone() ? "X" : " ";
            String taskString = "[" + taskType + "][" + isDone + "] " + task.getTaskName();
            if (task instanceof DeadlineTask) {
                taskString += " (by: " + ((DeadlineTask) task).getBy() + ")";
            } else if (task instanceof EventTask) {
                taskString += " (from: " + ((EventTask) task).getFrom() + " to: " + ((EventTask) task).getTo() + ")";
            }
            fileWriter.write(taskString + "\n");
        }
        fileWriter.close();
    } catch (IOException e) {
        System.out.println("Error saving tasks to file.");
    }
    }
}