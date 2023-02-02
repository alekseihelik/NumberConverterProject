public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        this.digits = new int[numberAsString.length()];

        for(int i = 0; i < numberAsString.length(); ++i) {
            String single = numberAsString.substring(i, i + 1);
            int d = Integer.parseInt(single);
            this.digits[i] = d;
        }

        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";

        for(int i = 0; i < this.digits.length; ++i) {
            o = o + this.digits[i];
        }

        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return this.digits;
    }

    public int convertToDecimal() {
        int[] decimal = new int[this.digits.length];

        for(int i = 0; i < this.digits.length; ++i) {
            decimal[i] = (int)(Math.pow((double)this.base, (double)i) * (double)this.digits[this.digits.length - (1 + i)]);
            if (i >= 1) {
                decimal[0] += decimal[i];
            }
        }

        return decimal[0];
    }

    public String convertToBinary() {
        String binary = "";

        for(int num = this.convertToDecimal(); num / 2 > 0; num /= 2) {
            binary = num % 2 + binary;
        }

        binary = "1" + binary;
        return binary;
    }

    public String convertToOctal() {
        String octal = "";

        int num;
        for(num = this.convertToDecimal(); num / 8 > 0; num /= 8) {
            octal = num % 8 + octal;
        }

        octal = num % 8 + octal;
        return octal;
    }

    public String convertToHexadecimal() {
        String hexa = "";

        String update;
        int num;
        for(num = this.convertToDecimal(); num / 16 > 0; num /= 16) {
            if (num % 16 >= 10) {
                update = this.hexNumToLetter(num % 16);
                hexa = update + hexa;
            } else {
                hexa = num % 16 + hexa;
            }
        }

        if (num % 16 >= 10) {
            update = this.hexNumToLetter(num % 16);
            hexa = update + hexa;
        } else {
            hexa = num % 16 + hexa;
        }

        return hexa;
    }

    private String hexNumToLetter(int num) {
        if (num == 10) {
            return "A";
        } else if (num == 11) {
            return "B";
        } else if (num % 16 == 12) {
            return "C";
        } else if (num == 13) {
            return "D";
        } else if (num % 16 == 14) {
            return "E";
        } else {
            return num % 16 == 15 ? "F" : "" + num;
        }
    }

    public String convertToAnyBase(int num, int base) {
        String update;
        String any;
        for(any = ""; num / base > 0; num /= base) {
            update = this.numbersToLetter(num % base);
            any = update + any;
        }

        update = this.numbersToLetter(num % base);
        any = update + any;
        return any;
    }

    private String numbersToLetter(int num) {
        String converted = "";
        String conversions = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";

        for(int i = 0; i < conversions.length(); ++i) {
            if (num == i) {
                char charAt = conversions.charAt(i);
                converted = "" + charAt;
            }
        }

        return converted;
    }

    public boolean isBinary(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }

    public boolean isOctal(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < '0' || c > '7') {
                return false;
            }
        }
        return true;
    }

    public boolean isHexadecimal(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                return false;
            }
        }
        return true;
    }
}