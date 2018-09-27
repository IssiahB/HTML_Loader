package html.loader.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class HtmlReader {
	
	
	public static String readUrl(String url) throws IOException{
		StringBuilder html = new StringBuilder();
		BufferedReader in = null;
		try {
			URL reader = new URL(url);
			in = new BufferedReader(new InputStreamReader(reader.openStream()));
			
			String line = "";
			while ((line = in.readLine()) != null) {
				html.append(line+"\n");
			}
			
			in.close();
		} catch (Exception e) {
			if(in != null)
				in.close();
			throw new IOException();
		}
		
		return html.toString();
	}
}
