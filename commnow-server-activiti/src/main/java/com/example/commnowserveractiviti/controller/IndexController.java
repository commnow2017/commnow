package com.example.commnowserveractiviti.controller;

import com.example.commnowserveractiviti.service.IActivitiService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private IActivitiService activitiService;

    @RequestMapping(value="/process")
    public void startProcessInstance(String process) {
        activitiService.startProcess(process,null);
    }

    @RequestMapping(value="/tasks", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public List<IndexController.TaskRepresentation> getTasks(@RequestParam String assignee) {
        List<Task> tasks = activitiService.getTasks(assignee);
        List<IndexController.TaskRepresentation> dtos = new ArrayList<IndexController.TaskRepresentation>();
        for (Task task : tasks) {
            dtos.add(new IndexController.TaskRepresentation(task.getId(), task.getName()));
        }
        return dtos;
    }

    @RequestMapping(value="/list")
    public void listTasks(){
        activitiService.listTasks();
    }
    static class TaskRepresentation {

        private String id;
        private String name;

        public TaskRepresentation(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

    }

}
