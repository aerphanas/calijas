/*
 * terdapat sebuah interface bernama Calculator yang menyediakan method-method untuk melakukan operasi matematika dasar,
 * yaitu penjumlahan, pengurangan, perkalian, dan pembagian. Kemudian, terdapat sebuah kelas bernama Caljas
 * yang mengimplementasikan interface Calculator dan menyediakan implementasi untuk method-method yang terdapat pada interface tersebut.
 * 
 * Kelas Caljas memiliki dua variabel instance bernama varX dan varY, yang akan digunakan sebagai input untuk operasi matematika yang akan dilakukan.
 * Kelas Caljas juga memiliki dua constructor, yaitu constructor kosong dan constructor dengan dua parameter.
 * Constructor kosong akan mengeset nilai default pada kedua variabel instance, yaitu 0,
 * sedangkan constructor dengan dua parameter akan mengeset nilai dari variabel instance sesuai dengan nilai yang diberikan pada parameter.
 * 
 * Kelas Caljas juga menyediakan method getter dan setter untuk masing-masing variabel instance.
 * Method getter akan mengembalikan nilai dari variabel instance, sedangkan method setter akan mengeset nilai
 * dari variabel instance sesuai dengan nilai yang diberikan pada parameter.
 * 
 * Terakhir, kelas Caljas menyediakan implementasi untuk method-method yang terdapat pada interface Calculator.
 * Method-method tersebut akan melakukan operasi matematika dasar sesuai dengan yang ditentukan pada interface dan mengembalikan hasilnya sebagai tipe integer.
 */

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

