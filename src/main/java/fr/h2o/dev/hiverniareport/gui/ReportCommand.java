package fr.h2o.dev.hiverniareport.gui;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReportCommand implements CommandExecutor {

    private final Main plugin;

    public ReportCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Seuls les joueurs peuvent utiliser cette commande !");
            return true;
        }

        Player player = (Player) sender;
        player.openInventory(GUI.createReportMenu());
        return true;
    }

    public Main getPlugin() {
        return plugin;
    }
}

