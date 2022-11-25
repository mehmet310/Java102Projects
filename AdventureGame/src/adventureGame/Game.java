package adventureGame;

import java.util.Scanner;

public class Game {
    Scanner s = new Scanner(System.in);

    public void start() {
        System.out.println(" Welcome to Adventure Game.");
        System.out.println("Please enter a name.");
        String player = s.nextLine();
        Player p = new Player(player);
        System.out.println("Dear player, " + p.getName() + " Welcome to the game.");
        System.out.println("Please select a char to start this game.");
        System.out.println("-------------------------------------------------------");
        p.selectChar();
        Location location = null;
        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println();
            System.out.println("Territories: "
                    + "1- Safe House : You are safe here."
                    + "2- ToolStore: You can purchase armor and gun."
                    + "3- Cave:(Reward)<Food> Enter to the cave but be careful there are zombies here!"
                    + "4- Forest:(Reward)<Firewood> Enter to the forest but be careful there are vampires here!"
                    + "5- River: (Reward)<Water> Enter to the river but be careful there are bears here!"
                    + "0- Exit: Finish the game.");
            System.out.println("Please select a location");
            int selectLoc = s.nextInt();

            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(p);
                    break;
                case 2:
                    location = new ToolStore(p);
                    break;
                case 3:
                    location = new Cave(p);
                    break;
                case 4:
                    location = new Forest(p);
                    break;
                case 5:
                    location = new River(p);
                    break;

                default:
                    System.out.println("Please enter an available zone!");
                    break;

            }
            if (location == null) {
                System.out.println("You gave up quickly :( ");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Game Over!");
                break;
            }
        }
    }
}
