package com.example.commnowserverfeign.server.impl;

import com.example.commnowserverfeign.server.IIndexServer;
import org.springframework.stereotype.Component;

@Component
public class IndexServer implements IIndexServer {
    @Override
    public String getIndex() {
        return "error";
    }
}
