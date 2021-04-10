package com.ronaldo.CursoMc.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.ronaldo.CursoMc.domain.Cliente;
import com.ronaldo.CursoMc.dto.ClienteDTO;
import com.ronaldo.CursoMc.repositories.ClienteRepository;
import com.ronaldo.CursoMc.resources.exception.FieldMessage;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteIUpdate,ClienteDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	
	@Autowired
	private ClienteRepository repo;
	@Override
	public void initialize(ClienteIUpdate ann) {
	} 

	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map= (Map<String, String> )request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		
		Integer uriId= Integer.parseInt(map.get("Id"));
				
		List<FieldMessage> list = new ArrayList<>();

		
        Cliente aux= repo.findByEmail(objDto.getEmail());
        if(aux!=null && !aux.getId().equals(uriId)) {
        	list.add(new FieldMessage("Email","Email ja existente"));
        }
		

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getFieldMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
