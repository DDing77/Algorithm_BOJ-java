import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        // 숫자 길이 상 long 사용
        long[] distances = new long[n - 1];
        long[] fuels = new long[n];

        // 거리 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n - 1; i++) {
            int distance = Integer.valueOf(st.nextToken());
            distances[i] = distance;
        }

        // 주유소 입력 받기
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int fuel = Integer.valueOf(st.nextToken());
            fuels[i] = fuel;
        }

        long price = distances[0] * fuels[0]; // 초기 연료비
        int nowCity = 0;
        int nextCity = nowCity + 1;

        // 마지막 도시 전까지 진행
        while(nextCity < n - 1) {
            if(fuels[nowCity] < fuels[nextCity]) {
                price += fuels[nowCity] * distances[nextCity];
            }
            else {
                price += fuels[nextCity] * distances[nextCity];
                nowCity = nextCity;
            }

            nextCity++;
        }

        System.out.print(price);
    }
}