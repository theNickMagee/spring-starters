package dpi.api.field;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dpi.api.category.Category;
import dpi.api.domain.DomainRepository;
import dpi.api.domain.DomainService;



@Service
public class FieldService {

	@Autowired
	private FieldRepository fieldRepository;
	
	@Autowired
	private DomainService domainService;
	
	@Autowired
	private DomainRepository domainRepository;

//	public List<Field> getFieldsInDomain(int id) {
//		return fieldRepository.findByDomainId(id);
//	}

	public List<Field> getAllFields() {
		List<Field> fields = new ArrayList<>();
		fieldRepository.findAll().forEach(fields::add);
		return fields;
	}
	
	public void setFieldsForDomain(int[] fieldIds, int domainId) {
		
		//set domain fields to fields
//		List<Field> fields = new ArrayList<>();
//		for (int i = 0; i < fieldIds.length; i++) {
//			fields.add(fieldRepository.getById(fieldIds[i]));
//		}
//		Set<Field> fieldsSet = new HashSet<Field>(fields);
//		domainService.getDomain(domainId).setFields(fieldsSet);
//		domainRepository.save(domainService.getDomain(domainId));
		List<Field> fields = getAllFields();
		for (Field f : fields) {
			if (f.getDomains().contains(domainService.getDomain(domainId))) {
				f.getDomains().remove(domainService.getDomain(domainId));
				fieldRepository.save(f);
			}
		}
		
		//set our domains as domains
		for (int i = 0; i < fieldIds.length; i++) {
			fieldRepository.getById(fieldIds[i]).getDomains().add(domainService.getDomain(domainId));
			fieldRepository.save(fieldRepository.getById(fieldIds[i]));
		}
	}

	public void deleteField(int id) {
		fieldRepository.deleteById(id);
		
	}

	public void createField(Field field) {
		fieldRepository.save(field);
	}

	public List<Field> getFieldsInDomain(int domainId) {
		List<Field> fields = new ArrayList<>();
		List<Field> selected = new ArrayList<>();
		fieldRepository.findAll().forEach(fields::add);
		for (Field f : fields) {
			if (f.getDomains().contains(domainService.getDomain(domainId))){
				selected.add(f);
			}
		}
		return selected;
	}
	
	
}
