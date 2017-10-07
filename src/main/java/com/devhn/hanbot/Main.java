package com.devhn.hanbot;

import com.devhn.hanbot.Command.CommandManager;
import com.devhn.hanbot.Command.Executable.InfoCommand;
import com.devhn.hanbot.Command.Executable.PingCommand;
import com.devhn.hanbot.Listener.MessageListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

/**
 * Created by DevHN, EntryPoint on 06/07/2017.
 */

public class Main {
    private static final CommandManager manager = new CommandManager();

    static {
        manager.registerCommand(new PingCommand());
        manager.registerCommand(new InfoCommand());
    }

    public static void main(String[] args) throws Exception {
        JDA api = new JDABuilder(AccountType.BOT)
                .setToken("MzE5MDM1MDM2MjE5MjExNzc3.DLkLwQ.R74mLmBzPuFBXTxlg5cY7oexZ1I")
                .buildAsync();

        api.addEventListener(new MessageListener(manager));
    }
}
