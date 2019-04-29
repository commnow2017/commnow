package com.example.commnowserveractiviti.service;

import org.activiti.engine.task.Task;

import java.util.List;
import java.util.Map;

public interface IActivitiService {

    public void startProcess(String process,Map<String, Object> variables);

    public List<Task> getTasks(String assignee);

    public void listTasks();
}
