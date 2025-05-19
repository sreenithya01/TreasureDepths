public class Treasure {
    public int x, y; // position on the map
    public int value; // points (like gold)
    public int weight; // oxygen cost to pick up
    public boolean collected = false;

    public Treasure(int x, int y, int value, int weight) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.weight = weight;
    }

    public String toString() {
        return "Treasure at (" + x + "," + y + ") | 💰 Value: " + value + " | 🫧 Oxygen Cost: " + weight;
    }
}
