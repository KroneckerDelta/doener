package de.god.doenerbestellung;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationStartupProcesses implements ApplicationListener<ApplicationReadyEvent> {

	private Collection<StartupProcess> startupProcesses = new ArrayList<>();

	@Autowired
	ApplicationStartupProcesses(DatabaseMigration databaseMigration) {
		startupProcesses.add(databaseMigration);
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
		System.out.println("############################");
		System.out.println("############################");
		System.out.println("############################");
		System.out.println("     F L Y W A Y    ApplicationStartupProcesses ");
		System.out.println("############################");
		System.out.println("############################");
		System.out.println("############################");

		startupProcesses.forEach(process -> process.execute(applicationReadyEvent));
	}
}