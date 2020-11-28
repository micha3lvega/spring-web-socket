package co.com.micha3lvega.spring.web.socket.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import co.com.micha3lvega.spring.web.socket.util.WeatherType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherInfo implements Serializable {

	private static final long serialVersionUID = -3097440663823687784L;

	private String place;
	private WeatherType type;
	private LocalDateTime time;
	private String localDateTimeStr;

	public WeatherInfo(WeatherType typeArg, LocalDateTime timeArg, String placeArg) {
		super();
		type = typeArg;
		time = timeArg;
		place = placeArg;
	}

}
