package com.amitesh.prize;

import com.amitesh.prize.Dimension;

class Tote {
  long idAgg;
  long priceAgg;
  long weightAgg;
  Dimension dimension;
  long filledVolume;

  Tote(Dimension d) {
    this.setDimension(d);
    this.setFilledVolume(0);
    this.setIdAgg(0);
    this.setPriceAgg(0);
    this.setWeightAgg(0);
  }

  Tote(Tote t) {
    this.setDimension(t.getDimension());
    this.setFilledVolume(t.getFilledVolume());
    this.setIdAgg(t.getIdAgg());
    this.setPriceAgg(t.getPriceAgg());
    this.setWeightAgg(t.getWeightAgg());
  }

  void setIdAgg(long ig) {
    this.idAgg = ig;
  }

  void setPriceAgg(long ig) {
    this.priceAgg = ig;
  }

  void setWeightAgg(long ig) {
    this.weightAgg = ig;
  }

  long getIdAgg(){
    return this.idAgg;
  }

  long getPriceAgg(){
    return this.priceAgg;
  }

  long getWeightAgg(){
    return this.weightAgg;
  }

  void setFilledVolume(long fv) {
    this.filledVolume = fv;
  }

  void setDimension(Dimension d) {
    this.dimension = d;
  }

  Tote addProduct(Product p) {
    if(this.canFit(p)) {
      this.filledVolume += p.getDimension().getVolume();
      this.priceAgg += (long)p.getPrice();
      this.weightAgg += (long)p.getWeight();
      this.idAgg += (long)p.getPId();
    }

    return this;
  }

  boolean canFit(Product p) {
    if (this.getDimension().isSubDimension(p.getDimension())) {
      if(this.getDimension().getVolume() - this.getFilledVolume() - p.getDimension().getVolume() >= 0) {
        return true;
      }
    }
    return false;
  }

  boolean isFull() {
    if(this.getFilledVolume() - this.getDimension().getVolume() == 0) {
      return true;
    } else {
      return false;
    }
  }

  Dimension getDimension() {
    return this.dimension;
  }

  long getFilledVolume() {
    return this.filledVolume;
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

  static Tote max(Tote t1,Tote t2) {
    int result = t1.compareTo(t2);
    if(result == 0 || result == 1) {
      return t1;
    } else {
      return t2;
    }
  }

  public String toString () {
    return new String("ID Sum : " + this.getIdAgg() + " Price Sum : " + this.getPriceAgg() + " Weight Sum : " + this.getWeightAgg() + " Filled Volume : " + this.getFilledVolume() + " Dimension : " + this.getDimension().toString());
  }
}
