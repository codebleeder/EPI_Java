package Chapter06_Strings;

public class Strings_03_SpreadsheetDecodeColID {
    public static Integer ssDecodeColID(String col) {
        int res = 0;
        for (int i = 0, j = col.length() - 1; i < col.length(); ++i, --j) {
            int val = col.charAt(i) - 'A' + 1;
            res += val * Math.pow(26, j);
        }
        return res;
    }

    public static String ssEncodeColID(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int rem = n % 26;
            if (rem == 0) {
                sb.insert(0, "Z");
                n = (n / 26) - 1;
            } else {
                sb.insert(0, (char) (rem + 'A' - 1));
                n /= 26;
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("A = 1  result=" + ssDecodeColID("A"));
        System.out.println("D = 4  result=" + ssDecodeColID("D"));
        System.out.println("ZZ = 702  result=" + ssDecodeColID("ZZ"));
        System.out.println();
        System.out.println("1 = A  result=" + ssEncodeColID(1));
        System.out.println("4 = D  result=" + ssEncodeColID(4));
        System.out.println("702 = ZZ  result=" + ssEncodeColID(702));

    }
}
