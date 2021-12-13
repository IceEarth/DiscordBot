package exception;

import command.util.Command;

public class InvalidArgumentsException extends Exception implements  ExceptionInterface{
    private final Command command;
    public InvalidArgumentsException(Command command){
        this.command = command;
    }

    @Override
    public String getError() {
        return command.invalidArguments();
    }
}
