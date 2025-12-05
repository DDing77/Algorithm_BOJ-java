import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] cnt = new int[366];

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int d = start; d <= end; d++) {
                cnt[d]++;
            }
        }

        int area = 0;
        int width = 0;
        int height = 0;

        for (int day = 1; day <= 365; day++) {
            if (cnt[day] > 0) {
                width++;
                if (height < cnt[day]) {
                    height = cnt[day];
                }
            } else {
                if (width > 0) {
                    area += width * height;
                    width = 0;
                    height = 0;
                }
            }
        }

        if (width > 0) {
            area += width * height;
        }

        System.out.println(area);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
