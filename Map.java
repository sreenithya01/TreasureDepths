import java.util.ArrayList;
import java.util.Random;

public class Map {
    public char[][] grid = new char[5][5]; // 5x5 grid
    public int diverX = 0, diverY = 0;

    public ArrayList<Treasure> treasures = new ArrayList<>();

    public Map() {
        // Fill map with empty space
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = '.';
            }
        }

        // Place treasures randomly
        placeTreasures(3);

        // Place diver at starting position (0, 0)
        grid[diverY][diverX] = 'D';
    }

    private void placeTreasures(int count) {
        Random rand = new Random();
        int placed = 0;
        while (placed < count) {
            int x = rand.nextInt(5);
            int y = rand.nextInt(5);
            if (grid[y][x] == '.') {
                int value = 10 + rand.nextInt(41); // Value between 10–50
                int weight = 5 + rand.nextInt(11); // Weight between 5–15 oxygen
                treasures.add(new Treasure(x, y, value, weight));
                grid[y][x] = 'T';
                placed++;
            }
        }
    }

    public void printMap() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void moveDiver(String direction) {
        // Clear previous diver position (unless treasure is still there)
        boolean wasOnTreasure = false;
        for (Treasure t : treasures) {
            if (t.x == diverX && t.y == diverY && !t.collected) {
                grid[diverY][diverX] = 'T';
                wasOnTreasure = true;
                break;
            }
        }

        if (!wasOnTreasure) {
            grid[diverY][diverX] = '.';
        }

        // Move the diver
        switch (direction) {
            case "up": if (diverY > 0) diverY--; break;
            case "down": if (diverY < 4) diverY++; break;
            case "left": if (diverX > 0) diverX--; break;
            case "right": if (diverX < 4) diverX++; break;
        }

        grid[diverY][diverX] = 'D';
    }

    public Treasure getTreasureAt(int x, int y) {
        for (Treasure t : treasures) {
            if (t.x == x && t.y == y && !t.collected) {
                return t;
            }
        }
        return null;
    }

    public int getDiverX() {
        return diverX;
    }

    public int getDiverY() {
        return diverY;
    }
}
