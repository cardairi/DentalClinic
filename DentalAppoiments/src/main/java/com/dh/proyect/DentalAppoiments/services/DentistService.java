package com.dh.proyect.DentalAppoiments.services;

import com.dh.proyect.DentalAppoiments.model.Dentist;
import com.dh.proyect.DentalAppoiments.repository.IDao;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class DentistService implements IDentistService {

    private final IDao <Dentist> dentistIDao;
   public DentistService(DentistRepository dentistH2Dao) {
       this.dentistIDao = dentistH2Dao;
    }

    @Override
    public List<Dentist> listDentist() {
        return null;
    }

    @Override
    public Dentist saveDentist(Dentist dentist) {
        return dentistIDao.save(dentist);

    }
    @Override
    public Dentist findDentist(Long id) {
        return null;
    }

    @Override
    public Dentist modifyDentist(Long id) {
        return null;
    }

    @Override
    public void deleteDentist(Long id) {

    }
}
