package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
    static int cnt0[] = new int[41];
    static int cnt1[] = new int[41];
    public static int fibo0(int n){
        if(n==1){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(cnt0[n-1] == -1 && cnt0[n-2] == -1){
            cnt0[n] = fibo0(n-1)+fibo0(n-2);
            return cnt0[n];
        }
        else if(cnt0[n-1] == -1){
            cnt0[n] = fibo0(n-1)+cnt0[n-2];
            return cnt0[n];
        }
        else if(cnt0[n-2] == -1){
            cnt0[n] = cnt0[n-1]+fibo0(n-2);
            return cnt0[n];
        }
        else{
            cnt0[n] = cnt0[n-1]+cnt0[n-2];
            return cnt0[n];
        }
    }
    public static int fibo1(int n){
        if(n==1){
            return 1;
        }
        if(n==0){
            return 0;
        }
        if(cnt1[n-1] == -1 && cnt1[n-2] == -1){
            cnt1[n] = fibo1(n-1)+fibo1(n-2);
            return cnt1[n];
        }
        else if(cnt1[n-1] == -1){
            cnt1[n] = fibo1(n-1)+cnt1[n-2];
            return cnt1[n];
        }
        else if(cnt1[n-2] == -1){
            cnt1[n] = cnt1[n-1]+fibo1(n-2);
            return cnt1[n];
        }
        else{
            cnt1[n] = cnt1[n-1]+cnt1[n-2];
            return cnt1[n];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Arrays.fill(cnt0, -1);
        Arrays.fill(cnt1, -1);
        cnt0[0] = 1;
        cnt1[0] = 0;
        cnt0[1] = 0;
        cnt1[1] = 1;
        for(int i =0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            fibo0(n);
            fibo1(n);
            System.out.println(cnt0[n]+" "+cnt1[n]);
        }
    }
}
