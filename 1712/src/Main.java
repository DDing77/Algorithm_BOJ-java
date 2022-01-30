import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        if(B>=C) {
            System.out.print(-1);
            return;
        }
        int D = C - B;
        int res = A / D;
        System.out.println(res+1);
    }
}
// 1000 + 70X = 170X
// 1000 = 100X
// X= 10

// 3 + 2X = X
// 3= -X