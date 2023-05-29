import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String parent;
    static int[] table;
    static int max;

    static void makeTable() {
        for (int k = 0; k < parent.length(); k++) {
            String pattern = parent.substring(k);
            table = new int[pattern.length()];
            int j = 0;
            for (int i = 1; i < pattern.length(); i++) {
                while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                    j = table[j - 1];
                }
                if (pattern.charAt(i) == pattern.charAt(j)) {
                    table[i] = ++j;
                    max = Math.max(max, table[i]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        parent = br.readLine();

        max = 0;

        makeTable();

        System.out.println(max);
    }
}
