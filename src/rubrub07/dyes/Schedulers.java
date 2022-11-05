package rubrub07.dyes;

import org.bukkit.Bukkit;


public class Schedulers {

	public static void run(Runnable runa) {
		Bukkit.getScheduler().runTaskAsynchronously(dyes.getPlugin(), runa);
	}
}
