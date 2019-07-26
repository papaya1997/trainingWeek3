package com.visa.prj.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.visa.prj.entity.Product;

@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Product.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "name.empty","name cant be empty");
		ValidationUtils.rejectIfEmpty(errors, "category", "category.empty","Category cant be empty");
		Product p = (Product) target;
		if(p.getPrice() <=0) {
			errors.rejectValue("price", "price.invalid","price should be positive value");
		}

	}

}
