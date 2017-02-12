package hello;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.Company;
import hello.CompanyDAO;

@RestController
public class CompanyController {

    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";    	
    }
    
    @RequestMapping("/companyList")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Company> getCompanyList() {  
		List<Company> list = CompanyDAO.getAllCompanies();
		return list;  	  
	}
	
	@RequestMapping("/company")	
	public Company getCompany(@RequestParam(value="id", defaultValue="1") String name) {
        return CompanyDAO.getComany(name);
    }
	
	@RequestMapping(value = "/companyList", method = RequestMethod.POST)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Company add(@RequestBody String c) { 
		Company company = null;
		if (c != null) {
			org.springframework.http.MediaType mediaType = new org.springframework.http.MediaType("application", "json");
		    HttpHeaders responseHeaders = new HttpHeaders();
		    responseHeaders.setContentType(mediaType);
		    
		    JSONObject json = new JSONObject(c);
		    company = new Company(Integer.parseInt(json.get("companyID").toString()), json.get("companyName").toString());
		    CompanyDAO.addCompany(company);
	    }
		
		return company;
	}
		
	@RequestMapping(value = "/companyList", method = RequestMethod.DELETE)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ResponseEntity<String> delete(@RequestBody String c) { 
		CompanyDAO.deleteCompany(c);
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/companyList", method = RequestMethod.PUT)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Company update(@RequestBody String c) { 
		Company company = null;
		if (c != null) {
			org.springframework.http.MediaType mediaType = new org.springframework.http.MediaType("application", "json");
		    HttpHeaders responseHeaders = new HttpHeaders();
		    responseHeaders.setContentType(mediaType);
		    
		    JSONObject json = new JSONObject(c);
		    company = new Company(Integer.parseInt(json.get("companyID").toString()), json.get("companyName").toString());
		    CompanyDAO.updateCompany(company);
	    }
		
		return company;
	}
}
