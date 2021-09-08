package Invs;

import org.bukkit.event.EventHandler;
import org.bukkit.Sound;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class InvWarps2 implements Listener, CommandExecutor
{
    public static void guiKits(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 27, "§8{ §cWarps [2] §8}");
        final ItemStack event4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
        final ItemMeta event4v = event4.getItemMeta();
        event4v.setDisplayName("§7-");
        event4.setItemMeta(event4v);
        inv.setItem(2, event4);
        inv.setItem(3, event4);
        inv.setItem(4, event4);
        inv.setItem(5, event4);
        inv.setItem(6, event4);
        inv.setItem(10, event4);
        inv.setItem(16, event4);
        inv.setItem(20, event4);
        inv.setItem(21, event4);
        inv.setItem(22, event4);
        inv.setItem(23, event4);
        inv.setItem(24, event4);
        final ItemStack event5 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        final ItemMeta event45v = event5.getItemMeta();
        event45v.setDisplayName("§7+");
        event5.setItemMeta(event4v);
        inv.setItem(26, event5);
        inv.setItem(18, event5);
        inv.setItem(0, event5);
        inv.setItem(8, event5);
        final ItemStack loja23 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
        final ItemMeta loja23v = loja23.getItemMeta();
        loja23v.setDisplayName("§7=");
        loja23.setItemMeta(loja23v);
        inv.setItem(1, loja23);
        inv.setItem(7, loja23);
        inv.setItem(17, loja23);
        inv.setItem(9, loja23);
        inv.setItem(19, loja23);
        inv.setItem(25, loja23);
        final ItemStack event6 = new ItemStack(Material.POTION);
        final ItemMeta eventv1 = event6.getItemMeta();
        eventv1.setDisplayName("§cMain");
        event6.setItemMeta(eventv1);
        inv.setItem(11, event6);
        final ItemStack event7 = new ItemStack(Material.ITEM_FRAME);
        final ItemMeta eventv2 = event7.getItemMeta();
        eventv2.setDisplayName("§cTextura");
        event7.setItemMeta(eventv2);
        inv.setItem(12, event7);
        final ItemStack event8 = new ItemStack(Material.IRON_FENCE);
        final ItemMeta eventv3 = event8.getItemMeta();
        eventv3.setDisplayName("§cGladiator");
        event8.setItemMeta(eventv3);
        inv.setItem(13, event8);
        ItemStack[] arrayOfItemStack;
        for (int descpyro1 = (arrayOfItemStack = inv.getContents()).length, metapyro1 = 0; metapyro1 < descpyro1; ++metapyro1) {
            final ItemStack item = arrayOfItemStack[metapyro1];
            if (item == null) {
                inv.setItem(inv.firstEmpty(), event4);
            }
        }
        p.openInventory(inv);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("warps")) {
            final Player p = (Player)sender;
            guiKits(p);
        }
        return false;
    }
    
    @EventHandler
    public void onPlayerCLickInventry(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§8{ §cWarps [2] §8}") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            if (e.getSlot() == 12) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/warp textura");
                p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5.0f, 5.0f);
                return;
            }
            if (e.getSlot() == 11) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/warp main");
                p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5.0f, 5.0f);
                return;
            }
            if (e.getSlot() == 13) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/warp gladiator");
                p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5.0f, 5.0f);
                return;
            }
            if (e.getSlot() == 0) {
                e.setCancelled(true);
                p.closeInventory();
                InvWarps.guiKits(p);
                p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5.0f, 5.0f);
            }
        }
    }
    
    public static void ir(final Player p, final String string) {
    }
}
