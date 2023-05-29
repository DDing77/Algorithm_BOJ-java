import java.io.*;
import java.util.*;

public class Main {

    static class Birth {
        String name;
        int birthday;

        public Birth(String name, int birthday) {
            this.name = name;
            this.birthday = birthday;
        }
    }

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Birth[] peoples = new Birth[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();

            if (a.length() == 1) a = "0" + a;
            if (b.length() == 1) b = "0" + b;

            peoples[i] = new Birth(name, Integer.parseInt(c + b + a));
        }

        Arrays.sort(peoples, (a, b) -> b.birthday - a.birthday);

        sb.append(peoples[0].name + "\n");
        sb.append(peoples[N - 1].name + "\n");

        System.out.print(sb);
    }


}