package com.edix.gestion.utils;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import com.edix.gestion.dto.BonoDto;
import com.edix.gestion.dto.ClienteDto;
import com.edix.gestion.dto.ConsultaDto;
import com.edix.gestion.dto.NutricionistaDto;
import com.edix.gestion.dto.custom.NutricionistaFactGlobalDto;
import com.edix.gestion.entity.Bono;
import com.edix.gestion.entity.Cliente;
import com.edix.gestion.entity.Consulta;
import com.edix.gestion.entity.Nutricionista;
import com.edix.gestion.entity.custom.NutricionistaFactGlobal;

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

	@Override
	public List<NutricionistaFactGlobalDto> listNutricionistaFactGlobal_NutricionistaFactGlobalDto(
			List<NutricionistaFactGlobal> nutricionistas) {
		return mapper.map(nutricionistas, new TypeToken<List<NutricionistaFactGlobalDto>>() {
		}.getType());
	}

	@Override
	public NutricionistaFactGlobalDto nutricionistaFactGlobal_NutricionistaFactGlobalDto(
			NutricionistaFactGlobal nutricionista) {
		return mapper.map(nutricionista, NutricionistaFactGlobalDto.class);
	} 
	
	@Override
	public ConsultaDto consultaEntity_consultaDto(Consulta consulta) {
		return mapper.map(consulta, ConsultaDto.class);
	}

	@Override
	public List<ConsultaDto> listConsultaEntity_ConsultaDto(List<Consulta> consultas) {
		return mapper.map(consultas, new TypeToken<List<ConsultaDto>>() {
		}.getType());
	}

	@Override
	public List<BonoDto> listBonoEntity_bonoDto(List<Bono> bono) {
		return mapper.map(bono, new TypeToken<List<Bono>>() {
		}.getType());
	}

	@Override
	public List<ClienteDto> listclienteEntity_clienteDto(List<Cliente> cliente) {
		return mapper.map(cliente, new TypeToken<List<Cliente>>() {
		}.getType());
	}


}
