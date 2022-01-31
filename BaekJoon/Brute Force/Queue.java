import java.util.LinkedList;
import java.util.Queue;

/*
 큐 구현 예제
 */
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        //삽입(3) - 삽입(1) - 삽입(2) - 삽입(7) - 삭제() - 삽입(9) - 삽입(5) - 삽입(4)
        queue.offer(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(7);
        queue.poll(); //3삭제
        queue.offer(9);
        queue.offer(5);
        queue.offer(4);
        queue.poll(); //실행결과 : 27954
        //상단 원소부터 추출
        while (!queue.isEmpty()) {
            System.out.println(queue.poll() + " ");
        }
    }
}