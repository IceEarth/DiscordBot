package command.util;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.function.Consumer;

public interface Command {



    void execute(String[] args, Member member, TextChannel channel, Message message, Consumer<Throwable> exception) ;

    void executeSlash();

    default public boolean isPermitted(Member member){
        return true;
    }

    default String invalidArguments(){
        return "Sorry! The usage is wrong! Do it that way:\n" + getUsage();
    }
    default String hierarchy(){
        return "I can't interact with this member! Please contact an admin if you believe this is an error!";
    }


    String getUsage();
}
