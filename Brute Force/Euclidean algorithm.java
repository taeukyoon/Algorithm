public class Main{

    /*
     유클리드 호제법 최대공약수 구하기
     재귀함수 사용
     */
    public static void main(String[] args) {
        System.out.print("최대공약수는 : "  + gcd(192, 162));
    }

    public static int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        } else {
            return gcd( b ,a % b);
        }
    }
}