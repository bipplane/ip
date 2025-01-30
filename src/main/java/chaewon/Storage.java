package chaewon;

import tasks.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Storage {
    protected final String filePath;
    protected TaskList tasks = new TaskList();
    protected Ui ui;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void loadTasks() throws FileNotFoundException {
        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String taskString = fileScanner.nextLine();
            String[] taskParts = taskString.split(" \\| ");
            String taskType = taskParts[0];
            boolean isDone = taskParts[1].equals("1");
            String taskName = taskParts[2];
            switch (taskType) {
            case "T":
                tasks.addTask(new TodoTask(taskName, isDone));
                break;
            case "D":
                String by = taskParts[3];
                tasks.addTask(new DeadlineTask(taskName, by, isDone));
                break;
            case "E":
                String from = taskParts[3];
                String to = taskParts[4];
                tasks.addTask(new EventTask(taskName, from, to, isDone));
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