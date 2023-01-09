public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int convertToDecimal() {
        int[] decimal = new int[digits.length];
        for(int i=0; i<digits.length;i++){
            decimal[i] = (int) (Math.pow(base, i) * digits[digits.length-(1+i)]);
            if(i>=1){
                decimal[0] += decimal[i];
            }
        }
        return decimal[0];
    }

    public String convertToBinary(){
        String binary = "";
        int num = convertToDecimal();
        while(num/2>0){
            binary = num%2 + binary;
            num /= 2;
        }
        binary = "1" + binary;
        return binary;
    }

    public String convertToOctal() {
        String octal = "";
        int num = convertToDecimal();
        while(num/8>0){
            octal = num%8 + octal;
            num/=8;
        }
        octal = num%8   + octal;
        return octal;
    }

    public String convertToHexadecimal() {
        String hexa = "";
        int num = convertToDecimal();
        while(num/16>0){
            if(num%16>=10){
                hexa = hexNumToLetter(num%16) + hexa;
            }
            else {
                hexa = num % 16 + hexa;
            }
            num/=16;
        }
        if(num%16>=10){
            hexa = hexNumToLetter(num%16) + hexa;
        }
        else {
            hexa = num % 16 + hexa;
        }
        return hexa;
    }

    private String hexNumToLetter(int num){
        if(num==10){
            return "A";
        }
        else if (num==11){
            return "B";
        }
        else if (num%16==12){
            return "C";
        }
        else if (num==13){
            return "D";
        }
        else if (num%16==14){
            return "E";
        }
        else if (num%16==15){
            return "F";
        }
        return num+"";
    }

    public String convertToAnyBase(int num, int base){
        String any = "";
        while(num/base>0){
            any = num%base + any;
            num/=base;
        }
        any = num%base + any;
        return any;
    }
}

