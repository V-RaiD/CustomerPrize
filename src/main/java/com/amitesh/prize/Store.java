package com.amitesh.prize;

import java.util.Scanner;
import java.io.File;
import java.lang.Integer;
import java.util.Arrays;

import com.amitesh.prize.Tote;
import com.amitesh.prize.Product;

class Store {
  Product[] productList;
  int totalItems;
  Store(String path, int listSize) {
    this.productList = new Product[listSize];
    this.tototalItems = listSize;
    this.readFileToList(path);
    Arrays.sort(this.productList, Product.comparator);
  }

  void readFileToList(String path) {
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
  }
}
