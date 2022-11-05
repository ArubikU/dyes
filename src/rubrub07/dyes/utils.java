package rubrub07.dyes;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import me.clip.placeholderapi.PlaceholderAPI;

public class utils {

	static List<String> cda = colorform.codesl();
	
	public static FileConfiguration lang() {

		File f = new File(dyes.getPlugin().getDataFolder(), "lang.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}

		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);
		return conf;
		
	}
	
	
	public static void openInventoryOne(Player p) {
		cda = colorform.codesl();
		Inventory normal;
		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}
		
		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);

		String suffix = "";
		String prefix = "";

		if(conf.getString("config.inv-suffix") != null) {
			suffix = conf.getString("config.inv-suffix");
		}
		if(conf.getString("config.inv-prefix") != null) {
			suffix = conf.getString("config.inv-prefix");
		}

		normal = Bukkit.createInventory(null, 54, prefix+"Tintes - 1"+suffix);
		for(int i=0; i<9; i++) {
			normal.setItem(i, colorform.Panel());
		}

		normal.setItem(9, colorform.Panel());
		normal.setItem(17, colorform.Panel());
		normal.setItem(18, colorform.Panel());
		normal.setItem(26, colorform.Panel());
		normal.setItem(27, colorform.Panel());
		normal.setItem(36, colorform.Panel());
		normal.setItem(35, colorform.Panel());
		normal.setItem(44, colorform.Panel());
		
		for(int i=45; i<54; i++) {
			normal.setItem(i, colorform.Panel());
		}
		
		if(cda.size() > 28) {
			normal.setItem(53, colorform.Next());
		}
		
		for(int i= 10; i<44; i++) {
				if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Panel().getType())) {
					continue;
				}
				if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Next().getType())) {
					continue;
				}
				if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Prev().getType())) {
					continue;
				}
			
			if(cda.isEmpty()) {
				break;
			}
			
			normal.setItem(i, colorform.generateColorDisplay(cda.get(0), p));
			cda.remove(0);
		}
		p.openInventory(normal);
	}

    public static void openInventoryTwo(Player p){
		cda = colorform.codesl();
		Inventory normal;
		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}
		
		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);

		String suffix = "";
		String prefix = "";

		if(conf.getString("config.inv-suffix") != null) {
			suffix = conf.getString("config.inv-suffix");
		}
		if(conf.getString("config.inv-prefix") != null) {
			suffix = conf.getString("config.inv-prefix");
		}

		normal = Bukkit.createInventory(null, 54, prefix+"Tintes - 2"+suffix);
     	
     	for(int i=0; i<9; i++) {
     		normal.setItem(i, colorform.Panel());
     	}
    
     	normal.setItem(9, colorform.Panel());
     	normal.setItem(17, colorform.Panel());
     	normal.setItem(18, colorform.Panel());
     	normal.setItem(26, colorform.Panel());
     	normal.setItem(27, colorform.Panel());
     	normal.setItem(36, colorform.Panel());
     	normal.setItem(35, colorform.Panel());
     	normal.setItem(44, colorform.Panel());
     	
     	for(int i=45; i<54; i++) {
     		normal.setItem(i, colorform.Panel());
     	}
     	
     	if(cda.size() > 56) {
     		normal.setItem(53, colorform.Next());
     	}
         
     	normal.setItem(45, colorform.Prev());

     	for(int i= 0; i<28; i++) {
     		cda.remove(0);
     	}
     	for(int i= 10; i<44; i++) {
     		if(cda.isEmpty()) {
     			break;
     		} else {
         		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Panel().getType())) {
         			continue;
         		}
         		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Next().getType())) {
         			continue;
         		}
         		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Prev().getType())) {
         			continue;
         		}
         		normal.setItem(i, colorform.generateColorDisplay(cda.get(0), p));
         		cda.remove(0);
     		}
     	}
		p.openInventory(normal);
    }
	
    public static void openInventoryTree(Player p){
		cda = colorform.codesl();
		Inventory normal;
		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}
		
		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);

		String suffix = "";
		String prefix = "";

		if(conf.getString("config.inv-suffix") != null) {
			suffix = conf.getString("config.inv-suffix");
		}
		if(conf.getString("config.inv-prefix") != null) {
			suffix = conf.getString("config.inv-prefix");
		}

		normal = Bukkit.createInventory(null, 54, prefix+"Tintes - 3"+suffix);
     	for(int i=0; i<9; i++) {
     		normal.setItem(i, colorform.Panel());
     	}
     	
     	normal.setItem(9, colorform.Panel());
     	normal.setItem(17, colorform.Panel());
     	normal.setItem(18, colorform.Panel());
     	normal.setItem(26, colorform.Panel());
     	normal.setItem(27, colorform.Panel());
     	normal.setItem(36, colorform.Panel());
     	normal.setItem(35, colorform.Panel());
     	normal.setItem(44, colorform.Panel());
     	
     	for(int i=45; i<54; i++) {
     		normal.setItem(i, colorform.Panel());
     	}
     	
     	if(cda.size() > 84) {
     		normal.setItem(53, colorform.Next());
     	}
     	
     	normal.setItem(45, colorform.Prev());

     	for(int i= 0; i<56; i++) {
     		cda.remove(0);
     	}
     	for(int i= 10; i<44; i++) {
     		if(cda.isEmpty()) {
     			break;
     		} else {
         		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Panel().getType())) {
         			continue;
         		}
         		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Next().getType())) {
         			continue;
         		}
         		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Prev().getType())) {
         			continue;
         		}
         		normal.setItem(i, colorform.generateColorDisplay(cda.get(0), p));
         		cda.remove(0);
     		}
     	}
		p.openInventory(normal);
    }

    public static void openInventoryFour(Player p){
		cda = colorform.codesl();
		Inventory normal;
		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}
		
		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);
		String suffix = "";
		String prefix = "";

		if(conf.getString("config.inv-suffix") != null) {
			suffix = conf.getString("config.inv-suffix");
		}
		if(conf.getString("config.inv-prefix") != null) {
			suffix = conf.getString("config.inv-prefix");
		}

		normal = Bukkit.createInventory(null, 54, prefix+"Tintes - 4"+suffix);
        	
        	for(int i=0; i<9; i++) {
        		normal.setItem(i, colorform.Panel());
        	}
        	
        	normal.setItem(9, colorform.Panel());
        	normal.setItem(17, colorform.Panel());
        	normal.setItem(18, colorform.Panel());
        	normal.setItem(26, colorform.Panel());
        	normal.setItem(27, colorform.Panel());
        	normal.setItem(36, colorform.Panel());
        	normal.setItem(35, colorform.Panel());
        	normal.setItem(44, colorform.Panel());
        	
        	for(int i=45; i<54; i++) {
        		normal.setItem(i, colorform.Panel());
        	}
        	
        	if(cda.size() > 112) {
        		normal.setItem(53, colorform.Next());
        	}
        	
        	normal.setItem(45, colorform.Prev());

         	for(int i= 0; i<84; i++) {
         		cda.remove(0);
         	}
         	for(int i= 10; i<44; i++) {
         		if(cda.isEmpty()) {
         			break;
         		} else {
             		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Panel().getType())) {
             			continue;
             		}
             		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Next().getType())) {
             			continue;
             		}
             		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Prev().getType())) {
             			continue;
             		}
             		normal.setItem(i, colorform.generateColorDisplay(cda.get(0), p));
             		cda.remove(0);
         		}
         	}
			p.openInventory(normal);
        }

    public static void openInventoryFive(Player p){
		cda = colorform.codesl();
		Inventory normal;
		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}
		
		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);

		String suffix = "";
		String prefix = "";

		if(conf.getString("config.inv-suffix") != null) {
			suffix = conf.getString("config.inv-suffix");
		}
		if(conf.getString("config.inv-prefix") != null) {
			suffix = conf.getString("config.inv-prefix");
		}

		normal = Bukkit.createInventory(null, 54, prefix+"Tintes - 5"+suffix);

            for(int i=0; i<9; i++) {
            	normal.setItem(i, colorform.Panel());
            }

            normal.setItem(9, colorform.Panel());
            normal.setItem(17, colorform.Panel());
            normal.setItem(18, colorform.Panel());
            normal.setItem(26, colorform.Panel());
            normal.setItem(27, colorform.Panel());
            normal.setItem(36, colorform.Panel());
            normal.setItem(35, colorform.Panel());
            normal.setItem(44, colorform.Panel());

            for(int i=45; i<54; i++) {
            	normal.setItem(i, colorform.Panel());
            }

            if(cda.size() > 140) {
            	normal.setItem(53, colorform.Next());
            }

            normal.setItem(45, colorform.Prev());

         	for(int i= 0; i<112; i++) {
         		cda.remove(0);
         	}
         	for(int i= 10; i<44; i++) {
         		if(cda.isEmpty()) {
         			break;
         		} else {
             		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Panel().getType())) {
             			continue;
             		}
             		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Next().getType())) {
             			continue;
             		}
             		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Prev().getType())) {
             			continue;
             		}
             		normal.setItem(i, colorform.generateColorDisplay(cda.get(0), p));
             		cda.remove(0);
         		}
         	}
			p.openInventory(normal);
    }

    public static void openInventorySix(Player p){
		cda = colorform.codesl();
		Inventory normal;
		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}
		
		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);

		String suffix = "";
		String prefix = "";

		if(conf.getString("config.inv-suffix") != null) {
			suffix = conf.getString("config.inv-suffix");
		}
		if(conf.getString("config.inv-prefix") != null) {
			suffix = conf.getString("config.inv-prefix");
		}

		normal = Bukkit.createInventory(null, 54, prefix+"Tintes - 6"+suffix);

            for(int i=0; i<9; i++) {
            	normal.setItem(i, colorform.Panel());
            }

            normal.setItem(9, colorform.Panel());
            normal.setItem(17, colorform.Panel());
            normal.setItem(18, colorform.Panel());
            normal.setItem(26, colorform.Panel());
            normal.setItem(27, colorform.Panel());
            normal.setItem(36, colorform.Panel());
            normal.setItem(35, colorform.Panel());
            normal.setItem(44, colorform.Panel());

            for(int i=45; i<54; i++) {
            	normal.setItem(i, colorform.Panel());
            }

            if(cda.size() > 168) {
            	normal.setItem(53, colorform.Next());
            }

            normal.setItem(45, colorform.Prev());

         	for(int i= 0; i<140; i++) {
         		cda.remove(0);
         	}
         	for(int i= 10; i<44; i++) {
         		if(cda.isEmpty()) {
         			break;
         		} else {
             		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Panel().getType())) {
             			continue;
             		}
             		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Next().getType())) {
             			continue;
             		}
             		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Prev().getType())) {
             			continue;
             		}
             		normal.setItem(i, colorform.generateColorDisplay(cda.get(0), p));
             		cda.remove(0);
         		}
         	}
			p.openInventory(normal);
    }

    public static void openInventorySeven(Player p){
		cda = colorform.codesl();
		Inventory normal;
		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}
		
		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);

		String suffix = "";
		String prefix = "";

		if(conf.getString("config.inv-suffix") != null) {
			suffix = conf.getString("config.inv-suffix");
		}
		if(conf.getString("config.inv-prefix") != null) {
			suffix = conf.getString("config.inv-prefix");
		}

		normal = Bukkit.createInventory(null, 54, prefix+"Tintes - 7"+suffix);

            for(int i=0; i<9; i++) {
            	normal.setItem(i, colorform.Panel());
            }

            normal.setItem(9, colorform.Panel());
            normal.setItem(17, colorform.Panel());
            normal.setItem(18, colorform.Panel());
            normal.setItem(26, colorform.Panel());
            normal.setItem(27, colorform.Panel());
            normal.setItem(36, colorform.Panel());
            normal.setItem(35, colorform.Panel());
            normal.setItem(44, colorform.Panel());

            for(int i=45; i<54; i++) {
            	normal.setItem(i, colorform.Panel());
            }

            if(cda.size() > 196) {
            	normal.setItem(53, colorform.Next());
            }

            normal.setItem(45, colorform.Prev());

         	for(int i= 0; i<168; i++) {
         		cda.remove(0);
         	}
         	for(int i= 10; i<44; i++) {
         		if(cda.isEmpty()) {
         			break;
         		} else {
             		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Panel().getType())) {
             			continue;
             		}
             		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Next().getType())) {
             			continue;
             		}
             		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Prev().getType())) {
             			continue;
             		}
             		normal.setItem(i, colorform.generateColorDisplay(cda.get(0), p));
             		cda.remove(0);
         		}
         	}

			p.openInventory(normal);
    }

    public static void openInventoryEight(Player p){
		cda = colorform.codesl();
		Inventory normal;
		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}
		
		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);

		String suffix = "";
		String prefix = "";

		if(conf.getString("config.inv-suffix") != null) {
			suffix = conf.getString("config.inv-suffix");
		}
		if(conf.getString("config.inv-prefix") != null) {
			suffix = conf.getString("config.inv-prefix");
		}

		normal = Bukkit.createInventory(null, 54, prefix+"Tintes - 8"+suffix);
            for(int i=0; i<9; i++) {
            	normal.setItem(i, colorform.Panel());
            }

            normal.setItem(9, colorform.Panel());
            normal.setItem(17, colorform.Panel());
            normal.setItem(18, colorform.Panel());
            normal.setItem(26, colorform.Panel());
            normal.setItem(27, colorform.Panel());
            normal.setItem(36, colorform.Panel());
            normal.setItem(35, colorform.Panel());
            normal.setItem(44, colorform.Panel());

            for(int i=45; i<54; i++) {
            	normal.setItem(i, colorform.Panel());
            }

            if(cda.size() > 224) {
            	normal.setItem(53, colorform.Next());
            }

            normal.setItem(45, colorform.Prev());

         	for(int i= 0; i<196; i++) {
         		cda.remove(0);
         	}
         	for(int i= 10; i<44; i++) {
         		if(cda.isEmpty()) {
         			break;
         		} else {
             		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Panel().getType())) {
             			continue;
             		}
             		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Next().getType())) {
             			continue;
             		}
             		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Prev().getType())) {
             			continue;
             		}
             		normal.setItem(i, colorform.generateColorDisplay(cda.get(0), p));
             		cda.remove(0);
         		}
         	}
			p.openInventory(normal);

    }

    public static void openInventoryNine(Player p){
		cda = colorform.codesl();
		Inventory normal;
		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}
		
		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);

		String suffix = "";
		String prefix = "";

		if(conf.getString("config.inv-suffix") != null) {
			suffix = conf.getString("config.inv-suffix");
		}
		if(conf.getString("config.inv-prefix") != null) {
			suffix = conf.getString("config.inv-prefix");
		}

		normal = Bukkit.createInventory(null, 54, prefix+"Tintes - 9"+suffix);

            for(int i=0; i<9; i++) {
            	normal.setItem(i, colorform.Panel());
            }

            normal.setItem(9, colorform.Panel());
            normal.setItem(17, colorform.Panel());
            normal.setItem(18, colorform.Panel());
            normal.setItem(26, colorform.Panel());
            normal.setItem(27, colorform.Panel());
            normal.setItem(36, colorform.Panel());
            normal.setItem(35, colorform.Panel());
            normal.setItem(44, colorform.Panel());

            for(int i=45; i<54; i++) {
            	normal.setItem(i, colorform.Panel());
            }

            if(cda.size() > 252) {
            	normal.setItem(53, colorform.Next());
            }

            normal.setItem(45, colorform.Prev());

         	for(int i= 0; i<224; i++) {
         		cda.remove(0);
         	}
         	for(int i= 10; i<44; i++) {
         		if(cda.isEmpty()) {
         			break;
         		} else {
             		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Panel().getType())) {
             			continue;
             		}
             		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Next().getType())) {
             			continue;
             		}
             		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Prev().getType())) {
             			continue;
             		}
             		normal.setItem(i, colorform.generateColorDisplay(cda.get(0), p));
             		cda.remove(0);
         		}
         	}
			p.openInventory(normal);


    }

    public static void openInventoryTen(Player p){
		cda = colorform.codesl();
		Inventory normal;
		File f = new File(dyes.getPlugin().getDataFolder(), "config.yml");
		if (!f.exists()) {
			f.getParentFile().mkdirs();
		}
		
		FileConfiguration conf = YamlConfiguration.loadConfiguration(f);

		String suffix = "";
		String prefix = "";

		if(conf.getString("config.inv-suffix") != null) {
			suffix = conf.getString("config.inv-suffix");
		}
		if(conf.getString("config.inv-prefix") != null) {
			suffix = conf.getString("config.inv-prefix");
		}

		normal = Bukkit.createInventory(null, 54, prefix+"Tintes - 10"+suffix);
			

			for(int i=0; i<9; i++) {
				normal.setItem(i, colorform.Panel());
			}

			normal.setItem(9, colorform.Panel());
			normal.setItem(17, colorform.Panel());
			normal.setItem(18, colorform.Panel());
			normal.setItem(26, colorform.Panel());
			normal.setItem(27, colorform.Panel());
			normal.setItem(36, colorform.Panel());
			normal.setItem(35, colorform.Panel());
			normal.setItem(44, colorform.Panel());

			for(int i=45; i<54; i++) {
				normal.setItem(i, colorform.Panel());
			}

			normal.setItem(45, colorform.Prev());

	     	for(int i= 0; i<252; i++) {
	     		cda.remove(0);
	     	}
	     	for(int i= 10; i<44; i++) {
	     		if(cda.isEmpty()) {
	     			break;
	     		} else {
	         		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Panel().getType())) {
	         			continue;
	         		}
	         		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Next().getType())) {
	         			continue;
	         		}
	         		if(normal.getItem(i) != null && normal.getItem(i).getType().equals(colorform.Prev().getType())) {
	         			continue;
	         		}
	         		normal.setItem(i, colorform.generateColorDisplay(cda.get(0), p));
	         		cda.remove(0);
	     		}
	     	}

			p.openInventory(normal);
			
	}
}
