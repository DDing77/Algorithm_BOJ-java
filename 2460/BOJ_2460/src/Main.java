import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Info {
        int output;
        int input;

        public Info(int output, int input) {
            this.output = output;
            this.input = input;
        }
    }

    static Info[] infos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        infos = new Info[10];
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int output = Integer.parseInt(st.nextToken());
            int input = Integer.parseInt(st.nextToken());


            infos[i] = new Info(output, input);
            cur -= output;
            cur += input;
            max = Math.max(max, cur);
        }
        System.out.println(max);

    }
}
