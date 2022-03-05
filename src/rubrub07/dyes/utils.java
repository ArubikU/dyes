package rubrub07.dyes;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class utils {

	static Set<String> codes = colorform.codes();
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
		codes = colorform.codes();
		Inventory normal = Bukkit.createInventory(null, 54, "Tintes - 1");
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
			normal.setItem(54, colorform.Next());
		}
		
		for(int i= 10; i<43; i++) {
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
			
			normal.setItem(i, colorform.generateColorDisplay(cda.get(0)));
			cda.remove(0);
		}
		p.openInventory(normal);
	}

    public static void openInventoryTwo(Player p){
		cda = colorform.codesl();
		codes = colorform.codes();
     	Inventory normal = Bukkit.createInventory(null, 54, "Tintes - 2");
     	
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
     		normal.setItem(54, colorform.Next());
     	}
         
     	normal.setItem(45, colorform.Prev());
     	
     	for(int i= 10; i<43; i++) {
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
     		
     		normal.setItem(i, colorform.generateColorDisplay(cda.get(29)));
     		cda.remove(0);
     	}
		p.openInventory(normal);
    }
	
    public static void openInventoryTree(Player p){
		cda = colorform.codesl();
		codes = colorform.codes();
     	Inventory normal = Bukkit.createInventory(null, 54, "Tintes - 3");
     	
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
     		normal.setItem(54, colorform.Next());
     	}
     	
     	normal.setItem(45, colorform.Prev());
     	
     	for(int i= 10; i<43; i++) {
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
     		
     		normal.setItem(i, colorform.generateColorDisplay(cda.get(57)));
     		cda.remove(0);
     	}
		p.openInventory(normal);
    }

    public static void openInventoryFour(Player p){
		cda = colorform.codesl();
		codes = colorform.codes();
        	Inventory normal = Bukkit.createInventory(null, 54, "Tintes - 4");
        	
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
        		normal.setItem(54, colorform.Next());
        	}
        	
        	normal.setItem(45, colorform.Prev());
        	
        	for(int i= 10; i<43; i++) {
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
        		
        		normal.setItem(i, colorform.generateColorDisplay(cda.get(85)));
                cda.remove(0);
            }
			p.openInventory(normal);
        }

    public static void openInventoryFive(Player p){
		cda = colorform.codesl();
		codes = colorform.codes();
            Inventory normal = Bukkit.createInventory(null, 54, "Tintes - 5");

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
            	normal.setItem(54, colorform.Next());
            }

            normal.setItem(45, colorform.Prev());

            for(int i= 10; i<43; i++) {
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
            
            	normal.setItem(i, colorform.generateColorDisplay(cda.get(113)));
                cda.remove(0);
            }
			p.openInventory(normal);
    }

    public static void openInventorySix(Player p){
		cda = colorform.codesl();
		codes = colorform.codes();
            Inventory normal = Bukkit.createInventory(null, 54, "Tintes - 6");

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
            	normal.setItem(54, colorform.Next());
            }

            normal.setItem(45, colorform.Prev());

            for(int i= 10; i<43; i++) {
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
            
            	normal.setItem(i, colorform.generateColorDisplay(cda.get(141)));
                cda.remove(0);
            }
			p.openInventory(normal);
    }

    public static void openInventorySeven(Player p){
		cda = colorform.codesl();
		codes = colorform.codes();
            Inventory normal = Bukkit.createInventory(null, 54, "Tintes - 7");

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
            	normal.setItem(54, colorform.Next());
            }

            normal.setItem(45, colorform.Prev());

            for(int i= 10; i<43; i++) {
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
            
            	normal.setItem(i, colorform.generateColorDisplay(cda.get(169)));
                cda.remove(0);
            }

			p.openInventory(normal);
    }

    public static void openInventoryEight(Player p){
		cda = colorform.codesl();
		codes = colorform.codes();
            Inventory normal = Bukkit.createInventory(null, 54, "Tintes - 8");

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
            	normal.setItem(54, colorform.Next());
            }

            normal.setItem(45, colorform.Prev());

            for(int i= 10; i<43; i++) {
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
            
            	normal.setItem(i, colorform.generateColorDisplay(cda.get(197)));
                cda.remove(0);
            }
			p.openInventory(normal);

    }

    public static void openInventoryNine(Player p){
		cda = colorform.codesl();
		codes = colorform.codes();
            Inventory normal = Bukkit.createInventory(null, 54, "Tintes - 9");

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
            	normal.setItem(54, colorform.Next());
            }

            normal.setItem(45, colorform.Prev());

            for(int i= 10; i<43; i++) {
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
            
            	normal.setItem(i, colorform.generateColorDisplay(cda.get(225)));
                cda.remove(0);
            }
			p.openInventory(normal);


    }

    public static void openInventoryTen(Player p){
		cda = colorform.codesl();
		codes = colorform.codes();
			Inventory normal = Bukkit.createInventory(null, 54, "Tintes - 10");

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

			for(int i= 10; i<43; i++) {
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
			
				normal.setItem(i, colorform.generateColorDisplay(cda.get(253)));
				cda.remove(0);
			}

			p.openInventory(normal);
			
	}
}
