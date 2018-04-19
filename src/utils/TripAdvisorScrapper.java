package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TripAdvisorScrapper {

	String url ="https://www.tripadvisor.com/ShowUserReviews-g150807-d154449-r574179957-Sunset_Marina_Resort_Yacht_Club-Cancun_Yucatan_Peninsula.html";
	
	public TripAdvisorScrapper() {
		
		try {
			Document document = Jsoup.connect(url).get();
			System.out.println(document.title());
			
			ArrayList<Element> elements = document.getAllElements();
			Iterator<Element> iterator = elements.iterator();
			while(iterator.hasNext())
				System.out.println(iterator.next().toString());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
			
		TripAdvisorScrapper scrapper = new TripAdvisorScrapper();
		
		
	}
	
}
