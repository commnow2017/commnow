package com.example.commnowserveractiviti.service.impl;

import com.example.commnowserveractiviti.service.IActivitiService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class ActivitiServiceImpl implements IActivitiService {
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Transactional
    public void startProcess(String process, Map<String, Object> variables){
        runtimeService.startProcessInstanceByKey(process,variables);
    }

    @Transactional
    public List<Task> getTasks(String assignee){
        return taskService.createTaskQuery().taskAssignee(assignee).list();
    }

    @Override
    public void listTasks() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().list();
        for (Task task : tasks) {
            System.out.println("Task available: " + task.getName());
        }
    }
}
