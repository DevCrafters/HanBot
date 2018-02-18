package com.devhn.hanbot.Command.Executable;

import com.devhn.hanbot.Command.Command;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelpCommand implements Command {

    @Override
    public String label() { return "h!help"; }

    @Override
    public void execute(MessageReceivedEvent mre, String[] args) {
        Message message = mre.getMessage();
        User user = mre.getAuthor();
        TextChannel channel = mre.getTextChannel();

        if (!user.isBot()) {
            channel.sendMessage("```java\n[ HanBot - help ]\n-" + user.getName() + "님의 개인 메시지로 명령어 모음이 전달되었습니다.```");
        }

        System.out.printf("\n[%s] %s 님이 %s 명령어를 실행하였습니다.", message.getCreationTime().toString(), user.getName(), label());
    }
}
