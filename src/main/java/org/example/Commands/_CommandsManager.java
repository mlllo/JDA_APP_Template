package org.example.Commands;

import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class _CommandsManager extends ListenerAdapter {

    @Override
    public void onReady(@NotNull ReadyEvent event) {

        ArrayList<CommandData> commandData = new ArrayList<>();

        //Command: /test
        commandData.add(Commands.slash("test", "test"));

        event.getJDA().updateCommands().addCommands(commandData).queue();

    }
}
