// this is just for data  

class Item {

    int id; // id for the item
    int weight; // this is weight of the item
    int x, y; // grid position for the weight
    int price; // this is the value

    Item(int id, int weight, int x, int y, int price) {
        this.id = id;
        this.weight = weight;
        this.x = x;
        this.y = y;
        this.price = price;
    }
}

class Worker {

    int capacity;
    int start_position_x;
    int start_position_y;

    Worker(int capacity, int start_position_x, int start_position_y) {
        this.capacity = capacity;
        this.start_position_x = start_position_x;
        this.start_position_y = start_position_y;
    }
}

class Position {

    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
