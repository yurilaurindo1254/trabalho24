package com.mycompany.hello.world.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("javaee8") //anotação indica o caminho do recurso (url)
public class HelloWorldResources {
    
    @GET
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }
}
