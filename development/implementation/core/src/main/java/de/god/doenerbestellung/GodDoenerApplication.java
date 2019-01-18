package de.god.doenerbestellung;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
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
@EnableAutoConfiguration(exclude = { FlywayAutoConfiguration.class })
public class GodDoenerApplication
{
    public static void main(String[] args)
    {
    }
}
