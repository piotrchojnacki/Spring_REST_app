package hello;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyDAO {
	
	private static final Map<String, Company> comMap = new HashMap<String, Company>();
	
	static {
        initEmps();
    }
 
    private static void initEmps() {
    	Company c1 = new Company(1, "Tire Systems");
    	Company c2 = new Company(2, "IT Enterprise");
    	Company c3 = new Company(3, "Car Manufacture");
    	Company c4 = new Company(4, "Electro Market");
 
        comMap.put(String.valueOf(c1.getCompanyID()), c1);
        comMap.put(String.valueOf(c2.getCompanyID()), c2);
        comMap.put(String.valueOf(c3.getCompanyID()), c3);
        comMap.put(String.valueOf(c4.getCompanyID()), c4);
    }
 
    public static Company getComany(String No) {
        return comMap.get(No);
    }
 
    public static Company addCompany(Company c) {
    	comMap.put(String.valueOf(c.getCompanyID()), c);
        return c;
    }
 
    public static Company updateCompany(Company c) {
        comMap.put(String.valueOf(c.getCompanyID()), c);
        return c;
    }
 
    public static void deleteCompany(String No) {
        comMap.remove(No);
    }
 
    public static List<Company> getAllCompanies() {
        Collection<Company> c = comMap.values();
        List<Company> list = new ArrayList<Company>();
        list.addAll(c);
        return list;
    }

}
