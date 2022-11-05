package rubrub07.dyes;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.eclipse.jdt.annotation.Nullable;

import io.lumine.mythic.lib.api.item.ItemTag;
import io.lumine.mythic.lib.api.item.NBTItem;
import io.lumine.mythic.lib.api.util.LegacyComponent;
import io.lumine.mythic.lib.gson.Gson;

public class colorform {

	private Color color;
	public String code;
	public String display;
	
	public colorform(@Nullable Color c,@Nullable String code) {
		if(c != null) {
		color = c;
		}
		else {
			color= Color.GREEN;
		}
		if(code != null) {

		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}
		
		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);
		String s = conf.getString("colors." + code + ".color");
		display = conf.getString("colors." + code + ".display-name");
		if(s.startsWith("#")) {
			setColorFromHEX(s);
		}
		else
		{
			String[] n = s.split(" "); //
			setColorFromRGB(Integer.valueOf(n[0]), Integer.valueOf(n[1]), Integer.valueOf(n[2]));
		}
		}
	}
	
	public void setColorFromRGB(String rgb) {
		color = Color.fromRGB(Integer.valueOf(rgb));
	}
	public void setColorFromRGB(int r, int g, int b) {
		color = Color.fromRGB(r, g, b);
	}
	
	public static ItemStack generateColorDisplay(String code, Player p) {

		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}
		
		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);
		
		ItemStack i = new ItemStack(Material.getMaterial(conf.getString("config.MATERIAL")));
		ItemMeta s = i.getItemMeta();
		s.setCustomModelData(conf.getInt("config.CMD"));
			i.setItemMeta(s);
		s = i.getItemMeta();
		
		s.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		s.addItemFlags(ItemFlag.HIDE_DYE);
		s.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		s.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		s.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		s.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		i.setItemMeta(s);
		
		if(i.getType().toString().contains("LEATHER")) {
			colorform col = new colorform(null, code);
			i = col.dyeLeatherStack(i);
		}
		else if(i.getType().toString().contains("POTION")) {
			colorform col = new colorform(null, code);
			i = col.dyePotionStack(i);
		}
		if(conf.getBoolean("colors." + code + ".glow") == true) {
			i.addEnchantment(Enchantment.DURABILITY, 0);
		}
		NBTItem is = NBTItem.get(i);
		is.addTag(new ItemTag("color-code", code));
		is.setDisplayNameComponent(LegacyComponent.parse(conf.getString("colors." + code + ".display-name")));
		if(conf.getString("colors." + code + ".permission") != null) {
			//if()
		}
		
		
		i = is.toItem();
		return i;
	}
	
	public static boolean hasPermission(Player p, colorform c) {

		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}
		
		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);
		
		if(conf.getString("colors." + c.code + ".permission") != null) {
			if(p.hasPermission(conf.getString("colors." + c.code + ".permission")) || p.isOp()) {
				return true;
			}else {
				return false;
			}
		}else {
			return true;
		}
	}
	@Nullable
	public String getDisplayName() {
		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}
		
		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);
		return conf.getString("colors." + code + ".display-name");
	}
	
	public static ItemStack Panel() {

		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}
		
		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);

		ItemStack i = new ItemStack(Material.getMaterial(conf.getString("config.BORDER-MATERIAL")));
		ItemMeta s = i.getItemMeta();
		s.setCustomModelData(conf.getInt("config.BORDER-CMD"));
		s.setDisplayName(conf.getString("config.BORDER-NAME"));
		s.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		s.addItemFlags(ItemFlag.HIDE_DYE);
		s.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		s.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		s.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		s.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		i.setItemMeta(s);
		return i;
	}

	
	public static ItemStack Next() {

		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}
		
		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);

		ItemStack i = new ItemStack(Material.getMaterial(conf.getString("config.NEXT-MATERIAL")));
		ItemMeta s = i.getItemMeta();
		s.setCustomModelData(conf.getInt("config.NEXT-CMD"));
		s.setDisplayName(conf.getString("config.NEXT-NAME"));
		s.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		s.addItemFlags(ItemFlag.HIDE_DYE);
		s.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		s.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		s.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		s.addItemFlags(ItemFlag.HIDE_PLACED_ON);

		i.setItemMeta(s);
		NBTItem is = NBTItem.get(i);
		is.setDisplayNameComponent(LegacyComponent.parse(conf.getString("config.NEXT-NAME")));
		is.addTag(new ItemTag("type", "next"));
		i = is.toItem();
		return i;
	}
	
	public static ItemStack Prev() {

		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}
		
		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);

		ItemStack i = new ItemStack(Material.getMaterial(conf.getString("config.PREV-MATERIAL")));
		ItemMeta s = i.getItemMeta();
		s.setCustomModelData(conf.getInt("config.PREV-CMD"));
		s.setDisplayName(conf.getString("config.PREV-NAME"));
		s.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		s.addItemFlags(ItemFlag.HIDE_DYE);
		s.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		s.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		s.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		s.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		i.setItemMeta(s);
		NBTItem is = NBTItem.get(i);
		is.setDisplayNameComponent(LegacyComponent.parse(conf.getString("config.PREV-NAME")));
		is.addTag(new ItemTag("type", "prev"));
		
		i = is.toItem();
		return i;
	}
	
	public static Set<String> codes(){


		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}

		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);
		Set<String> codes = new HashSet<>();
		for(String s : conf.getConfigurationSection("colors.").getKeys(false)) {
			codes.add(s);
		}
		
		return codes;
	}

	
	public static java.util.List<String> codesl(){


		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}

		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);
		java.util.List<String> codes = new ArrayList<String>();
		for(String s : conf.getConfigurationSection("colors.").getKeys(false)) {
			codes.add(s);
		}
		
		return codes;
	}
	
	
	public void setColorFromHEX(String hex) {
		color = HexToColor(hex);
	}

	public Color getColor() {
		return color;
	}
	
	public ItemStack dyeLeatherStack(ItemStack i) {
		LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
		meta.setColor(color);
		i.setItemMeta(meta);
		return i;
	}
	
	public ItemStack dyePotionStack(ItemStack i) {
		PotionMeta meta = (PotionMeta) i.getItemMeta();
		meta.setColor(color);
		i.setItemMeta(meta);
		return i;
	}

    public static Color HexToColor(String hex) 
    {
        hex = hex.replace("#", "");
        switch (hex.length()) {
        case 6:
            return Color.fromRGB(
            Integer.valueOf(hex.substring(0, 2), 16),
            Integer.valueOf(hex.substring(2, 4), 16),
            Integer.valueOf(hex.substring(4, 6), 16));
         }
         return null;
    }
}
