import java.util.*;

class Node {
    int x, y;
    int g, h, f;

    Node(int x, int y, int g, int h) {
        this.x = x;
        this.y = y;
        this.g = g;
        this.h = h;
        this.f = g + h;
    }
}

class PathFinding {

    // directions: up, down, left, right
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

    public int findShortestPath(int[][] grid, Position start, Position end) {

        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> a.f - b.f);

        boolean[][] visited = new boolean[n][m];

        pq.add(new Node(start.x, start.y, 0,
                heuristic(start.x, start.y, end)));

        while (!pq.isEmpty()) {

            Node curr = pq.poll();

            if (curr.x == end.x && curr.y == end.y) {
                return curr.g; // distance
            }

            if (visited[curr.x][curr.y])
                continue;
            visited[curr.x][curr.y] = true;

            for (int d = 0; d < 4; d++) {

                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if (isValid(nx, ny, grid, visited)) {

                    int newG = curr.g + 1;
                    int newH = heuristic(nx, ny, end);

                    pq.add(new Node(nx, ny, newG, newH));
                }
            }
        }

        return -1; // no path
    }

    private int heuristic(int x, int y, Position end) {
        return Math.abs(x - end.x) + Math.abs(y - end.y);
    }

    private boolean isValid(int x, int y, int[][] grid, boolean[][] visited) {

        return x >= 0 && y >= 0 &&
                x < grid.length && y < grid[0].length &&
                grid[x][y] != -1 &&
                !visited[x][y];
    }
}