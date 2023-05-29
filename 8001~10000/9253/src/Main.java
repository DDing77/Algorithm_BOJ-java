import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String parent1;
    static String parent2;
    static String pattern;
    static int[] table;

    static void makeTable() {
        table = new int[pattern.length()];

        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) table[i] = ++j;
        }
    }

    static boolean KMP(String parent) {
        makeTable();
        int j = 0;
        for (int i = 0; i < parent.length(); i++) {
            while (j > 0 && parent.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (parent.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    return true;
                } else j++;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        parent1 = br.readLine();
        parent2 = br.readLine();
        pattern = br.readLine();

        if (KMP(parent1) && KMP(parent2)) System.out.println("YES");
        else System.out.println("NO");
    }
}
