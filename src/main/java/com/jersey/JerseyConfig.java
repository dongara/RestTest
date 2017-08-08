package com.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.service.facade.FileRestService;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(FileRestService.class);
    }

}
