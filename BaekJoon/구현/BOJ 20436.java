import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 BOJ 20436 ZOAC 3
 */
public class Main {
    static String keyVal1, keyVal2;
    static int res;
    static HashMap<String, KeyBoard> vowels; //모음
    static HashMap<String, KeyBoard> consonant; //자음

    static class KeyBoard {
        int x;
        int y;

        public KeyBoard(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        vowels = new HashMap<>();
        consonant = new HashMap<>();

        keyVal1 = st.nextToken();
        keyVal2 = st.nextToken();
        String str = br.readLine();

        init();

        for (int i = 0; i < str.length(); i++) {
            String val = str.charAt(i)+"";
            inputTime(val);
        }
        System.out.println(res);
    }
    public static int inputTime(String val) {
        if (consonant.containsKey(val)) {
            KeyBoard keyBoard1 = consonant.get(keyVal1);
            KeyBoard keyBoard2 = consonant.get(val);
            res += (Math.abs(keyBoard1.x - keyBoard2.x) + Math.abs(keyBoard1.y - keyBoard2.y)); //시간
            res++;
            keyVal1 = val;
        } else {
            KeyBoard keyBoard1 = vowels.get(keyVal2);
            KeyBoard keyBoard2 = vowels.get(val);
            res += (Math.abs(keyBoard1.x - keyBoard2.x) + Math.abs(keyBoard1.y - keyBoard2.y));
            res++;
            keyVal2 = val;
        }
        return res;
    }
    public static void init() {
        //자음
        consonant.put("q", new KeyBoard(0, 0));
        consonant.put("w", new KeyBoard(0, 1));
        consonant.put("e", new KeyBoard(0, 2));
        consonant.put("r", new KeyBoard(0, 3));
        consonant.put("t", new KeyBoard(0, 4));
        consonant.put("a", new KeyBoard(1, 0));
        consonant.put("s", new KeyBoard(1, 1));
        consonant.put("d", new KeyBoard(1, 2));
        consonant.put("f", new KeyBoard(1, 3));
        consonant.put("g", new KeyBoard(1, 4));
        consonant.put("z", new KeyBoard(2, 0));
        consonant.put("x", new KeyBoard(2, 1));
        consonant.put("c", new KeyBoard(2, 2));
        consonant.put("v", new KeyBoard(2, 3));

        //모음
        vowels.put("y", new KeyBoard(0, 5));
        vowels.put("u", new KeyBoard(0, 6));
        vowels.put("i", new KeyBoard(0, 7));
        vowels.put("o", new KeyBoard(0, 8));
        vowels.put("p", new KeyBoard(0, 9));
        vowels.put("h", new KeyBoard(1, 5));
        vowels.put("j", new KeyBoard(1, 6));
        vowels.put("k", new KeyBoard(1, 7));
        vowels.put("l", new KeyBoard(1, 8));
        vowels.put("b", new KeyBoard(2, 4));
        vowels.put("n", new KeyBoard(2, 5));
        vowels.put("m", new KeyBoard(2, 6));
    }
}
