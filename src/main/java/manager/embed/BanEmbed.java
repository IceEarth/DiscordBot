package manager.embed;

import command.Ban;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import util.Discord;

import javax.annotation.Nullable;

public class BanEmbed {
    private final EmbedBuilder embedBuilder = new EmbedBuilder();

    public BanEmbed(Member member, long duration, String reason){
        embedBuilder.setDescription("You have banned " + member.getAsMention() + (reason == null ? "." : " for the reason *" + reason + "*.") +
                "\n\n" + (duration > 0 ? "The ban ends at the " : "Them is banned ") + Discord.formatTimeAndDuration(duration) + ".");
        embedBuilder.setThumbnail(member.getUser().getAvatarUrl());
    }

    public MessageEmbed getEmbed(){
        return embedBuilder.build();
    }
}
