package com.domiaffaire.api;

import com.domiaffaire.api.entities.Room;
import com.domiaffaire.api.entities.User;
import com.domiaffaire.api.enums.UserRole;
import com.domiaffaire.api.repositories.RoomRepository;
import com.domiaffaire.api.repositories.UserRepository;
import com.domiaffaire.api.services.DeadlineServiceImpl;
import com.domiaffaire.api.services.DomiAffaireServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	CommandLineRunner start(UserRepository userRepository, RoomRepository roomRepository, DeadlineServiceImpl service){
		return args -> {
//			User admin = new User();
//			admin.setEnabled(true);
//			admin.setEmail("admin@gmail.com");
//			admin.setPwd(new BCryptPasswordEncoder().encode("yosrMeddah123_"));
//			admin.setName("Admin DomiAffaire");
//			admin.setUserRole(UserRole.ADMIN);
//			userRepository.save(admin);
//
//
////			float pack = 70f;
////			int modePaiment = 3;
////			double totalHTVA = pack * modePaiment;
////			double tva = totalHTVA * 0.19;
////			double totalTTC = totalHTVA + tva;
////			double rs = totalTTC * 0.1;
////			int timbre = 1;
////			double net = (totalTTC - rs) + timbre;
////			String formattedNet = String.format("%.3f", net).replace(',', '.');
////			double netFinal = Double.parseDouble(formattedNet);
////			System.out.println(netFinal);
//
//
//
////			float pack = 70f;
////			int modePaiment = 3;
////			BigDecimal totalHTVA = BigDecimal.valueOf(pack).multiply(BigDecimal.valueOf(modePaiment));
////			BigDecimal tva = totalHTVA.multiply(BigDecimal.valueOf(0.19));
////			BigDecimal totalTTC = totalHTVA.add(tva);
////			BigDecimal rs = totalTTC.multiply(BigDecimal.valueOf(0.1));
////			int timbre = 1;
////			BigDecimal net = totalTTC.subtract(rs).add(BigDecimal.valueOf(timbre));
////			BigDecimal scaledNet = net.setScale(3, BigDecimal.ROUND_HALF_UP);
////			System.out.println(scaledNet);
//
////			LocalDateTime staticDate = LocalDateTime.of(2024, 5, 15, 12, 29);
////			if(LocalDateTime.now().compareTo(staticDate)>0){
////				System.out.println("Not Equals");
////			}
////			long monthsDifference = ChronoUnit.MONTHS.between(staticDate, LocalDateTime.now());
////
////			System.out.println("Months difference: " + monthsDifference);
////			// Print the static date
////			System.out.println("Static Date: " + staticDate);
////			System.out.println("local Date: " +LocalDateTime.now());
////
////			LocalDateTime dateAfter3Months = staticDate.plusMonths(3);
////
////			// Print the date after adding 3 months
////			System.out.println("Date after adding 3 months: " + dateAfter3Months);
//			final Object lock = new Object();
//			LocalDateTime staticDate = LocalDateTime.of(2024, 5, 15, 12, 48,0);
////			while (true) {
////				synchronized (lock) {
////					LocalDateTime currentDateTime = LocalDateTime.now();
////					if (currentDateTime.compareTo(staticDate) > 0) {
////						System.out.println("Not Equals");
////					} else if (currentDateTime.compareTo(staticDate) == 0) {
////						System.out.println("Equals");
////					} else {
////						System.out.println("Less than");
////					}
////				}
////				// Wait for a moment before checking again
////				try {
////					Thread.sleep(1000); // Adjust this value as needed for your desired frequency
////				} catch (InterruptedException e) {
////					e.printStackTrace();
////				}
////			}
//
//
//			LocalDateTime paymentDate = LocalDateTime.of(2024, 5, 15, 12, 29, 0);
//			LocalDateTime limitDate = paymentDate.plusMonths(3);
//			System.out.println(limitDate);
//			LocalDateTime limitedDate2 = LocalDateTime.of(2024, 5, 15, 16, 45, 0);
//			LocalDateTime warningDate = limitDate.minusDays(5);
//			System.out.println(warningDate);
//			LocalDateTime warningDate2 = LocalDateTime.of(2024, 5, 15, 14, 52, 0);
//
//			Duration durationUntilLimit = Duration.between(limitedDate2,LocalDateTime.now() );
//			long secondsUntilLimit = Math.max(0, durationUntilLimit.getSeconds());
//			System.out.println(secondsUntilLimit);
//
//			boolean paymentLimitPrinted = false;
//			boolean paymentWarningPrinted = false;
//
//			while (true) {
//				synchronized (lock) {
//					LocalDateTime currentDateTime = LocalDateTime.now();
//					if (!paymentLimitPrinted && currentDateTime.compareTo(limitedDate2) > 0) {
//						System.out.println("You passed the payment limit.");
//						limitedDate2 = limitedDate2.plusMinutes(2);
//						paymentLimitPrinted = false;
//					} else if (!paymentWarningPrinted && currentDateTime.compareTo(warningDate2) >= 0) {
//						System.out.println("Be careful, you have to pay soon.");
//						paymentWarningPrinted = true;
//					}
//				}
//				// Wait for a moment before checking again
//
//				try {
//					Thread.sleep(secondsUntilLimit*1000); // Adjust this value as needed for your desired frequency
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
			// Sample CSV data
			String data = "665f9cfea7c36f32c7c95e2a,8,\"Projecteur,Tableau\"\n" +
					"665f9d1fa7c36f32c7c95e2b,9,\"Projecteur,Tableau,Conférence Vidéo\"\n" +
					"665f9d41a7c36f32c7c95e2c,4,\"Projecteur,Tableau,Ordinateur Portable\"\n" +
					"665f9d5ca7c36f32c7c95e2d,6,\"Projecteur,Tableau,Conférence Vidéo\"\n" +
					"665f9d7da7c36f32c7c95e2e,6,\"Tableau,Ordinateur Portable\"\n" +
					"666317ca30bccc70aebb1770,20,\"Tableau,Conférence Vidéo,Projecteur\"";

			// Split data into lines
			List<String> lines = Arrays.asList(data.split("\n"));

			// Parse each line and create Room objects
			List<Room> rooms = lines.stream().map(line -> {
				String[] parts = line.split(",");
				String id = parts[0];
				int nbrPlaces = Integer.parseInt(parts[1]);
				List<String> equipments = Arrays.asList(parts[2].replace("\"", "").split(","));

				return Room.builder()
						.id(id)
						.nbrPlaces(nbrPlaces)
						.equipments(equipments)
						.build();
			}).collect(Collectors.toList());

			// Save all rooms to the repository
			roomRepository.saveAll(rooms);

			service.checkDeadlines();
		};
	}

}
