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

import me.clip.placeholderapi.PlaceholderAPI;

import org.bukkit.Bukkit;
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
		if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
			Player p = (Player) sender;
			FileConfiguration lang = utils.lang();
			FileConfiguration conf = dyes.getPlugin().getConfig();
			if(args == null || args.length == 0) {
				  if(lang.contains("message-cmd-error")) {
						 if(lang.getString("message-cmd-error").equalsIgnoreCase("false")) {
							 return true;
						 }
						 if(p.getInventory().getItemInMainHand().getItemMeta().hasDisplayName()) {
						 dyes.Message(p,PlaceholderAPI.setPlaceholders(p,lang.getString("message-cmd-error").replaceAll("%item%", p.getInventory().getItemInHand().getItemMeta().getDisplayName())));
						 }
						 else {
							 dyes.Message(p,PlaceholderAPI.setPlaceholders(p,lang.getString("message-cmd-error").replaceAll("%item%", p.getInventory().getItemInHand().getType().name().toLowerCase().replace('_', ' '))));
							 }
				  }
				return true;
			}
			
			Boolean able = false;
			if(conf.getStringList("config.except").contains(p.getInventory().getItemInMainHand().getType().name())){
				able = true;
			}
			if(p.getInventory().getItemInMainHand().getItemMeta() != null)
			{
				if(conf.getString("config.need-lore")!=null) {
					if(p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
						Boolean a = true;
						for(String s : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
							if(s.contains(conf.getString("config.need-lore"))) {
								a = false;
							}
						}
						able = a;
					}
				}
				
				if(p.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
					if(conf.getIntegerList("config.except-cmd").contains(p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData())) {
						able = true;
					}
				}
			}
			
			if(able) {
				  if(lang.contains("message-color-except")) {
						 if(lang.getString("message-color-except").equalsIgnoreCase("false")) {
							 return true;
						 }
						 if(p.getInventory().getItemInMainHand().getItemMeta().hasDisplayName()) {
						 dyes.Message(p,PlaceholderAPI.setPlaceholders(p,lang.getString("message-color-except").replaceAll("%item%", p.getInventory().getItemInHand().getItemMeta().getDisplayName())));
						 }
						 else {
							 dyes.Message(p,PlaceholderAPI.setPlaceholders(p,lang.getString("message-color-except").replaceAll("%item%", p.getInventory().getItemInHand().getType().name().toLowerCase().replace('_', ' '))));
							 }
				  }
				  else {
					  dyes.Message(p,"<red>Mensaje no hallado");
					  dyes.Message(p,"<gray>Ingresar mensaje en lang.yml");
					  dyes.Message(p,"<gray>ejemplo: ");
					  dyes.Message(p,"<gray>message-color-except: El item %item% no puede ser aplicado");
				  }
				  return true;
				
			}
			

			
			if(args[0].equalsIgnoreCase("dye")) {
				if(args == null || args.length == 1) {
					return true;
				}
				if(colorform.codesl().contains(args[1])) {
					colorform c = new colorform(null, args[1]);
					

					  if(!colorform.hasPermission(p, c)) {
						  

						  if(lang.contains("message-color-permission")) {

								if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
							 dyes.Message(p,PlaceholderAPI.setPlaceholders((Player) p, lang.getString("message-color-permission").replaceAll("%color%", c.getDisplayName())));
								}
								else
								{
									 dyes.Message(p,lang.getString("message-color-permission").replaceAll("%color%", c.getDisplayName()));
								}
						  }
						  else if(!lang.getString("message-color-permission").equalsIgnoreCase("false")) {
							  dyes.Message(p,"<red>Mensaje no hallado");
							  dyes.Message(p,"<gray>Ingresar mensaje en lang.yml");
							  dyes.Message(p,"<gray>ejemplo: ");
							  dyes.Message(p,"<gray>message-color-permission: El color %color% tiene un permiso que no tienes");
						  }
						  
						  return true;
					  }
					
					  if(p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().getType() != Material.AIR) {
							ItemStack i = p.getInventory().getItemInMainHand();
							  if(i.getType().toString().contains("LEATHER") && i.getType() != Material.LEATHER) {
								  ItemStack b = c.dyeLeatherStack(i);
								  p.getInventory().setItemInMainHand(b);
								  

								  if(lang.contains("message-color-apply")) {
										 if(lang.getString("message-color-apply").equalsIgnoreCase("false")) {
											 return true;
										 }
										 dyes.Message(p,PlaceholderAPI.setPlaceholders(p,lang.getString("message-color-apply").replaceAll("%color%", c.display)));

										 }
								  else {
									  dyes.Message(p,"<red>Mensaje no hallado");
									  dyes.Message(p,"<gray>Ingresar mensaje en lang.yml");
									  dyes.Message(p,"<gray>ejemplo: ");
									  dyes.Message(p,"<gray>message-color-apply: El color %color% a sido aplicado");
								  }
								  return true;
							  }
							  if(i.getType().toString().contains("POTION")) {
								  ItemStack b = c.dyePotionStack(i);
								  p.getInventory().setItemInMainHand(b);
								  

								  if(lang.contains("message-color-apply")) {
									 if(lang.getString("message-color-apply").equalsIgnoreCase("false")) {
										 return true;
									 }
									 dyes.Message(p,PlaceholderAPI.setPlaceholders(p,lang.getString("message-color-apply").replaceAll("%color%", c.display)));

								  }
								  else {
									  dyes.Message(p,"<red>Mensaje no hallado");
									  dyes.Message(p,"<gray>Ingresar mensaje en lang.yml");
									  dyes.Message(p,"<gray>ejemplo: ");
									  dyes.Message(p,"<gray>message-color-apply: El color %color% a sido aplicado");
								  }
								  return true;
							  }
					  }else {
						  if(lang.contains("message-not-mainhand")) {

							 if(lang.getString("message-not-mainhand").equalsIgnoreCase("false")) {
								 return true;
							 }
								dyes.Message(sender, PlaceholderAPI.setPlaceholders(p,lang.getString("message-not-mainhand")));
							return true;
						  }
						  else {
								dyes.Message(sender, "<red>Mensaje no hallado");
								dyes.Message(sender, "<gray>Ingresar mensaje en lang.yml");
								dyes.Message(sender, "<gray>ejemplo: ");
								dyes.Message(sender, "<gray>message-not-mainhand: No tienes un item en mano ");
						  }
					  }
				}else {
					  if(lang.contains("message-color-fail")) {
						 if(lang.getString("message-color-fail").equalsIgnoreCase("false")) {
							 return true;
						 }
							dyes.Message(sender, PlaceholderAPI.setPlaceholders(p,lang.getString("message-color-fail")));
						return true;
					  }
					  else {
							dyes.Message(sender, "<red>Mensaje no hallado");
							dyes.Message(sender, "<gray>Ingresar mensaje en lang.yml");
							dyes.Message(sender, "<gray>ejemplo: ");
							dyes.Message(sender, "<gray>message-color-fail: No tienes un item en mano ");
					  }
				}
			}
			if(conf.getString("config.gui").equalsIgnoreCase("true")) {
				if(args[0].equalsIgnoreCase("gui")) {
		
					  if(p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().getType() != Material.AIR) {
							

						  ItemStack i = p.getItemInHand();
						  if(i.getType().toString().contains("LEATHER") && i.getType() != Material.LEATHER) {
							  utils.openInventoryOne(p);
						  } 
						  
						  else if(i.getType().toString().contains("POTION")) {
							  utils.openInventoryOne(p);
						  }else {

							  if(lang.contains("message-not-mainhand")) {
								 if(lang.getString("message-not-mainhand").equalsIgnoreCase("false")) {
									 return true;
								 }
									dyes.Message(sender, PlaceholderAPI.setPlaceholders(p, lang.getString("message-not-mainhand")));
							  }else {
								dyes.Message(sender, "<red>Mensaje no hallado");
								dyes.Message(sender, "<gray>Ingresar mensaje en lang.yml");
								dyes.Message(sender, "<gray>ejemplo: ");
								dyes.Message(sender, "<gray>message-not-mainhand: No tienes un item en mano ");
							  
							  }
						  }
						  
					  }else {
						  if(lang.contains("message-not-mainhand")) {
							 if(lang.getString("message-not-mainhand").equalsIgnoreCase("false")) {
								 return true;
							 }
								dyes.Message(sender, PlaceholderAPI.setPlaceholders(p, lang.getString("message-not-mainhand")));
							return true;
						  }
						  else {
								dyes.Message(sender, "<red>Mensaje no hallado");
								dyes.Message(sender, "<gray>Ingresar mensaje en lang.yml");
								dyes.Message(sender, "<gray>ejemplo: ");
								dyes.Message(sender, "<gray>message-not-mainhand: No tienes un item en mano ");
						  }
					  }
				}
			}
			return false;
		
		}  //NO PAPI
		else {
		Player p = (Player) sender;
		FileConfiguration lang = utils.lang();
		FileConfiguration conf = dyes.getPlugin().getConfig();
		if(args == null || args.length == 0) {
			return true;
		}
		if(conf.getStringList("config.except").contains(p.getInventory().getItemInMainHand().getType())) {
			  if(lang.contains("message-color-except")) {
					 if(lang.getString("message-color-except").equalsIgnoreCase("false")) {
						 return true;
					 }
					 dyes.Message(p,lang.getString("message-color-except").replaceAll("%item%", p.getInventory().getItemInHand().getItemMeta().getDisplayName()));
					 
			  }
			  else {
				  dyes.Message(p,"<red>Mensaje no hallado");
				  dyes.Message(p,"<gray>Ingresar mensaje en lang.yml");
				  dyes.Message(p,"<gray>ejemplo: ");
				  dyes.Message(p,"<gray>message-color-except: El item %item% no puede ser aplicado");
			  }
			  return true;
			
		}
		if(args[0].equalsIgnoreCase("dye")) {
			if(args == null || args.length == 1) {
				return true;
			}
			if(colorform.codesl().contains(args[1])) {
				colorform c = new colorform(null, args[1]);
				  if(p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().getType() != Material.AIR) {
						ItemStack i = p.getInventory().getItemInMainHand();
						  if(i.getType().toString().contains("LEATHER") && i.getType() != Material.LEATHER) {
							  ItemStack b = c.dyeLeatherStack(i);
							  p.getInventory().setItemInMainHand(b);
							  

							  if(lang.contains("message-color-apply")) {
									 if(lang.getString("message-color-apply").equalsIgnoreCase("false")) {
										 return true;
									 }
									 p.sendMessage(ChatColor.translateAlternateColorCodes('&',lang.getString("message-color-apply").replaceAll("%color%", c.display)));

									 }
							  else {
								  dyes.Message(p,"<red>Mensaje no hallado");
								  dyes.Message(p,"<gray>Ingresar mensaje en lang.yml");
								  dyes.Message(p,"<gray>ejemplo: ");
								  dyes.Message(p,"<gray>message-color-apply: El color %color% a sido aplicado");
							  }
							  return true;
						  }
						  if(i.getType().toString().contains("POTION")) {
							  ItemStack b = c.dyePotionStack(i);
							  p.getInventory().setItemInMainHand(b);
							  

							  if(lang.contains("message-color-apply")) {
								 if(lang.getString("message-color-apply").equalsIgnoreCase("false")) {
									 return true;
								 }
								 dyes.Message(p,lang.getString("message-color-apply").replaceAll("%color%", c.display));

							  }
							  else {
								  dyes.Message(p,"<red>Mensaje no hallado");
								  dyes.Message(p,"<gray>Ingresar mensaje en lang.yml");
								  dyes.Message(p,"<gray>ejemplo: ");
								  dyes.Message(p,"<gray>message-color-apply: El color %color% a sido aplicado");
							  }
							  return true;
						  }
				  }else {
					  if(lang.contains("message-not-mainhand")) {

						 if(lang.getString("message-not-mainhand").equalsIgnoreCase("false")) {
							 return true;
						 }
							dyes.Message(sender, lang.getString("message-not-mainhand"));
						return true;
					  }
					  else {
							dyes.Message(sender, "<red>Mensaje no hallado");
							dyes.Message(sender, "<gray>Ingresar mensaje en lang.yml");
							dyes.Message(sender, "<gray>ejemplo: ");
							dyes.Message(sender, "<gray>message-not-mainhand: No tienes un item en mano ");
					  }
				  }
			}else {
				  if(lang.contains("message-color-fail")) {
					 if(lang.getString("message-color-fail").equalsIgnoreCase("false")) {
						 return true;
					 }
						dyes.Message(sender, lang.getString("message-color-fail"));
					return true;
				  }
				  else {
						dyes.Message(sender, "<red>Mensaje no hallado");
						dyes.Message(sender, "<gray>Ingresar mensaje en lang.yml");
						dyes.Message(sender, "<gray>ejemplo: ");
						dyes.Message(sender, "<gray>message-color-fail: No tienes un item en mano ");
				  }
			}
		}
		if(conf.getString("config.gui").equalsIgnoreCase("true")) {
			if(args[0].equalsIgnoreCase("gui")) {
	
				  if(p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().getType() != Material.AIR) {
						

					  ItemStack i = p.getItemInHand();
					  if(i.getType().toString().contains("LEATHER") && i.getType() != Material.LEATHER) {
						  utils.openInventoryOne(p);
					  } 
					  
					  else if(i.getType().toString().contains("POTION")) {
						  utils.openInventoryOne(p);
					  }else {

						  if(lang.contains("message-not-mainhand")) {
							 if(lang.getString("message-not-mainhand").equalsIgnoreCase("false")) {
								 return true;
							 }
								dyes.Message(sender, lang.getString("message-not-mainhand"));
								return true;
						  }else {
							dyes.Message(sender, "<red>Mensaje no hallado");
							dyes.Message(sender, "<gray>Ingresar mensaje en lang.yml");
							dyes.Message(sender, "<gray>ejemplo: ");
							dyes.Message(sender, "<gray>message-not-mainhand: No tienes un item en mano ");
						  }
						  }
					  
				  }else {
					  if(lang.contains("message-not-mainhand")) {
						 if(lang.getString("message-not-mainhand").equalsIgnoreCase("false")) {
							 return true;
						 }
							dyes.Message(sender, lang.getString("message-not-mainhand"));
						return true;
					  }
					  else {
							dyes.Message(sender, "<red>Mensaje no hallado");
							dyes.Message(sender, "<gray>Ingresar mensaje en lang.yml");
							dyes.Message(sender, "<gray>ejemplo: ");
							dyes.Message(sender, "<gray>message-not-mainhand: No tienes un item en mano ");
					  }
				  }
			}
		}
		return false;
		}
	}

}
