package co.com.micha3lvega.spring.web.socket.domain;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import co.com.micha3lvega.spring.web.socket.dto.WeatherInfo;
import co.com.micha3lvega.spring.web.socket.util.WeatherType;

@Component
public final class WeatherData {
	/** Weather data. */
	private Map<String, WeatherInfo> weatherData;

	/**
	 * Default constructor.
	 */
	public WeatherData() {
		weatherData = new HashMap<>();
		weatherData.put("Madrid",
				new WeatherInfo(WeatherType.RAINY, LocalDateTime.of(2015, Month.OCTOBER, 12, 13, 45), "Madrid"));
		weatherData.put("London",
				new WeatherInfo(WeatherType.SUNNY, LocalDateTime.of(2015, Month.OCTOBER, 15, 16, 25), "London"));
		weatherData.put("Paris",
				new WeatherInfo(WeatherType.WINDY, LocalDateTime.of(2015, Month.OCTOBER, 21, 8, 15), "Paris"));
	}

	/**
	 * Get weather info from a place.
	 *
	 * @param place - The place
	 * @return The weather info
	 */
	public WeatherInfo getWeatherFrom(String place) {
		return weatherData.get(place);
	}

	/**
	 * Get a list of weather info.
	 *
	 * @return A weather info list
	 */
	public List<WeatherInfo> getAllWeather() {
		List<WeatherInfo> aList = new ArrayList<>();
		Set<String> keys = this.weatherData.keySet();
		for (String key : keys) {
			aList.add(this.weatherData.get(key));
		}

		return aList;
	}
}