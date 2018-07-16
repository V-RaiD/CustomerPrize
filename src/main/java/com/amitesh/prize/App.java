package com.amitesh.prize;

import java.lang.Integer;

public class App {
    public static void main( String[] args ) {
      Store store = new Store(args[0], Integer.parseInt(args[1]));
      Tote tote = new Tote(45,30,35);
      System.out.println(store.fillTheTote(tote).toString());
    }
}
