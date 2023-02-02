import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cost = new int[N];
        int costY = 0;
        int costM = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());

            if (cost[i] / 30 == 0) {
                costY += 10;
            } else if (cost[i] % 30 == 0) {
                costY += (cost[i] / 30) * 10 + 10;
            } else if (cost[i] % 30 != 0) {
                costY += (cost[i] / 30) * 10;
                costY += 10;
            }


            if (cost[i] / 60 == 0) {
                costM += 15;
            } else if (cost[i] % 60 == 0) {
                costM += (cost[i] / 60) * 15 + 15;
            } else if (cost[i] % 60 != 0) {
                costM += (cost[i] / 60) * 15;
                costM += 15;
            }
        }

        if (costY < costM) {
            System.out.println("Y " + costY);
        } else if (costY == costM) {
            System.out.println("Y M " + costY);
        } else {
            System.out.println("M " + costM);
        }
    }
}
