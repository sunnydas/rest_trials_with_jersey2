package com.sunny.rest.bean;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sundas on 10/16/2017.
 */
@Produces(MediaType.APPLICATION_JSON)
public class User {

  private String id;

  private String fName;

  private String lName;

  private String address;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "User{" +
        "id='" + id + '\'' +
        ", fName='" + fName + '\'' +
        ", lName='" + lName + '\'' +
        ", address='" + address + '\'' +
        '}';
  }

  public String getfName() {
    return fName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
    if (getfName() != null ? !getfName().equals(user.getfName()) : user.getfName() != null) return false;
    if (getlName() != null ? !getlName().equals(user.getlName()) : user.getlName() != null) return false;
    return !(getAddress() != null ? !getAddress().equals(user.getAddress()) : user.getAddress() != null);

  }

  @Override
  public int hashCode() {
    int result = getId() != null ? getId().hashCode() : 0;
    result = 31 * result + (getfName() != null ? getfName().hashCode() : 0);
    result = 31 * result + (getlName() != null ? getlName().hashCode() : 0);
    result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
    return result;
  }

  public void setfName(String fName) {

    this.fName = fName;
  }

  public String getlName() {
    return lName;
  }

  public void setlName(String lName) {
    this.lName = lName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
