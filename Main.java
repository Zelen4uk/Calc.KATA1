import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input:");
        String input = scan.nextLine();
        System.out.println();
        try {
            System.out.println(Main.calc(input));
        } catch (ArrayIndexOutOfBoundsException e1){
            System.out.println("throws Exception");
            System.exit(0);
        }
    }
    public static String calc(String input) {

        String[] str = input.split(" ", 3); // разбивает строку на массив с разделителем "пробел" и ограничивает длинну массива.

        String output = null;

        String arithmetic_sign = str[1];
        try {
            switch (arithmetic_sign) {
                case "+", "-", "/", "*":
                    break;
                default:
                    throw new IOException();
            }
        } catch (IOException e){
            System.out.println("throws Exception");
            System.exit(0);
        }

        Scanner scan_a = new Scanner(str[0]);
        Scanner scan_b = new Scanner(str[2]);
        if (scan_a.hasNextInt() & scan_b.hasNextInt()) {
           ArabicNumerals numerals = new ArabicNumerals(str[0],str[2],str[1]);
            output = numerals.getOutput();
        } else {
            try {
                Roman romanA = Roman.valueOf(str[0]); //valueOf(str[0]) - метод возвращает строковое представление переданного аргумента.
                Roman romanB = Roman.valueOf(str[2]);
            RomansNumerals numerals = new RomansNumerals(romanA.getNumber(), romanB.getNumber(), arithmetic_sign);
            Conversion conversion = new Conversion(numerals.getNumbers());
            output = conversion.getConversion();
            } catch (IllegalArgumentException e) {
                System.out.println("throws Exception");
                System.exit(0);
            }
        }
        System.out.println("Output:");
        return output;
    }

}
class ArabicNumerals{
    int number1;
    int number2;
    String arithmetic_sign;
    String output;
    public ArabicNumerals(String number1, String number2, String arithmetic_sign){
        try {
            this.number1 = Integer.parseInt(number1);
            this.number2 = Integer.parseInt(number2);
            this.arithmetic_sign = arithmetic_sign;
        } catch (NumberFormatException e){
            System.out.println("throws Exception");
            System.exit(0);
        }
    }
    public String getOutput() {
       try {
           if (number1 > 0 & number2 > 0) {
               if (number1 < 11 & number2 < 11) {
               } else {
                   throw new IOException();
               }
           } else {
               throw new IOException();
           }
       } catch ( IOException e) {
           System.out.println("throws Exception");
           System.exit(0);
       }
        switch (arithmetic_sign){
            case "+":
                output = String.valueOf(number1 + number2);
                break;
            case "-":
                output = String.valueOf(number1 - number2);
                break;
            case "*":
                output = String.valueOf(number1 * number2);
                break;
            case "/":
                output = String.valueOf(number1 / number2);
                break;
        }
        return output;
    }

}
class RomansNumerals{
    int number1;
    int number2;
    String arithmetic_sign;
    int output;
    public RomansNumerals( int number1, int number2, String arithmetic_sign){
        this.number1 = number1;
        this.number2 = number2;
        this.arithmetic_sign = arithmetic_sign;
    }
    public int getNumbers()
    {
        switch (arithmetic_sign){
            case "+":
                output = (number1 + number2);
                break;
            case "-":
                output = (number1 - number2);
                break;
            case "*":
                output = (number1 * number2);
                break;
            case "/":
                output = (number1 / number2);
        }
        return output;
    }

}
class Conversion {
    int input;
    public Conversion (int input){
        this.input = input;
    }
    public String getConversion () {

        try {

            if (input > 0) {
            } else {
                throw new IOException();
            }
        } catch (IOException e) {
            System.out.println("throws Exception");
            System.exit(0);
        }
        int units = input % 10;
        int tens = (input % 100) / 10;
        int hundreds = (input % 1000) / 100;

        String s_units = "";
        String s_tens = "";
        String s_hundreds = "";

        switch (units) {
            case 1:
                s_units = "I";
                break;
            case 2:
                s_units = "II";
                break;
            case 3:
                s_units = "III";
                break;
            case 4:
                s_units = "IV";
                break;
            case 5:
                s_units = "V";
                break;
            case 6:
                s_units = "VI";
                break;
            case 7:
                s_units = "VII";
                break;
            case 8:
                s_units = "VIII";
                break;
            case 9:
                s_units = "IX";
                break;
            default:
        }

        switch (tens){
            case 1:
                s_tens = "X";
                break;
            case 2:
                s_tens = "XX";
                break;
            case 3:
                s_tens = "XXX";
                break;
            case 4:
                s_tens = "XL";
                break;
            case 5:
                s_tens = "L";
                break;
            case 6:
                s_tens = "LX";
                break;
            case 7:
                s_tens = "LXX";
                break;
            case 8:
                s_tens = "LXXX";
                break;
            case 9:
                s_tens = "XC";
                break;
            default:
        }
        if (hundreds == 1){
            s_hundreds = "C";
        }

        return (s_hundreds) + (s_tens) + (s_units);
    }
}
enum Roman {
    I(1), II(2), III(3), IV(4) ,V(5),
    VI(6), VII(7), VIII(8), IX(9), X(10);
    private final int number;

    Roman(int number){
        this.number = number;
    }

    public int getNumber(){

        return number;
    }
}
