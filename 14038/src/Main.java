import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int wCnt = 0;
        for (int i = 0; i < 6; i++) {
            String c = br.readLine();
            if (c.equals("W")) {
                wCnt++;
            }
        }

        if (wCnt >= 5) System.out.println(1);
        else if (wCnt >= 3) System.out.println(2);
        else if (wCnt >= 1) System.out.println(3);
        else System.out.println(-1);
    }
}
