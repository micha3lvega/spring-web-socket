package co.com.micha3lvega.spring.web.socket.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceInfo implements Serializable {

	private static final long serialVersionUID = 4286054261097724529L;
	private String place;

}
