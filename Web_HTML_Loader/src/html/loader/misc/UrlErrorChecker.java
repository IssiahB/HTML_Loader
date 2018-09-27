package html.loader.misc;

import java.net.URL;

public class UrlErrorChecker {
	
	public static boolean isUrlFlawed(String url) {
		try {
			URL checker = new URL(url);
			return false;
		} catch (Exception e) {
			return true;
		}
	}
	
}
