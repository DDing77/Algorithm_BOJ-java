import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int remain = N % 4;

        int cnt = 0;
        cnt = N / 4;
        if (remain > 0) cnt++;

        String res = "";
        for (int i = 0; i < cnt; i++) {
            res += "long ";
        }
        res += "int";

        System.out.println(res);
    }
}