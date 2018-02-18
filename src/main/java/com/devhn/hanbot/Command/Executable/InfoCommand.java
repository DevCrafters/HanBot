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
            if (!user.isBot()) {
                if (args[0].equalsIgnoreCase("channel")) {
                    System.out.printf("\n[%s] %s 님이 %s %s 명령어를 실행하였습니다.", message.getCreationTime().toString(), user.getName(), label(), args[0]);
                    channel.sendMessage("```java\n[ " + mre.getTextChannel().getName() + " ]\n\n- 생성된 시간: "
                            + mre.getTextChannel().getCreationTime() + "\n```").queue();
                } else if (args[0].equalsIgnoreCase("bot")) {
                    System.out.printf("\n[%s] %s 님이 %s %s 명령어를 실행하였습니다.", message.getCreationTime().toString(), user.getName(), label(), args[0]);
                    channel.sendMessage("```java\n[ HanBot - info ]\n- 봇 이름: Hanbot```").queue();
                } else if (args[0].equalsIgnoreCase("")){
                    channel.sendMessage("```java\n[ h!info 를 통해 제대로 된 명령어를 입력하십시오. - 기본 ]```").queue();
                } else {
                    channel.sendMessage("```java\n[ h!info 를 통해 제대로 된 명령어를 입력하십시오. - args 가 이상함 ]```").queue();
                }
            } else {
                System.out.printf("\n[%s] %s 봇이 %s 명령어를 실행하려고 시도하였습니다.", message.getCreationTime().toString(), user.getName(), label());
                channel.sendMessage("```java\n[ 봇은 명령어를 사용할 수 없습니다. ]```").queue();
            }
        } else if (args.length > 1 && !user.isBot()) {
            channel.sendMessage("```java\n[ h!info 를 통해 제대로 된 명령어를 입력하십시오. - args 너무 많음 ]```").queue();
        } else if (args.length == 0 && !user.isBot()) {
            System.out.printf("\n[%s] %s 님이 %s 명령어를 실행하였습니다.", message.getCreationTime().toString(), user.getName(), label());
            channel.sendMessage("```java\n[ Hanbot - info ]\n- 가능한 arg 목록: server, bot```").queue();
        }
    }
}
