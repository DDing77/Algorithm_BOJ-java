import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int L;
    int H;
    int[][] pillars;
    int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        pillars = new int[N][2];

        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pillars[i][0] = Integer.parseInt(st.nextToken());
            pillars[i][1] = Integer.parseInt(st.nextToken());

            maxHeight = Math.max(maxHeight, pillars[i][1]);
        }

        Arrays.sort(pillars, Comparator.comparingInt(o -> o[0]));

        int preL = pillars[0][0];
        int preH = pillars[0][1];

        res = 0;
        for (int i = 1; i < N; i++) {
            if (preH <= pillars[i][1]) {
                res += (pillars[i][0] - preL) * preH;
                preL = pillars[i][0];
                preH = pillars[i][1];
            }
        }

        preL = pillars[N - 1][0];
        preH = pillars[N - 1][1];
        for (int i = N - 1; i >= 0; i--) {
            if (preH < pillars[i][1]) {
                res += (preL - pillars[i][0]) * preH;
                preL = pillars[i][0];
                preH = pillars[i][1];
            }
        }

        res += maxHeight;
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
