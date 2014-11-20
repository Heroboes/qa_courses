package com.dio.courses.abakhtiozin;

/**
 * Created by AA on 19.10.2014.
 */
public class Team {

    private String teamName;
    private Dev developer;
    private BA businessAnalyst;
    private QA tester;

    public Team(String teamName, Dev developer, BA businessAnalyst, QA tester) {
        this.teamName = teamName;
        this.developer = developer;
        this.businessAnalyst = businessAnalyst;
        this.tester = tester;
    }



    public static void main(String[] args) {

        String teamName = "E2E4";
        BA businessAnalyst = new BA("Ivan", "Polyakov");
        QA tester = new QA("Vika", "Petrova");
        Dev developer = new Dev("Maxim", "Romanov");
        Person developer2 = new Dev("kizya","abrashkovich");



        Team team = new Team(teamName, developer, businessAnalyst, tester);

        Task task = team.businessAnalyst.createTask("make order");
        team.businessAnalyst.assigneeOn(task);

        team.businessAnalyst.setTaskStatus(task, TaskStatus.OPEN);

        team.developer.assigneeOn(task);

        if (!team.developer.isInformed()){
            team.developer.askForInformation(businessAnalyst);
        }
        team.developer.doJob(task);

        team.tester.assigneeOn(task);
        if (!team.tester.isInformed()){
            team.tester.askForInformation(businessAnalyst);
        }
        int bugs = 7;
        team.tester.countOfBugs(task,bugs); //first tester's found bugs then do his job, no logic but I dont know how to implement it in another way.

        while (task.getBugsFound() >= 0){
//if developer is really bad :)
            team.tester.doJob(task);
            team.developer.assigneeOn(task);
            team.developer.doJob(task);
            team.tester.assigneeOn(task);
            team.tester.doJob(task);
            task.setBugsFound(bugs--);

        }
        System.out.println(task.getTaskStatus());
    }
}
