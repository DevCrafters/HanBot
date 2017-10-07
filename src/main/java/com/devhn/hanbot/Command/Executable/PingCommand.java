package com.devhn.hanbot.Command.Executable;

import com.devhn.hanbot.Command.Command;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PingCommand implements Command {
    @Override
    public String label() { return "h!ping"; }

    @Override
    public void execute(MessageReceivedEvent mre, String[] args) {
        Message message = mre.getMessage();
        User user = mre.getAuthor();
        TextChannel channel = mre.getTextChannel();

        System.out.printf("\n[%s] %s 님이 %s 명령어를 실행하였습니다.", message.getCreationTime().toString(), user.getName(), label());
        channel.sendMessage("pong!").queue();
    }
}
