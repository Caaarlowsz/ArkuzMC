package Eventos;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.Packet;
import net.minecraft.server.v1_7_R4.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.spigotmc.ProtocolInjector;

public class TabPersonalizado implements Listener {
	private static int VERSION;

	static {
		TabPersonalizado.VERSION = 47;
	}

	@EventHandler
	void TabDoServidor(final PlayerJoinEvent e) {
		final Player jogador = e.getPlayer();
		Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) ArkuzPvP.getInstance(), (Runnable) new Runnable() {
			@Override
			public void run() {
				final PlayerConnection connect = ((CraftPlayer) jogador).getHandle().playerConnection;
				final IChatBaseComponent top = ChatSerializer
						.a("{'extra': [{text: '', color: 'aqua'}],'color': gold, 'text': '     §4------={" + ArkuzPvP.prefix
								+ "§c}=------\n       '}");
				final IChatBaseComponent bottom = ChatSerializer.a(
						"{'extra': [{'color': 'aqua', 'text': '  \n§4\u27bc  §7Twiter §cEm Breve \n§4\u27bc §7Site §c"
								+ ArkuzPvP.loja
								+ "\n§4\u27bc §7TS §cEm Breve', 'underline': 'true'}], 'color': 'gold', 'text': ''}");
				if (((CraftPlayer) jogador).getHandle().playerConnection.networkManager
						.getVersion() < TabPersonalizado.VERSION) {
					return;
				}
				connect.sendPacket((Packet) new ProtocolInjector.PacketTabHeader(top, bottom));
			}
		}, 1L, 20L);
	}
}
