package com.dh.proyect.DentalAppoiments.repository.impl;
import com.dh.proyect.DentalAppoiments.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
