import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int X;
    static int cnt = 0;
    static int line = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        X = Integer.parseInt(br.readLine());

        while(X > cnt) {
            line++;
            cnt = line * (line + 1) / 2;
        }

        if(line % 2 == 0) {
            int top = line - (cnt - X);
            int bottom = 1 + (cnt - X);
            sb.append(top).append('/').append(bottom);
        } else {
            int top = 1 + (cnt - X);
            int bottom = line - (cnt - X);
            sb.append(top).append('/').append(bottom);
        }
        System.out.println(sb);
    }
}
