package rubrub07.dyes;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class dyes  extends JavaPlugin implements TabExecutor {
	PluginDescriptionFile pdffile = getDescription();
	public String rutaconf;
	public String version = pdffile.getVersion();
	public String name = ChatColor.AQUA + "[" + pdffile.getName() + "]";
	public PluginManager pm;
	public FileConfiguration config = this.getConfig();

	private static dyes plugin;
	
	public static dyes getPlugin() {
		return plugin;
	}

	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(name + ChatColor.BLUE + " Plugin encendido (version: " + version + " )");
		registrarConfig();
		plugin = this;
		pm = getServer().getPluginManager();
		pm.registerEvents(new listener(), plugin);

		try {this.getCommand("dyes").setExecutor(new cmd());
		} catch (Error e) {Bukkit.getLogger().severe(e.toString());
		}
		try {this.getCommand("dyes").setTabCompleter(new cmd());
		} catch (Error e) {Bukkit.getLogger().severe(e.toString());
		}
	}
	

	public void registrarConfig() {
		File config = new File(this.getDataFolder(), "config.yml");
		rutaconf = config.getPath();
		if (!config.exists()) {this.getConfig().options().copyDefaults(true);saveConfig();
		}

	}
}
