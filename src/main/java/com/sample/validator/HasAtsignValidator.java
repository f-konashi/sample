package com.sample.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HasAtsignValidator implements ConstraintValidator<HasAtsign, String> {

	@Override
	public void initialize(HasAtsign annotation) {

	}

	/**
	 * 入力された値に「@(アットマーク)」が存在するか、正規表現で確認します.
	 * フォームに値が入力されている場合、バリデーションを行いません.
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.length() == 0 ) {
			return true;
		}
		return value.matches("^.*@.*");
	}
}
