package Comandos;

import org.bukkit.event.EventHandler;
import java.util.Iterator;
import java.util.List;
import Main.Main;
import java.util.ArrayList;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.Listener;

public class cPlugin implements Listener
{
    @EventHandler
    public void onCommandPreProcess(final PlayerCommandPreprocessEvent e) {
        final String[] msg = e.getMessage().split(" ");
        final List<String> plugins = new ArrayList<String>();
        plugins.add("pl");
        plugins.add("plugin");
        plugins.add("about" + msg);
        plugins.add("ver" + msg);
        plugins.add("help" + msg);
        plugins.add("ver");
        plugins.add("help");
        plugins.add("?");
        plugins.add("me");
        plugins.add("bukkit:me");
        plugins.add("/calc");
        plugins.add("bukkit:help");
        plugins.add("bukkit:pl");
        plugins.add("bukkit:plugins");
        plugins.add("about");
        plugins.add("about" + msg);
        plugins.add("bukkit:?");
        plugins.add("plugins");
        plugins.add("minecraft:me");
        for (final String Loop : plugins) {
            if (msg[0].equalsIgnoreCase("/" + Loop)) {
                e.getPlayer().sendMessage("§7 ");
                e.getPlayer().sendMessage("§7                §6§lPLUGIN§7                ");
                e.getPlayer().sendMessage(String.valueOf(Main.prefix) + " §f\u27bc §7Plugin Criado Por §cFleaShot ");
                e.getPlayer().sendMessage(String.valueOf(Main.prefix) + " §f\u27bc §7 Servidor ultilizando o plugin: §a§l" + Main.prefix);
                e.getPlayer().sendMessage("§7                §6§lPLUGIN§7                ");
                e.getPlayer().sendMessage("§7   ");
                e.setCancelled(true);
            }
        }
    }
}
