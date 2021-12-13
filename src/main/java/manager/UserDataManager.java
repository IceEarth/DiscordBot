package manager;

import entity.UserData;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;

import java.util.HashMap;

public class UserDataManager {
    private final HashMap<Long, UserData> userData = new HashMap<>();
    public UserDataManager(){
        //todo get all data from database...
    }
    public UserData getData(Member member){
        return userData.get(member.getIdLong());
    }
    public UserData getData(User user){
        return userData.get(user.getIdLong());

    }
    public UserData getData(Long id){
        return userData.get(id);
    }

}
