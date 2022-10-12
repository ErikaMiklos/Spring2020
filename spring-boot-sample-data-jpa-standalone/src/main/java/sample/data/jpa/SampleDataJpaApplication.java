/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sample.data.jpa.domain.Etudiant;
import sample.data.jpa.domain.Prof;
import sample.data.jpa.domain.StatusRdv;
import sample.data.jpa.service.EtudiantServiceImpl;
import sample.data.jpa.service.ProfServiceImpl;
import sample.data.jpa.service.RdvServiceImpl;

import java.util.stream.Stream;

@SpringBootApplication
public class SampleDataJpaApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleDataJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProfServiceImpl profService,
							EtudiantServiceImpl etudiantService,
							RdvServiceImpl rdvService){
		return args -> {
			//add profs to the database
			Prof prof1 = new Prof();
			prof1.setNom("Barais");
			prof1.setPrenom("Olivier");
			prof1.setMatiere("TAA");
			profService.saveProf(prof1);

			Prof prof2 = new Prof();
			prof2.setNom("Christie");
			prof2.setPrenom("Marc");
			prof2.setMatiere("MMM");
			profService.saveProf(prof2);

			//add etudiants to the database
			Etudiant etudiant1 = new Etudiant();
			etudiant1.setNom("Miklos");
			etudiant1.setPrenom("Erika");
			etudiant1.setFaculte("ISTIC");
			etudiantService.saveEtudiant(etudiant1);

			Etudiant etudiant2 = new Etudiant();
			etudiant2.setNom("Debrandt");
			etudiant2.setPrenom("William");
			etudiant2.setFaculte("ISTIC");
			etudiantService.saveEtudiant(etudiant2);

			Etudiant etudiant3 = new Etudiant();
			etudiant3.setNom("Gipsz");
			etudiant3.setPrenom("Jakab");
			etudiant3.setFaculte("ESIR");
			etudiantService.saveEtudiant(etudiant3);

			//add new rdvs of profs existants
			Stream.of("9h-10h","11h-12h","15h-16h")
					.forEach( heureRDV -> {
						rdvService.saveRdv(1L, "21/10/2022", heureRDV);
			});

			Stream.of("10h-11h","14h-15h","16-17h")
					.forEach( heureRDV -> {
						rdvService.saveRdv(2L, "25/10/2022", heureRDV);
			});

			//booking an open rdv by a student
			rdvService.updateRdv(3L, 3L, StatusRdv.RESERVE);
			rdvService.updateRdv(4L, 5L, StatusRdv.RESERVE);
		};
	}

}
