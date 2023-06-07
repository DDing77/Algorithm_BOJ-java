import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String curTime;
    static String throwTime;
    static int hour;
    static int min;
    static int sec;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        curTime = br.readLine();
        throwTime = br.readLine();

        if (curTime.equals(throwTime)) {
            System.out.println("24:00:00");
            return;
        }

        hour = Integer.parseInt(throwTime.split(":")[0]) - Integer.parseInt(curTime.split(":")[0]);
        min = Integer.parseInt(throwTime.split(":")[1]) - Integer.parseInt(curTime.split(":")[1]);
        sec = Integer.parseInt(throwTime.split(":")[2]) - Integer.parseInt(curTime.split(":")[2]);

        if (sec < 0) {
            sec += 60;
            min--;
        }

        if (min < 0) {
            min += 60;
            hour--;
        }

        if (hour < 0) {
            hour += 24;
        }

        System.out.printf("%02d:%02d:%02d%n", hour, min, sec);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}