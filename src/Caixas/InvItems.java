package Caixas;

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

public class InvItems implements Listener, CommandExecutor
{
    public static void guiKits(final Player p) {
        final Inventory lojadeoutros = Bukkit.getServer().createInventory((InventoryHolder)p, 27, "§8{ §cItems §8}");
        final ItemStack event4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
        final ItemMeta event4v = event4.getItemMeta();
        event4v.setDisplayName("§7-");
        event4.setItemMeta(event4v);
        lojadeoutros.setItem(2, event4);
        lojadeoutros.setItem(3, event4);
        lojadeoutros.setItem(4, event4);
        lojadeoutros.setItem(5, event4);
        lojadeoutros.setItem(6, event4);
        lojadeoutros.setItem(10, event4);
        lojadeoutros.setItem(12, event4);
        lojadeoutros.setItem(14, event4);
        lojadeoutros.setItem(16, event4);
        lojadeoutros.setItem(20, event4);
        lojadeoutros.setItem(21, event4);
        lojadeoutros.setItem(22, event4);
        lojadeoutros.setItem(23, event4);
        lojadeoutros.setItem(24, event4);
        final ItemStack event5 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        final ItemMeta event45v = event5.getItemMeta();
        event45v.setDisplayName("§7+");
        event5.setItemMeta(event4v);
        lojadeoutros.setItem(26, event5);
        lojadeoutros.setItem(18, event5);
        final ItemStack event6 = new ItemStack(Material.INK_SACK, 1, (short)8);
        final ItemMeta event451v = event6.getItemMeta();
        event451v.setDisplayName("§7{ §cAnterior §7}");
        event6.setItemMeta(event451v);
        lojadeoutros.setItem(0, event6);
        final ItemStack event7 = new ItemStack(Material.INK_SACK, 1, (short)10);
        final ItemMeta event456v = event7.getItemMeta();
        event456v.setDisplayName("§7{ §aProximo §7}");
        event7.setItemMeta(event456v);
        lojadeoutros.setItem(8, event7);
        final ItemStack loja23 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
        final ItemMeta loja23v = loja23.getItemMeta();
        loja23v.setDisplayName("§7=");
        loja23.setItemMeta(loja23v);
        lojadeoutros.setItem(1, loja23);
        lojadeoutros.setItem(7, loja23);
        lojadeoutros.setItem(17, loja23);
        lojadeoutros.setItem(9, loja23);
        lojadeoutros.setItem(19, loja23);
        lojadeoutros.setItem(25, loja23);
        final ItemStack event8 = new ItemStack(Material.CHEST, 1, (short)0);
        final ItemMeta event4562v = event7.getItemMeta();
        event4562v.setDisplayName("§7{ §aKits (Leve) §7}");
        event8.setItemMeta(event4562v);
        lojadeoutros.setItem(11, event8);
        final ItemStack event9 = new ItemStack(Material.ENDER_CHEST, 1, (short)0);
        final ItemMeta event4561v = event7.getItemMeta();
        event4561v.setDisplayName("§7{ §cKits (Pesada) §7}");
        event9.setItemMeta(event4561v);
        lojadeoutros.setItem(13, event9);
        final ItemStack event10 = new ItemStack(Material.GOLDEN_APPLE, 1, (short)0);
        final ItemMeta event4564v = event10.getItemMeta();
        event4564v.setDisplayName("§7{ §eCoins §7}");
        event10.setItemMeta(event4564v);
        lojadeoutros.setItem(15, event10);
        ItemStack[] arrayOfItemStack;
        for (int descpyro1 = (arrayOfItemStack = lojadeoutros.getContents()).length, metapyro1 = 0; metapyro1 < descpyro1; ++metapyro1) {
            final ItemStack item = arrayOfItemStack[metapyro1];
            if (item == null) {
                lojadeoutros.setItem(lojadeoutros.firstEmpty(), event4);
            }
        }
        p.openInventory(lojadeoutros);
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
        if (e.getInventory().getTitle().equalsIgnoreCase("§8{ §cItems §8}") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            if (e.getSlot() == 11) {
                e.setCancelled(true);
                p.closeInventory();
                InvLeve.guiKits(p);
                p.playSound(p.getLocation(), Sound.DOOR_OPEN, 5.0f, 5.0f);
                return;
            }
            if (e.getSlot() == 13) {
                e.setCancelled(true);
                p.closeInventory();
                InvPesada.guiKits(p);
                p.playSound(p.getLocation(), Sound.DOOR_OPEN, 5.0f, 5.0f);
                return;
            }
            if (e.getSlot() == 15) {
                e.setCancelled(true);
                p.closeInventory();
                InvCoins.guiKits(p);
                p.playSound(p.getLocation(), Sound.DOOR_OPEN, 5.0f, 5.0f);
            }
        }
    }
    
    public static void ir(final Player p, final String string) {
    }
}
