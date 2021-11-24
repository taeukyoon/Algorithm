import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 17825 주사위 윷놀이
 Date: 21-11-24
 순열, DFS, 시뮬레이션
 */
public class Main {
    static int[] dice, order;
    static int res = Integer.MIN_VALUE;
    static Node[] horse;
    static Node start;


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        dice = new int[11];
        order = new int[11];
        horse = new Node[5];

        for(int i = 1; i <= 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        init();
        perm(1);
        System.out.println(res);
    }
    public static void init() {
        start = new Node(0);

        Node temp = start;
        for(int i = 2; i <= 40; i += 2) {
            temp = temp.addNext(i);
        }

        Node end = temp.addNext(0);
        end.isFinish = true;
        end.next = end;

        Node middle = new Node(25);

        temp = middle.addNext(30);
        temp = temp.addNext(35);
        temp.next = Node.getNode(start, 40);

        //10-13-16-19-25
        temp = Node.getNode(start, 10);
        temp = temp.fastPath = new Node(13);
        temp = temp.addNext(16);
        temp = temp.addNext(19);
        temp.next = middle;

        //20-22-24-25
        temp = Node.getNode(start, 20);
        temp = temp.fastPath = new Node(22);
        temp = temp.addNext(24);
        temp.next = middle;

        //30-28-27-26-25
        temp = Node.getNode(start, 30);
        temp = temp.fastPath = new Node(28);
        temp = temp.addNext(27);
        temp = temp.addNext(26);
        temp.next = middle;
    }
    public static void perm(int depth) {
        if(depth == 11) {
            res = Math.max(res, game());
            return;
        }
        for(int i = 1; i <= 4; i++) {
            order[depth] = i;
            perm(depth + 1);
        }
    }

    public static int game() {
        Arrays.fill(horse, start);

        int score = 0;
        for(int i = 1; i <= 10; i++) {
            Node now = horse[order[i]]; //순열로 할당된 순서대로 말 움직인다.
            now.isEmpty = true; //현재 있는칸 비운다

            for(int j = 1; j <= dice[i]; j++) { //주사위만큼
                if(j == 1 && now.fastPath != null) {
                    now = now.fastPath;
                } else {
                    now = now.next;
                }
            }

            horse[order[i]] = now; //이동후 말 위치 조정

            if(!now.isEmpty && !now.isFinish) { //이동 마친곳에 말존재하면, 해당 말은 고를 수 없다.
                score = 0;
                break;
            } else {
                now.isEmpty = false;
                score += now.val;
            }
        }

        for (int i = 1; i <= 4; i++) {
            horse[i].isEmpty = true;
        }
        return score;
    }
}
class Node{
    int val; //윷놀이판 해당점수
    boolean isEmpty, isFinish; //해당칸이 없는가, 도착지점인가
    Node next, fastPath; //fastPath 부분은 10, 20, 30의 두 가지 방향

    public Node(int val) {
        this.val = val;
        this.isEmpty = true;
    }

    public Node addNext(int val) {
        Node nextNode = new Node(val);
        this.next = nextNode;
        return nextNode;
    }

    public static Node getNode(Node start, int target) { //지름길 지점
        Node temp = start;

        while (true) { //시작지점부터
            if(temp == null) return null;
            if(temp.val == target) return temp;
            temp = temp.next;
        }
    }
}