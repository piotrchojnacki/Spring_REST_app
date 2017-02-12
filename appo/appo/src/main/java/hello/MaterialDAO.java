package hello;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaterialDAO {
	
	private static final Map<String, Material> comMapMatId = new HashMap<String, Material>();
	private static final Map<String, Material> comMapComId = new HashMap<String, Material>();
	
	static {
        initEmps();
    }
	
    private static void initEmps() {
    	Material m1 = new Material("Winter Tire", 1, 1,"Perfect Winter Tires.", "None", "Tire Systems", 99, "EUR");
    	Material m2 = new Material("Summer Tire", 2, 1, "Premium Summer Tires.", "Good price", "Tire Systems", 79, "EUR");
    	Material m3 = new Material("Tire", 3, 1, "Tires.", "None", "Tire Systems", 129, "EUR");
    	Material m4 = new Material("Reporting Software", 4, 2, "Software for reporting.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", "IT Enterprise", 732, "EUR");
    	Material m5 = new Material("Text Editor", 5, 2, "Simple text editor.", "None", "IT Enterprise", 99, "PLN");
    	Material m6 = new Material("Passenger Car", 6, 3, "Super fast car for 4 people.", "Warranty for 5 years.", "Car Manufacture", 25000, "EUR");
    	Material m7 = new Material("Truck", 7, 3, "Perfect Truck for your Perfect Company.", "Warranty for 10 years.", "Car Manufacture", 45000, "EUR");
    	Material m8 = new Material("Pickupe", 8, 3, "Best Pickup EVER.", "Warranty for 5 years.", "Car Manufacture", 36000, "EUR");
    	Material m9 = new Material("Laptop", 9, 4, "Get ultra performence with our ULTRA-LAPTOP.", "OS not included.", "Electro Market", 1000, "EUR");
    	Material m10 = new Material("Smartphone", 10, 4, "Thin Smartphone, big deal.", "None", "Electro Market", 500, "EUR");
    	Material m11 = new Material("Tablet", 11, 4, "Tablet for everyone.", "Good price", "Electro Market", 300, "EUR");
 
    	comMapMatId.put(String.valueOf(m1.getId()), m1);
    	comMapMatId.put(String.valueOf(m2.getId()), m2);
    	comMapMatId.put(String.valueOf(m3.getId()), m3);
    	comMapMatId.put(String.valueOf(m4.getId()), m4);
    	comMapMatId.put(String.valueOf(m5.getId()), m5);
    	comMapMatId.put(String.valueOf(m6.getId()), m6);
    	comMapMatId.put(String.valueOf(m7.getId()), m7);
    	comMapMatId.put(String.valueOf(m8.getId()), m8);
    	comMapMatId.put(String.valueOf(m9.getId()), m9);
    	comMapMatId.put(String.valueOf(m10.getId()), m10);
    	comMapMatId.put(String.valueOf(m11.getId()), m11);  
    	
    	comMapComId.put(String.valueOf(m1.getCompanyID()), m1);
    	comMapComId.put(String.valueOf(m2.getCompanyID()), m2);
    	comMapComId.put(String.valueOf(m3.getCompanyID()), m3);
    	comMapComId.put(String.valueOf(m4.getCompanyID()), m4);
    	comMapComId.put(String.valueOf(m5.getCompanyID()), m5);
    	comMapComId.put(String.valueOf(m6.getCompanyID()), m6);
    	comMapComId.put(String.valueOf(m7.getCompanyID()), m7);
    	comMapComId.put(String.valueOf(m8.getCompanyID()), m8);
    	comMapComId.put(String.valueOf(m9.getCompanyID()), m9);
    	comMapComId.put(String.valueOf(m10.getCompanyID()), m10);
    	comMapComId.put(String.valueOf(m11.getCompanyID()), m11);
    }
    
    public static Material getMaterial(String No) {
        return comMapMatId.get(No);
    }
    
    public static MaterialSmall getMaterialSmall(String No) {
        Material mat = comMapMatId.get(No);
        return new MaterialSmall(mat.getName(), mat.getId(), mat.getCompanyID());
    }   

    
    public static List<Material> getMaterialByCompanyID(String No) {
    	 Collection<Material> m = comMapMatId.values();
         List<Material> list = new ArrayList<Material>();
         list.addAll(m);
         List<Material> result = new ArrayList<Material>();
         
 		for (Material mat : list) {
			if(mat.getCompanyID().toString().equals(No))
				result.add(mat);
		}
         
         return result;         
    }
    
    public static List<MaterialSmall> getMaterialByCompanyIDSmall(String No) {
    	 Collection<Material> m = comMapMatId.values();
         List<Material> list = new ArrayList<Material>();
         list.addAll(m);
         List<MaterialSmall> result = new ArrayList<MaterialSmall>();
         
 		for (Material mat : list) {
			if(mat.getCompanyID().toString().equals(No))
				result.add(new MaterialSmall(mat.getName(), mat.getId(), mat.getCompanyID()));
		}
         
         return result;         
    }
    
    public static Material addMaterial(Material m) {
    	comMapMatId.put(String.valueOf(m.getId()), m);
        return m;
    }
    
    public static Material updateMaterial(Material m) {
    	comMapMatId.put(String.valueOf(m.getCompanyID()), m);
        return m;
    }
    
    public static void deleteMaterial(String No) {
    	comMapMatId.remove(No);
    }
    
    public static List<MaterialSmall> getAllMaterials() {
        Collection<Material> m = comMapMatId.values();
        List<Material> list = new ArrayList<Material>();
        list.addAll(m);
        
        List<MaterialSmall> result = new ArrayList<MaterialSmall>();
        
        for (Material mat : list) {
			result.add(new MaterialSmall(mat.getName(), mat.getId(), mat.getCompanyID()));
		}
        
        return result;
    }
    
    

	
}
