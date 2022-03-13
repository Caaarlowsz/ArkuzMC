package Eventos;

import java.util.List;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Bussola implements Listener {
	@EventHandler
	public void onCompass(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (Habilidade.getAbility(p) != "Nenhum" && p.getItemInHand().getType() == Material.COMPASS
				&& (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
						|| event.getAction() == Action.RIGHT_CLICK_BLOCK
						|| event.getAction() == Action.RIGHT_CLICK_AIR)) {
			Boolean pesquisado = false;
			for (int i = 0; i < 1000; ++i) {
				final List<Entity> pertos = (List<Entity>) p.getNearbyEntities((double) i, 128.0, (double) i);
				for (final Object e : pertos) {
					if (((Entity) e).getType().equals((Object) EntityType.PLAYER)
							&& p.getLocation().distance(((Entity) e).getLocation()) > 0.0) {
						p.setCompassTarget(((Entity) e).getLocation());
						p.sendMessage(
								String.valueOf(ArkuzPvP.prefix) + " �4\u27bc �7Apontado Para: �c" + ((Player) e).getName());
						pesquisado = true;
						break;
					}
				}
				if (pesquisado) {
					break;
				}
			}
			if (!pesquisado) {
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Nenhum Player Encontrado");
				p.setCompassTarget(p.getWorld().getSpawnLocation());
			}
		}
	}
}
