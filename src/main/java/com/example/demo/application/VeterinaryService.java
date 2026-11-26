package com.example.demo.application;
import com.example.demo.domain.Appointment;
import com.example.demo.domain.Clinic;
import com.example.demo.domain.MedicalRecord;
import com.example.demo.domain.Vaccinations;
import com.example.demo.infrastructure.ClinicRepository;
import com.example.demo.infrastructure.DogEntity;
import com.example.demo.infrastructure.DogRepository;
import com.example.demo.infrastructure.MedicalRecordEntity;
import com.example.demo.infrastructure.MedicalRecordRepository;
import com.example.demo.infrastructure.StaffEntity;
import com.example.demo.infrastructure.StaffRepository;
import com.example.demo.infrastructure.VaccinationsEntity;
import com.example.demo.infrastructure.VaccinationsRepository;
import com.example.demo.infrastructure.AppointmentEntity;
import com.example.demo.infrastructure.AppointmentRepository;
import com.example.demo.infrastructure.ClinicEntity;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service 
public class VeterinaryService {
    private final ClinicRepository clinicRepository;
    private final StaffRepository staffRepository;
    private final AppointmentRepository appointmentRepository;
    private final DogRepository dogRepository;
    private final MedicalRecordRepository medicalRecordRepository;
    private final VaccinationsRepository vaccinationsRepository;

    public VeterinaryService(ClinicRepository clinicRepository, StaffRepository staffRepository, AppointmentRepository appointmentRepository, DogRepository dogRepository, MedicalRecordRepository medicalRecordRepository, VaccinationsRepository vaccinationsRepository) {
        this.clinicRepository = clinicRepository;
        this.staffRepository = staffRepository;
        this.appointmentRepository = appointmentRepository;
        this.dogRepository = dogRepository;
        this.medicalRecordRepository = medicalRecordRepository;
        this.vaccinationsRepository = vaccinationsRepository;
    }

    @Transactional
    public Long registerClinic( Long staffID, String name, int capacity, String address, String contact) {
        // e krijojme domain
        Clinic clinic = new Clinic(null, staffID, name, capacity, address, contact, 0);

        // kontrollojme kapacitetin
        if (clinic.getCapacity() <= 0) {
            throw new IllegalArgumentException("Kapaciteti duhet te jete me i madh se 0.");
        }

        // e gjejme staff-in ne db
        StaffEntity staff = staffRepository.findById(staffID).orElseThrow(() -> new IllegalArgumentException("Staff nuk u gjet."));

        // e krijojme entity
        ClinicEntity entity = new ClinicEntity();
        entity.setName(clinic.getName());
        entity.setCapacity(clinic.getCapacity());
        entity.setAddress(clinic.getAddress());
        entity.setContact(clinic.getContact());
        entity.setNumberOfDogs(clinic.getNumberOfDogs());

        // e lidhim staff-in me kliniken
        staff.setClinic(entity);
        entity.getStaff().add(staff);

        // e ruajme ne db
        return clinicRepository.save(entity).getId();
    }

    @Transactional
    public Long scheduleAppointment(Long dogID, Long staffID, Long clinicID, LocalDateTime dateTime, String reason) {
        // e kontrollojme nese qeni ekziston
        DogEntity dog = dogRepository.findById(dogID).orElseThrow(() -> new IllegalArgumentException("Qeni nuk u gjet."));

        // e kontrollojme nese staff ekziston
        StaffEntity staff = staffRepository.findById(staffID).orElseThrow(() -> new IllegalArgumentException("Staff nuk u gjet."));

        // e kontrollojme nese klinika ekziston
        ClinicEntity clinic = clinicRepository.findById(clinicID).orElseThrow(() -> new IllegalArgumentException("Klinika nuk u gjet."));

        // kontrollojme nese staff i perket klinikes
        if (staff.getClinic() == null || !staff.getClinic().getId().equals(clinicID)) {
            throw new IllegalArgumentException("Staff nuk i perket kesaj klinike.");
        }

        // kontrollojme daten
        if (dateTime == null || !dateTime.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Data e terminit duhet te jete ne te ardhmen.");
        }

        // e krijojme domain
        Appointment appointment = new Appointment(null, dogID, staffID, clinicID, dateTime, reason, Appointment.AppointmentStatusEnum.SCHEDULED);
        // mapojme te dhenat ne entity
        AppointmentEntity entity = new AppointmentEntity();
        entity.setDog(dog);
        entity.setStaff(staff);
        entity.setClinic(clinic);
        entity.setDateTime(appointment.getDateTime());
        entity.setReason(appointment.getReason());
        entity.setStatus(appointment.getStatus());

        // e ruajme ne db
        return appointmentRepository.save(entity).getId();
    }

    @Transactional
    public void completeAppointment(Long appointmentID) {
        // e gjejme terminin
        AppointmentEntity appointment = appointmentRepository.findById(appointmentID).orElseThrow(() -> new IllegalArgumentException("Termini nuk u gjet."));

        // kontrollojme nese termini eshte i planifikuar
        if (appointment.getStatus() != Appointment.AppointmentStatusEnum.SCHEDULED) {
            throw new IllegalArgumentException("Vetem terminet e planifikuara mund te perfundojne.");
        }

        // e ndryshojme statusin
        appointment.setStatus(Appointment.AppointmentStatusEnum.COMPLETED);

        // e ruajme ndryshimin
        appointmentRepository.save(appointment);
    }

    @Transactional
    public void cancelAppointment(Long appointmentID) {
        // e gjejme terminin
        AppointmentEntity appointment = appointmentRepository.findById(appointmentID).orElseThrow(() -> new IllegalArgumentException("Termini nuk u gjet."));

        // kontrollojme nese termini mund te anulohet
        if (appointment.getStatus() != Appointment.AppointmentStatusEnum.SCHEDULED) {
            throw new IllegalArgumentException("Vetem terminet e planifikuara mund te anulohen.");
        }

        // e ndryshojme statusin
        appointment.setStatus(Appointment.AppointmentStatusEnum.CANCELLED);

        // e ruajme ndryshimin
        appointmentRepository.save(appointment);
    }

    @Transactional
    public Long createMedicalRecord(Long dogID, Long vaccineID, Long vetID, String diagnosis) {
        // e kontrollojme nese qeni ekziston
        DogEntity dog = dogRepository.findById(dogID).orElseThrow(() -> new IllegalArgumentException("Qeni nuk u gjet."));

        // e kontrollojme nese veterinari ekziston
        StaffEntity vet = staffRepository.findById(vetID).orElseThrow(() -> new IllegalArgumentException("Veterinari nuk u gjet."));

        // e kontrollojme vaksinimin nese eshte specifikuar
        VaccinationsEntity vaccine = null;

        if (vaccineID != null) {
            vaccine = vaccinationsRepository.findById(vaccineID).orElseThrow(() -> new IllegalArgumentException("Vaksinimi nuk u gjet."));
        }

        // e krijojme domain
        MedicalRecord record = new MedicalRecord(null, dogID, vaccineID, vetID, diagnosis);

        // mapojme te dhenat ne entity
        MedicalRecordEntity entity = new MedicalRecordEntity();
        entity.setDog(dog);
        entity.setVaccine(vaccine);
        entity.setVet(vet);
        entity.setDiagnosis(record.getDiagnosis());

        // e ruajme ne db
        return medicalRecordRepository.save(entity).getId();
    }

    @Transactional
    public Long registerVaccination(Long dogID, String vaccineName, int dose, LocalDateTime lastDoseDate) {
        // kontrollojme nese qeni ekziston
        DogEntity dog = dogRepository.findById(dogID).orElseThrow(() -> new IllegalArgumentException("Qeni nuk u gjet."));

        // kontrollojme te dhenat e vaksinimit
        if (vaccineName == null || vaccineName.isBlank()) {
            throw new IllegalArgumentException("Emri i vaksines eshte i detyrueshem.");
        }

        if (dose <= 0) {
            throw new IllegalArgumentException("Doza duhet te jete me e madhe se zero.");
        }

        if (lastDoseDate == null || lastDoseDate.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Data e vaksinimit nuk eshte valide.");
        }

        // Krijojme objektin ne domain
        Vaccinations vaccination = new Vaccinations(null, dogID, vaccineName, dose, lastDoseDate);

        // E mapojme objektin ne entity
        VaccinationsEntity entity = new VaccinationsEntity();
        entity.setDogId(dog);
        entity.setVaccineName(vaccination.getVaccineName());
        entity.setDose(vaccination.getDose());
        entity.setLastDoseDate(vaccination.getLastDoseDate());
        entity.setNextDoseDate(vaccination.getNextDoseDate());

        // E ruajme vaksinimin ne databaze
        return vaccinationsRepository.save(entity).getId();
    }
}