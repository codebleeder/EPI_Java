package Chapter12_HashTables;

public class HashTables_00_StringHash {
    private static int stringHash(String s, int modulus) {
        int hash = 0;
        int kMult = 997;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            hash = (hash * kMult + c) % modulus;
        }
        return hash;
    }

    public static void main(String[] args) {
        System.out.println(stringHash("random string", 7));
    }
}
