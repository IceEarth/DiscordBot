package manager
        ;

import command.util.Command;
import command.Ban;
import command.Help;
import command.util.CommandData;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.exceptions.HierarchyException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class CommandManager {
    private final Map<CommandData, Command> commands;

    public CommandManager(JDA jda){
        this.commands = new ConcurrentHashMap<>();
        registerCommand(new Help(), new CommandData("help"));
        registerCommand(new Ban(), new CommandData("ban"));
    }
    public void registerCommand(Command command, CommandData description){
        commands.putIfAbsent(description, command);
    }

    public boolean canExecuteCommand(String command, String[] args, Member member, TextChannel channel, Message message){
        for(Map.Entry<CommandData, Command> entry : commands.entrySet()){
            String[] possibleStrings = new String[]{entry.getKey().command() + entry.getKey().aliases()};
            for(String s : possibleStrings){
                if(s.equalsIgnoreCase(command)) {
                    //entry.getValue().execute(args, member, channel, message);
                    return true;
                }
            }
        }
        return false;
    }
    public void executeCommand(String command, String[] args, Member member, TextChannel channel, Message message){
        for(Map.Entry<CommandData, Command> entry : commands.entrySet()){
            List<String> possibleStrings = new ArrayList<>();
            possibleStrings.add(entry.getKey().command());
            Collections.addAll(possibleStrings, entry.getKey().aliases());
            for(String s : possibleStrings){
                if(s.equalsIgnoreCase(command)) {
                    entry.getValue().execute(args, member, channel, message, throwable -> {
                        if (throwable instanceof HierarchyException) {
                            channel.sendMessage("HIERACHRY...").queue();
                        } else {
                            channel.sendMessage("nix ;(...").queue();
                        }
                        System.out.println("Hallo?");
                    });

                    return;
                }
            }
        }
    }


}
/*try {

        }catch (HierarchyException ex){
        System.out.println("hierarchy...");
        channel.sendMessage(ex.getMessage()).queue();
        } catch (Exception e) {
        System.out.println("Exception: " + e.getMessage());
        }*/