package command;

import command.util.Command;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.function.Consumer;

public class Help implements Command {

    @Override
    public void execute(String[] args, Member member, TextChannel channel, Message message, Consumer<Throwable> exception) {

    }

    @Override
    public void executeSlash() {

    }

    @Override
    public String getUsage() {
        return null;
    }
}
