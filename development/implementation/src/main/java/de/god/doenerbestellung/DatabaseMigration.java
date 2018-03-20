package de.god.doenerbestellung;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Component;

import de.god.util.flyway.FlywayMigrateService;
import de.god.util.flyway.exception.FlywayMigrationConfigurationNotExistingException;
import de.god.util.flyway.provider.property.JNDIPropertyProvider;

@Component
public class DatabaseMigration implements StartupProcess {

	@Autowired
	private DataSource dataSource;

	@Override
	public void execute(ApplicationReadyEvent event) {
		FlywayMigrateService flyway = instance();
		flyway.validateAndMigrate();
	}

	public FlywayMigrateService instance() {
		System.out.println("############################");
		System.out.println("############################");
		System.out.println("############################");
		System.out.println("     F L Y W A Y     ");
		System.out.println("############################");
		System.out.println("############################");
		System.out.println("############################");

		try {
			return new FlywayMigrateService(properties -> dataSource, new JNDIPropertyProvider());
		} catch (FlywayMigrationConfigurationNotExistingException e) {
			System.out.println("Unable to initialize flyway migration service {}");
			throw new RuntimeException();
		}
	}
}
