package exercise.datbase;

import exercise.models.ResultSet;
import java.util.List;

public interface InnerJoinInterface {

 ResultSet innerJoin(String columnFromRight, String columnFromLeft);
}
