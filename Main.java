import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("🌊 Welcome to Treasure Depths — Free Dive!");
        Scanner scanner = new Scanner(System.in);

        Diver diver = new Diver();
        Map map = new Map();

        int score = 0;
        boolean surfaced = false;

        while (diver.oxygen > 0) {
            System.out.println("\nOxygen: " + diver.oxygen);
            map.printMap();

            System.out.print("Move (up/down/left/right), surface: ");
            String dir = scanner.nextLine();

            if (dir.equalsIgnoreCase("surface")) {
                surfaced = true;
                System.out.println("⬆️ You surfaced safely!");
                break;
            }

            // Movement and oxygen cost
            map.moveDiver(dir);
            diver.move(dir); // -1 oxygen for move

            // Check for treasure
            Treasure t = map.getTreasureAt(map.getDiverX(), map.getDiverY());
            if (t != null && !t.collected) {
                System.out.println("💎 You found a treasure!");
                System.out.println(t);

                System.out.print("Pick up treasure? (yes/no): ");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    if (diver.oxygen >= t.weight) {
                        diver.oxygen -= t.weight;
                        score += t.value;
                        t.collected = true;
                        System.out.println("✅ Picked up! Score so far: " + score);
                    } else {
                        System.out.println("❌ Not enough oxygen to pick it up!");
                    }
                }
            }
        }

        // End of dive
        System.out.println("\n🌬️ Dive ended.");
        if (surfaced) {
            System.out.println("🏁 Final Score (treasures surfaced with): " + score);
        } else {
            System.out.println("❌ You ran out of oxygen before surfacing!");
            System.out.println("🏁 Final Score: 0");
        }
    }
}
