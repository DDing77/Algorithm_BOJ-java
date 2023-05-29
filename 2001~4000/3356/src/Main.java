import java.io.*;
import java.io.IOException;
import java.util.*;

public class Main {
    static int L;
    static String S;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        System.out.println(v1 - v2);
    }
}
