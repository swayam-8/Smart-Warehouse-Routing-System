import java.util.*;

class Input {

    List<Item> items;
    int[][] grid;
    Worker worker;

    Input() {

        Scanner sc = new Scanner(System.in);

        // grid size
        System.out.print("Enter grid rows: ");
        int n = sc.nextInt();

        System.out.print("Enter grid cols: ");
        int m = sc.nextInt();

        grid = new int[n][m];

        // worker input (safe)
        int sx, sy;
        while (true) {
            System.out.print("Enter worker start x: ");
            sx = sc.nextInt();

            System.out.print("Enter worker start y: ");
            sy = sc.nextInt();

            if (isValid(sx, sy, n, m)) break;

            System.out.println("Invalid position! Try again.");
        }

        System.out.print("Enter worker capacity: ");
        int capacity = sc.nextInt();

        worker = new Worker(capacity, sx, sy);

        // items
        System.out.print("Enter number of items: ");
        int k = sc.nextInt();

        items = new ArrayList<>();

        for (int i = 0; i < k; i++) {

            System.out.println("\nItem " + (i + 1));

            System.out.print("Enter weight: ");
            int w = sc.nextInt();

            System.out.print("Enter value: ");
            int val = sc.nextInt();

            int x, y;

            // safe position input
            while (true) {
                System.out.print("Enter position x: ");
                x = sc.nextInt();

                System.out.print("Enter position y: ");
                y = sc.nextInt();

                if (isValid(x, y, n, m)) break;

                System.out.println("Invalid position! Try again.");
            }

            items.add(new Item(i + 1, w, x, y, val));

            grid[x][y] = 1;
        }
    }

    // helper function
    private boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}