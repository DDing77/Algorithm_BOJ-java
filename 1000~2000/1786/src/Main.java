import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static String parent;
    static String pattern;
    static int[] table;
    static int cnt = 0;
    static ArrayList<Integer> idx = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static void makeTable() {
        table = new int[pattern.length()];

        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                table[i] = ++j;
            }
        }
    }

    static void KMP() {
        makeTable();
        int j = 0;
        for (int i = 0; i < parent.length(); i++) {
            while (j > 0 && parent.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (parent.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    cnt++;
                    idx.add(i - pattern.length() + 2);
                    j = table[j];
                } else {
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        parent = br.readLine();
        pattern = br.readLine();

        KMP();
        sb.append(cnt).append('\n');
        for (int idx : idx) sb.append(idx).append(" ");

        System.out.println(sb);
    }
}
