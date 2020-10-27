package Chapter06_Strings;

public class Strings_06_ReverseWords {
    public static void reverseWords(char[] words) {
        int i = 0, j = words.length - 1;
        reverse(words, i, j);
        i = 0;
        j = 0;
        while (j < words.length) {
            // find beginning of the word
            while (i < words.length && Character.isWhitespace(words[i])) {
                ++i;
            }
            j = i;
            // find the end of the word
            while (j < words.length && !Character.isWhitespace(words[j])) {
                ++j;
            }
            reverse(words, i, j - 1);
            i = j;


        }
    }

    public static void reverse(char[] words, int i, int j) {
        while (i < j) {
            char temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            ++i;
            --j;
        }
    }

    public static void main(String[] args) {
        char[] words = "bob likes alice".toCharArray();
        reverseWords(words);
        System.out.println(new String(words));
    }
}
