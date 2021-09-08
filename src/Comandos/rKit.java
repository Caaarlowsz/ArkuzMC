package Comandos;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import Kits.C4;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.GameMode;
import Essencial.KitAPI;
import Essencial.Cooldown;
import Eventos.Habilidade;
import org.bukkit.Sound;
import Main.Main;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import java.util.ArrayList;
import org.bukkit.command.CommandExecutor;

public class rKit implements CommandExecutor
{
    public static ArrayList<String> jaresetou;
    
    static {
        rKit.jaresetou = new ArrayList<String>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("rkit")) {
            if (p.hasPermission("arkuz.rkit")) {
                if (rKit.jaresetou.contains(p.getName())) {
                    p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Aguarde Para Resetar Seu Kit Novamente");
                    return true;
                }
                rKit.jaresetou.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Kit Resetado Com Sucesso");
                p.teleport(p.getWorld().getSpawnLocation());
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 10.0f, 0.0f);
                p.getInventory().clear();
                Habilidade.removeAbility(p);
                Cooldown.remove(p);
                KitAPI.remove(p);
                p.setHealth(20.0);
                p.setFireTicks(0);
                p.setFoodLevel(20);
                p.setAllowFlight(false);
                p.setFlying(false);
                p.setGameMode(GameMode.SURVIVAL);
                p.getInventory().setHelmet((ItemStack)null);
                p.getInventory().setChestplate((ItemStack)null);
                p.getInventory().setLeggings((ItemStack)null);
                p.getInventory().setBoots((ItemStack)null);
                setitem(p, Material.PAPER, "§4\u27bc §cWarps", 1, Enchantment.DAMAGE_ALL, 0, false);
                setitem(p, Material.BOOK, "§4\u27bc §cLoja", 2, Enchantment.DAMAGE_ALL, 0, false);
                setitem(p, Material.PISTON_STICKY_BASE, "§4\u27bc §cKits", 4, Enchantment.DAMAGE_ALL, 0, false);
                setitem(p, Material.CHEST, "§4\u27bc §cCaixas", 6, Enchantment.DAMAGE_ALL, 0, false);
                setitem(p, Material.REDSTONE, "§4\u27bc §cOutros", 7, Enchantment.DAMAGE_ALL, 0, false);
                if (C4.bomba.containsKey(p.getName())) {
                    final Item item = C4.bomba.get(p.getName());
                    item.remove();
                }
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        rKit.jaresetou.remove(p.getName());
                        p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea J\u00e1 Pode Resetar Seu Kit");
                    }
                }, 100L);
                return true;
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Sem Permiss\u00e3o");
            }
        }
        return false;
    }
    
    public static void setitem(final Player p, final Material mat, final String nome, final int lugar, final Enchantment enchant, final int level, final boolean trueorfalse) {
        final ItemStack item = new ItemStack(mat);
        final ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(nome);
        itemmeta.addEnchant(enchant, level, trueorfalse);
        item.setItemMeta(itemmeta);
        p.getInventory().setItem(lugar, item);
    }
}
