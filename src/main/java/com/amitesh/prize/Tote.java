package com.amitesh.prize;

import com.amitesh.com.amitesh.prize.Dimension;

class Tote {
  long idAgg;
  long priceAgg;
  long weightAgg;
  Dimension dimension;
  long filledVolume;

  Tote(Dimension d) {
    this.setDimension(d);
  }

  void setDimension(Dimension d) {
    this.dimension = d;
  }

  void addProduct(Product p) {
    this.filledVolume += p.getDimension().getVolume();
    this.priceAgg += (long)p.getPrice();
    this.weightAgg += (long)p.getWeight();
    this.idAgg += (long)p.getPId();
  }

  int compareTo(Tote t) {
    if (this.priceAgg - t.priceAgg < 0) {
      return -1;
    } else if (this.priceAgg - t.priceAgg > 0) {
      return 1;
    } else {
      if (this.weightAgg - t.weightAgg < 0) {
        return 1;
      } else if (this.weightAgg - t.weightAgg > 0) {
        return -1;
      } else {
        if (this.filledVolume - t.filledVolume < 0) {
          return 1;
        } else if (this.filledVolume - t.filledVolume > 0) {
          return -1;
        } else {
          return 0;
        }
      }
    }
  }
}
