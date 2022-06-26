import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int envelopWeight = 229 * 324 * Integer.parseInt(st.nextToken()) * 2;
        int posterWeight = 297 * 420 * Integer.parseInt(st.nextToken()) * 2;
        int infoSheetWeight = 210 * 297 * Integer.parseInt(st.nextToken());

        System.out.println((envelopWeight + posterWeight + infoSheetWeight) * 0.000001);
    }
}