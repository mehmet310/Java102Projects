package adventureGame;

public class Snake extends Obstacle{

        public Snake()
        {
            super(4,"Snake",3+(int)(Math.random()*4),12,0);
        }

}
