package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

//    retrives data for db (as entity) and converts to dto to send to controller ***
//    public List<PatientResponseDTO> getPatient() {
//        List<Patient> patients = patientRepository.findAll();
//        List<PatientResponseDTO> patientResponseDTO = patients.stream()
//                .map(patient -> PatientMapper.toDTO(patient)).toList();
//        return patientResponseDTO;
//    }
    public List<PatientResponseDTO> getPatient() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientMapper::toDTO).toList();
    }
}
