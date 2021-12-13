package command.util;

public record CommandData(String command, /*Boolean needOwnInstance,*/ String... aliases) {
}
