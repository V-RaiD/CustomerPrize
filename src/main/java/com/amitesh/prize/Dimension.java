package com.amitesh.prize;

class Dimension {
  int l;
  int w;
  int h;

  Dimension (int l,int w, int h) {
    this.setLength(l);
    this.setWidth(w);
    this.setHeight(h);
  }

  void setLength(int l) {
    this.l = l;
  }

  void setwidth(int w) {
    this.w = w;
  }

  void setLength(int h) {
    this.h = h;
  }

  int getLength() {
    return this.l;
  }

  int getWidth() {
    return this.w;
  }

  int getHeight() {
    return this.h;
  }

  long getVolume() {
    return (long)this.getLength() * (long)this.getWidth() * (long)this.getHeight();
  }

  int compareTo(Dimension d) {
    if(this.getVolume() - d.getVolume() < 0) {
      return -1;
    } else if (this.getVolume() - d.getVolume() > 0) {
      return 1;
    } else {
      return 0;
    }
  }

  boolean isSubDimension (Dimension d) {
    if(this.getLength() - d.getLength() >= 0) {
      if(this.getWidth() - d.getWidth() >= 0) {
        if(this.getHeight() - d.getHeight() >= 0) {
          return true;
        }
      }
    }

    return false;
  }
}
