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

        if( a == 0 && b == 0) System.out.println("Not a moose");
        else if ( a== b) System.out.println("Even " + a * 2);
        else System.out.println("Odd " + Math.max(a,b) * 2);

    }
}