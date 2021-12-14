package exercise.models;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class CombineResult {

  private User user;
  private Purchase purchase;

  public CombineResult(User user, Purchase purchase) {
    this.user = user;
    this.purchase = purchase;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Purchase getPurchase() {
    return purchase;
  }

  public void setPurchase(Purchase purchase) {
    this.purchase = purchase;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append(user.toString()).append(purchase.toString()).build();
  }
}
