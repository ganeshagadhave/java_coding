package exercise.models;

import com.opencsv.bean.CsvBindByName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class User {

  @CsvBindByName
  private String user_id;

  @CsvBindByName
  private String name;

  @CsvBindByName
  private String email;

  public String getUserId() {
    return user_id;
  }

  public void setUserId(String userId) {
    this.user_id = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("user_id", user_id)
        .append("name", name)
        .append("email", email)
        .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    User user = (User) o;

    if (!user_id.equals(user.user_id)) {
      return false;
    }
    if (!name.equals(user.name)) {
      return false;
    }
    return email != null ? email.equals(user.email) : user.email == null;
  }

  @Override
  public int hashCode() {
    int result = user_id.hashCode();
    result = 31 * result + name.hashCode();
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }
}
