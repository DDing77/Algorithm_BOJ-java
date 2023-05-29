import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double A1 = Double.parseDouble(st.nextToken());
        double P1 = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());

        double R1 = Double.parseDouble(st.nextToken());
        double P2 = Double.parseDouble(st.nextToken());

        if ((A1 / P1) < ((Math.pow(R1, 2) * Math.PI) / P2)) System.out.println("Whole pizza");
        else System.out.println("Slice of pizza");
    }
}
