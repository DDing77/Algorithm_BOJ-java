import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Info implements Comparable<Info> {
        int countryNum;
        int stuNum;
        int value;

        public Info(int countryNum, int stuNum, int value) {
            this.countryNum = countryNum;
            this.stuNum = stuNum;
            this.value = value;
        }

        @Override
        public int compareTo(Info o) {
            return o.value - this.value;
        }
    }

    static Info[] infos;
    static int[] count;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        infos = new Info[N];
        count = new int[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            infos[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(infos);

        int cnt = 0;
        int idx = 0;
        while (cnt < 3) {
            if (count[infos[idx].countryNum] < 2) {
                sb.append(infos[idx].countryNum + " " + infos[idx].stuNum).append('\n');
                count[infos[idx].countryNum]++;
                cnt++;
            }
            idx++;
        }
        System.out.print(sb);
    }
}
