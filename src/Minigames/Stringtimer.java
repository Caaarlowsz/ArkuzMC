package Minigames;

public class Stringtimer {
	public static String timerChecker(final int i) {
		final int minutes = i / 60;
		final int seconds = i % 60;
		final String disMinu = String.valueOf((minutes < 10) ? "" : "") + minutes;
		String disSec;
		if (seconds <= 9) {
			disSec = String.valueOf((seconds < 10) ? "" : "") + seconds;
		} else {
			disSec = String.valueOf((seconds < 10) ? "0" : "") + seconds;
		}
		String formattedTime;
		if (minutes != 0) {
			formattedTime = String.valueOf(disMinu) + ":" + disSec;
		} else {
			formattedTime = String.valueOf(disSec) + "s";
		}
		return formattedTime;
	}

	public static String timerBunito(final Integer i) {
		final int minutes = i / 60;
		final int seconds = i % 60;
		final String disMinu = String.valueOf((minutes < 10) ? "" : "") + minutes;
		final String disSec = String.valueOf((seconds < 10) ? "0" : "") + seconds;
		final String formattedTime = String.valueOf(disMinu) + "m " + disSec + "s";
		return formattedTime;
	}

	public static String timerFeio(final int i) {
		final int minutes = i / 60;
		final int seconds = i % 60;
		final String disMinu = String.valueOf((minutes < 10) ? "" : "") + minutes;
		final String disSec = String.valueOf((seconds < 10) ? "0" : "") + seconds;
		final String formattedTime = String.valueOf(disMinu) + ":" + disSec;
		return formattedTime;
	}
}
