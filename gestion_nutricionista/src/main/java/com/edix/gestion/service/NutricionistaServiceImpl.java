package com.edix.gestion.service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.edix.gestion.entity.Nutricionista;
import com.edix.gestion.entity.custom.NutricionistaFactGlobal;
import com.edix.gestion.repository.NutricionistaRepository;

@Service
public class NutricionistaServiceImpl implements NutricionistaService{
	
	@Autowired
	private NutricionistaRepository nutriRepo;

	@Override
	public Optional<List<Nutricionista>> findAllNutricionistas() {
		return Optional.of(((JpaRepository<Nutricionista, Integer>) nutriRepo).findAll());
	}

	@Override
	public Optional<Nutricionista> findNutricionista(Integer id) {
		return ((CrudRepository<Nutricionista, Integer>) nutriRepo).findById(id);
	}

	@Override
	public Optional<List<NutricionistaFactGlobal>> getAllFacturacionDeNutricionistas(Date fechaMin, Date fechaMax) {
		return nutriRepo.getAllFacturacionNutricionistas(fechaMin, fechaMax);
	}

	@Override
	public Optional<List<NutricionistaFactGlobal>> getAllFacturacionDeNutricionistasMesActual() {
		Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date firstDayMonth = (Date) calendar.getTime();
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date lastDayMonth = (Date) calendar.getTime();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String startDateStr = df.format(firstDayMonth);
        String endDateStr = df.format(lastDayMonth);
		System.out.println("Primer dia: " + startDateStr + "ultimo dia: " + endDateStr);
		return nutriRepo.getAllFacturacionNutricionistasMesActual(firstDayMonth, lastDayMonth);
	}

	@Override
	public Optional<NutricionistaFactGlobal> getFacturacionNutricionistaMesActual(Integer id) {
		Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date firstDayMonth = (Date) calendar.getTime();
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date lastDayMonth = (Date) calendar.getTime();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String startDateStr = df.format(firstDayMonth);
        String endDateStr = df.format(lastDayMonth);
		System.out.println("Primer dia: " + startDateStr + "ultimo dia: " + endDateStr);
		return nutriRepo.getFacturacionNutricionistaMesActual_Id(id, firstDayMonth, lastDayMonth);
	}

	@Override
	public Optional<NutricionistaFactGlobal> getFacturacionNutricionistaPorFecha(Date fechaMin, Date fechaMax,
			Integer id) {
		return nutriRepo.getFacturacionNutricionistaPorFecha_Id(fechaMin, fechaMax, id);
	}

	@Override
	public Optional<List<NutricionistaFactGlobal>> getAllFacturacionDeNutricionistasDiaActual() {
		Calendar calendar = Calendar.getInstance();
	    int year = calendar.get(Calendar.YEAR);
	    int month = calendar.get(Calendar.MONTH);
	    int day = calendar.get(Calendar.DATE);
	    calendar.set(year, month, day, 0, 0, 0);
	    Date startOfDay = calendar.getTime();
	    
	    Calendar calendar2 = Calendar.getInstance();
	    int year2 = calendar2.get(Calendar.YEAR);
	    int month2 = calendar2.get(Calendar.MONTH);
	    int day2 = calendar2.get(Calendar.DATE);
	    calendar2.set(year2, month2, day2, 23, 59, 59);
	    Date endOfDay = calendar2.getTime();
	    System.out.println("primera hora: " + startOfDay + "ultima hora: " + endOfDay);
		return nutriRepo.getAllFacturacionNutricionistasDiaActual(startOfDay, endOfDay);
	}

	@Override
	public Nutricionista findById(int idNutricionista) {
		return nutriRepo.findById(idNutricionista).orElse(null);
	}

	@Override
	public int altaNutricionista(Nutricionista nutricionista) {
		if (findById(nutricionista.getIdNutricionista()) == null) {
			nutriRepo.save(nutricionista);
			return 0;
		}
		return 1;
	}

	@Override
	public int updateNutricionista(Nutricionista nutricionista) {
		if (findById(nutricionista.getIdNutricionista()) != null) {
			nutriRepo.save(nutricionista);
			return 0;
		}
		return 1;
	}

	@Override
	public int eliminarNutricionista(int idNutricionista) {
		if (findById(idNutricionista) != null) {
			nutriRepo.deleteById(idNutricionista);
			return 0;
		}
		return 1;
	}

}
