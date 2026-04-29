package app.backend.pgserver.global.util;

public class ThreadUtil {

	public static void sleep(long millis) {
		try {

			Thread.sleep(millis);

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();

			throw new RuntimeException("Mock PG sleep interrupted", e);
		}
	}
}
