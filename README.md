# Warehouse Pick-and-Pack Optimization

## 📌 Project Overview
This project is a Java-based algorithmic solution designed to optimize warehouse "pick-and-pack" operations. Given a warehouse represented as a 2D grid containing items with specific weights, values, and locations, the system helps a worker with limited carrying capacity maximize the total value of collected items while minimizing the travel distance required to pick them up.

## 🧠 Data Structures & Algorithms (DSA) Used
* **0/1 Knapsack Algorithm (Dynamic Programming):** Determines the optimal combination of items that yields the maximum value within the worker's weight limit.
* **A* (A-Star) Pathfinding Algorithm:** Uses a `PriorityQueue` and a Manhattan distance heuristic to find the shortest path between selected items on the warehouse grid.

## 📂 Project Structure
The project is structured into a main directory containing the problem statement and a `src` folder containing the Java source code.

```text
dsa course project/
│
├── ps.txt               # The problem statement and core objective of the project.
│
└── src/                 # Source code directory
    ├── input.java       # Handles user input for grid size, worker capacity, and item details. Ensures coordinates are valid.
    ├── knapsnack.java   # Contains the Dynamic Programming logic (DP table & backtracking) to select the optimal items.
    ├── pathfinding.java # Implements the A* search algorithm using a PriorityQueue to calculate the shortest route.
    ├── model.java       # Defines the foundational data objects: Item, Worker, Position, and Node.
    └── main.java        # The entry point of the program. It ties the input, knapsack solver, and pathfinding sequence together.
