package com.dio.courses.abakhtiozin;

/**
 * Created by AA on 19.10.2014.
 */
public class BA extends Person implements Work {

    public BA(String name, String surname) {
        super(name, surname);
    }


    public Task createTask(String description){
        return new Task(description);
    }

    public boolean giveInformation(QA qa){
        qa.setInformed(true);
        return qa.isInformed();
    }

    public boolean giveInformation(Dev dev){
        dev.setInformed(true);
        return dev.isInformed();
    }

    @Override
    public void doJob(Task task) {
        task.setTaskSummary("make order form on site and database tables");
    }

    @Override
    public void setTaskStatus(Task task, TaskStatus taskStatus) {

    }

    @Override
    public void assigneeOn(Task task) {
        task.setAssigned(this.toString());
    }
}
