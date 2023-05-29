import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Pair[] arr = new Pair[3];


        for (int i = 0; i < 3; i++) {
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Pair(x, y);
        }

        if ((arr[1].y - arr[0].y) * (arr[2].x - arr[1].x) == (arr[1].x - arr[0].x) * (arr[2].y - arr[1].y))
            System.out.println("-1");
        else {
            double one = Math.sqrt(Math.pow(arr[1].y - arr[0].y, 2) + Math.pow(arr[1].x - arr[0].x, 2));
            double two = Math.sqrt(Math.pow(arr[2].y - arr[0].y, 2) + Math.pow(arr[2].x - arr[0].x, 2));
            double three = Math.sqrt(Math.pow(arr[2].y - arr[1].y, 2) + Math.pow(arr[2].x - arr[1].x, 2));

            double[] length = new double[3];
            length[0] = one + two;
            length[1] = two + three;
            length[2] = one + three;

            double min = Double.MAX_VALUE;
            double max = Double.MIN_VALUE;

            for (int i = 0; i < 3; i++) {
                if (min > length[i])
                    min = length[i];
                if (max < length[i])
                    max = length[i];
            }

            System.out.println(2 * max - 2 * min);
        }
    }
}