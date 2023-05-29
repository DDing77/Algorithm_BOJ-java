import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static double x1, x2;
    static double y1, y2;
    static double z1, z2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x1 = Double.parseDouble(st.nextToken());
        y1 = Double.parseDouble(st.nextToken());
        z1 = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());

        x2 = Double.parseDouble(st.nextToken());
        y2 = Double.parseDouble(st.nextToken());
        z2 = Double.parseDouble(st.nextToken());

        if (x1 <= x2 && y1 <= y2 && z1 <= z2) System.out.println("A");
        else if (x1 / 2 <= x2 && y1 <= y2 && z1 <= z2) System.out.println("B");
        else if (y1 <= y2 && z1 <= z2) System.out.println("C");
        else if (y1 / 2 <= y2 && z1 / 2 <= z2) System.out.println("D");
        else System.out.println("E");
    }
}