package hello;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.Material;
import hello.MaterialDAO;

@RestController
public class MaterialController {
	
 //   @RequestMapping("/materialList")
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	public List<Material> getMaterialList() {  
//		List<Material> list = MaterialDAO.getAllMaterials();
//		return list;  	  
//	}
    
	@RequestMapping("/materialList")	
	public List<MaterialSmall> getMaterial(@RequestParam(value="id", defaultValue="-1") String name, @RequestParam(value="companyID", defaultValue="-1") String company) {
        if (!name.equals("-1")) {
        	List<MaterialSmall> result = new ArrayList<MaterialSmall>();
        	result.add(MaterialDAO.getMaterialSmall(name));
        	return result;
        }
        else if (!company.equals("-1")) {
        	return MaterialDAO.getMaterialByCompanyIDSmall(company);
        }        
        else {
        	List<MaterialSmall> list = MaterialDAO.getAllMaterials();
    		return list; 
        }     	
        
    }
	
	@RequestMapping("/materialDetails")
	public Material getMaterial(@RequestParam(value="id", defaultValue="-1") String name) {
		return MaterialDAO.getMaterial(name);
	}
	
	
	
	
	
	@RequestMapping(value = "/materialList", method = RequestMethod.POST)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Material add(@RequestBody String m) { 
		Material material = null;
		if (m != null) {
			org.springframework.http.MediaType mediaType = new org.springframework.http.MediaType("application", "json");
		    HttpHeaders responseHeaders = new HttpHeaders();
		    responseHeaders.setContentType(mediaType);
		    
		    JSONObject json = new JSONObject(m);
		    material = new Material(					 json.get("name").toString(), 
		    							Integer.parseInt(json.get("id").toString()), 
		    							Integer.parseInt(json.get("materialID").toString()),
		    											 json.get("description").toString(),
		    											 json.get("notes").toString(),
		    											 json.get("supplier").toString(),
		    							Integer.parseInt(json.get("price").toString()), 
		    											 json.get("currency").toString());
		    MaterialDAO.addMaterial(material);
	    }
		
		return material;
	}
	
	@RequestMapping(value = "/materialList", method = RequestMethod.DELETE)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ResponseEntity<String> delete(@RequestBody String m) { 
		MaterialDAO.deleteMaterial(m);
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/materialList", method = RequestMethod.PUT)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Material update(@RequestBody String m) { 
		Material material = null;
		if (m != null) {
			org.springframework.http.MediaType mediaType = new org.springframework.http.MediaType("application", "json");
		    HttpHeaders responseHeaders = new HttpHeaders();
		    responseHeaders.setContentType(mediaType);
		    
		    JSONObject json = new JSONObject(m);
		    material = new Material(					 json.get("name").toString(), 
					Integer.parseInt(json.get("id").toString()), 
					Integer.parseInt(json.get("materialID").toString()),
									 json.get("description").toString(),
									 json.get("notes").toString(),
									 json.get("supplier").toString(),
					Integer.parseInt(json.get("price").toString()), 
									 json.get("currency").toString());
		    MaterialDAO.updateMaterial(material);
	    }
		
		return material;
	}

}
