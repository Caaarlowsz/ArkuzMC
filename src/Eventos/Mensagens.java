package Eventos;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.util.Random;

public class Mensagens implements Listener {
	public Mensagens() {
		final Random random = new Random();
		switch (random.nextInt(6)) {
		case 1: {
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(
					String.valueOf(ArkuzKitPvP.prefix) + "\n§fCompre §aVIP§f e ajude o servidor a crescer! " + ArkuzKitPvP.loja);
			break;
		}
		case 2: {
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(String.valueOf(ArkuzKitPvP.prefix) + "\n§fVeja os comandos usando §b/ajuda");
			break;
		}
		case 4: {
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(
					String.valueOf(ArkuzKitPvP.prefix) + "\n§fCaso queira se aplicar para a §2equipe§f digite §e/aplicar");
			break;
		}
		case 5: {
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(
					String.valueOf(ArkuzKitPvP.prefix) + "\n§fCaso ache hacks, Use o comando §2/report §b<nick> <motivo>");
			break;
		}
		case 6: {
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(
					String.valueOf(ArkuzKitPvP.prefix) + "\n§fCaso ache hacks, Use o comando §2/report §b<nick> <motivo>");
			break;
		}
		default: {
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(
					String.valueOf(ArkuzKitPvP.prefix) + "\n§fCaso ache hacks, Use o comando §2/report §b<nick> <motivo>");
			break;
		}
		}
	}
}
