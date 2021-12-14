package exercise;

import exercise.datbase.DataBaseTable;
import exercise.datbase.PurchaseTable;
import exercise.datbase.Table;
import exercise.datbase.UserTable;
import exercise.models.ResultSet;
import exercise.utilities.CsvFileProcessor;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class SQLMasterTests {

    @Test
    void shouldContainsUserList() {
        Assertions.assertNotNull(CsvFileProcessor.UserCsvProcess());
    }

    @Test
    void shouldContainsPurchaseList() {
        Assertions.assertNotNull(CsvFileProcessor.purchaseCsvProcess());
    }

    @Test
    void shouldContainsUserElementsInList() {
        DataBaseTable userTable = new UserTable(CsvFileProcessor.UserCsvProcess());
        ResultSet resultSet = userTable.orderBy("user_id");
        Assertions.assertNotNull(resultSet);
        Assertions.assertEquals(5, resultSet.getResultList().size());
    }

    @Test
    void shouldContainsPurchaseElementsInList() {
        DataBaseTable userTable = new PurchaseTable(CsvFileProcessor.purchaseCsvProcess());
        ResultSet resultSet = userTable.orderBy("user_id");
        Assertions.assertNotNull(resultSet);
        Assertions.assertEquals(9, resultSet.getResultList().size());
    }

    @Test
    void shouldContainsUserAndPurchaseElementsInList() {
        DataBaseTable table = new Table(CsvFileProcessor.UserCsvProcess(),
            CsvFileProcessor.purchaseCsvProcess());
        ResultSet resultSet = table.innerJoin("user_id", "user_id");
        Assertions.assertNotNull(resultSet);
        Assertions.assertEquals(8, resultSet.getResultList().size());
    }

}
