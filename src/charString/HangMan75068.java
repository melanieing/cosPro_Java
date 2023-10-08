package charString;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 75068. 행맨_함수 작성
 * 출제자의 대답을 담은 배열 반환
 */
public class HangMan75068 {
    public static void main(String[] args) {
        HangMan75068 q = new HangMan75068();
        String word = "happy";
        String[] question = {"a", "e", "i", "o", "u", "p", "h", "x", "y", "j", "r"};

        System.out.println(Arrays.toString(q.solution(word, question)));
    }

    private String[] solution(String word, String[] question) {
        ArrayList<String> list = new ArrayList<>();

        for (String value : question) {
            if (word.length() == 0) { // 알파벳을 모두 찾을 경우 바로 끝내기
                break;
            }
            if (word.contains(value)) { // 일치하면
                list.add("Yes");
                word = word.replace(value, "");
            } else { // 불일치하면
                list.add("No");
            }
        }

        if (word.length() == 0) { // 찾은 경우
            list.add("SUCCESS");
        } else { // 못 찾은 경우
            list.add("FAIL");
        }

        // ArrayList -> Array로 변환
        int idx = 0;
        String[] answer = new String[list.size()];
        for (String s : list) {
            answer[idx++] = s;
        }

        return answer;
    }
}
