package com.sunny.rest.client;

import com.sunny.rest.bean.User;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.util.List;

/**
 * Created by sundas on 10/21/2017.
 */
public class SunnyServiceClient {

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Client client = javax.ws.rs.client.ClientBuilder.newClient();
    String BASE_URI =
        "http://localhost:8080/SunnyExample/sunny/hello";
    WebTarget  webTarget = client.target(BASE_URI);
//Append departments URI path to Base URI
    WebTarget resource = webTarget;

// Build appropriate request type by specifying the content
// type for the response
    Invocation.Builder builder=resource.
        request(javax.ws.rs.core.MediaType.APPLICATION_JSON);
//Build a GET request invocation
    Invocation invocation=builder.buildGet();
//Invoke the request and receive the response in
// specified format type.
    GenericType<List<User>> responseType=new GenericType<List<User>>() { };
    List<User> users = invocation.invoke(responseType);
    System.out.println(users);
  }
}

