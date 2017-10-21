package com.sunny.rest;

import com.sun.glass.ui.Size;
import com.sunny.rest.bean.User;
import jersey.repackaged.com.google.common.collect.Lists;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/hello")
public class SunnyService {

  @GET
  @Path("/{param}")
  @Produces("text/plain")
  public Response getMsg(@PathParam("param") String msg,@QueryParam("query") String qParam) {

    String output = "Sunny says : " + msg + " and optional query parama = " + qParam;

    return Response.status(200).entity(output).build();

  }


  @POST
  @Path("/{userId}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response addUser(@PathParam("userId") String userId,User user) {
    Response response = null;
    try{
      UserStore.addUser(user,userId);
      String status = "{\"status\": [\"" + "added user = " + userId + " successfully" + "\"]}";
      response = Response.status(200).entity(status).build();
    }catch(IllegalArgumentException e){
      String err = "{\"errors\": [\"" + e.getMessage() + "\"]}";
      System.err.println(err);
      response = Response.status(500).entity(err).build();
    }
    return response;
  }

  @GET
  @Path("/{userId}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response getUser(@PathParam("userId") String userId){
    Response response = null;
    User user = UserStore.getUser(userId);
    if(user != null){
      response = Response.status(Response.Status.OK).entity(user).build();
    }
    else{
      response = Response.status(Response.Status.NOT_FOUND).build();
    }
    return response;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response getUsers(){
    Response response = null;
    List<User> users = UserStore.getUsers();
    if(users != null){
      GenericEntity<List<User>> genericEntity = new GenericEntity<List<User>>(users){};
      response = Response.ok(genericEntity).build();
    }
    else{
      response = Response.status(Response.Status.NOT_FOUND).build();
    }
    return response;
  }

  @PUT
  @Path("/{userId}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response updateUser(@PathParam("userId") String userId,User user){
    Response response = null;
    try{
      UserStore.updateUser(user,userId);
      String status = "{\"status\": [\"" + "updated user = " + userId + " successfully" + "\"]}";
      response = Response.status(200).entity(status).build();
    }catch(IllegalArgumentException e){
      String err = "{\"errors\": [\"" + e.getMessage() + "\"]}";
      System.err.println(err);
      response = Response.status(404).entity(err).build();
    }
    return response;
  }


  @DELETE
  @Path("/{userId}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response deleteUser(@PathParam("userId") String userId){
    Response response = null;
    try{
      UserStore.deleteUser(userId);
      String status = "{\"status\": [\"" + "delete user = " + userId + " successfully" + "\"]}";
      response = Response.status(200).entity(status).build();
    }catch(IllegalArgumentException e){
      String err = "{\"errors\": [\"" + e.getMessage() + "\"]}";
      System.err.println(err);
      response = Response.status(404).entity(err).build();
    }
    return response;
  }



}