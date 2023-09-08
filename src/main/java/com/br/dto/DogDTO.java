package com.br.dto;

import org.springframework.beans.BeanUtils;

import com.br.entities.Dog;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DogDTO {

	private Long id;
	private String nome;
	private String especie;
	private String genero;
	private String idade;
	private String raca;
	private String porte;
	private String peso;
	private String castrado;
	private String vacinado;
	private String descricaoPet;

	public DogDTO(Dog entity) {
		BeanUtils.copyProperties(entity, this);
	}

}
