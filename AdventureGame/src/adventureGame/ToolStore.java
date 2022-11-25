package adventureGame;

import java.util.Scanner;

public class ToolStore extends NormalLoc {
    public ToolStore(Player p) {
        super(p, "ToolStore");
    }

    @Override
    public boolean onLocation() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Welcome to ToolStore!");
        boolean showMenu = true;
        while (showMenu != false) {
            System.out.println("1-Guns");
            System.out.println("2-Armors");
            System.out.println("3-Exit");
            System.out.println("Your Choice: ");
            int pick = inp.nextInt();
            while (pick < 1 || pick > 3) {
                System.out.println("Unavailable value,try again!");
                pick = inp.nextInt();

            }
            switch (pick) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyWeapon();
                    break;
                case 3:
                    System.out.println("Have a nice day!");
                    showMenu = false;
                    return true;
            }

        }
        return true;
    }

    public void printArmor() {

        System.out.println("-------------Armors---------- ");
        System.out.println();
        for (Armor a : Armor.armors()) {

            System.out.println(a.getId() + "-" + a.getName() + " Money: " + a.getPrice() + " Block: " + a.getBlock());

        }

    }

    public void buyArmor() {
        Scanner input = new Scanner(System.in);
        int pick = input.nextInt();
        while (pick < 0 || pick > Armor.armors().length) {
            System.out.println("Unavailable value,try again!");
            pick = input.nextInt();
        }
        if (pick != 0) {
            if (Armor.getArmorByID(pick) != null) {
                if (Armor.getArmorByID(pick).getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You do not have enough money");
                } else {
                    System.out.println(Armor.getArmorByID(pick).getName() + "you bought this armor!");
                    int newMoney = this.getPlayer().getMoney() - Armor.getArmorByID(pick).getPrice();
                    System.out.println("Your previous armor: " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(Armor.getArmorByID(pick));
                    System.out.println("Your armor now: " + this.getPlayer().getInventory().getArmor().getName());

                    System.out.println("Your remained money: " + this.getPlayer().getMoney());
                }
            }
        }
    }

    public void buyWeapon() {
        Scanner input = new Scanner(System.in);
        int pick = input.nextInt();
        while (pick < 0 || pick > Weapon.weapons().length) {
            System.out.println("Unavailable value,try again!");
            pick = input.nextInt();
        }
        if (pick != 0) {
            if (Weapon.getWeaponByID(pick) != null) {
                if (Weapon.getWeaponByID(pick).getMoney() > this.getPlayer().getMoney()) {
                    System.out.println("You do not have enough money");
                } else {
                    System.out.println(Weapon.getWeaponByID(pick).getName() + "you bought this weapon!");
                    int newMoney = this.getPlayer().getMoney() - Weapon.getWeaponByID(pick).getMoney();
                    System.out.println("Your previous weapon: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(Weapon.getWeaponByID(pick));
                    System.out.println("Your weapon now: " + this.getPlayer().getInventory().getWeapon().getName());

                    System.out.println("Your remained money: " + this.getPlayer().getMoney());
                }
            }
        }
    }

    public void printWeapon() {

        System.out.println("--------------Guns---------- ");
        System.out.println();
        for (Weapon w : Weapon.weapons()) {

            System.out.println(w.getId() + "-" + w.getName() + " Money: " + w.getMoney() + " Damage: " + w.getDamage());

        }
        System.out.println("0-Exit");

    }
}
