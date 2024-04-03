package com.panrose.tacocloud.entity;

import lombok.Data;
import java.util.List;
import java.util.ArrayList;
@Data
public class TacoOrder {

  private String deliveryName;
  private String deliveryStreet;
  private String deliveryCity;
  private String deliveryState;
  private String deliveryZip;
  private String deliveryComments;
  private String ccNumber;
  private String ccExpiration;
  private String ccCVV;

  private List<Taco> tacos = new ArrayList<>();

  public void addTaco(Taco taco) {
    this.tacos.add(taco);
  }

}
