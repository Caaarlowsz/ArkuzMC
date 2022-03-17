package Kits;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import Essencial.Cooldown;
import Essencial.KitUtil;
import Eventos.Habilidade;

public class Hulk implements Listener {
	@EventHandler
	public void PickUpPlayer(final PlayerInteractEntityEvent e) {
		if (!(e.getRightClicked() instanceof Player)) {
			return;
		}
		if (e.getRightClicked() instanceof Player) {
			final Player p = e.getPlayer();
			if (Habilidade.getAbility(p).equalsIgnoreCase("Hulk")) {
				final Player r = (Player) e.getRightClicked();
				if (Cooldown.add(p)) {
					KitUtil.MensagemCooldown(p);
					return;
				}
				if (p.getItemInHand().getType() != Material.SADDLE) {
					return;
				}
				if (p.getPassenger() != null) {
					p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
							+ " §4➼ §7Aguarde o Player Sair Da Cabeça Do Adversario");
					return;
				}
				if (r.getPassenger() != null) {
					return;
				}
				Cooldown.add(p, 6);
				p.setPassenger((Entity) r);
				r.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
						+ " §4➼ §7Um Hulk Prendeu Você Aperde SHIFT Para Se Desprender");
			}
		}
	}
}
