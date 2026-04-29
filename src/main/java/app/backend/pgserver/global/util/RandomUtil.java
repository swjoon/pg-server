package app.backend.pgserver.global.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {

	public static boolean chance(final int percent) {
		if (percent <= 0) {
			return false;
		}

		if (percent >= 100) {
			return true;
		}

		return ThreadLocalRandom.current().nextInt(100) < percent;
	}

	/**
	 * minMillis ~ maxMillis 사이 랜덤 sleep
	 */
	public static void randomSleep(final long minMillis, final long maxMillis) {
		long sleepMillis = ThreadLocalRandom.current().nextLong(minMillis, maxMillis + 1);

		ThreadUtil.sleep(sleepMillis);
	}

	/**
	 * percent 확률로 랜덤 sleep
	 */
	public static void sleepByChance(
		final int percent,
		final long minMillis,
		final long maxMillis
	) {
		if (chance(percent)) {
			randomSleep(minMillis, maxMillis);
		}
	}

	/**
	 * percent 확률로 RuntimeException 발생
	 */
	public static void abortByChance(
		final int percent,
		final String message
	) {
		if (chance(percent)) {
			throw new RuntimeException(message);
		}
	}

}
