package exercise.utilities;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import exercise.models.Purchase;
import exercise.models.User;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CsvFileProcessor {


 /* public static void main(String[] args) throws IOException {
    UserCsvProcess();
    purchaseCsvProcess(); change
  }*/

  public static List<User> UserCsvProcess() {
    List<User> returnList = new ArrayList<>();

    try (
        Reader reader = Files.newBufferedReader(Paths.get("/home/ggadhave/ebay/java_coding/coding"
            + "-challenge-sql-master/src/main/resources/users.csv"));
    ) {
      CsvToBean<User> csvToBean = new CsvToBeanBuilder<User>(reader)
          .withType(User.class)
          .withIgnoreLeadingWhiteSpace(true)
          .build();

      Iterator<User> csvUserIterator = csvToBean.iterator();

      while (csvUserIterator.hasNext()) {
        User user = csvUserIterator.next();
        returnList.add(user);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return returnList;
  }

  public static List<Purchase> purchaseCsvProcess() {

    List<Purchase> returnList = new ArrayList<>();
    try (
        Reader reader = Files.newBufferedReader(Paths.get("/home/ggadhave/ebay/java_coding/coding"
            + "-challenge-sql-master/src/main/resources/purchases.csv"));
    ) {
      CsvToBean<Purchase> csvToBean = new CsvToBeanBuilder<Purchase>(reader)
          .withType(Purchase.class)
          .withIgnoreLeadingWhiteSpace(true)
          .build();

      Iterator<Purchase> csvUserIterator = csvToBean.iterator();

      while (csvUserIterator.hasNext()) {
        Purchase purchase = csvUserIterator.next();
        returnList.add(purchase);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return returnList;
  }

}
