package fr.h2o.dev.hiverniareport;

import fr.h2o.dev.hiverniareport.command.ReportCommand;
import fr.h2o.dev.hiverniareport.gui.GUI;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("report").setExecutor(new ReportCommand(this));
        getServer().getPluginManager().registerEvents(new GUI(this), this);
        getLogger().info("ReportPlugin activé !");
    }

    @Override
    public void onDisable() {
        getLogger().info("ReportPlugin désactivé !");
    }
}

