import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        sb1.append(st.nextToken());
        sb2.append(st.nextToken());

        sb1.reverse();
        sb2.reverse();

        int temp = Integer.parseInt(sb1.toString()) + Integer.parseInt(sb2.toString());

        sb1 = new StringBuilder();
        sb1.append(temp).reverse();
        System.out.println(Integer.parseInt(sb1.toString()));
    }
}
