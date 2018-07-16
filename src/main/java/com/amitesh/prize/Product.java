package com.amitesh.prize;

import java.util.Comparator;

class Product {
  int pId;
  int price;
  int weight;
  Dimension dimension;

  Product (int pId, int price, int length, int width, int height, int weight) {
    this.setPId(pId);
    this.setPrice(price);
    this.setWeight(weight);
    this.setDimension(new Dimension(length, width, height));
  }

  void setPId(int pId) {
    this.pId = pId;
  }

  void setPrice(int price) {
    this.price = price;
  }

  void setWeight(int weight) {
    this.weight = weight;
  }

  void setDimension(Dimension dimension) {
    this.dimension = dimension;
  }

  int getPId () {
    return this.pId;
  }

  int getPrice() {
    return this.price;
  }

  int getWeight() {
    return this.weight;
  }

  Dimension getDimension() {
    return this.dimension;
  }

  static Comparator comparator = new Comparator<Product>() {
    public int compare(Product p1, Product p2) {
      if(p1.getPrice() - p2.getPrice() < 0) {
        return 1;
      } else if (p1.getPrice() - p2.getPrice() > 0) {
        return -1;
      } else {
        if(p1.getWeight() - p2.getWeight() < 0) {
          return -1;
        } else if (p1.getWeight() - p2.getWeight() > 0) {
          return 1;
        } else {
          return p1.getDimension().compareTo(p2.getDimension());
        }
      }
    }
  };
}
