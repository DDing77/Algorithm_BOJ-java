import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static String S;
    static Integer[] SA;
    static int[] group;
    static int[] lcp;
    static int d;
    static int length;

    public static Comparator<Integer> comp = new Comparator<>() {
        @Override
        public int compare(Integer idx1, Integer idx2) {
            if (group[idx1] != group[idx2]) {
                return group[idx1] - group[idx2];
            }

            idx1 += d;
            idx2 += d;

            if (idx1 > S.length()) {
                idx1 = length;
            }

            if (idx2 > S.length()) {
                idx2 = length;
            }

            return group[idx1] - group[idx2];
        }
    };

    public static void getSuffixArray() {
        d = 1;

        SA = new Integer[length];
        group = new int[length + 1];

        for (int i = 0; i < length; i++) {
            SA[i] = i;
            group[i] = S.charAt(i) - 'a';
        }
        group[length] = -1;

        while (d < length) {

            Arrays.sort(SA, comp);
            d *= 2;
            if(d >= length) {
                break;
            }

            for (int i : SA) {
                System.out.println(S.substring(i));
            }
            System.out.println("======================");
//            System.out.println("SA = " + Arrays.toString(SA));
//            System.out.println(Arrays.toString(group));
            int[] temp = new int[length + 1];

            temp[SA[0]] = 0;
            temp[length] = -1;
            for (int i = 1; i < length; i++) {
                if (group[SA[i - 1]] < group[SA[i]]) {
//                    System.out.println("i-1 = " + group[SA[i-1]] + " , i = " + group[SA[i]]);
                    temp[SA[i]] = temp[SA[i - 1]] + 1;
                } else {
                    temp[SA[i]] = temp[SA[i - 1]];
                }
//                System.out.println("temp = " + Arrays.toString(temp));
            }

            group = temp;

        }
    }

    public static void getLCP() {
        lcp = new int[length];
        int[] invSA = new int[length];

        for (int i = 0; i < length; i++) {
            invSA[SA[i]] = i;
        }

        int k = 0;
        for (int i = 0; i < length; i++) {
            if (invSA[i] == length - 1) {
                k = 0;
                continue;
            }

            int j = SA[invSA[i] + 1];

            while (i + k < length && j + k < length) {
                if (S.charAt(i + k) != S.charAt(j + k)) {
                    break;
                }
                k++;
            }

            lcp[invSA[i]] = k;

            if (k > 0) {
                k--;
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        S = br.readLine();
        length = S.length();

        getSuffixArray();

        for (int i : SA) {
            sb.append(S.substring(i)).append('\n');
        }

        for (int i = 0; i < length; i++) {
            sb.append((SA[i] + 1) + " ");
        }

        getLCP();
        sb.append('\n').append("x ");
        for (int i = 0; i < length - 1; i++) {
            sb.append(lcp[i] + " ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
