import java.io.*;
public class Main { // BOJ_14681
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double X = Double.parseDouble(br.readLine());
        double Y = Double.parseDouble(br.readLine());

        if(X>0) {
            if(Y>0) System.out.println("1");
            else System.out.println("4");
        }
        else if (X <0){
            if(Y>0) System.out.println("2");
            else System.out.println("3");
        }
    }
}
