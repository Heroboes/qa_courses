package com.dio.courses.abakhtiozin;

/**
 * Created by AA on 19.10.2014.
 */
public class Dev extends Person implements Work {


    public Dev(String name, String surname) {
        super(name, surname);
    }

    private boolean isInformed = false;

    public boolean isInformed() {
        return isInformed;
    }

    public void setInformed(boolean isInformed) {
        this.isInformed = isInformed;
    }

    public boolean askForInformation(BA businessAnalyst){
        return businessAnalyst.giveInformation(this);
    }

    public void setTaskStatus(Task task, TaskStatus taskStatus){
        task.setTaskStatus(taskStatus);
    }

    @Override
    public void doJob(Task task) {
        if (task.getTaskStatus() == TaskStatus.IN_PROGRESS || task.getTaskStatus() == TaskStatus.RETURNED) {
            task.setTaskStatus(TaskStatus.IN_TESTING);
        }
    }
    @Override
    public void assigneeOn(Task task) {
        task.setAssigned(this.toString());
        task.setTaskStatus(TaskStatus.IN_PROGRESS);
    }
}
