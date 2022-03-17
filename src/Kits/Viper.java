package Kits;

import Essencial.KitAPI;
import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Viper implements Listener {

	@EventHandler
	public void onSnail(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getEntity();
		final Player d = (Player) e.getDamager();
		if (!KitAPI.Viper.contains(d.getName())) {
			return;
		}
		if (Math.random() > 0.4 && Math.random() > 0.1) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 80, 0));
			d.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §6➼ §7Você Infectou o Player §e " + p.getDisplayName());
		}
	}
}
