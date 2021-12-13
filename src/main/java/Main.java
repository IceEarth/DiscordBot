import manager.CommandManager;

import listener.MessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import util.ExitCommand;

import javax.security.auth.login.LoginException;

public class Main {
    private JDA jda;
    private JDABuilder jdaBuilder;
    public static void main(String[] args) throws LoginException {
        new Main().run();
    }
    public void run() throws LoginException {
        jdaBuilder = JDABuilder.createDefault("ODI3NjE3NDEyMjUzMjIwOTQ0.YGdoxw.uGHltLzu-y8OZltdee9nsMJagEA");

        jdaBuilder.setActivity(Activity.watching("IceEarth beim Programmieren zu!"));
        jdaBuilder.setStatus(OnlineStatus.IDLE);
        jda  = jdaBuilder.build();
        jda.addEventListener(new MessageListener(jda, new CommandManager(jda)));
        new ExitCommand(jda);
    }

}
