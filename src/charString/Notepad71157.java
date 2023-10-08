package charString;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 71157. 메모장_함수 작성
 * 단어를 모두 적으면 몇 줄이 되는지?
 */
public class Notepad71157 {
    public static void main(String[] args) {
        Notepad71157 q = new Notepad71157();
        int K = 10;
        String[] words = {new String("nice"), new String("happy"), new String("hello"), new String("world"), new String("hi")};

        System.out.println(q.solution(K, words));
    }

    private int solution(int k, String[] words) {
        int answer = 1;

        Queue<String> queue = new LinkedList<>(Arrays.asList(words));

        int limit = 0;
        while (!queue.isEmpty()) {
            limit += queue.peek().length();
            if (limit > k) { // 한 줄 넘어갈 때 초기화
                limit = 0;
                answer++;
                continue;
            }
            queue.poll();
            limit++; // 다음 단어 넣기 위한 공백 추가
        }

        return answer;
    }
}
