package io.github.aerphanas.calijas;

public interface Calculator {
  public int add();
  public int min();
  public int mul();
  public int div();
}

class Caljas implements Calculator {
  
  private int varX;
  private int varY;
  
  public Caljas() {
    this(0, 0);
  }
  
  public Caljas(int varX, int varY) {
    this.varX = varX;
    this.varY = varY;
  }

  public int getVarX() {
    return varX;
  }

  public void setVarX(int varX) {
    this.varX = varX;
  }

  public int getVarY() {
    return varY;
  }

  public void setVarY(int varY) {
    this.varY = varY;
  }

  @Override
  public int add() {
    return this.varX + this.varY;
  }

  @Override
  public int min() {
    return this.varX - this.varY;
  }

  @Override
  public int mul() {
    return this.varX * this.varY;
  }

  @Override
  public int div() {
    return this.varX / this.varY;
  }

}

