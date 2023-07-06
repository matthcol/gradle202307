package data.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data.Movie;

class TestMovie {

	@Test
	void testConstructorDefault() {
		var movie = new Movie();
		assertAll(
				() -> assertNull(movie.getId(), "id"),
				() -> assertNull(movie.getTitle(), "title"),
				() -> assertNull(movie.getYear(), "year"),
				() -> assertNull(movie.getDuration(), "duration")
		);
	}

	@Test
	void testBuilderTitleYear() {
		String title = "Nobody";
		short year = 2021;
		var movie = Movie.builder()
				.title(title)
				.year(year)
				.toMovie();
		assertAll(
				() -> assertNull(movie.getId(), "id"),
				() -> assertEquals(title, movie.getTitle(), "title"),
				() -> assertEquals(year, movie.getYear(), "year"),
				() -> assertNull(movie.getDuration(), "duration")
		);
	}

	@Test
	void testBuilderIdTitleYear() {
		int id = 7888964;
		String title = "Nobody";
		short year = 2021;
		var movie = Movie.builder()
				.id(id)
				.title(title)
				.year(year)
				.toMovie();
		assertAll(
				() -> assertEquals(id, movie.getId(), "id"),
				() -> assertEquals(title, movie.getTitle(), "title"),
				() -> assertEquals(year, movie.getYear(), "year"),
				() -> assertNull(movie.getDuration(), "duration")
		);
	}

	@Test
	void testBuilderTitleYearDuration() {
		String title = "Nobody";
		short year = 2021;
		short duration = 92;
		var movie = Movie.builder()
				.title(title)
				.year(year)
				.duration(duration)
				.toMovie();
		assertAll(
				() -> assertNull(movie.getId(), "id"),
				() -> assertEquals(title, movie.getTitle(), "title"),
				() -> assertEquals(year, movie.getYear(), "year"),
				() -> assertEquals(duration, movie.getDuration(), "duration")
		);
	}

	@Test
	void testBuilderIdTitleYearDuration() {
		int id = 7888964;
		String title = "Nobody";
		short year = 2021;
		short duration = 92;
		var movie = Movie.builder()
				.id(id)
				.title(title)
				.year(year)
				.duration(duration)
				.toMovie();
		assertAll(
				() -> assertEquals(id, movie.getId(), "id"),
				() -> assertEquals(title, movie.getTitle(), "title"),
				() -> assertEquals(year, movie.getYear(), "year"),
				() -> assertEquals(duration, movie.getDuration(), "duration")
		);
	}
}
