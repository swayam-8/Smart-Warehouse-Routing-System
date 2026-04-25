import java.util.List;

class Main {

    public static void main(String[] args) {

        // take input from user
        Input input = new Input();

        List<Item> items = input.items;
        int[][] grid = input.grid;
        Worker worker = input.worker;

        // run knapsack
        KnapsackSolver ks = new KnapsackSolver();
        List<Item> selected = ks.solve(items, worker.capacity);

        System.out.println("\nSelected Items:");
        for (Item item : selected) {
            System.out.println(
                "Item " + item.id +
                " | Weight = " + item.weight +
                " | Value = " + item.price +
                " | Position = (" + item.x + ", " + item.y + ")"
            );
        }

        // pathfinding
        PathFinding pf = new PathFinding();

        Position current = new Position(
                worker.start_position_x,
                worker.start_position_y
        );

        int totalDistance = 0;

        System.out.println("\nPath Traversal:");

        for (Item item : selected) {

            Position target = new Position(item.x, item.y);

            int dist = pf.findShortestPath(grid, current, target);

            System.out.println(
                "From (" + current.x + "," + current.y + ") -> " +
                "(" + target.x + "," + target.y + ") = " + dist
            );

            totalDistance += dist;

            // move worker to new position
            current = target;
        }

        System.out.println("\nTotal Distance = " + totalDistance);
    }
}