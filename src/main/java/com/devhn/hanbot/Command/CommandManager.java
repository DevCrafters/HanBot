package com.devhn.hanbot.Command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final Map<String, Command> commandMap = new HashMap<>();

    public void registerCommand(Command command) {
        commandMap.put(command.label(), command);
    }

    public void execute(MessageReceivedEvent mre) {
        String commandLine = mre.getMessage().getContent();
        String label = commandLine;
        String args = "";
        int point = commandLine.indexOf(' ');
        if (point >= 0) {
            label = commandLine.substring(0, point);
            args = commandLine.substring(point + 1, commandLine.length());
        }

        Command command = commandMap.get(label);
        if (command != null)
            command.execute(mre, args.split(" "));
    }
}
