//package com.dh.proyect.DentalAppoiments.services;
//import com.dh.proyect.DentalAppoiments.repository.IDao;
//import com.dh.proyect.DentalAppoiments.model.Appointment;
//
//import java.util.List;
//
//public class AppointmentService {
//
//    private final IDao<Appointment> appointmentIDao;
//
//    public AppointmentService(IDao<Appointment> appointmentIDao) {
//        this.appointmentIDao = appointmentIDao;
//    }
//
//    // List appointment
//    public List<Appointment> list() {
//        return appointmentIDao.list();
//
//    }
//// Find Appointment
//    public  Appointment findAppointmentByID(Long id) {
//        return appointmentIDao.findById(id);
//    }
//
//    // Save Appointment by id
//    public Appointment saveById(Long id){
//        return appointmentIDao.saveById(id);
//    }
//
//    // Creating Appointment
//    public Appointment createAppointment(Appointment appointment) {
//        return appointmentIDao.create(appointment);
//    }
//
//    //Modifying Appointment
//    public Appointment modifyAppointment(Long id) {
//        return appointmentIDao.modifyById(id);
//    }
//
//    // Delete Appointment
//    public Appointment deleteAppoitment(Long id) {
//        return appointmentIDao.deleteById(id);
//    }
//
//}
//
