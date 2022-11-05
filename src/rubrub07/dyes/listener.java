package rubrub07.dyes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.lumine.mythic.lib.api.item.NBTItem;
import me.clip.placeholderapi.PlaceholderAPI;

public class listener implements Listener {

	@SuppressWarnings("static-access")
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (event.getView().getTitle().contains("Tintes -")) {
			FileConfiguration lang = utils.lang();
			FileConfiguration conf = dyes.getPlugin().getConfig();
			event.setCancelled(true);
			String s = event.getView().getTitle();
			String[] a = s.split("-");

			if (event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR) {
				ItemStack t = event.getWhoClicked().getInventory().getItemInMainHand();
				NBTItem n = NBTItem.get(event.getCurrentItem());

				if (n.hasTag("color-code")) {
					colorform c = new colorform(null, n.getString("color-code"));
					if (!colorform.hasPermission((Player) event.getWhoClicked(), c)) {

						if (lang.contains("message-color-permission")) {

							if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
								dyes.Message(event.getWhoClicked(),
										PlaceholderAPI.setPlaceholders((Player) event.getWhoClicked(),
												lang.getString("message-color-permission").replaceAll("%color%",
														c.generateColorDisplay(n.getString("color-code"),
																(Player) event.getWhoClicked()).getItemMeta()
																.getDisplayName())));
							} else {
								dyes.Message(event.getWhoClicked(),
										lang.getString("message-color-permission").replaceAll("%color%",
												c.generateColorDisplay(n.getString("color-code"),
														(Player) event.getWhoClicked()).getItemMeta()
														.getDisplayName()));
							}
						} else if (!lang.getString("message-color-permission").equalsIgnoreCase("false")) {
							dyes.Message(event.getWhoClicked(), "<red>Mensaje no hallado");
							dyes.Message(event.getWhoClicked(), "<gray>Ingresar mensaje en lang.yml");
							dyes.Message(event.getWhoClicked(), "<gray>ejemplo: ");
							dyes.Message(event.getWhoClicked(),
									"<gray>message-color-permission: El color %color% tiene un permiso que no tienes");
						}

						return;
					}

					if (!t.getItemMeta().hasCustomModelData()) {
						ItemMeta e = t.getItemMeta();
						e.setCustomModelData(0);
						t.setItemMeta(e);
					}

					ItemStack i = event.getWhoClicked().getInventory().getItemInMainHand();
					if (i.getType().toString().contains("LEATHER") && i.getType() != Material.LEATHER
							&& !conf.getIntegerList("config.except-cmd").contains(t.getItemMeta().getCustomModelData())
							&& !conf.getStringList("config.except").contains(t.getType().name())) {
						ItemStack b = c.dyeLeatherStack(i);
						event.getWhoClicked().getInventory().setItemInMainHand(b);

						if (lang.contains("message-color-apply")) {
							if (!lang.getString("message-color-apply").equalsIgnoreCase("false")) {
								if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
									dyes.Message(event.getWhoClicked(),
											PlaceholderAPI
													.setPlaceholders((Player) event.getWhoClicked(),
															lang.getString("message-color-apply")
																	.replaceAll(
																			"%color%", c
																					.generateColorDisplay(
																							n.getString("color-code"),
																							(Player) event
																									.getWhoClicked())
																					.getItemMeta().getDisplayName())));
								} else {
									dyes.Message(event.getWhoClicked(),
											lang.getString("message-color-apply").replaceAll("%color%",
													c.generateColorDisplay(n.getString("color-code"),
															(Player) event.getWhoClicked()).getItemMeta()
															.getDisplayName()));
								}
							}
						} else {

							dyes.Message(event.getWhoClicked(), "<red>Mensaje no hallado");
							dyes.Message(event.getWhoClicked(), "<gray>Ingresar mensaje en lang.yml");
							dyes.Message(event.getWhoClicked(), "<gray>ejemplo: ");
							dyes.Message(event.getWhoClicked(),
									"<gray>message-color-apply: El color %color% a sido aplicado");
						}
					} else if (i.getType().toString().contains("POTION")
							&& !conf.getIntegerList("config.except-cmd").contains(t.getItemMeta().getCustomModelData())
							&& !conf.getStringList("config.except").contains(t.getType().name())) {
						ItemStack b = c.dyePotionStack(i);
						event.getWhoClicked().getInventory().setItemInMainHand(b);

						if (lang.contains("message-color-apply")) {
							if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
								dyes.Message(event.getWhoClicked(),
										PlaceholderAPI.setPlaceholders((Player) event.getWhoClicked(),
												lang.getString("message-color-apply").replaceAll("%color%",
														c.generateColorDisplay(n.getString("color-code"),
																(Player) event.getWhoClicked()).getItemMeta()
																.getDisplayName())));
							} else {
								dyes.Message(event.getWhoClicked(),
										lang.getString("message-color-apply").replaceAll("%color%",
												c.generateColorDisplay(n.getString("color-code"),
														(Player) event.getWhoClicked()).getItemMeta()
														.getDisplayName()));
							}
						} else if (!lang.getString("message-color-apply").equalsIgnoreCase("false")) {
							dyes.Message(event.getWhoClicked(), "<red>Mensaje no hallado");
							dyes.Message(event.getWhoClicked(), "<gray>Ingresar mensaje en lang.yml");
							dyes.Message(event.getWhoClicked(), "<gray>ejemplo: ");
							dyes.Message(event.getWhoClicked(),
									"<gray>message-color-apply: El color %color% a sido aplicado");
						}
					} else {
						if (lang.contains("message-color-except")) {
							if (lang.getString("message-color-except").equalsIgnoreCase("false")) {
							}

							if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
								if (t.getItemMeta().hasDisplayName()) {
									dyes.Message(event.getWhoClicked(),
											PlaceholderAPI.setPlaceholders((Player) event.getWhoClicked(),
													lang.getString("message-color-except").replaceAll("%item%",
															t.getItemMeta().getDisplayName())));
								} else {
									dyes.Message(event.getWhoClicked(),
											PlaceholderAPI.setPlaceholders((Player) event.getWhoClicked(),
													lang.getString("message-color-except").replaceAll("%item%",
															t.getType().name().toLowerCase().replace('_', ' '))));
								}
							} else {
								if (t.getItemMeta().hasDisplayName()) {
									dyes.Message(event.getWhoClicked(), lang.getString("message-color-except")
											.replaceAll("%item%", t.getItemMeta().getDisplayName()));
								} else {
									dyes.Message(event.getWhoClicked(), lang.getString("message-color-except")
											.replaceAll("%item%", t.getType().name().toLowerCase().replace('_', ' ')));
								}
							}
						} else {
							dyes.Message(event.getWhoClicked(), "<red>Mensaje no hallado");
							dyes.Message(event.getWhoClicked(), "<gray>Ingresar mensaje en lang.yml");
							dyes.Message(event.getWhoClicked(), "<gray>ejemplo: ");
							dyes.Message(event.getWhoClicked(),
									"<gray>message-color-except: El item %item% no puede ser aplicado");
						}
					}
				}

				if (n.hasTag("type")) {
					if (n.getString("type").equalsIgnoreCase("next")) {
						Player p = (Player) event.getWhoClicked();
						if (a[1].contains("1") && a[1].contains("10") == false) {
							utils.openInventoryTwo(p);
						}
						if (a[1].contains("2")) {
							utils.openInventoryTree(p);
						}
						if (a[1].contains("3")) {
							utils.openInventoryFour(p);
						}
						if (a[1].contains("4")) {
							utils.openInventoryFive(p);
						}
						if (a[1].contains("5")) {
							utils.openInventorySix(p);
						}
						if (a[1].contains("6")) {
							utils.openInventorySeven(p);
						}
						if (a[1].contains("7")) {
							utils.openInventoryEight(p);
						}
						if (a[1].contains("8")) {
							utils.openInventoryNine(p);
						}
						if (a[1].contains("9")) {
							utils.openInventoryTen(p);
						}
					}
					if (n.getString("type").equalsIgnoreCase("prev")) {
						Player p = (Player) event.getWhoClicked();
						if (a[1].contains("2")) {
							utils.openInventoryOne(p);
						}
						if (a[1].contains("3")) {
							utils.openInventoryTwo(p);
						}
						if (a[1].contains("4")) {
							utils.openInventoryTree(p);
						}
						if (a[1].contains("5")) {
							utils.openInventoryFour(p);
						}
						if (a[1].contains("6")) {
							utils.openInventoryFive(p);
						}
						if (a[1].contains("7")) {
							utils.openInventorySix(p);
						}
						if (a[1].contains("8")) {
							utils.openInventorySeven(p);
						}
						if (a[1].contains("9")) {
							utils.openInventoryEight(p);
						}
						if (a[1].contains("10")) {
							utils.openInventoryNine(p);
						}
					}
				}
			}
		}
	}
}
