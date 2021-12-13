package exception;

import command.util.Command;

public class HierarchyException extends net.dv8tion.jda.api.exceptions.HierarchyException{
    public HierarchyException(Command command){
        super(command.hierarchy());
    }

}
