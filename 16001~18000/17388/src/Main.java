import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] uni;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        uni = new int[3];

        int sum = 0;
        int res = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            uni[i] = Integer.parseInt(st.nextToken());
            sum += uni[i];
            if (min > uni[i]) {
                min = uni[i];
                res = i;
            }
        }

        if (sum >= 100) System.out.println("OK");
        else {
            switch (res) {
                case 0:
                    System.out.println("Soongsil");
                    break;
                case 1:
                    System.out.println("Korea");
                    break;
                case 2:
                    System.out.println("Hanyang");
                    break;
                default:
                    break;
            }
        }
    }
}
