package dataStructure;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;
/**
 * 78081. 출석 체크_함수 작성
 * 중복되는 이름을 제거하고 알파벳순으로 정렬한 배열
 */
public class CheckAttendancy78081 {
    public static void main(String[] args) {
        CheckAttendancy78081 q = new CheckAttendancy78081();
        String[] names = {"Amy", "Carol", "Bob", "Amy"};

        System.out.println(Arrays.toString(q.solution(names)));
    }

    private String[] solution(String[] names) {

        TreeSet<String> set = new TreeSet<>(); // 순서가 있고 중복이 없는 트리셋 생성
        Collections.addAll(set, names); // 배열 -> 트리셋

        return set.toArray(new String[0]); // 트리셋 -> 배열
    }
}
