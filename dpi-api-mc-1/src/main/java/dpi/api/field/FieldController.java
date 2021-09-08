package dpi.api.field;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dpi.api.domain.DomainService;




@RestController
public class FieldController {

	@Autowired
	private FieldService fieldService;
	
	@Autowired
	private DomainService domainService;
	
	@RequestMapping("/domains/{id}/fields")
	public List<Field> getFieldsInDomain(@PathVariable int id) {
		return fieldService.getFieldsInDomain(id);
	}
	
	@RequestMapping("/domains/fields")
	public List<Field> getAllFields() {
		return fieldService.getAllFields();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/domains/fields/{id}")
	public void deleteField( @PathVariable int id) {
		fieldService.deleteField(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/domains/{id}/fields")
	public void addDomain(@RequestBody Field field, @PathVariable int id) {
		field.setDomain(domainService.getDomain(id));
		fieldService.createField(field);
	}
	
	
}
