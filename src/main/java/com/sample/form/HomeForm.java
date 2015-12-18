package com.sample.form;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.sample.validator.HasAtsign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeForm implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String keyword;
	
	@Min(0)
	@HasAtsign
	private String price;
}
