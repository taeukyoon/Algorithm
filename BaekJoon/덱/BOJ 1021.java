import java.util.LinkedList;
import java.util.Scanner;

/*
 BOJ 1021 회전하는 큐
 */
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            list.add(i);
        }
        int cnt = 0;
        for(int i = 0; i < m; i++) {
            int num = sc.nextInt();

            int index = list.indexOf(num);
            int half = list.size()/2;

            if(half >= index) {
                while(num != list.getFirst()) {
                    list.add(list.removeFirst());
                    cnt++;
                }
            }else {
                while(num != list.getFirst()) {
                    list.addFirst(list.removeLast());
                    cnt++;
                }
            }
            list.remove();
        }
        System.out.println(cnt);
    }
}