import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int Br;
    static int Bc;
    static int Dr;
    static int Dc;
    static int Jr;
    static int Jc;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Br = Integer.parseInt(st.nextToken());
        Bc = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Dr = Integer.parseInt(st.nextToken());
        Dc = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Jr = Integer.parseInt(st.nextToken());
        Jc = Integer.parseInt(st.nextToken());

        int bessieVal = Math.max(Math.abs(Br - Jr), Math.abs(Bc - Jc));
        int daisyVal = Math.abs(Dr - Jr) + Math.abs(Dc - Jc);

        if (bessieVal > daisyVal) {
            System.out.println("daisy");
        } else if (bessieVal == daisyVal) {
            System.out.println("tie");
        } else {
            System.out.println("bessie");
        }

    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}