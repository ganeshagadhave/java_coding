package exercise.models;

import com.opencsv.bean.CsvBindByName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Purchase {

  @CsvBindByName
  private String ad_id;

  @CsvBindByName
  private String title;

  @CsvBindByName
  private String user_id;

  public String getAd_id() {
    return ad_id;
  }

  public void setAd_id(String ad_id) {
    this.ad_id = ad_id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUserId() {
    return user_id;
  }

  public void setUserId(String user_id) {
    this.user_id = user_id;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("ad_id", ad_id)
        .append("title", title)
        .append("user_id", user_id)
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

    Purchase purchase = (Purchase) o;

    if (!ad_id.equals(purchase.ad_id)) {
      return false;
    }
    if (title != null ? !title.equals(purchase.title) : purchase.title != null) {
      return false;
    }
    return user_id.equals(purchase.user_id);
  }

  @Override
  public int hashCode() {
    int result = ad_id.hashCode();
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + user_id.hashCode();
    return result;
  }
}
