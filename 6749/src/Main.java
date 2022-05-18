import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int youngest;
    static int middle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        youngest = Integer.parseInt(br.readLine());
        middle = Integer.parseInt(br.readLine());

        int gap = middle - youngest;
        int res = middle + gap;
        System.out.println(res);
    }
}
