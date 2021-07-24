
/*
 배열을 이용한 큐구현해보기
 */
class Main{
     public class ArrayQueue {
         int Max = 1000;
         int rear; //꼬리부분
         int front; //머리부분
         int[] queue;
         int value;

         public ArrayQueue() { // 초기상태의 큐배열 만들기
             front = rear = 0;
             queue = new int[Max];
         }

         public boolean queueisEmpty() {
             return front == rear;
         }

         public boolean queueisFull() { // 배열의 뒤부분이 배열의 최대크기랑 같으면
             if (rear == Max-1) {
                 return true;
             }else return false;
         }
         public void push() { //배열이 가득차면 더이상 푸쉬x
             if(queueisFull()) {
                 System.out.println("큐에 더이상 담을수 없습니다.");
                 return;
             }else { //rear에 값을 넣어주고 rear증가
                 queue[rear++] = value;
             }
         }
         public int pop() {
             if(queueisEmpty()) {
                 System.out.println("큐에 존재하는 값이 없습니다!");
                 return -1;
             }
             int popValue = queue[front++];
             return popValue;
         }
         public int peek() {
             if(queueisEmpty()) {
                 System.out.println("큐에 존재하는 값이 없습니다!");
                 return -1;
             }
             int peekValue = queue[front];
             return peekValue;
         }
     }
}