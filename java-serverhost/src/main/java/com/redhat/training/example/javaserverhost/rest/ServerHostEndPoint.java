package com.redhat.training.example.javaserverhost.rest;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.net.InetAddress;

@Path("/")
public class ServerHostEndPoint {

  static final String ANSI_RESET = "\u001B[0m";
  static final String ANSI_RED = "\u001B[31m";
  @GET
  @Produces("text/plain")
  public Response doGet() {
    String host = "";
    try {
      host = InetAddress.getLocalHost().getHostName();
    }
    catch (Exception e) {
       e.printStackTrace();
    }
    //String msg = "I am running on server "+host+" Version 1.0 \n";
    String msg = "I am running on server "+ANSI_RED+host+ANSI_RESET+" Version 2.0 \n";
    return Response.ok(msg).build();
  }
}

