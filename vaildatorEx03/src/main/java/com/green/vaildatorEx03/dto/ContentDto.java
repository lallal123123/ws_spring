package com.green.vaildatorEx03.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentDto {

	private int id;
	
	@NotNull(message="writer is null.")
	@NotEmpty(message="writer is empty.")
	@Size(min=3, max=10, message="writer min3,max 10.")
	private String writer;
	
	@NotNull(message="content is null.")
	@NotEmpty(message="content is empty.")
	private String content;
}
