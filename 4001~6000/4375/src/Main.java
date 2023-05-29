import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s == null) break;
            int temp = 0;
            int num = Integer.parseInt(s);
            for (int i = 1; i <= num; i++) {
                temp = (temp * 10 + 1) % num;
                if (temp == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
