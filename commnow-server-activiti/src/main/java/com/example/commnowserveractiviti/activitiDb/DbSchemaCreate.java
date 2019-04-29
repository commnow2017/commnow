package com.example.commnowserveractiviti.activitiDb;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;

public class DbSchemaCreate {

    /*创建Activiti所需的数据库表*/
    public static void main(String[] args) {
        ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResourceDefault()
                .setDatabaseSchemaUpdate(ProcessEngineConfigurationImpl.DB_SCHEMA_UPDATE_CREATE)
                .buildProcessEngine();
    }

}
