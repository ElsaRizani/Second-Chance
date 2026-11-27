package com.example.demo.config;

import com.example.demo.domain.ApplicationStatusEnum;
import com.example.demo.domain.RoleEnum;
import com.example.demo.infrastructure.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(
            DogRepository dogRepository,
            CaptureRecordRepository captureRepository,
            UserRepository userRepository,
            CitizenProfileRepository citizenRepository,
            AdoptionApplicationRepository applicationRepository) {

        return args -> {
            if (dogRepository.count() == 0) {
                System.out.println("Duke ruajtur seeds...");

                UserEntity user = new UserEntity();
                user.setFullName("Alban Hoxha");
                user.setEmail("alban@example.com");
                user.setPasswordHash("hashed_password_placeholder");
                user.setRole(RoleEnum.CITIZEN);

                CitizenProfileEntity citizen = new CitizenProfileEntity();
                citizen.setAddress("Prishtine");
                citizen.setPhone("044111222");
                citizen.setUserid(user);
                user.setCitizenProfile(citizen);

                userRepository.saveAndFlush(user);

                CaptureRecordEntity capture1 = new CaptureRecordEntity();
                capture1.setCaptureDate(LocalDate.now());
                capture1 = captureRepository.saveAndFlush(capture1);

                DogEntity dog1 = new DogEntity();
                dog1.setName("Luna");
                dog1.setBreed("Labrador");
                dog1.setEstimatedAge(2);
                dog1.setHealthCondition("Mire");
                dog1.setShelterId(1L);
                dog1.setCaptureRecord(capture1);
                dogRepository.saveAndFlush(dog1);

                CaptureRecordEntity capture2 = new CaptureRecordEntity();
                capture2.setCaptureDate(LocalDate.now());
                capture2 = captureRepository.saveAndFlush(capture2);

                DogEntity dog2 = new DogEntity();
                dog2.setName("Max");
                dog2.setBreed("Bulldog");
                dog2.setEstimatedAge(3);
                dog2.setHealthCondition("Ka nevoje per vaksine");
                dog2.setShelterId(1L);
                dog2.setCaptureRecord(capture2);
                dogRepository.save(dog2);

                System.out.println("U krijuan qente dhe perdoruesi ne databaze!");
            }

            if (applicationRepository.count() == 0) {
                CitizenProfileEntity citizen = citizenRepository.findAll().get(0);
                DogEntity dog = dogRepository.findAll().get(0);

                AdoptionApplicationEntity application = new AdoptionApplicationEntity();
                application.setCitizen(citizen);
                application.setDog(dog);
                application.setApplicationDate(LocalDate.now());
                application.setStatus(ApplicationStatusEnum.DOREZUAR);
                applicationRepository.saveAndFlush(application);

                System.out.println("U krijua adoption application!");
            }
        };
    }
}
