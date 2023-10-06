package charString;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 100725. 오타 수정_함수 작성
 * 오타를 지운 1차원 문자열 배열 반환
 */
public class Typo100725 {
    public static void main(String[] args) {
        Typo100725 q = new Typo100725();
        String[][] typo = {{"appple", "1"}, {"bananaa", "6"}};

        System.out.println(Arrays.toString(q.solution(typo)));
    }

    private String[] solution(String[][] typo) {
        ArrayList<String> resultList = new ArrayList<>();

        for (String[] t : typo) {
            String str = t[0];
            StringBuilder sb = new StringBuilder();
            for (int i = 0 ; i < str.length(); i++) {
                if (i == Integer.parseInt(t[1])) {
                    continue;
                }
                sb.append(str.charAt(i));
            }
            resultList.add(sb.toString());
        }

        return resultList.toArray(new String[0]);
    }
}
