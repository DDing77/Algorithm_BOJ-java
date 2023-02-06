import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] start, end;

    public static boolean isLeafYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) return true;
        return false;
    }

    public static int[] getMonths(int year) {
        int[] months = {
                31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        if (isLeafYear(year)) {
            months[1] = 29;
        }

        return months;
    }

    public static long getSum(int[] year) {
        long total = 0;
        int[] tempMonths;
        for (int i = 1; i < year[0]; i++) {
            tempMonths = getMonths(i);
            for (int j = 0; j < 12; j++) {
                total += tempMonths[j];
            }
        }

        tempMonths = getMonths(year[0]);
        for (int i = 0; i < year[1] - 1; i++) {
            total += tempMonths[i];
        }

        total += year[2];

        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        start = new int[3];
        end = new int[3];

        st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());
        start[2] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        end[0] = Integer.parseInt(st.nextToken());
        end[1] = Integer.parseInt(st.nextToken());
        end[2] = Integer.parseInt(st.nextToken());


        if (end[0] - start[0] > 1000 || (end[0] - start[0] == 1000 && end[1] > start[1])
                || (end[0] - start[0] == 1000 && end[1] == start[1] && end[2] >= start[2])) {
            System.out.println("gg");
            return;
        }

        long startSum = getSum(start);
        long endSum = getSum(end);

        System.out.println("D-" + (endSum - startSum));
    }
}
