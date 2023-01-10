import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10, or 16): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        int n = Integer.parseInt(number);

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        if(choice.equals("2")){
            System.out.println("Octal Number: " + nc.convertToOctal());
            System.out.println("Decimal Number: " + nc.convertToDecimal());
            System.out.println("Hexadecimal Number: " + nc.convertToHexadecimal());
        }
        else if(choice.equals("8")){
            System.out.println("Binary Number: " + nc.convertToBinary());
            System.out.println("Decimal Number: " + nc.convertToDecimal());
            System.out.println("Hexadecimal Number: " + nc.convertToHexadecimal());
        }
        else if(choice.equals("10")){
            System.out.println("Binary Number: " + nc.convertToBinary());
            System.out.println("Octal Number: " + nc.convertToOctal());
            System.out.println("Hexadecimal Number: " + nc.convertToHexadecimal());
        }
        else if(choice.equals("16")){
            System.out.println("Binary Number: " + nc.convertToBinary());
            System.out.println("Octal Number: " + nc.convertToOctal());
            System.out.println("Decimal Number: " + nc.convertToDecimal());
        }
        System.out.print("Enter a base 10 number: ");
        String num = s.nextLine();
        System.out.print("Enter a base to convert to: ");
        String newBase = s.nextLine();
        int numAsInt = Integer.parseInt(num);
        int newBaseAsInt = Integer.parseInt(newBase);
        System.out.println("Your new number is: " + nc.convertToAnyBase(numAsInt, newBaseAsInt));
    }
}

