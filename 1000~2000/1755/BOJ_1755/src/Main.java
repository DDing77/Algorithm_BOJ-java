import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static String[] number = {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
    };

    static class Info implements Comparable<Info> {
        int idx;
        String str;

        public Info(int idx, String str) {
            this.idx = idx;
            this.str = str;
        }

        @Override
        public int compareTo(Info o) {
            return this.str.compareTo(o.str);
        }
    }

    static Info[] infos;
    static int M, N;

    static String makeStr(int num) {
        ArrayList<String> list = new ArrayList<>();
        while (num > 0) {
            list.add(number[num % 10]);
            num /= 10;
        }
        String res = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            res += list.get(i);
            res += " ";
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        infos = new Info[N - M + 1];
        for (int i = M; i <= N; i++) infos[i - M] = new Info(i, makeStr(i));

        Arrays.sort(infos);
        for (int i = 0; i < infos.length; i++) {
            sb.append(infos[i].idx + " ");
            if ((i + 1) % 10 == 0) sb.append('\n');
        }
        System.out.println(sb);
    }
}
