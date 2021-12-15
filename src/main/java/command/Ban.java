package command;

import command.util.Command;
import manager.CommandManager;
import manager.embed.BanEmbed;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.exceptions.HierarchyException;
import net.dv8tion.jda.api.exceptions.PermissionException;
import net.dv8tion.jda.api.requests.RestAction;
import org.apache.commons.lang3.time.DurationFormatUtils;
import util.Discord;
import util.Math;

import java.awt.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Ban implements Command {
    private Throwable error;
    private RestAction<Member> member;
    private String reason;
    private Duration duration;
    private BanEmbed embed;
    private int durationInt;
    private String durationTime;
    private String[] durationString;

    @Override
    public void execute(String[] args, Member member, TextChannel channel, Message message, Consumer<Throwable> exception){
        {
                message.getGuild().retrieveMemberById(Discord.getMembersId(args[0])).queue(target -> {
                    if((error = isExecutable(member, target)) != null){
                        exception.accept(error);
                        return;
                    }


                    durationString = args.length > 1 ? Math.splitToIntString(args[1]) : null;


                    reason = args.length > 2 ? String.join(" ", Arrays.stream(args).toList().subList(2, args.length)) : null;
                    System.out.println("REASON: " + reason);


                    if (durationString != null) {
                        durationInt = Integer.parseInt(durationString[0]);

                        switch (durationString[1]) {
                            case "s", "seconds" -> duration = Duration.ofSeconds(durationInt);
                            case "min", "minutes" -> duration = Duration.ofMinutes(durationInt);
                            case "h", "hours" -> duration = Duration.ofHours(durationInt);
                            case "d", "days" -> duration = Duration.ofDays(durationInt);
                            case "m", "months" -> duration = Duration.ofDays(durationInt * 30L);
                        }
                    } else {
                        duration = Duration.ofSeconds(0);
                    }

                    this.embed = new BanEmbed(target, this.duration.toMillis(), reason);
                    //message.getChannel().sendMessage().queue();
                    target.ban(0).queue();




                });


        }


    }

    @Override
    public void executeSlash() {

    }

    public boolean isPermitted(Member member){
        return member.hasPermission(Permission.BAN_MEMBERS);
    }

    @Override
    public String getUsage() {
        return "/ban [Member] (duration/date) (reason)";
    }

    private Throwable isExecutable(Member member, Member target){
        if(!isPermitted(member))return new PermissionException("ban");
        if(!member.getGuild().getSelfMember().canInteract(target))return new HierarchyException("ban");
        return null;
    }



}

                    /*try {
                        memb.ban(0).queue();
                    } catch (HierarchyException ex) {
                        channel.sendMessage("This user has more rights than me... I can't ban him ;(").queue();
                    } catch (PermissionException ex) {
                        channel.sendMessage("Sorry, but I am not permitted to do that!").queue();
                    }

                    EmbedBuilder embedBuilder = new EmbedBuilder();
                    embedBuilder.setColor(Color.red);
                    embedBuilder.setDescription("Der " + memb.getAsMention() + " wurde erfolgreich gebannt! Sein Bann endet am " + Discord.formatTimeAndDuration(duration.toMillis()));*/