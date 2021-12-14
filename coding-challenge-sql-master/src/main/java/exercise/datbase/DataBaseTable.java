package exercise.datbase;

import exercise.models.ResultSet;

public class DataBaseTable implements QueryProcessor{

  @Override
  public ResultSet innerJoin(String columnFromRight, String columnFromLeft) {
    return null;
  }

  @Override
  public ResultSet orderBy(String columnName) {
    return null;
  }
}
