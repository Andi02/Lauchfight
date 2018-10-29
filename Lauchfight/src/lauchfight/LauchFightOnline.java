package lauchfight;

import java.util.ArrayList;
import lauchfight.attacks.hunter.ShootArrowFactory;
import lauchfight.attacks.lauch.LauchwurfFactory;
import lauchfight.attacks.mage.TeleportFactory;
import lauchfight.attacks.soldier.PistolFactory;

public class LauchFightOnline{

    //holds all Objects
    //all players have to be at the beginning of the list
    public static ArrayList<Object> world = new ArrayList<Object>();

    public void setUp() {

        //create all the Players
        Player p1 = new Player(0.2,20);
        Player p2 = new Player(0.2,20);
        
        p1.setHitBoxHeight(50);
        p1.setHitBoxWidth(50);
        
        p2.setHitBoxHeight(50);
        p2.setHitBoxWidth(50);
        //add the attackFactorys to the player
        p1.addAttackFactory(new ShootArrowFactory());
        p1.addAttackFactory(new ShootArrowFactory());
        p2.addAttackFactory(new TeleportFactory());
        p2.addAttackFactory(new LauchwurfFactory());
        //add the players to the world array
        world.add(p1);
        world.add(p2);
    }

    public String tickGame(String action) {

        //interpret the input
        interpret(action);

        //all online Players
        ArrayList<Player> players = new ArrayList<Player>();

        //get the players form the world
        world.stream().filter((o) -> (o instanceof Player)).forEach((o) -> {
            //check if o is a Player
            //if so cast it to Player and add it to the players List
            players.add((Player) o);
        });

        //buffer in order to delete Objects
        ArrayList<Object> bufferWorld = new ArrayList<Object>();

        //for every Object in the world
        for (Object o : world) {

            //check if any of the players collides with any of the attacks
            for (Player p : players) {
            	
            	//System.out.println(p.xPos+ " "+ p.yPos);
            	
                if (isColliding(o, p)) {

                    //check if the object the player collides with is a Attack
                    if (o instanceof Attack) {
                        //if so cast it to a Attack and call the onCollision function with p as argument
                        ((Attack) o).onCollision(p);
                    }

                }
            }
            

            //update the Object
            o.update();
            
            //check if the is still alive
            if (o.getAlive()) {
            	
                //if it is add it to the bufferWorld
                bufferWorld.add(o);
            }
           
        }
        //set the world to the buffer world
        world = bufferWorld;
        //System.out.println(bufferWorld.size());
        //convert the world to a string and return it
        String ret = bufferWorld.stream().map((o) -> o.toString()).reduce("", String::concat);
        
        return ret;
    }

    //interpret the actionString form the client
    public void interpret(String actions) {

        //first spile the actions in a lot of single commands
        //interpret every command
        for (String command : actions.split("_")) {
            
            //start by spliting the command by spaces
            String[] commandParts = command.split(" ");

            //the first part is the command
            if (commandParts[0].equals("addX")) {
                //move the given Player to the right Position

                int i = Integer.valueOf(commandParts[1]);

                //try moveing the i'th player to the position
                try {
                    //make shure the i'th element of world is a Player
                    if (world.get(i) instanceof Player) {
                        //if it is conver it to a Player in order to call Player unique methods on it!
                        ((Player) world.get(i)).addXPos(Integer.valueOf(commandParts[2]));
                    }
                } catch (Exception e) {
                	
                	System.out.println(actions);
                    System.out.println("cannot cast to int (addX)");
                }

            } else if (commandParts[0].equals("addY")) {
                //move the given Player to the right Position

                int i = Integer.valueOf(commandParts[1]);

                //try moveing the i'th player to the position
                try {

                    //make shure the i'th element of world is a Player
                    if (world.get(i) instanceof Player) {
                        //if it is conver it to a Player in order to call Player unique methods on it!
                        ((Player) world.get(i)).addYPos(Integer.valueOf(commandParts[2]));
                    }
                } catch (Exception e) {
                    System.out.println("cannot cast to int (addY)");
                }

            } else if (commandParts[0].equals("attack")) {
                //let the i'th player create a new attack 
                int i = Integer.valueOf(commandParts[1]);

                //get the index of the Attack that has to be created
                int index = Integer.valueOf(commandParts[2]);

                //get the mouse X and Y pos out of the command
                int mX = Integer.valueOf(commandParts[3]);
                int mY = Integer.valueOf(commandParts[4]);

                //make shure the i'th element of world is a Player
                if (world.get(i) instanceof Player) {
                    //if it is convert it to a Player in order to call Player unique methods on it!

                    //check if the cooldown is 0
                    if (((Player) world.get(i)).getFactory(index).getCoolDown() == 0) {
                        //if it is add a new attack to the world
                        world.add(((Player) world.get(i)).useAttack(index, mX, mY));
                    }

                }

            }
        }

    }

    //check if colliding with the given Object
    public boolean isColliding(Object o1, Object o2) {

        //check the X axis
        if (o1.getXPos() + o1.getHitBoxWidth() > o2.getXPos()) {
            if (o2.getXPos() + o2.getHitBoxWidth() > o1.getXPos()) {

                //check the Y axis
                if (o1.getYPos() + o1.getHitBoxHeight() > o2.getYPos()) {
                    if (o2.getYPos() + o2.getHitBoxHeight() > o1.getYPos()) {
                        //collision
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
