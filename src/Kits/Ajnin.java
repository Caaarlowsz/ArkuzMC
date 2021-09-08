package Kits;

import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import java.text.DecimalFormat;
import Essencial.KitUtil;
import Essencial.Cooldown;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.Plugin;
import Main.Main;
import org.bukkit.Bukkit;
import Eventos.Habilidade;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.Player;
import java.util.HashMap;
import org.bukkit.event.Listener;

public class Ajnin implements Listener
{
    public HashMap<Player, Player> ajinhash;
    public HashMap<Player, Long> ajincooldown;
    
    public Ajnin() {
        this.ajinhash = new HashMap<Player, Player>();
        this.ajincooldown = new HashMap<Player, Long>();
    }
    
    @EventHandler
    public void a(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            final Player p = (Player)e.getDamager();
            final Player t = (Player)e.getEntity();
            if (Habilidade.getAbility(p).equalsIgnoreCase("Ajnin")) {
                this.ajinhash.put(p, t);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                    }
                }, 200L);
            }
        }
    }
    
    @EventHandler
    public void aPlayerToggle(final PlayerToggleSneakEvent e) {
        final Player p = e.getPlayer();
        if (Cooldown.add(p)) {
            KitUtil.MensagemCooldown(p);
            return;
        }
        if (e.isSneaking() && Habilidade.getAbility(p).equalsIgnoreCase("Ajnin") && this.ajinhash.containsKey(p)) {
            final Player t = this.ajinhash.get(p);
            if (t != null && !t.isDead()) {
                String s = null;
                if (this.ajincooldown.get(p) != null) {
                    final long l = this.ajincooldown.get(p) - System.currentTimeMillis();
                    final DecimalFormat localDecimalFormat = new DecimalFormat("##");
                    final int i = (int)l / 1000;
                    s = localDecimalFormat.format(i);
                }
                if (p.getLocation().distance(t.getLocation()) < 200.0) {
                    t.teleport(p.getLocation());
                    p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7O Player Foi Teleportado At\u00e9 Voc\u00ea");
                    Cooldown.add(p, 3);
                    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Seu Cooldown Acabou");
                        }
                    }, 140L);
                }
                else {
                    p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7O Ultimo Player Hitado Est\u00e1 Loge Demais");
                }
            }
        }
    }
    
    @EventHandler
    public void aomorrer(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        final Player t = this.ajinhash.get(p);
        this.ajinhash.remove(t);
        this.ajinhash.remove(p);
    }
    
    @EventHandler
    public void aosair(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        final Player t = this.ajinhash.get(p);
        this.ajinhash.remove(t);
        this.ajinhash.remove(p);
    }
}
