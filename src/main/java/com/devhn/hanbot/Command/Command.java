package com.devhn.hanbot.Command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by DevHN, EntryPoint on 06/07/2017.
 */

public interface Command {
    String label();

    void execute(MessageReceivedEvent mre, String[] args);
}