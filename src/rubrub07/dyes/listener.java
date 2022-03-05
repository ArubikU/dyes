package rubrub07.dyes;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import io.lumine.mythic.lib.api.item.NBTItem;

public class listener implements Listener{

	  
	  @EventHandler
	  public void onInventoryClick(InventoryClickEvent event) {
	  if (event.getView().getTitle().contains("Tintes -")) {
		  FileConfiguration lang = utils.lang();
		  event.setCancelled(true);
		  String s = event.getView().getTitle();
		  String[] a = s.split("-");

		  if(event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR) {
			  ItemStack t = event.getCurrentItem();
			  NBTItem n = NBTItem.get(event.getCurrentItem());
			  //event.getWhoClicked().sendMessage(n.getTags().toString());
			  if(n.hasTag("color-code")) {
				  colorform c = new colorform(null , n.getString("color-code"));
				  ItemStack i = event.getWhoClicked().getInventory().getItemInMainHand();
				  if(i.getType().toString().contains("LEATHER") && i.getType() != Material.LEATHER) {
					  ItemStack b = c.dyeLeatherStack(i);
					  event.getWhoClicked().getInventory().setItemInMainHand(b);

					  if(lang.contains("message-color-aplly")) {
						 event.getWhoClicked().sendMessage(ChatColor.translateAlternateColorCodes('&', lang.getString("message-color-aplly").replaceAll("%color%", c.generateColorDisplay(n.getString("color-code")).getItemMeta().getDisplayName())));
					  }
					  else {
						  event.getWhoClicked().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cMensaje no hallado"));
						  event.getWhoClicked().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Ingresar mensaje en lang.yml"));
						  event.getWhoClicked().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7ejemplo: "));
						  event.getWhoClicked().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7message-color-aplly: El color %color% a sido aplicado"));
					  }
				  }
				  if(i.getType().toString().contains("POTION")) {
					  ItemStack b = c.dyePotionStack(i);
					  event.getWhoClicked().getInventory().setItemInMainHand(b);

					  if(lang.contains("message-color-aplly")) {
						 event.getWhoClicked().sendMessage(ChatColor.translateAlternateColorCodes('&', lang.getString("message-color-aplly").replaceAll("%color%", c.generateColorDisplay(n.getString("color-code")).getItemMeta().getDisplayName())));
					  }
					  else {
						  event.getWhoClicked().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cMensaje no hallado"));
						  event.getWhoClicked().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Ingresar mensaje en lang.yml"));
						  event.getWhoClicked().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7ejemplo: "));
						  event.getWhoClicked().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7message-color-aplly: El color %color% a sido aplicado"));
					  }
				  }
			  }
			  
			  if(n.hasTag("type")) {
				  if(n.getString("type").equalsIgnoreCase("next")) {
					  Player p = (Player) event.getWhoClicked();
					  if(a[1].contains("1")) {
						  utils.openInventoryTwo(p);
					  }
					  if(a[1].contains("2")) {
						  utils.openInventoryTree(p);
					  }
					  if(a[1].contains("3")) {
						  utils.openInventoryFour(p);
					  }
					  if(a[1].contains("4")) {
						  utils.openInventoryFive(p);
					  }
					  if(a[1].contains("5")) {
						  utils.openInventorySix(p);
					  }
					  if(a[1].contains("6")) {
						  utils.openInventorySeven(p);
					  }
					  if(a[1].contains("7")) {
						  utils.openInventoryEight(p);
					  }
					  if(a[1].contains("8")) {
						  utils.openInventoryNine(p);
					  }
					  if(a[1].contains("9")) {
						  utils.openInventoryTen(p);
					  }
				  }
				  if(n.getString("type").equalsIgnoreCase("prev")) {
					  Player p = (Player) event.getWhoClicked();
					  if(a[1].contains("2")) {
						  utils.openInventoryOne(p);
					  }
					  if(a[1].contains("3")) {
						  utils.openInventoryTwo(p);
					  }
					  if(a[1].contains("4")) {
						  utils.openInventoryTree(p);
					  }
					  if(a[1].contains("5")) {
						  utils.openInventoryFour(p);
					  }
					  if(a[1].contains("6")) {
						  utils.openInventoryFive(p);
					  }
					  if(a[1].contains("7")) {
						  utils.openInventorySix(p);
					  }
					  if(a[1].contains("8")) {
						  utils.openInventorySeven(p);
					  }
					  if(a[1].contains("9")) {
						  utils.openInventoryEight(p);
					  }
					  if(a[1].contains("10")) {
						  utils.openInventoryNine(p);
					  }
				  }
			  }
		  }
	  }
	  }
}
