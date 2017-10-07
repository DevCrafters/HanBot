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

        if (args.length == 1 && !user.isBot()) {
            if (args[0].equalsIgnoreCase("channel")) {
                System.out.printf("\n[%s] %s 님이 %s %s 명령어를 실행하였습니다.", message.getCreationTime().toString(), user.getName(), label(), args[0]);
                channel.sendMessage("```java\n[ " + mre.getTextChannel().getName() + " ]\n\n- 생성된 시간: "
                                    + mre.getTextChannel().getCreationTime() + "\n```").queue();
            } else if (args[0].equalsIgnoreCase("bot")) {
                System.out.printf("\n[%s] %s 님이 %s %s 명령어를 실행하였습니다.", message.getCreationTime().toString(), user.getName(), label(), args[0]);
                channel.sendMessage("구현중임 ㅅㄱ - info / bot").queue();
            } else {
                channel.sendMessage("```java\n[ h!info 를 통해 제대로 된 명령어를 입력하십시오. - args 가 이상함 / 1개 ]```").queue();
            }
        } else if (args.length > 1 && !user.isBot()) {
            channel.sendMessage("```java\n[ h!info 를 통해 제대로 된 명령어를 입력하십시오. - args 너무 많음 ]```").queue();
        } else if (args.length == 0 && !user.isBot()) {
            System.out.printf("\n[%s] %s 님이 %s 명령어를 실행하였습니다.", message.getCreationTime().toString(), user.getName(), label());
            channel.sendMessage("```h!info / server, bot```").queue();
        }
    }
}
