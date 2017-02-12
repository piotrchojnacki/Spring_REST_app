package hello;

public class MaterialSmall {
	private final String name;
    private final Integer id;
    private final Integer companyID;
    
    public MaterialSmall(String name, Integer id, Integer companyID) {
    	this.name = name;
    	this.id = id;
    	this.companyID = companyID;
    }
    
    public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}
	
	public Integer getCompanyID() {
		return companyID;
	}
}
