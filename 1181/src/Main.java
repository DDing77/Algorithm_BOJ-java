import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static class STR implements Comparable<STR> {
        String str;

        public STR(String str) {
            this.str = str;
        }

        @Override
        public int compareTo(STR o) {
            if(str.length() == o.str.length()) {
                return str.compareTo(o.str);
            }
            return str.length() <= o.str.length() ? -1 : 1;
        }
    }

    static STR[] strs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        strs = new STR[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            strs[i] = new STR(str);
        }
        Arrays.sort(strs);
        for (int i = 0; i < N; i++) {
            if(i>0 && strs[i-1].str.equals(strs[i].str)) continue;
            System.out.println(strs[i].str);
        }
    }
}
