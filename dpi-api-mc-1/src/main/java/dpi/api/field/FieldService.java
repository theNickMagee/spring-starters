package dpi.api.field;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class FieldService {

	@Autowired
	private FieldRepository fieldRepository;

//	public List<Field> getFieldsInDomain(int id) {
//		return fieldRepository.findByDomainId(id);
//	}

	public List<Field> getAllFields() {
		List<Field> fields = new ArrayList<>();
		fieldRepository.findAll().forEach(fields::add);
		return fields;
	}

	public void deleteField(int id) {
		fieldRepository.deleteById(id);
		
	}

	public void createField(Field field) {
		fieldRepository.save(field);
	}
	
	
}
