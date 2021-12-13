package command.util;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.exceptions.HierarchyException;

public interface Command {



    void execute(String[] args, Member member, TextChannel channel, Message message) throws Exception;

    void executeSlash();

    default public boolean isPermitted(Member member){
        return true;
    }

    default String invalidArguments(){
        return "Sorry! The usage is wrong! Do it that way:\n" + getUsage();
    }
    default String hierarchy(){
        return "The member you want to interact with is in the hierarchy higher than me. Sorry!";
    }

    String getUsage();
}
