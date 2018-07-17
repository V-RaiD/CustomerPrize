package com.amitesh.prize;

import java.util.Scanner;
import java.io.File;
import java.lang.Integer;
import java.util.Arrays;
import java.lang.Exception;

import com.amitesh.prize.Tote;
import com.amitesh.prize.Product;

class Store {
  Product[] productList;
  int totalItems;
  Store(String path, int listSize) {
    this.productList = new Product[listSize];
    this.totalItems = listSize;
    this.readFileToList(path);
    Arrays.sort(this.productList, Product.comparator);
  }

  void readFileToList(String path) {
    try {
      Scanner scan = new Scanner(new File(path));
      int i = 0;
      while(scan.hasNext() && i < totalItems) {
        String line = scan.nextLine();
        String[] values = line.split(",");
        this.productList[i++] = new Product(
        Integer.parseInt(values[0]),
        Integer.parseInt(values[1]),
        Integer.parseInt(values[2]),
        Integer.parseInt(values[3]),
        Integer.parseInt(values[4]),
        Integer.parseInt(values[5])
        );
      }

      scan.close();
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  int getTotalItems() {
    return this.totalItems;
  }

  Product getProductByIndex(int index) {
      if(index < this.getTotalItems()) {
        return this.productList[index];
      } else {
        return new Product(0, 0, 0, 0, 0, 0);
      }
  }

  Tote fillTheTote(Tote tote, int index) {
    if(tote.isFull() || index > this.getTotalItems()) {
      return tote;
    } else {
      return Tote.max(this.fillTheTote(tote.addProduct(this.getProductByIndex(index)), index+1), this.fillTheTote(new Tote(tote),index+1));
    }
  }

  static Tote generateTote() {
    return new Tote(new Dimension(45,30,35));
  }
}
