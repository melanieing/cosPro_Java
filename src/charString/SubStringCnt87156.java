package charString;
/**
 * 87156. 부분문자열 등장 횟수_디버깅
 * s에 p가 몇 번 등장하는지?
 */
public class SubStringCnt87156 {
    public static void main(String[] args) {
        SubStringCnt87156 q = new SubStringCnt87156();
        String s = "ABABA";
        String p = "ABA";

        System.out.println(q.solution(s, p));
    }

    private int solution(String s, String p) {
        int answer = 0;

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            int check = 1;
            for (int j = i; j < i + p.length(); j++) {
                if (s.charAt(j) != p.charAt(j-i)) {
                    check = 0;
                    break;
                }
            }
            if (check == 1) {
                answer++;
            }
        }
        return answer;
    }
}
