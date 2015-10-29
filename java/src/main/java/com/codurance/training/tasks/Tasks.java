package com.codurance.training.tasks;

import java.util.ArrayList;
import java.util.List;

import static com.codurance.training.tasks.Task.MARKED_AS_DONE;
import static com.codurance.training.tasks.Task.NOT_MARKED_AS_DONE;

public class Tasks {
    public static final Tasks NO_TASKS = null;

    private static final String PRINT_LINE_FORMATTER = "    [%c] %d: %s%n";

    private static final char TASK_DONE_SYMBOL = 'x';
    private static final char TASK_NOT_DONE_SYMBOL = ' ';

    private List<Task> tasksList = new ArrayList<>();

    public void add(Task task) {
        tasksList.add(task);
    }

    public boolean setDone(int id, boolean done) {
        for (Task task : tasksList) {
            if (task.setDoneUsing(id, done)) return MARKED_AS_DONE;
        }
        return NOT_MARKED_AS_DONE;
    }

    public void show(Screen out) {
        for (Task task : tasksList) {
            out.printf(PRINT_LINE_FORMATTER, (
                            task.isDone()
                                    ? TASK_DONE_SYMBOL
                                    : TASK_NOT_DONE_SYMBOL),
                    task.getId(), task.getDescription());
        }
    }
}
