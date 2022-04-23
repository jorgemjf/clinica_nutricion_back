package com.edix.gestion.utils;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import com.edix.gestion.dto.NutricionistaDto;
import com.edix.gestion.entity.Nutricionista;

@Component
public class TransformationImpl implements Transformation{
	
	private ModelMapper mapper;
	
	public TransformationImpl() {
		mapper = new ModelMapper();
	}

	@Override
	public List<NutricionistaDto> listNutricionistaEntity_NutricionistaDto(List<Nutricionista> nutricionistas) {
		return mapper.map(nutricionistas, new TypeToken<List<NutricionistaDto>>() {
		}.getType());
	}

	@Override
	public NutricionistaDto nutricionistaEntity_NutricionistaDto(Nutricionista nutricionista) {
		return mapper.map(nutricionista, NutricionistaDto.class);
	} 

}
