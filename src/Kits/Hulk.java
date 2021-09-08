package Kits;

import org.bukkit.event.EventHandler;
import org.bukkit.entity.Entity;
import Main.Main;
import org.bukkit.Material;
import Essencial.KitUtil;
import Essencial.Cooldown;
import Eventos.Habilidade;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.Listener;

public class Hulk implements Listener
{
    @EventHandler
    public void PickUpPlayer(final PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player)) {
            return;
        }
        if (e.getRightClicked() instanceof Player) {
            final Player p = e.getPlayer();
            if (Habilidade.getAbility(p).equalsIgnoreCase("Hulk")) {
                final Player r = (Player)e.getRightClicked();
                if (Cooldown.add(p)) {
                    KitUtil.MensagemCooldown(p);
                    return;
                }
                if (p.getItemInHand().getType() != Material.SADDLE) {
                    return;
                }
                if (p.getPassenger() != null) {
                    p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Aguarde o Player Sair Da Cabe\u00e7a Do Adversario");
                    return;
                }
                if (r.getPassenger() != null) {
                    return;
                }
                Cooldown.add(p, 6);
                p.setPassenger((Entity)r);
                r.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Um Hulk Prendeu Voc\u00ea Aperde SHIFT Para Se Desprender");
            }
        }
    }
}
