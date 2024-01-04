import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    int T;
    HashSet<Integer>[] number;
    HashSet res;

    private boolean check(int number) {
        while (number > 0) {
            if (number % 10 == 5 || number % 10 == 8) {
                number /= 10;
                continue;
            }
            return false;
        }
        return true;
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            number = new HashSet[3];

            for (int j = 0; j < number.length; j++) {
                number[j] = new HashSet<>();
                int N = Integer.parseInt(br.readLine());
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    number[j].add(Integer.parseInt(st.nextToken()));
                }
            }

            res = new HashSet();
            for (int first : number[0]) {
                for (int second : number[1]) {
                    for (int third : number[2]) {
                        if (check(first + second + third)) {
                            res.add(first + second + third);
                        }
                    }
                }
            }
            sb.append(res.size()).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
