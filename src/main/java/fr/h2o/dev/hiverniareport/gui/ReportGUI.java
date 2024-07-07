package fr.h2o.dev.hiverniareport.gui;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ReportGUI implements Listener {

    private final Main plugin;

    public ReportGUI(Main plugin) {
        this.plugin = plugin;
    }

    public static Inventory createReportMenu() {
        Inventory inventory = Bukkit.createInventory(null, 27, ChatColor.RED + "Report Menu");

        ItemStack hacking = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta hackingMeta = hacking.getItemMeta();
        hackingMeta.setDisplayName(ChatColor.RED + "Hacking");
        hacking.setItemMeta(hackingMeta);

        ItemStack abuse = new ItemStack(Material.BARRIER);
        ItemMeta abuseMeta = abuse.getItemMeta();
        abuseMeta.setDisplayName(ChatColor.RED + "Abuse");
        abuse.setItemMeta(abuseMeta);

        ItemStack other = new ItemStack(Material.BOOK);
        ItemMeta otherMeta = other.getItemMeta();
        otherMeta.setDisplayName(ChatColor.RED + "Other");
        other.setItemMeta(otherMeta);

        inventory.setItem(11, hacking);
        inventory.setItem(13, abuse);
        inventory.setItem(15, other);

        return inventory;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getTitle().equals(ChatColor.RED + "Report Menu")) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            if (event.getCurrentItem() == null) return;

            switch (event.getCurrentItem().getType()) {
                case DIAMOND_SWORD:
                    player.sendMessage(ChatColor.RED + "Vous avez signalé un cheater !");
                    break;
                case BARRIER:
                    player.sendMessage(ChatColor.RED + "Vous avez signalé un abus !");
                    break;
                case BOOK:
                    player.sendMessage(ChatColor.RED + "Vous avez signalé un autre problème !");
                    break;
                default:
                    break;
            }

            player.closeInventory();
        }
    }
}

