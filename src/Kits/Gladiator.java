package Kits;

import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.GameMode;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.EventHandler;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import Essencial.KitAPI;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import java.util.ArrayList;
import Main.Main;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import java.util.HashMap;
import org.bukkit.block.Block;
import java.util.List;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;

public class Gladiator implements Listener
{
    public Plugin plugin;
    private List<Block> gladiatorbloco;
    private HashMap<Block, Player> gladblock;
    private HashMap<Player, Player> lutando;
    private HashMap<Player, Location> lugar;
    private int glad1;
    private int glad2;
    
    public Gladiator(final Main plugin) {
        this.gladiatorbloco = new ArrayList<Block>();
        this.gladblock = new HashMap<Block, Player>();
        this.lutando = new HashMap<Player, Player>();
        this.lugar = new HashMap<Player, Location>();
        this.plugin = (Plugin)plugin;
    }
    
    @EventHandler
    void KitGladiator(final PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Player) {
            final Player p = e.getPlayer();
            final Player r = (Player)e.getRightClicked();
            if (p.getItemInHand().getType() == Material.IRON_FENCE && KitAPI.Gladiator.contains(p.getName())) {
                final Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() + 80.0, p.getLocation().getZ());
                final Location loc2 = new Location(p.getWorld(), (double)(p.getLocation().getBlockX() + 8), (double)(p.getLocation().getBlockY() + 82), (double)(p.getLocation().getBlockZ() + 8));
                final Location loc3 = new Location(p.getWorld(), (double)(p.getLocation().getBlockX() - 8), (double)(p.getLocation().getBlockY() + 82), (double)(p.getLocation().getBlockZ() - 8));
                if (this.lutando.containsKey(p) || this.lutando.containsKey(r)) {
                    p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Ja Est\u00e1 Em Um Gladiator");
                    return;
                }
                final List<Location> cuboid = new ArrayList<Location>();
                for (int bX = -10; bX <= 10; ++bX) {
                    for (int bZ = -10; bZ <= 10; ++bZ) {
                        for (int bY = -1; bY <= 10; ++bY) {
                            final Block b = loc.clone().add((double)bX, (double)bY, (double)bZ).getBlock();
                            if (!b.isEmpty()) {
                                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Pode Usar o seu Kit Aqui");
                                return;
                            }
                            if (bY == 10) {
                                cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                            }
                            else if (bY == -1) {
                                cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                            }
                            else if (bX == -10 || bZ == -10 || bX == 10 || bZ == 10) {
                                cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                            }
                        }
                    }
                }
                for (final Location loc4 : cuboid) {
                    loc4.getBlock().setType(Material.GLASS);
                    this.gladiatorbloco.add(loc4.getBlock());
                    this.gladblock.put(loc4.getBlock(), p);
                    this.gladblock.put(loc4.getBlock(), r);
                }
                this.lugar.put(p, p.getLocation());
                this.lugar.put(r, r.getLocation());
                p.teleport(loc2);
                r.teleport(loc3);
                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
                r.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
                this.lutando.put(p, r);
                this.lutando.put(r, p);
                this.glad1 = Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                    }
                }, 4800L);
                this.glad2 = Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Gladiator.this.lutando.containsKey(p) && Gladiator.this.lutando.containsKey(r)) {
                            Gladiator.this.lutando.remove(p);
                            Gladiator.this.lutando.remove(r);
                            p.teleport((Location)Gladiator.this.lugar.get(p));
                            r.teleport((Location)Gladiator.this.lugar.get(r));
                            for (final Block glad : Gladiator.this.gladiatorbloco) {
                                if ((Gladiator.this.gladblock.get(glad) == r || Gladiator.this.gladblock.get(glad) == p) && glad.getType() == Material.GLASS) {
                                    glad.setType(Material.AIR);
                                }
                            }
                            Gladiator.this.lugar.remove(p);
                            Gladiator.this.lugar.remove(r);
                            Gladiator.this.gladblock.remove(p);
                            Gladiator.this.gladblock.remove(r);
                        }
                    }
                }, 6000L);
            }
        }
    }
    
    @EventHandler
    void KitGladiatorInteragir(final BlockBreakEvent e) {
        final Player p = e.getPlayer();
        if (this.gladiatorbloco.contains(p) && p.getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    void KitGladiatorSair(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        if (this.lutando.containsKey(p)) {
            final String nome = this.lutando.get(p).getName();
            final Player q = Bukkit.getPlayer(nome);
            this.lutando.remove(p);
            this.lutando.remove(q);
            q.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7O Player §c" + p.getDisplayName() + " §7Deslogou No Gladiator");
            q.teleport((Location)this.lugar.get(q));
            Bukkit.getScheduler().cancelTask(this.glad1);
            Bukkit.getScheduler().cancelTask(this.glad2);
            for (final Block glad : this.gladiatorbloco) {
                if ((this.gladblock.get(glad) == q || this.gladblock.get(glad) == p) && glad.getType() == Material.GLASS) {
                    glad.setType(Material.AIR);
                }
            }
            this.gladblock.remove(p);
            this.gladblock.remove(q);
        }
    }
    
    @EventHandler
    void KitGladiatorMorrer(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        if (this.lutando.containsKey(p)) {
            final String nome = this.lutando.get(p).getName();
            final Player m = Bukkit.getPlayer(nome);
            m.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Ganhou o Gladiator");
            p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Perdeu o Gladiator");
            this.lutando.remove(p);
            this.lutando.remove(m);
            m.teleport((Location)this.lugar.get(m));
            m.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
            Bukkit.getScheduler().cancelTask(this.glad1);
            Bukkit.getScheduler().cancelTask(this.glad2);
            for (final Block glad : this.gladiatorbloco) {
                if ((this.gladblock.get(glad) == m || this.gladblock.get(glad) == p) && glad.getType() == Material.GLASS) {
                    glad.setType(Material.AIR);
                }
            }
            this.gladblock.remove(p);
            this.gladblock.remove(m);
        }
    }
    
    @EventHandler
    void KitGladiatorComando(final PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        if (this.lutando.containsKey(p)) {
            e.setCancelled(true);
            p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7N\u00e3o se Pode Usar Comandos No Gladiator");
        }
    }
}
