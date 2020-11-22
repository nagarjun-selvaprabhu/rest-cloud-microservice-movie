package com.nagarjun.cts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.TypeAlias;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Getter
	@Setter
	@NotBlank(message = "name is mandatory")
	private String name;
	@Getter
	@Setter
	@NotBlank(message = "lang is mandatory")
	private String lang;
	@Getter
	@Setter
	@NotBlank(message = "v is mandatory")
	private String genre;

}
