package com.sunny.rest;

import com.sunny.rest.bean.User;

import java.util.*;

/**
 * Created by sundas on 10/16/2017.
 */
public class UserStore {

  private static Map<String,User> userStoreInternal = new HashMap<>();


  public static void addUser(User user,String userId) throws IllegalArgumentException{
    if(!userStoreInternal.containsKey(userId)){
      user.setId(userId);
      userStoreInternal.put(userId,user);
    }
    else{
      throw new IllegalArgumentException("User = " + userId + " already exists");
    }
  }


  public static User getUser(String id){
    return userStoreInternal.get(id);
  }


  public static List<User> getUsers(){
    Iterator<Map.Entry<String,User>> entryIterator = userStoreInternal.entrySet().iterator();
    List<User> users = new ArrayList<>();
    while(entryIterator.hasNext()){
      users.add(entryIterator.next().getValue());
    }
    return users;
  }

  public static void updateUser(User user,String userId) throws IllegalArgumentException{
    if(userStoreInternal.containsKey(userId)){
      userStoreInternal.put(userId,user);
    }
    else{
      throw new IllegalArgumentException("User = " + userId + " not found");
    }
  }

  public static void deleteUser(String userId)throws IllegalArgumentException{
    if(userStoreInternal.containsKey(userId)){
      userStoreInternal.remove(userId);
    }
    else{
      throw new IllegalArgumentException("User = " + userId + " not found");
    }
  }

}
