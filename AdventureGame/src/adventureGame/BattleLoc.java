package adventureGame;

import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;

    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        Scanner s = new Scanner(System.in);
        int obsNumber = this.randObstacleNumber();
        System.out.println("You are here now: " + this.getName());
        System.out.println("Be careful! There are " + obsNumber + "times " + this.getObstacle().getName() + "here!");
        System.out.println("<F>ight or <E>scape");
        String selection = s.nextLine();

        if (selection.equals("F") || selection.equals("f") && (combat(obsNumber))) {

            System.out.println(this.getName() + " you beat all enemies!");
            return true;

        }
        if (this.getPlayer().getHealthy() <= 0) {
            System.out.println("You died! ");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        Scanner input=new Scanner(System.in);
        int finishMonster = 0;
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            int firstHit = firstHit();
            while (this.getPlayer().getHealthy() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("<P>unch or <E>scape");
                String selectCombat = input.nextLine().toUpperCase();
                while (!selectCombat.equals("P") && !selectCombat.equals("E")) {
                    System.out.println("Wrong value, Try again!");
                    selectCombat = input.nextLine().toUpperCase();
                }
                if (selectCombat.equals("P")) {
                    if (firstHit == 0) {           // Because of 50% percantage,if 0 ,then player will hit. else monster will hit.
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        System.out.println("You hit it");
                        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
                        System.out.println("Remained Health: " + this.getPlayer().getHealthy());
                        System.out.println(this.getObstacle().getName() + " kalan cani: " + this.getObstacle().getHealth());
                        System.out.println();
                        if (this.getObstacle().getHealth() > 0) {
                            int durability = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            this.getPlayer().setHealthy(this.getPlayer().getHealthy() - durability);
                            System.out.println("Monster hit you");
                            System.out.println("Monster's damage " + this.getObstacle().getDamage());
                            System.out.println("Your remained health: " + this.getPlayer().getHealthy());
                            System.out.println(this.getObstacle().getName() + " remained health point: " + this.getObstacle().getHealth());
                            System.out.println();
                        }
                    }
                    if (firstHit == 1) {
                        if (this.getPlayer().getHealthy() > 0) {
                            int durability = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            this.getPlayer().setHealthy(this.getPlayer().getHealthy() - durability);
                            System.out.println("Monster hit it");
                            System.out.println("Monster's damage to you: " + this.getObstacle().getDamage());
                            System.out.println("Your remained health: " + this.getPlayer().getHealthy());
                            System.out.println(this.getObstacle().getName() + " remained health point: " + this.getObstacle().getHealth());
                            System.out.println();
                        }
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        System.out.println("You hit it");
                        System.out.println("Your damage to it: " + this.getPlayer().getTotalDamage());
                        System.out.println("Your remained health: " + this.getPlayer().getHealthy());
                        System.out.println(this.getObstacle().getName() + " remained health point: " + this.getObstacle().getHealth());
                        System.out.println();
                    }
                } else {
                    System.out.println("You gave up quickly :(");
                    break;
                }
                if (this.getPlayer().getHealthy() <= 0) {
                    return false;
                }
                if (this.getObstacle().getHealth() <= 0) {
                    if (this.getName().equals("Mine")) {
                        Random snake = new Random();
                        snakeAward();
                    } else {
                        this.getPlayer().setMoney(this.getObstacle().getAward() + this.getPlayer().getMoney());
                        System.out.println("Your updated money: " + this.getPlayer().getMoney());
                    }
                    finishMonster++;
                }
                if (finishMonster == (obsNumber) && this.getObstacle().getHealth() <= 0) {
                    System.out.println(finishMonster);
                    System.out.println("Congratulations !!! You killed all monsters at "+ this.getName()+" location!");
                    locationAward();
                    return true;
                }
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Your Health: " + this.getPlayer().getHealthy());
        System.out.println(this.getObstacle().getName() + " its health" + this.getObstacle().getHealth());
        System.out.println("-------------------------------");
    }

    public void obstacleStats(int i) {
        System.out.println(i + " . " + this.getObstacle().getName() + " Values");
        System.out.println("--------------------------");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Money: " + this.getPlayer().getMoney());
        System.out.println("Award: " + this.getObstacle().getAward());
        System.out.println();


    }
    public int firstHit(){
        Random random=new Random();
        return random.nextInt(2);

    }

    public int randBossMonster(){
        Random random=new Random();
        return random.nextInt(this.maxObstacle)+1;

    }


    public void playerStats() {
        System.out.println("Player Values");
        System.out.println("------------------");
        System.out.println("Health: " + this.getPlayer().getHealthy());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Money: " + this.getPlayer().getMoney());
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Blocking: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println();


    }

    public int randObstacleNumber() {
        Random random = new Random();
        return random.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
    public void snakeAward() {
        Random a = new Random();
        int percentage = a.nextInt(100) ;
        int gun = a.nextInt(100);
        int shield = a.nextInt(100);
        int money = a.nextInt(100);
        if (percentage < 15) {
            if (gun < 50) {
                if (isWantWeapon("Gun")) {
                    this.getPlayer().getInventory().setWeapon(Weapon.getWeaponByID(1));
                }
            }
            if (gun >= 50 && gun < 80) {
                if (isWantWeapon("Sword")) {
                    this.getPlayer().getInventory().setWeapon(Weapon.getWeaponByID(2));
                }
            }
            if (gun >= 80) {
                if (isWantWeapon("Rifle")) {
                    this.getPlayer().getInventory().setWeapon(Weapon.getWeaponByID(3));
                }
            }
        } else if (percentage >= 15 && percentage < 30) {   // zirh else if blogu
            if (shield < 50) {
                if (isWantArmor("Light")) {
                    this.getPlayer().getInventory().setArmor(Armor.getArmorByID(1));
                }
            }
            if (shield >= 50 && shield < 80) {
                if (isWantArmor("Medium")) {
                    this.getPlayer().getInventory().setArmor(Armor.getArmorByID(2));
                }
            }
            if (shield >= 80) {
                if (isWantArmor("Heavy")) {
                    this.getPlayer().getInventory().setArmor(Armor.getArmorByID(3));
                }
            }
        } else if (percentage >= 30 && percentage < 55) {
            awardMoney(money);
        } else {
            System.out.println("Sorry,Snake is empty.");
            System.out.println();
        }
    }
    public void awardMoney(int money) {
        if (money < 50) {
            this.getPlayer().setMoney(1 + this.getPlayer().getMoney());
            System.out.println("you earned 1 gold.");
        } else if (money >= 50 && money < 80) {
            this.getPlayer().setMoney(5 + this.getPlayer().getMoney());
            System.out.println("you earned 5 gold.");
        } else {
            this.getPlayer().setMoney(10 + this.getPlayer().getMoney());
            System.out.println("you earned 10 gold.");
        }
    }
    public boolean isWantWeapon(String name) {
        Scanner input=new Scanner(System.in);
        System.out.println("Congratulations " + name + " you earned it, do you want to take it?");
        System.out.println("You have : " + this.getPlayer().getInventory().getWeapon().getName()+"now.");
        System.out.println("1-Yes");
        System.out.println("2-No");
        System.out.println();
        int isCheck  = input.nextInt();
        input.nextLine();
        while (isCheck  < 1 || isCheck  > 2) {
            System.out.println("Wrong choice,try again!");
            isCheck  = input.nextInt();
            input.nextLine();
        }
        if (isCheck  == 2) {
            return false;
        }
        return true;
    }
    public boolean isWantArmor(String name) {
        Scanner input=new Scanner(System.in);
        System.out.println("Congratulations " + name + " you earned it, do you want to take it?");
        System.out.println("You have : " + this.getPlayer().getInventory().getArmor().getName()+ "now.");
        System.out.println("1-Yes");
        System.out.println("2-No");
        System.out.println();
        int isCheck = input.nextInt();
        input.nextLine();
        while (isCheck  < 1 || isCheck  > 2) {
            System.out.println("Wrong choice,try again!");
            isCheck  = input.nextInt();
            input.nextLine();
        }
        if (isCheck  == 2) {
            return false;
        }
        return true;
    }
    public void locationAward() {
        if (this.getName().equals("Cave")) {
            this.getPlayer().getInventory().setFood(this.award);
        }
        if (this.getName().equals("Forest")) {
            this.getPlayer().getInventory().setFirewood(this.award);
        }
        if (this.getName().equals("River")) {
            this.getPlayer().getInventory().setWater(this.award);
        }
        if (this.getName().equals("Mine")) {
            this.getPlayer().getInventory().setSnake(this.getPlayer().getInventory().getSnake());
        }
    }
}
