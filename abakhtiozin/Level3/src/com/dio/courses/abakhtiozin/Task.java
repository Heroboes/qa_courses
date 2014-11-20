package com.dio.courses.abakhtiozin;

/**
 * Created by AA on 19.10.2014.
 */
public class Task {

    private String description;
    private TaskStatus taskStatus;
    private String assigned;

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskSummary() {
        return taskSummary;
    }

    private String taskSummary;

    private int bugsFound;

    public int getBugsFound() {
        return bugsFound;
    }

    public void setBugsFound(int bugsFound) {
        this.bugsFound = bugsFound;
    }

    public void setTaskSummary(String taskSummary) {
        this.taskSummary = taskSummary;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getDescription() {
        return description;
    }

    public Task( String description) {
        this.description = description;
    }
}
