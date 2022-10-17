import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        // System.out.println(helper("BBBAABBBAABBABBBB", 0));
        System.out.println(formY(
                new int[][] {
                        { 0, 1, 2 },
                        { 0, 2, 2 },
                        { 1, 1, 1 }
                }));

    }

    public static int formY(int[][] matrix) {
        int half = matrix.length / 2;
        int cols = matrix[0].length;

        HashMap<Integer, Integer> forY = new HashMap<>();
        HashMap<Integer, Integer> forBg = new HashMap<>();

        forY.put(0, 0);
        forY.put(1, 0);
        forY.put(2, 0);
        forBg.put(0, 0);
        forBg.put(1, 0);
        forBg.put(2, 0);

        for (int i = 0; i < half; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == i || j == (cols - 1) - i) {
                    if (matrix[i][j] != 0)
                        forY.put(0, forY.get(0) + 1);
                    if (matrix[i][j] != 1)
                        forY.put(1, forY.get(1) + 1);
                    if (matrix[i][j] != 2)
                        forY.put(2, forY.get(2) + 1);
                } else {
                    if (matrix[i][j] != 0)
                        forBg.put(0, forBg.get(0) + 1);
                    if (matrix[i][j] != 1)
                        forBg.put(1, forBg.get(1) + 1);
                    if (matrix[i][j] != 2)
                        forBg.put(2, forBg.get(2) + 1);
                }
            }
        }

        for (int i = half; i < matrix.length; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == cols / 2) {
                    if (matrix[i][j] != 0)
                        forY.put(0, forY.get(0) + 1);
                    if (matrix[i][j] != 1)
                        forY.put(1, forY.get(1) + 1);
                    if (matrix[i][j] != 2)
                        forY.put(2, forY.get(2) + 1);
                } else {
                    if (matrix[i][j] != 0)
                        forBg.put(0, forBg.get(0) + 1);
                    if (matrix[i][j] != 1)
                        forBg.put(1, forBg.get(1) + 1);
                    if (matrix[i][j] != 2)
                        forBg.put(2, forBg.get(2) + 1);
                }
            }
        }

        int a = forY.get(0) + Math.min(forBg.get(1), forBg.get(2));
        int b = forY.get(1) + Math.min(forBg.get(2), forBg.get(0));
        int c = forY.get(2) + Math.min(forBg.get(0), forBg.get(1));

        return Math.min(a, Math.min(b, c));
    }

    public static int removeA(String S, int pos) {
        int count = 0;
        for (int i = pos; i < S.length(); i++) {
            if (S.charAt(i) == 'A')
                count++;
        }
        return count;
    }

    public static int helper(String S, int pos) {

        if (pos >= S.length())
            return 0;

        if (S.charAt(pos) == 'B') {
            int keepB = removeA(S, pos + 1);
            int temp = pos;
            while (temp < S.length() && S.charAt(temp) == 'B')
                temp++;
            int removeB = (temp - pos) + helper(S, temp);
            return Math.min(keepB, removeB);
        } else {
            int temp = pos;
            while (temp < S.length() && S.charAt(temp) == 'A')
                temp++;
            int keepA = helper(S, temp);
            return keepA;
        }
    }
}
