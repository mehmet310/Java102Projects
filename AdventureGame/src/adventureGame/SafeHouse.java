package adventureGame;

import adventureGame.NormalLoc;

public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player)
    {
        super(player,"Safe House");
    }
    @Override
    public boolean onLocation()
    {
        System.out.println("You are in SafeHouse now!");
        System.out.println("Your health point renewed!");
        this.getPlayer().setHealthy(this.getPlayer().getOriginalHealthy());
        return true;
    }
}
