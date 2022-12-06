package com.dh.proyect.DentalAppoiments.services;
import com.dh.proyect.DentalAppoiments.services.dto.AppointmentDto;
import java.util.Set;



public interface IAppoitmentService {

        // List of appointments
        Set<AppointmentDto> listAppointment();

        // Creating appointment
        AppointmentDto createAppointment(AppointmentDto appointmentDto);

        //Find appointment by id
        AppointmentDto findAppointment(Long id);

        //Modifying appointment by id
        AppointmentDto modifyAppointment(Long id, AppointmentDto appointmentDto);

        // Delete appointment by id
        void deleteAppointment(Long id);
}
