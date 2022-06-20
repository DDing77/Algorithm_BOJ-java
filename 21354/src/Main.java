import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int axel;
    static int petra;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        axel = Integer.parseInt(st.nextToken()) * 7;
        petra = Integer.parseInt(st.nextToken()) * 13;

        if (petra > axel) System.out.println("Petra");
        else if (petra == axel) System.out.println("lika");
        else System.out.println("Axel");
    }
}