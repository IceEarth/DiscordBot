package util;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExitCommand {
    private Thread loop;
    public ExitCommand(JDA jda){
        loop = new Thread(() ->{
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try{
                while((line = reader.readLine()) != null){
                    switch (line.toLowerCase()) {
                        case "exit", "stop" -> {
                            shutDown(jda);
                            System.exit(0);
                        }
                        case "restart", "rl" -> {
                            shutDown(jda);
                            System.out.println("Restart...");
                            System.out.println("Restart complete...");
                        }
                    }
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }

        });
        loop.start();
    }
    private void shutDown(JDA jda){
        jda.shutdownNow();
        if(loop != null) this.loop.interrupt();
        System.out.println("Successfully stopped");
    }
}
