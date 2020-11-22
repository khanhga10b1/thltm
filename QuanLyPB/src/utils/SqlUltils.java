package utils;

import java.util.Arrays;


public class SqlUltils {
	private SqlUltils() {
	}

	public static <T extends AutoCloseable> void close(T... closedElements) {
		Arrays.stream(closedElements).forEach(el -> {
			if (el != null) {
				try {
					el.close();
				} catch (Exception e) {
				}
			}
		});
	}

}
