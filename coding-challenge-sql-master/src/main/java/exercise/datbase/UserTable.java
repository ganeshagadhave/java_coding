package exercise.datbase;

import exercise.models.ResultSet;
import exercise.models.User;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class UserTable extends DataBaseTable{

  private List<User> userList;

  public UserTable(List<User>users) {
    userList = users;

  }

  @Override
  public ResultSet orderBy(String columnName) {

    sortByColumnName(columnName);
    ResultSet<User> resultSet = new ResultSet<>();
    resultSet.setResultList(userList);

    return resultSet;
  }

  //TODO: remove ifs with some dynamic name matching option, use enum may help
  private void sortByColumnName(String columnName) {
    if (null != columnName) {
      sortByUserId(columnName);
      sortByName(columnName);
      sortByEmail(columnName);
    }
  }

  private void sortByUserId(String columnName) {
    if (columnName.equalsIgnoreCase("user_id")) {
      final Function<User, String> factor = User::getUserId;
      userList.sort(Comparator.comparing(factor));
    }
  }

  private void sortByName(String columnName) {
    if (columnName.equalsIgnoreCase("name")) {
      final Function<User, String> factor = User::getName;
      userList.sort(Comparator.comparing(factor));
    }
  }

  private void sortByEmail(String columnName) {
    if (columnName.equalsIgnoreCase("email")) {
      final Function<User, String> factor = User::getEmail;
      userList.sort(Comparator.comparing(factor));
    }
  }

}
