package co.com.micha3lvega.spring.web.socket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

import co.com.micha3lvega.spring.web.socket.domain.WeatherData;
import co.com.micha3lvega.spring.web.socket.dto.PlaceInfo;
import co.com.micha3lvega.spring.web.socket.dto.WeatherInfo;

/**
 * @author lagarcia
 *
 */
@Controller
@EnableScheduling
public final class WeatherController {

	
	private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

	
	/** The data storage. */
	@Autowired
	private WeatherData wData;

	/** Web socket message template */
	@Autowired
	private SimpMessagingTemplate template;

	/**
	 * Get weather info for a given place.
	 *
	 * @param place - The place
	 * @return The weather info
	 */
	@MessageMapping("/weather")
	@SendTo("/topic/weatherinfo")
	public WeatherInfo getWeatherInfo(PlaceInfo place) {
		/* Default */
		WeatherInfo wInfo = new WeatherInfo();
		try {
			logger.info("Get weather from " + place.getPlace());

			/* Lets make a pause */
			Thread.sleep(1000);

			/* Return weather info for the given place */
			wInfo = wData.getWeatherFrom(place.getPlace());

			logger.info("Retrieving weather from " + place.getPlace());

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return wInfo;
	}

	/**
	 * Run weather info periodically.
	 */
	// @Scheduled(fixedRate = 2000)
	public void runWInfo() {
		this.template.convertAndSend("/topic/weatherinfo", wData.getWeatherFrom("Madrid"));
	}

	/**
	 * @return the wData
	 */
	public WeatherData getwData() {
		return wData;
	}

	/**
	 * @param wDataArg the wData to set
	 */
	public void setwData(WeatherData wDataArg) {
		wData = wDataArg;
	}
}
