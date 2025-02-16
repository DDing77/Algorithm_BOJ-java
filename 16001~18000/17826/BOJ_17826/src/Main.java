import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int[] scores;
    private int myScore;

    private void solution() throws IOException {

        scores = new int[50];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < scores.length; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(scores);

        myScore = Integer.parseInt(br.readLine());
        int myRank = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == myScore) {
                myRank = i;
                break;
            }
        }

        myRank = 50 - myRank - 1;
        if (myRank < 5) {
            System.out.println("A+");
        } else if (myRank < 15) {
            System.out.println("A0");
        } else if (myRank < 30) {
            System.out.println("B+");
        } else if (myRank < 35) {
            System.out.println("B0");
        } else if (myRank < 45) {
            System.out.println("C+");
        } else if (myRank < 48) {
            System.out.println("C0");
        } else {
            System.out.println("F");
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
