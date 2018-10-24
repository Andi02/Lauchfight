package lauchfight;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class OnlineThread extends Thread {
    
    public Player p;
    public boolean isRunning = false;

    public void run() {
        
        try {
            //prep array
            String a = "player="+p.getId()+"&x="+p.getX()+"&y="+p.getY();
            URL url = new URL("http://chris022.atwebpages.com/LauchFight/testerei.php?"+a);
            InputStream is = url.openStream();

            Scanner scanner = new Scanner(is, "UTF-8");
            String str = scanner.useDelimiter("\\A").next();
            LauchFight.data = str;
            System.out.println(str);
            run();
        } catch (Exception e) {
        }
    }

}
