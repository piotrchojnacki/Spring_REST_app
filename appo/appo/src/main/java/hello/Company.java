package hello;

public class Company {

    private final String companyName;
    private final Integer companyID;

    public Company(Integer companyID, String companyName) {
    	this.companyName = companyName;
    	this.companyID = companyID;
    }
    
    public String getCompanyName() {
    	return companyName;
    }
    
    public Integer getCompanyID() {
    	return companyID;
    }
}
