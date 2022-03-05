package rubrub07.dyes;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import org.bukkit.ChatColor;

public class cmd implements TabExecutor{

	@SuppressWarnings("unchecked")
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1) {
			FileConfiguration conf = dyes.getPlugin().getConfig();
			List<String> list = new ArrayList<>();

			if(conf.getString("config.gui").equalsIgnoreCase("true")) {
				list.add("gui");
			}
			list.add("dye");

			Collections.sort(list);

			return list;
		}
		if(args[0].equalsIgnoreCase("dye")) {
			List<String> list = new ArrayList<String>();
			list = colorform.codesl();

			Collections.sort(list);

			return list;
		}
		return null;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)  {
		Player p = (Player) sender;
		FileConfiguration lang = utils.lang();
		FileConfiguration conf = dyes.getPlugin().getConfig();
		if(args == null || args.length == 0) {
			return true;
		}
		if(args[0].equalsIgnoreCase("dye")) {
			if(args == null || args.length == 1) {
				return true;
			}
			if(colorform.codes().contains(args[1])) {
				colorform c = new colorform(null, args[1]);
				  if(p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().getType() != Material.AIR) {
						ItemStack i = p.getInventory().getItemInMainHand();
						  if(i.getType().toString().contains("LEATHER") && i.getType() != Material.LEATHER) {
							  ItemStack b = c.dyeLeatherStack(i);
							  p.getInventory().setItemInMainHand(b);
							  

							  if(lang.contains("message-color-aplly")) {
									 p.sendMessage(ChatColor.translateAlternateColorCodes('&', lang.getString("message-color-aplly").replaceAll("%color%", c.display)));
									 }
							  else {
								  p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cMensaje no hallado"));
								  p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Ingresar mensaje en lang.yml"));
								  p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7ejemplo: "));
								  p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7message-color-aplly: El color %color% a sido aplicado"));
							  }
							  return true;
						  }
						  if(i.getType().toString().contains("POTION")) {
							  ItemStack b = c.dyePotionStack(i);
							  p.getInventory().setItemInMainHand(b);
							  

							  if(lang.contains("message-color-aplly")) {
								 p.sendMessage(ChatColor.translateAlternateColorCodes('&', lang.getString("message-color-aplly").replaceAll("%color%", c.display)));
							  }
							  else {
								  p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cMensaje no hallado"));
								  p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Ingresar mensaje en lang.yml"));
								  p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7ejemplo: "));
								  p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7message-color-aplly: El color %color% a sido aplicado"));
							  }
							  return true;
						  }
				  }else {
					  if(lang.contains("message-not-mainhand")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', lang.getString("message-not-mainhand")));
						return true;
					  }
					  else {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cMensaje no hallado"));
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Ingresar mensaje en lang.yml"));
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7ejemplo: "));
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7message-not-mainhand: No tienes un item en mano "));
					  }
				  }
			}else {
				  if(lang.contains("message-color-fail")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', lang.getString("message-color-fail")));
					return true;
				  }
				  else {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cMensaje no hallado"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Ingresar mensaje en lang.yml"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7ejemplo: "));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7message-color-fail: No tienes un item en mano "));
				  }
			}
		}
		if(conf.getString("config.gui").equalsIgnoreCase("true")) {
			if(args[0].equalsIgnoreCase("gui")) {
	
				  if(p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().getType() != Material.AIR) {
						utils.openInventoryOne(p);
				  }else {
					  if(lang.contains("message-not-mainhand")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', lang.getString("message-not-mainhand")));
						return true;
					  }
					  else {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cMensaje no hallado"));
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Ingresar mensaje en lang.yml"));
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7ejemplo: "));
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7message-not-mainhand: No tienes un item en mano "));
					  }
				  }
			}
		}
		return false;
	}

}
