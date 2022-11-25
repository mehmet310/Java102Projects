package adventureGame;


import java.util.Scanner;

public class Player {

    private int damage;
    private int healthy;

    private int originalHealthy;
    private int money;
    private String name;

    private String charName;
    private Inventory inventory;

    public Player(String name) {

        this.name = name;
        this.inventory = new Inventory();
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getTotalDamage(){
        return damage+ this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void printInfo() {
        System.out.println("Gun: " + this.getInventory().getWeapon().getName()
                + ",\t Armor: " + this.getInventory().getArmor().getName()
                + ",\t Blocking: " + this.getInventory().getArmor().getBlock()
                + ",\t Damage: " + this.getDamage()
                + ",\t Health: " + this.getHealthy()
                + ",\t Money: " + this.getMoney());
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        if(healthy<0)
        {
           healthy=0;
        }
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void selectChar() // We can select character here.
    {
        Scanner s = new Scanner(System.in);
        Character[] lists = {new Samurai(), new Archer(), new Knight()};

        System.out.println("Characters: ");
        System.out.println("--------------------------------------------------");
        for (Character character : lists) {
            System.out.println("ID: " + character.getId()
                    + " Char:" + character.getName()
                    + " \t Damage: " + character.getDamage()
                    + "\t Health: " + character.getHealth()
                    + " \t Money: " + character.getMoney());
        }
        System.out.println("----------------------");
        System.out.println("Please select character");
        int pickChar = s.nextInt();
        switch (pickChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                System.out.println("Wrong character selection,try again!");
                break;
        }

    }

    public void initPlayer(Character character) {
        this.setDamage(character.getDamage());
        this.setHealthy(character.getHealth());
        this.setOriginalHealthy(character.getHealth());
        this.setMoney(character.getMoney());
        this.setCharName(character.getName());
    }

    public Weapon getWeapon()
    {
        return this.getInventory().getWeapon();
    }

    public int getOriginalHealthy() {
        return originalHealthy;
    }

    public void setOriginalHealthy(int originalHealthy) {
        this.originalHealthy = originalHealthy;
    }
}