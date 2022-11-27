//package com.dh.proyect.DentalAppoiments.services;
//import com.dh.proyect.DentalAppoiments.repository.IDao;
//import com.dh.proyect.DentalAppoiments.model.Patient;
//import org.apache.log4j.Logger;
//import java.util.List;
//
//public class PatientService {
//
//        private static final Logger LOGGER = Logger.getLogger(PatientService.class);
//    private final IDao<Patient> patientDao;
//
//    //Constructor
//    public PatientService(IDao<Patient> patientDao) {
//        this.patientDao = patientDao;
//    }
//
//    // List patient
//    public List<Patient> listPatient() {
//        LOGGER.info("List Patient" );
//        return patientDao.list();
//    }
//    // Creating patient
//    public Patient createPatient(Patient patient) {
//        return patientDao.create(patient);
//    }
//
//    // Save patient by id
//    public Patient saveById(Long id){
//        return patientDao.saveById(id);
//    }
//
//    //Find patient by id
//    public Patient findPatient(Long id){
//        return patientDao.findById(id);
//    }
//    //Modifying patient
//    public Patient modifyPatient(Long id){
//        return patientDao.modifyById(id);
//    }
//
//    // Delete patient
//    public Patient deletePatient(Long id) {
//        return patientDao.deleteById(id);
//    }
//
//}
//

