import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        double a = Integer.parseInt(st.nextToken());

        double u = 0;
        double taxi = 0;

        u= a*a*Math.PI;
        taxi= a*a*2;

        System.out.println(String.format("%.6f", u));
        System.out.println(String.format("%.6f", taxi));
    }
}