package exercise;

import exercise.datbase.DataBaseTable;
import exercise.datbase.PurchaseTable;
import exercise.datbase.Table;
import exercise.datbase.UserTable;
import exercise.models.Purchase;
import exercise.models.ResultSet;
import exercise.models.User;
import exercise.utilities.CsvFileProcessor;
import java.util.List;

public class MainClass {



  public static void main(String[] args) {

    List<User> userList = CsvFileProcessor.UserCsvProcess();
    List<Purchase> purchaseList = CsvFileProcessor.purchaseCsvProcess();

    System.out.println("================= Order By user_id on User table ========================");
    DataBaseTable userTable = new UserTable(userList);
    ResultSet resultSet = userTable.orderBy("user_id");
    resultSet.getResultList().forEach(System.out::println);

    System.out.println("================= Order By user_id on Purchase table =====================");
    DataBaseTable purchaseTable = new PurchaseTable(purchaseList);
    ResultSet resultSetPurchase = purchaseTable.orderBy("user_id");
    resultSetPurchase.getResultList().forEach(System.out::println);

    System.out.println("================= Inner join on both table ========================");
    DataBaseTable combineQueries = new Table(userList, purchaseList);
    ResultSet innerJoinResult = combineQueries.innerJoin("user_id", "user_id");
    innerJoinResult.getResultList().forEach(System.out::println);

  }
}
