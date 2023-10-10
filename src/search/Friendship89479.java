package search;
/**
 * 89479. 친구 관계_빈칸채우기
 * x와 y가 친구 관계라면 "We are friends."를, 친구 관계가 아니라면 "We are not friends."를 return
 */
public class Friendship89479 {

    int[] parent = new int[10001];

    public static void main(String[] args) {
        Friendship89479 q = new Friendship89479();
        int n = 5;
        int[][] friends = {{1,2},{2,3},{3,4}};
        int x = 1;
        int y = 4;

        System.out.println(q.solution(n, friends, x, y));
    }

    private String solution(int n, int[][] friends, int x, int y) {
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < friends.length; i++) {
            makeConnection(friends[i][0], friends[i][1]);
        }

        if (getParent(x) == getParent(y)) {
            return "We are friends.";
        } else {
            return "We are not friends.";
        }
    }

    public int getParent(int num) {
        if (num == parent[num]) {
            return num;
        }
        return parent[num] = getParent(parent[num]);
    }

    public void makeConnection(int x, int y) {
        x = getParent(x);
        y = getParent(y);

        parent[y] = x;
    }
}
