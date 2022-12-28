/* 
 * Pertama, terdapat sebuah kelas bernama Options yang digunakan untuk menyimpan opsi yang dapat diterima oleh aplikasi.
 * Kemudian, terdapat tiga objek bernama variablex, variabley, dan operator yang masing-masing merupakan opsi yang dapat diterima oleh aplikasi.
 * Masing-masing objek memiliki nama singkat ("x", "y", dan "o"), nama panjang ("varx", "vary", dan "operator"),
 * serta deskripsi yang akan ditampilkan saat menjalankan perintah caljas -h. Selain itu, masing-masing objek juga diberi flag setRequired(true),
 * yang berarti bahwa objek tersebut harus diberikan saat menjalankan aplikasi.
 * Kemudian, objek-objek tersebut ditambahkan ke objek Options menggunakan method addOption().
 * 
 * Selanjutnya, terdapat sebuah objek bernama parser yang merupakan instansiasi dari kelas DefaultParser,
 * yang digunakan untuk memparsing input yang diberikan saat menjalankan aplikasi.
 * Kemudian, terdapat objek bernama formatter yang merupakan instansiasi dari kelas HelpFormatter,
 * yang akan digunakan untuk menampilkan bantuan saat terjadi error saat memparsing input.
 * 
 * Kemudian, terdapat sebuah objek bernama cmd yang akan menyimpan hasil parsing dari input yang diberikan.
 * Pemanggilan method parse() pada objek parser akan mencoba memparsing input yang diberikan dan akan mengembalikan objek CommandLine.
 * Jika terjadi error saat memparsing input, maka akan ditampilkan pesan error dan bantuan menggunakan objek formatter,
 * kemudian program akan diakhiri dengan menjalankan System.exit(1).
 * 
 * Setelah berhasil memparsing input, maka nilai dari input akan diambil menggunakan method getOptionValue() pada objek cmd
 * dan disimpan pada variabel inputVary, inputVarx, dan inputOperator. Kemudian, variabel-variabel tersebut akan dikonversi menjadi tipe integer
 * dan disimpan pada variabel varx dan vary. Jika terjadi error saat konversi, maka akan ditampilkan stack trace error.
 */

package io.github.aerphanas.calijas;

import org.apache.commons.cli.*;

public class App 
{
  public static void main( String[] args ) {

    Options pilihan = new Options();

    Option variablex = new Option("x", "varx", true, "angka yang akan dikalkulasi");
    variablex.setRequired(true);
    pilihan.addOption(variablex);

    Option variabley = new Option("y", "vary", true, "angka yang akan dikalkulasi");
    variabley.setRequired(true);
    pilihan.addOption(variabley);

    Option operator = new Option("o", "operator", true, "operator untuk operasi yang akan dilakukan");
    operator.setRequired(true);
    pilihan.addOption(operator);

    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();
    CommandLine cmd = null;

    try {
      cmd = parser.parse(pilihan, args);
    } catch (ParseException e) {
      System.out.println(e.getMessage());
      formatter.printHelp("caljas", pilihan);
      System.exit(1);
    }

    String inputVary = cmd.getOptionValue("vary");
    String inputVarx = cmd.getOptionValue("varx");
    String inputOperator = cmd.getOptionValue("operator");

    int varx = 0;
    int vary = 0;
    int result = 0;

    try {
      varx = Integer.parseInt(inputVarx);
      vary = Integer.parseInt(inputVary);
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }

    Calculator docalc = new Caljas(varx, vary);

    switch (inputOperator) {
      case "+":
        result = docalc.add();
        break;
      case "-":
        result = docalc.min();
        break;
      case "*":
        result = docalc.mul();
        break;
      case "/":
        result = docalc.div();
        break;
      default:
        System.err.println("program saatini hanya mensupport + - * /");
        System.exit(1);
    }
    System.out.printf("hasil %d %s %d adalah %d", varx, inputOperator, vary, result);
  }

}
