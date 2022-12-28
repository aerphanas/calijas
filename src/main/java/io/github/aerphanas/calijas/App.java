package io.github.aerphanas.calijas;

import org.apache.commons.cli.*;

public class App 
{
  public static void main( String[] args ) {
    Options pilihan = new Options();

    Option variablex = new Option("x", "varx", true, "tolong masukan variabel x");
    variablex.setRequired(true);
    pilihan.addOption(variablex);

    Option variabley = new Option("y", "vary", true, "tolong masukan variabel y");
    variabley.setRequired(true);
    pilihan.addOption(variabley);

    Option operator = new Option("o", "operator", true, "tolong masukan operator");
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
