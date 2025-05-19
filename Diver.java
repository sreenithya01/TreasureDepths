public class Diver {
    int x = 0, y = 0;
    int oxygen = 50;

    public void move(String direction) {
        switch (direction) {
            case "up": y -= 1; break;
            case "down": y += 1; break;
            case "left": x -= 1; break;
            case "right": x += 1; break;
        }
        oxygen -= 1;
        System.out.println("Moved " + direction + ". New position: (" + x + ", " + y + "). Oxygen: " + oxygen);
    }
}
