import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    private final int[] days = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };
    private HashMap<String, Integer> months;
    private String[] inputs;
    private double res;

    public void makeTable() {
        months = new HashMap<>();
        months.put("January", 1);
        months.put("February", 2);
        months.put("March", 3);
        months.put("April", 4);
        months.put("May", 5);
        months.put("June", 6);
        months.put("July", 7);
        months.put("August", 8);
        months.put("September", 9);
        months.put("October", 10);
        months.put("November", 11);
        months.put("December", 12);
    }

    public boolean isLeafYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        makeTable();

        inputs = br.readLine().split(", | |:");

        int year = Integer.parseInt(inputs[2]);
        int month = months.get(inputs[0]);
        int day = Integer.parseInt(inputs[1]);
        int hour = Integer.parseInt(inputs[3]);
        int min = Integer.parseInt(inputs[4]);

        int total = 525_600;
        boolean isLeaf = isLeafYear(year);
        if (isLeaf) total += 24 * 60;

        double sum = 0;
        for (int i = 1; i < month; i++) {
            sum += days[i-1];
            if (i == 2 && isLeaf) {
                sum++;
            }
        }

        sum += day - 1;
        sum *= 24 * 60;
        sum += (hour * 60) + (min);
        System.out.println((sum / total) * 100);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
