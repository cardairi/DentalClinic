package com.dh.proyect.DentalAppoiments.services;
import com.dh.proyect.DentalAppoiments.entities.Dentist;
import com.dh.proyect.DentalAppoiments.repository.impl.DentistRepository;
import com.dh.proyect.DentalAppoiments.services.dto.DentistDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Service
public class DentistService implements IDentistService {
    @Autowired
    ObjectMapper mapper;
    @Autowired
    private DentistRepository dentistRepository;

    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    //Logger methods
    private static final Logger LOGGER = LogManager.getLogger(DentistService.class);

    // List dentist
    @Override
    public Set<DentistDto> listDentist() {
        List<Dentist> dentistEntityList = dentistRepository.findAll();
        Set<DentistDto> dentistDto = new HashSet<>();
        for (Dentist d : dentistEntityList) {
            dentistDto.add(mapper.convertValue(d, DentistDto.class));
        }
        return dentistDto;
    }

    // Creating dentist
    @Override
    public DentistDto createDentist(DentistDto dentistDto) {
        Dentist dentist =  mapper.convertValue(dentistDto, Dentist.class);
        dentistRepository.save(dentist);
        DentistDto dentistDto1 = mapper.convertValue(dentist, DentistDto.class);
        return dentistDto1;
    }

    //Find dentist by id
    @Override
    public DentistDto findDentist(Long id) {
        DentistDto dentistDto = null;
        Optional<Dentist> dentistToFound = dentistRepository.findById(id);
        if (dentistToFound.isPresent()) {
            LOGGER.info("The dentist was found with id: " + id);
            return dentistDto = mapper.convertValue(dentistToFound, DentistDto.class);
        } else {
            LOGGER.info("No dentists were found with id: " + id);
        }
        return dentistDto;
    }

    //Modifying dentist by id
    @Override
    public DentistDto modifyDentist(Long id, DentistDto dentistDto) {
        DentistDto dentistDtoModify = null;
        Optional<Dentist> dentistToModify = dentistRepository.findById(id);
        if (dentistToModify.isPresent()) {
            dentistToModify .get().setName(dentistDto.name != null ? dentistDto.name : dentistToModify.get().getName());
            dentistToModify .get().setLastName(dentistDto.lastName != null ? dentistDto.lastName : dentistToModify .get().getLastName());
            LOGGER.info("The dentist was updated with id: " + id);
            dentistDtoModify =  mapper.convertValue(dentistToModify, DentistDto.class);
        } else {
            LOGGER.error("No dentists were found with id: " + id);
    }
        return dentistDto;
    }

    // Delete dentist by id
    @Override
    public void deleteDentist(Long id) {
        DentistDto dentistDtoDelete = null;
        Optional<Dentist> dentist = dentistRepository.findById(id);
        if (dentist.isPresent()) {
            LOGGER.info("The dentist was deleted");
            dentistRepository.deleteById(id);
        }
    }
}
