package rubrub07.dyes;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.eclipse.jdt.annotation.Nullable;

import io.lumine.mythic.lib.adventure.audience.Audience;
import io.lumine.mythic.lib.adventure.audience.MessageType;
import io.lumine.mythic.lib.adventure.platform.bukkit.BukkitAudiences;
import io.lumine.mythic.lib.adventure.text.Component;
import io.lumine.mythic.lib.adventure.text.minimessage.MiniMessage;
import io.lumine.mythic.lib.adventure.title.TitlePart;



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
	public static void Message(Player pl,String s) {

		BukkitAudiences au = BukkitAudiences.create(dyes.getPlugin());
		Audience p= Audience.empty();
		p = au.player(pl);
		MiniMessage mm = MiniMessage.miniMessage();
		Component parsed = mm.deserialize(s.toString());
		dyes.sendMessage(p, parsed, 0);
	}

	public static void Message(CommandSender pl,String s) {

		BukkitAudiences au = BukkitAudiences.create(dyes.getPlugin());
		Audience p= Audience.empty();
		p = au.sender(pl);
		MiniMessage mm = MiniMessage.miniMessage();
		Component parsed = mm.deserialize(s.toString());
		dyes.sendMessage(p, parsed, 0);
	}
	
	public static void MiniMessage(Object s,Player player, int id /* 0: message 1: actionbar*/) {
		BukkitAudiences au = BukkitAudiences.create(dyes.getPlugin());
		Audience p= Audience.empty();
		p = au.player(player);
		MiniMessage mm = MiniMessage.miniMessage();
		Component parsed = mm.deserialize(s.toString());
		dyes.sendMessage(p, parsed, id);
	}
	
	//ConsoleCommandSender 
	public static void MiniMessage(Object s,@Nullable ConsoleCommandSender player, int id /* 0: message 1: actionbar*/) {
		if(player == null) {
			BukkitAudiences au = BukkitAudiences.create(dyes.getPlugin());
			Audience p= Audience.empty();
			p = au.sender(Bukkit.getConsoleSender());
			MiniMessage mm = MiniMessage.miniMessage();
			Component parsed = mm.deserialize(s.toString());
			dyes.sendMessage(p, parsed, id);
		}else {
		BukkitAudiences au = BukkitAudiences.create(dyes.getPlugin());
		Audience p= Audience.empty();
		p = au.sender(player);
		MiniMessage mm = MiniMessage.miniMessage();
		Component parsed = mm.deserialize(s.toString());
		dyes.sendMessage(p, parsed, id);
		}
	}
	//CommandSender 
	public static void MiniMessage(Object s,CommandSender player, int id /* 0: message 1: actionbar*/) {
		BukkitAudiences au = BukkitAudiences.create(dyes.getPlugin());
		Audience p= Audience.empty();
		p = au.sender(player);
		MiniMessage mm = MiniMessage.miniMessage();
		Component parsed = mm.deserialize(s.toString());
		dyes.sendMessage(p, parsed, id);
	}
	
	
	public static void sendMessage(Audience p, Component parsed, int id) {

		if(id == 0){
				p.sendMessage(parsed);
			}
		else if(id == 1){
				p.sendActionBar(parsed);
			}
		else if(id == 2){
				p.sendTitlePart(TitlePart.TITLE, parsed);
			}
		else if(id == 3){
				p.sendTitlePart(TitlePart.SUBTITLE, parsed);
			}
		else if(id == 5){
				p.sendMessage(parsed, MessageType.SYSTEM);
			}
		else {
			p.sendMessage(parsed);
		}
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
