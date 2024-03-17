import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    List<User> users;
    int N;
    String answer;
    List<String> res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        answer = br.readLine();

        users = new ArrayList<>();
        users.add(new User(0, "Adrian", "ABC"));
        users.add(new User(1, "Bruno", "BABC"));
        users.add(new User(2, "Goran", "CCAABB"));

        int maxScore = 0;
        res = new ArrayList<>();
        for (User user : users) {
            int sum = 0;
            for (int i = 0; i < answer.length(); i++) {
                if (answer.charAt(i) == user.pattern.charAt(i % user.pattern.length())) {
                    sum++;
                }
            }
            if (maxScore < sum) {
                res.clear();
                ;
                res.add(user.name);
                maxScore = sum;
            } else if (maxScore == sum) {
                res.add(user.name);
            }
        }

        sb.append(maxScore).append("\n");
        for (String userName : res) {
            sb.append(userName).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class User {

        int id;
        String name;
        String pattern;

        public User(int id, String name, String pattern) {
            this.id = id;
            this.name = name;
            this.pattern = pattern;
        }
    }
}
