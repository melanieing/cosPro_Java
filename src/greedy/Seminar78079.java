package greedy;
/**
 * 78079. 세미나 참관_디버깅
 * 정확히 t시간 동안 영희가 세미나에 참관할 수 있는 방법의 수
 */
public class Seminar78079 {
    public static void main(String[] args) {
        Seminar78079 q = new Seminar78079();
        int[] seminars = {1,2,3,2,5};
        int t = 5;

        System.out.println(q.solution(seminars, t));
    }

    private int solution(int[] seminars, int t) {
        int st = 0;
        int total = 0;
        int answer = 0;

        for (int ed = 0; ed < seminars.length; ed++) {
            total += seminars[ed];
            while (total > t) { // t시간을 넘어가면 앞에서부터 빼기
                total -= seminars[st];
                st += 1;
            }
            if (total == t) { // 정확히 t시간일 때
                answer += 1;
            }
        }
        return answer;
    }


}
