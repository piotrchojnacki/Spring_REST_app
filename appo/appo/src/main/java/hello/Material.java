package hello;

public class Material extends MaterialSmall {
    
    private final String description;
    private final String notes;
    private final String supplier;
    private final Integer price;
    private final String currency;
    
    public Material(String name, Integer id, Integer companyID, String description, String notes, String supplier, Integer price, String currency) {
	    super(name, id, companyID);
	  	this.description = description;
	  	this.notes = notes;
	  	this.supplier = supplier;
	  	this.price = price;
	  	this.currency = currency;
    }
	
    public String getName() {
		return super.getName();
	}

	public Integer getId() {
		return super.getId();
	}
	
	public Integer getCompanyID() {
		return super.getCompanyID();
	}

	public String getDescription() {
		return description;
	}

	public String getNotes() {
		return notes;
	}

	public String getSupplier() {
		return supplier;
	}

	public Integer getPrice() {
		return price;
	}

	public String getCurrency() {
		return currency;
	}

}
