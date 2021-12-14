package exercise.datbase;

import exercise.models.Purchase;
import exercise.models.ResultSet;
import exercise.utilities.CsvFileProcessor;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class PurchaseTable extends DataBaseTable{

  private List<Purchase> purchaseList;

  public PurchaseTable(List<Purchase> purchases) {
    purchaseList = purchases;

  }

  @Override
  public ResultSet orderBy(String columnName) {

    sortByColumnName(columnName);
    ResultSet<Purchase> resultSet = new ResultSet<>();
    resultSet.setResultList(purchaseList);

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
    if (columnName.equalsIgnoreCase("ad_id")) {
      final Function<Purchase, String> factor = Purchase::getAd_id;
      purchaseList.sort(Comparator.comparing(factor));
    }
  }

  private void sortByName(String columnName) {
    if (columnName.equalsIgnoreCase("name")) {
      final Function<Purchase, String> factor = Purchase::getTitle;
      purchaseList.sort(Comparator.comparing(factor));
    }
  }

  private void sortByEmail(String columnName) {
    if (columnName.equalsIgnoreCase("user_id")) {
      final Function<Purchase, String> factor = Purchase::getUserId;
      purchaseList.sort(Comparator.comparing(factor));
    }
  }

}
