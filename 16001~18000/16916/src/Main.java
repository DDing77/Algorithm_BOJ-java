import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String S;
    static String P;
    static int[] table;

    static void makeTable() {
        table = new int[P.length()];

        int j = 0;
        for (int i = 1; i < P.length(); i++) {
            while (j > 0 && P.charAt(i) != P.charAt(j)) {
                j = table[j - 1];
            }
            if (P.charAt(i) == P.charAt(j)) {
                table[i] = ++j;
            }
        }
    }

    static boolean KMP() {
        makeTable();
        System.out.println(Arrays.toString(table));
        int j = 0;
        for (int i = 0; i < S.length(); i++) {
            while (j > 0 && S.charAt(i) != P.charAt(j)) {
                j = table[j - 1];
            }
            if (S.charAt(i) == P.charAt(j)) {
                if (j == P.length() - 1) {
                    return true;
                } else {
                    j++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        P = br.readLine();

        if (KMP()) System.out.println(1);
        else System.out.println(0);
        System.out.println(Arrays.toString(table));
    }
}
