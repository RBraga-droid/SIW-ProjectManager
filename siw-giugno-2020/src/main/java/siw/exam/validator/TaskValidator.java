package siw.exam.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import siw.exam.model.Task;
@Component
public class TaskValidator implements Validator{
	final Integer MAX_NAME_LENGTH = 100;
	final Integer MIN_NAME_LENGTH = 2;
	final Integer MAX_DESCRIPTION_LENGTH = 200;
	final Integer MIN_DESCRIPTION_LENGTH = 0;
	@Override
	public boolean supports(Class<?> clazz) {
		return Task.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Task task = (Task)target;
		String name = task.getName().trim();
		String description =task.getDescription().trim();
		
		if(name.trim().isEmpty())
			errors.rejectValue("taskName", "required");
		else if (name.length()<MIN_NAME_LENGTH || name.length()>MAX_NAME_LENGTH)
			errors.rejectValue("taskName", "size");
		
		if(description.trim().isEmpty())
			errors.rejectValue("description", "required");
		else if (description.length()<MIN_DESCRIPTION_LENGTH || description.length()>MAX_DESCRIPTION_LENGTH)
			errors.rejectValue("description", "size");
	}

}