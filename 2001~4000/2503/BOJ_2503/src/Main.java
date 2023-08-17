import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    Question[] questions;
    int res;

    public boolean validate(int number) {
        int z = number % 10;
        number /= 10;
        int y = number % 10;
        number /= 10;
        int x = number;

        if (z == 0 || y == 0 || x == 0) {
            return false;
        }

        if (z == y || z == x || y == x) {
            return false;
        }

        return true;
    }

    public boolean getResult(Question question, int number) {
        char[] questionNumber = String.valueOf(question.questionNumber).toCharArray();
        char[] inputNumber = String.valueOf(number).toCharArray();

        int strikeCnt = 0;
        int ballCnt = 0;

        if (questionNumber[0] == inputNumber[0]) {
            strikeCnt++;
        } else {
            if (questionNumber[0] == inputNumber[1] || questionNumber[0] == inputNumber[2]) {
                ballCnt++;
            }
        }

        if (questionNumber[1] == inputNumber[1]) {
            strikeCnt++;
        } else {
            if (questionNumber[1] == inputNumber[0] || questionNumber[1] == inputNumber[2]) {
                ballCnt++;
            }
        }

        if (questionNumber[2] == inputNumber[2]) {
            strikeCnt++;
        } else {
            if (questionNumber[2] == inputNumber[0] || questionNumber[2] == inputNumber[1]) {
                ballCnt++;
            }
        }

        if (question.strikeCnt == strikeCnt && question.ballCnt == ballCnt) {
            return true;
        }

        return false;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        questions = new Question[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            questions[i] = new Question(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        res = 0;
        for (int i = 123; i <= 987; i++) {
            if (!validate(i)) {
                continue;
            }

            boolean flag = true;
            for (Question question : questions) {
                if (!getResult(question, i)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static class Question {
        int questionNumber;
        int strikeCnt;
        int ballCnt;

        public Question(int questionNumber, int strikeCnt, int ballCnt) {
            this.questionNumber = questionNumber;
            this.strikeCnt = strikeCnt;
            this.ballCnt = ballCnt;
        }
    }
}
