package dataStructure;

import java.util.*;
/**
 * 89483. 자기소개_디버깅
 * 자기소개를 한 순서대로 사람들의 번호를 차례대로 1차원 배열에 담아 return
 */
public class SelfIntro89483 {
    public static void main(String[] args) {
        SelfIntro89483 q = new SelfIntro89483();
        int n = 5;
        int[] position = {2, -1, -2, 3, 1};

        System.out.println(Arrays.toString(q.solution(n, position)));
    }

    private int[] solution(int n, int[] position) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> people = new LinkedList<>(); // 2,3,4,5

        result.add(1); // 1번 사람이 먼저 자기소개

        for (int i = 2; i <= n; i++) {
            people.add(i); // 2 ~ 마지막 번호까지의 사람 넣기
        }

        int pos = position[0];
        for (int i = 0; i < n-1; i++) { // n-1번 반복
            if (pos > 0) { // 양수일 경우 -> 오른쪽 방향(시계 방향)으로 아직 자기소개를 하지 않은 사람만 세서 n번째 위치에 앉아있는 사람을 지목
                for (int j = 0; j < pos - 1; j++) {
                    people.add(people.getFirst());
                    people.removeFirst();
                }
                result.add(people.getFirst());
                pos = position[people.getFirst() - 1];
                people.removeFirst();
            } else { // 음수일 경우 -> 왼쪽 방향(시계 반대 방향)으로 아직 자기소개를 하지 않은 사람만 세서 n번째 위치에 앉아있는 사람을 지목
                pos = -pos;
                for (int j = 0; j < pos - 1; j++) {
                    people.addFirst(people.getLast());
                    people.removeLast();
                }
                result.add(people.getLast());
                pos = position[people.getLast() - 1];
                people.removeLast();
            }
        }

        // ArrayList -> Array로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;

    }
}
