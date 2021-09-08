package Eventos;

import Main.Main;
import org.bukkit.Bukkit;
import java.util.Random;
import org.bukkit.event.Listener;

public class Mensagens implements Listener
{
    public Mensagens() {
        final Random random = new Random();
        switch (random.nextInt(6)) {
            case 1: {
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(String.valueOf(Main.prefix) + "\n§fCompre §aVIP§f e ajude o servidor a crescer! " + Main.loja);
                break;
            }
            case 2: {
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(String.valueOf(Main.prefix) + "\n§fVeja os comandos usando §b/ajuda");
                break;
            }
            case 4: {
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(String.valueOf(Main.prefix) + "\n§fCaso queira se aplicar para a §2equipe§f digite §e/aplicar");
                break;
            }
            case 5: {
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(String.valueOf(Main.prefix) + "\n§fCaso ache hacks, Use o comando §2/report §b<nick> <motivo>");
                break;
            }
            case 6: {
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(String.valueOf(Main.prefix) + "\n§fCaso ache hacks, Use o comando §2/report §b<nick> <motivo>");
                break;
            }
            default: {
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage(String.valueOf(Main.prefix) + "\n§fCaso ache hacks, Use o comando §2/report §b<nick> <motivo>");
                break;
            }
        }
    }
}
