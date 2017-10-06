package com.devhn.hanbot.Event;

import net.dv8tion.jda.client.events.group.GroupUserJoinEvent;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

/**
 * Created by DevHN on 09/07/2017.
 */

public class JoinEvent {
    public void onJoinEvent(GroupUserJoinEvent event, MessageChannel channel) {
        User user = event.getUser();
        boolean bot = user.isBot();
        if (!bot) {
            channel.sendMessage(user + " 님이 접속하셨습니다.");
        } else {
            channel.sendMessage("봇 " + user + " 님이 접속하셨습니다.");
        }
    }
}
