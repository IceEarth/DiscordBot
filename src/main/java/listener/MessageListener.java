package listener;

import manager.CommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Arrays;

public class MessageListener extends ListenerAdapter {


    private final JDA jda;
    private final CommandManager commandManager;

    public MessageListener(JDA jda, CommandManager commandManager) {
        this.jda = jda;
        this.commandManager = commandManager;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getAuthor() == jda.getSelfUser()) return;
        final String PREFIX = "!";
        TextChannel channel;
        String message = event.getMessage().getContentRaw();
        String usedPrefix = message.split("|")[0];
        message = message.substring(1);
        String[] args;
        String label;
        if(message.contains(" ")) {

            args = message.split(" ");

            label = args[0];

            args = Arrays.copyOfRange(args, 1, args.length);
        }else {
            args = null;
            label = message;
        }


        if(event.isFromType(ChannelType.TEXT)){

            channel = event.getTextChannel();
            if(usedPrefix.equals(PREFIX)) {
                commandManager.executeCommand(label, args, event.getMember(), channel, event.getMessage());
                /*switch (label) {
                    case "help" -> new Help().execute(args, event.getMember(), channel, event.getMessage());

                    case "time" -> new Time().execute(args, event.getMember(), channel, event.getMessage());

                    case "clear" -> new ClearCommand().execute(args, event.getMember(), channel, event.getMessage());
                }*/
            }
        }


    }
}
