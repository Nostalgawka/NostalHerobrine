package pl.vjasieg.nostalherobrine;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Debug implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if(cmd.getName().equalsIgnoreCase("herobrine")) {
            if(sender.isOp()) {
                if (args.length == 1) {
                    try {
                        HerobrineEntity.spawnHerobrine(args[0]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }
}
