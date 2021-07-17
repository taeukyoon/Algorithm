import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 BOJ 11328 Strfry
 */
class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[26];


        for(int i = 0; i < n; i++) {

            char[] a1 = sc.next().toCharArray();
            char[] a2 = sc.next().toCharArray();
            for(char c : a1) arr[c - 97]++;
            for(char c : a2) arr[c - 97]--;
            boolean flag = true;
            for(int j : arr)
                if(j != 0) flag = false;
            System.out.println(flag ? "Possible" : "Impossible");
        }
    }
}