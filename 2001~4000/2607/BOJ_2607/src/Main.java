import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    int N;
    String parent;
    String pattern;
    int[] alphabetParent;
    int[] alphabetPattern;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        parent = br.readLine();
        alphabetParent = new int[26];
        for (int i = 0; i < parent.length(); i++) {
            alphabetParent[parent.charAt(i) - 'A']++;
        }

        res = 0;
        for (int i = 0; i < N - 1; i++) {
            pattern = br.readLine();

            if (Math.abs(parent.length() - pattern.length()) > 1) {
                continue;
            }

            int[] alphabetParentClone = alphabetParent.clone();
            int hitCnt = 0;
            int parentLength = parent.length();

            for (int j = 0; j < pattern.length(); j++) {
                if (alphabetParentClone[pattern.charAt(j) - 'A'] > 0) {
                    hitCnt++;
                    alphabetParentClone[pattern.charAt(j) - 'A']--;
                }
            }

            if (parentLength == pattern.length()) {
                if (parentLength == hitCnt || parentLength - 1 == hitCnt) {
                    res++;
                }
            } else if (parentLength == pattern.length() - 1 && hitCnt == parentLength) {
                res++;
            } else if (parentLength == pattern.length() + 1 && hitCnt == pattern.length()) {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

