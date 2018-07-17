package com.amitesh.prize;

import java.lang.Integer;

public class App {
    public static void main( String[] args ) {
      Store store = new Store(args[0], Integer.parseInt(args[1]));
      System.out.println(store.fillTheTote(Store.generateTote(), 0).toString());
    }
}
