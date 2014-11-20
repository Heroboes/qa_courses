package com.dio.courses.abakhtiozin;

/**
 * Created by AA on 19.10.2014.
 */
public class QA extends Person implements Work {

    public QA(String name, String surname) {
        super(name, surname);
    }

    public boolean askForInformation(BA businessAnalyst) {
        return businessAnalyst.giveInformation(this);
    }

    private boolean isInformed = false;

    public boolean isInformed() {
        return isInformed;
    }

    public void setInformed(boolean isInformed) {
        this.isInformed = isInformed;
    }

    public void countOfBugs(Task task, int count) {
        task.setBugsFound(count);
    }

    public void setTaskStatus(Task task, TaskStatus taskStatus) {
        task.setTaskStatus(taskStatus);
    }

    @Override
    public void assigneeOn(Task task) {
        task.setAssigned(this.toString());
        task.setTaskStatus(TaskStatus.IN_TESTING);
    }

    @Override
    public void doJob(Task task) {
        if (task.getTaskStatus() == TaskStatus.IN_TESTING) {
            if (task.getBugsFound() > 0) {
                task.setTaskStatus(TaskStatus.RETURNED);
            } else {
                task.setTaskStatus(TaskStatus.CLOSED);
            }
        }
    }


}
