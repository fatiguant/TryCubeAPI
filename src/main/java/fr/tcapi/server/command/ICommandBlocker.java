package fr.tcapi.server.command;

import java.util.List;

public interface ICommandBlocker {

    void addBlockedCommands(String prefix, String... commands);

    void removeCommands(String prefix, String... commands);

    List<String> getBlockedCommands();

}