package com.dh.proyect.DentalAppoiments.services;
import com.dh.proyect.DentalAppoiments.entities.Appointment;
import com.dh.proyect.DentalAppoiments.repository.impl.AppointmentRepository;
import com.dh.proyect.DentalAppoiments.services.dto.AppointmentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AppointmentService implements IAppoitmentService {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    private PatientService pacientService;
    @Autowired
    private DentistService dentistService;

    @Autowired
    private final AppointmentRepository appointmentRepository;


    //Logger methods
    private static final Logger LOGGER = LogManager.getLogger(AppointmentService.class);

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // List of appointments
    @Override
    public Set<AppointmentDto> listAppointment() {
        List<Appointment>  appointmentsEntityList = appointmentRepository.findAll();
        Set<AppointmentDto>appointmentDto = new HashSet<>();
        for (Appointment a :  appointmentsEntityList) {
            appointmentDto.add(mapper.convertValue(a, AppointmentDto.class));
            LOGGER.info("The appointment was listed");
        }
        return appointmentDto;
    }

    // Creating appointment
    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        Appointment appointmement = mapper.convertValue(appointmentDto, Appointment.class);
        appointmentRepository.save(appointmement);
        AppointmentDto appointmentDto1 = mapper.convertValue(appointmement, AppointmentDto.class);
        return appointmentDto1;
    }

    //Find appointment by id
    @Override
    public AppointmentDto findAppointment(Long id) {
            AppointmentDto appointmentDto = null;
            Optional<Appointment> appointmentToFound = appointmentRepository.findById(id);
            if (appointmentToFound.isPresent()) {
                LOGGER.info("The appointment was found with id: " + id);
                return appointmentDto = mapper.convertValue(appointmentToFound, AppointmentDto.class);
            } else {
                LOGGER.info("No appointment were found with id: " + id);
            }
            return appointmentDto;
    }
    //Modifying appointment by id
    @Override
    public AppointmentDto modifyAppointment(Long id, AppointmentDto appointmentDto) {
        AppointmentDto appointmentDtoModify = null;
        Optional<Appointment> appointmentToModify =appointmentRepository.findById(id);
        if (appointmentToModify .isPresent()) {
                appointmentToModify.get().setDentist(appointmentDto.dentist != null ? appointmentDto.dentist : appointmentToModify.get().getDentist());
                 appointmentToModify.get().setPatient(appointmentDto.patient != null ?  appointmentDto.patient : appointmentToModify.get().getPatient());
                 appointmentToModify.get().setDischargeDate(appointmentDto.dischargeDate != null ?  appointmentDto.dischargeDate : appointmentToModify.get().getDischargeDate());
                    LOGGER.info("The appointment was updated with id: " + id);
            appointmentDto =  mapper.convertValue(appointmentToModify, AppointmentDto.class);
                } else {
                    LOGGER.error("No appointment were found with id: " + id);
                }
                return appointmentDto;
    }
    // Delete appointment by id
    @Override
    public void deleteAppointment(Long id) {
        AppointmentDto dentistDtoDelete = null;
        Optional<Appointment> appointment= appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            LOGGER.info("The appointment was deleted");
            appointmentRepository.deleteById(id);
        }
    }
}