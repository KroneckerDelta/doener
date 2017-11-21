package de.god.doenerbestellung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/***
 * <pre>
 *     ____     ___    ____ __  __  ____ ____      ___  ____  ____ 
 *     || \\   // \\  ||    ||\ || ||    || \\    // \\ || \\ || \\
 *     ||  )) ((   )) ||==  ||\\|| ||==  ||_//    ||=|| ||_// ||_//
 *     ||_//   \\_//  ||___ || \|| ||___ || \\    || || ||    ||
 * 
 * </pre>
 * 
 * @author tmichael
 *
 */
@ComponentScan
@Configuration
@EnableAutoConfiguration
public class GodDoenerApplication {

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			System.out.println(""); // ANSI Shadow
			System.out.println("");
			System.out.println("Starting App:");
			System.out.println("");
			System.out.println("");
			System.out.println("██████╗  ██████╗ ███████╗███╗   ██╗███████╗██████╗      █████╗ ██████╗ ██████╗ ");
			System.out.println("██╔══██╗██╔═══██╗██╔════╝████╗  ██║██╔════╝██╔══██╗    ██╔══██╗██╔══██╗██╔══██╗");
			System.out.println("██║  ██║██║   ██║█████╗  ██╔██╗ ██║█████╗  ██████╔╝    ███████║██████╔╝██████╔╝");
			System.out.println("██║  ██║██║   ██║██╔══╝  ██║╚██╗██║██╔══╝  ██╔══██╗    ██╔══██║██╔═══╝ ██╔═══╝ ");
			System.out.println("██████╔╝╚██████╔╝███████╗██║ ╚████║███████╗██║  ██║    ██║  ██║██║     ██║     ");
			System.out.println("╚═════╝  ╚═════╝ ╚══════╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝    ╚═╝  ╚═╝╚═╝     ╚═╝     ");
			System.out.println("");
			System.out.println("");
			try {
				SpringApplication.run(GodDoenerApplication.class, args);
				System.out.println("                                                                                   ");
				System.out.println("██████╗  ██████╗ ███████╗███╗   ██╗███████╗██████╗     ██████╗ ██╗   ██╗███╗   ██╗");
				System.out.println("██╔══██╗██╔═══██╗██╔════╝████╗  ██║██╔════╝██╔══██╗    ██╔══██╗██║   ██║████╗  ██║");
				System.out.println("██║  ██║██║   ██║█████╗  ██╔██╗ ██║█████╗  ██████╔╝    ██████╔╝██║   ██║██╔██╗ ██║");
				System.out.println("██║  ██║██║   ██║██╔══╝  ██║╚██╗██║██╔══╝  ██╔══██╗    ██╔══██╗██║   ██║██║╚██╗██║");
				System.out.println("██████╔╝╚██████╔╝███████╗██║ ╚████║███████╗██║  ██║    ██║  ██║╚██████╔╝██║ ╚████║");
				System.out.println("╚═════╝  ╚═════╝ ╚══════╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝    ╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═══╝");
				System.out.println("                                                                                   ");
				break;

			} catch (Exception e) {

				System.out.println("                                                                                   ");
				System.out.println("████████╗██████╗ ██╗   ██╗     █████╗  ██████╗  █████╗ ██╗███╗   ██╗");
				System.out.println("╚══██╔══╝██╔══██╗╚██╗ ██╔╝    ██╔══██╗██╔════╝ ██╔══██╗██║████╗  ██║");
				System.out.println("   ██║   ██████╔╝ ╚████╔╝     ███████║██║  ███╗███████║██║██╔██╗ ██║");
				System.out.println("   ██║   ██╔══██╗  ╚██╔╝      ██╔══██║██║   ██║██╔══██║██║██║╚██╗██║");
				System.out.println("   ██║   ██║  ██║   ██║       ██║  ██║╚██████╔╝██║  ██║██║██║ ╚████║");
				System.out.println("   ╚═╝   ╚═╝  ╚═╝   ╚═╝       ╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝");
				System.out.println("                                                                     ");

				Thread.sleep(2500l);
			}

			System.out.println("                                                                                   ");
			System.out.println("███████╗███╗   ██╗██████╗ ███████╗██████╗ ");
			System.out.println("██╔════╝████╗  ██║██╔══██╗██╔════╝██╔══██╗");
			System.out.println("█████╗  ██╔██╗ ██║██║  ██║█████╗  ██║  ██║");
			System.out.println("██╔══╝  ██║╚██╗██║██║  ██║██╔══╝  ██║  ██║");
			System.out.println("███████╗██║ ╚████║██████╔╝███████╗██████╔╝");
			System.out.println("╚══════╝╚═╝  ╚═══╝╚═════╝ ╚══════╝╚═════╝ ");
			System.out.println("                                           ");
		}

	}
}
