package sort;

/**
 * 94334. 촤빈값_빈칸채우기
 * 배열의 최빈값 찾기
 */
public class Mode94334 {

    public int[] count = new int[1001];
    public int maxCount = 0;
    public int answer = 0;

    public static void main(String[] args) {
        Mode94334 q = new Mode94334();
        int[] sequence = {1,1,3,2,4,4,4};

        System.out.println(q.solution(sequence));
    }

    public int solution(int[] sequence) {
        func_a(sequence);   // 각 원소의 빈도 기록
        func_c();           // 빈도의 최댓값 구하기
        func_b();           // 해당 빈도의 원소 구하기

        return answer;
    }

    public void func_a(int[] sequence) {
        for (int num : sequence) {
            count[num]++;
        }
    }

    public void func_b() {
        for (int i = 1; i <= 1000; i++) { // 작은 값부터 순서대로 체크하므로 복수일 경우 고려할 필요 없음
            if (count[i] == maxCount) {
                answer = i;
                return;
            }
        }
    }

    public void func_c() {
        for (int i = 1; i <= 1000; i++) {
            maxCount = Math.max(maxCount, count[i]);
        }
    }

}
