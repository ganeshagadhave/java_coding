package exercise.datbase;

import exercise.models.CombineResult;
import exercise.models.Purchase;
import exercise.models.ResultSet;
import exercise.models.User;
import exercise.utilities.CsvFileProcessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Domain model holds different objects
 */
public class Table extends DataBaseTable {

  private List<User> userList;
  private List<Purchase> purchaseList;

  public Table(List<User> users, List<Purchase> purchases) {
    userList = users;
    purchaseList = purchases;

  }

  @Override
  public ResultSet innerJoin(String columnFromRight, String columnFromLeft) {
      List<CombineResult> resultList = new ArrayList<>();
    if (columnFromLeft != null && columnFromRight != null) {
      if (columnFromLeft.equalsIgnoreCase("user_id") && columnFromRight.equalsIgnoreCase(
          "user_id")) {
        // For loop help to visualize the iterations , we can use stream apis
        for (User user : userList) {
          for (Purchase purchase : purchaseList) {
            if (user.getUserId().equals(purchase.getUserId())) {
              resultList.add(new CombineResult(user, purchase));
            }
          }
        }
      }
    }
    ResultSet resultSet = new ResultSet();
    resultSet.setResultList(resultList);
    return resultSet;
  }

  @Override
  public ResultSet orderBy(String columnName) {
    return null;
  }
}
