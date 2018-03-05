package de.god.doenerbestellung;

import org.springframework.boot.context.event.ApplicationReadyEvent;

public interface StartupProcess {
	void execute(ApplicationReadyEvent event);
}
