import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] angles  = new int[3];
        int sum = 0;
        for(int i=0; i<3; i++) {
            angles[i] = Integer.parseInt(br.readLine());
            sum += angles[i];
        }


        if( angles[0] == 60 && angles[1] == 60 && angles[2] == 60) System.out.println("Equilateral");
        else if(sum == 180 && ( (angles[0] == angles[1]) || (angles[1] == angles[2]) || (angles[1] == angles[2]))) System.out.println("Isosceles");
        else if(sum == 180 && ( (angles[0] != angles[1]) || (angles[1] != angles[2]) || (angles[1] != angles[2]))) System.out.println("Scalene");
        else System.out.println("Error");
    }
}
