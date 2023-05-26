import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A;
    static int B;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()) - 1;
        B = Integer.parseInt(st.nextToken()) - 1;

        int aX = A / 4;
        int aY = A % 4;

        int bX = B / 4;
        int bY = B % 4;

        System.out.println(Math.abs(aX - bX) + Math.abs(aY - bY));
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
