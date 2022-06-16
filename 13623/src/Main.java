import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a == 1 && b == 0 && c == 0) System.out.println("A");
        else if (a == 0 && b == 1 && c == 1) System.out.println("A");
        else if (a == 0 && b == 1 && c == 0) System.out.println("B");
        else if (a == 1 && b == 0 && c == 1) System.out.println("B");
        else if (a == 0 && b == 0 && c == 1) System.out.println("C");
        else if (a == 1 && b == 1 && c == 0) System.out.println("C");
        else System.out.println("*");
    }
}