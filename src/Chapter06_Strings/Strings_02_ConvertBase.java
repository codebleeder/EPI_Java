package Chapter06_Strings;

public class Strings_02_ConvertBase {
    public static String convertBase(String num, int b1, int b2) {
        int decVal = 0;
        for (int i = num.length() - 1, j = 0; i >= 0; --i, ++j) {
            char c = num.charAt(j);
            int digit = Character.isDigit(c) ? c - '0' : 'A' - c + 10;
            decVal += digit * Math.pow(b1, i);
        }
        StringBuilder sb = new StringBuilder();
        while (decVal > 0) {
            int remainder = decVal % b2;
            char remainderChar = (char) (b2 > 10 && remainder >= 10 ? (remainder - 10 + 'A') : remainder + '0');
            sb.insert(0, remainderChar);
            decVal /= b2;
        }
        return sb.toString();
    }

    // book solution:
    public static String convertBase2(String num, int b1, int b2) {
        boolean isNegative = num.startsWith("-");
        int numDec = 0;
        for (int i = (isNegative ? 1 : 0); i < num.length(); ++i) {
            numDec *= b1;
            numDec += Character.isDigit(num.charAt(i)) ? num.charAt(i) - '0' : num.charAt(i) - 'A' + 10;
        }
        return (isNegative ? "-" : "") + (numDec == 0 ? "0" : constructFromBase(numDec, b2));
    }

    public static String constructFromBase(int num, int base) {
        return num == 0
                ? ""
                : constructFromBase(num / base, base)
                + (char) (num % base >= 10 ? 'A' + num % base - 10 : '0' + num % base);
    }

    public static void main(String[] args) {
        System.out.println("615b7 to b13 = 1A7  result = " + convertBase2("615", 7, 13));
    }
}
