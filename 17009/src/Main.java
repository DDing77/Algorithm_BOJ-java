import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[6];

        for (int i = 0; i < 6; i++) arr[i] = Integer.parseInt(br.readLine());

        int A = arr[0] * 3 + arr[1] * 2 + arr[2];
        int B = arr[3] * 3 + arr[4] * 2 + arr[5];

        if (A == B)
            System.out.println("T");
        else if (A > B)
            System.out.println("A");
        else
            System.out.println("B");
    }
}