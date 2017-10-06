package com.devhn.hanbot.Listener;

import com.devhn.hanbot.Command.CommandManager;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {
    private final CommandManager manager;

    public MessageListener(CommandManager manager) {
        this.manager = manager;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent mre) {
        manager.execute(mre);
    }
}
