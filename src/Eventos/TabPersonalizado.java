package Eventos;

import org.bukkit.event.EventHandler;
import org.bukkit.plugin.Plugin;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PlayerConnection;
import net.minecraft.server.v1_7_R4.Packet;
import org.spigotmc.ProtocolInjector;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.event.player.PlayerJoinEvent;
import Main.Main;
import org.bukkit.event.Listener;

public class TabPersonalizado implements Listener
{
    private static int VERSION;
    
    static {
        TabPersonalizado.VERSION = 47;
    }
    
    public TabPersonalizado(final Main main) {
    }
    
    @EventHandler
    void TabDoServidor(final PlayerJoinEvent e) {
        final Player jogador = e.getPlayer();
        final int ping = ((CraftPlayer)jogador).getHandle().playerConnection.player.ping;
        Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
            @Override
            public void run() {
                final PlayerConnection connect = ((CraftPlayer)jogador).getHandle().playerConnection;
                final IChatBaseComponent top = ChatSerializer.a("{'extra': [{text: '', color: 'aqua'}],'color': gold, 'text': '     §4------={" + Main.prefix + "§c}=------\n       '}");
                final IChatBaseComponent bottom = ChatSerializer.a("{'extra': [{'color': 'aqua', 'text': '  \n§4\u27bc  §7Twiter §cEm Breve \n§4\u27bc §7Site §c" + Main.loja + "\n§4\u27bc §7TS §cEm Breve', 'underline': 'true'}], 'color': 'gold', 'text': ''}");
                if (((CraftPlayer)jogador).getHandle().playerConnection.networkManager.getVersion() < TabPersonalizado.VERSION) {
                    return;
                }
                connect.sendPacket((Packet)new ProtocolInjector.PacketTabHeader(top, bottom));
            }
        }, 1L, 20L);
    }
}
