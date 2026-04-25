import java.util.List;
import java.util.ArrayList;

class KnapsackSolver {

    public List<Item> solve(List<Item> items, int capacity) {

        int n = items.size();

        int[][] dp = new int[n + 1][capacity + 1];

        // build dp table
        for (int i = 1; i <= n; i++) {

            Item curr = items.get(i - 1);

            for (int w = 0; w <= capacity; w++) {

                if (curr.weight <= w) {

                    int take = curr.price + dp[i - 1][w - curr.weight];
                    int skip = dp[i - 1][w];

                    dp[i][w] = Math.max(take, skip);

                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // backtracking
        List<Item> selected = new ArrayList<>();

        int w = capacity;

        for (int i = n; i > 0; i--) {

            if (dp[i][w] != dp[i - 1][w]) {

                Item curr = items.get(i - 1);
                selected.add(curr);

                w = w - curr.weight;
            }
        }

        return selected;
    }
}