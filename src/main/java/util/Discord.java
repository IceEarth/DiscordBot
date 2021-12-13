package util;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;

public class Discord {
    public static Member getMemberByID(Guild guild, Long id){
        Member gottenMember = guild.getMemberById(id);
        //Member retrievedMember = guild.retrieveMemberById(id).complete();
        return  gottenMember == null ? guild.retrieveMemberById(id).complete() : gottenMember;
    }
    public static String getAsMentioned(Long id){
        return "<@!" + id + ">";
    }
    public static Long getMembersId(String id){
        return Long.valueOf(id.replace("<@!" , "").replace(">", ""));
    }
    public static String formatTime(long timeInMillis){
        long duration = (System.currentTimeMillis() + timeInMillis) / 1000;
        return "<t:" + duration + ">";
    }
    public static String formatDuration(long timeInMillis){
        long duration = (System.currentTimeMillis() + timeInMillis) / 1000;
        return "<t:" + duration + ":R>";
    }
    public static String formatTimeAndDuration(long millis){
        if(millis > 0){
            return formatTime(millis) + " (" + formatDuration(millis) + ")";
        }else {
            return "**forever**";
        }

    }
}
