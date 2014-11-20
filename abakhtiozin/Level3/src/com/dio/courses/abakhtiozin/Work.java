package com.dio.courses.abakhtiozin;

/**
 * Created by AA on 19.10.2014.
 */
public interface Work {

    public void doJob(Task task);
    public void setTaskStatus(Task task, TaskStatus taskStatus);
    public void assigneeOn(Task task);
}
