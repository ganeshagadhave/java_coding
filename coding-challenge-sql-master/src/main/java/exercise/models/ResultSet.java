package exercise.models;

import java.util.ArrayList;
import java.util.List;

public class ResultSet<T> {

  private List<T> resultList;

  public List<T> getResultList() {
    return new ArrayList<T>(resultList);
  }

  public void setResultList(List<T> resultList) {
    this.resultList = resultList;
  }
}
