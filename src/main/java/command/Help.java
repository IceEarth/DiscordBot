package command;

import command.util.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class Help implements Command {

    @Override
    public void execute(String[] args, Member member, TextChannel channel, Message message) {

    }

    @Override
    public void executeSlash() {

    }

    @Override
    public String getUsage() {
        return null;
    }
}
