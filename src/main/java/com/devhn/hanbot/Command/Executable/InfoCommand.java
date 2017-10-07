package com.devhn.hanbot.Command.Executable;

import com.devhn.hanbot.Command.Command;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class InfoCommand implements Command {

    @Override
    public String label() { return "h!info"; }

    @Override
    public void execute(MessageReceivedEvent mre, String[] args) {
        Message message = mre.getMessage();
        User user = mre.getAuthor();
        TextChannel channel = mre.getTextChannel();

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("server")) {
                System.out.printf("[%s] %s 님이 %s %s 명령어를 실행하였습니다.", message.getCreationTime().toString(), user.getName(), label(), args[0]);
                channel.sendMessage("```[ " + mre.getTextChannel().getName() + " ]\n- 생성된 시간: **"
                                    + mre.getTextChannel().getCreationTime() + "**\n");
            }
        }
    }
}
