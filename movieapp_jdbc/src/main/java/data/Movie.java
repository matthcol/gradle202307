package data;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(buildMethodName = "toMovie")
@ToString(of= {"id", "title", "year"})
public class Movie {
	
	private Integer id;

	private String title;

	private Short year;

	private Short duration;

}
