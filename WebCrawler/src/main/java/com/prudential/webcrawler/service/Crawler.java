package com.prudential.webcrawler.service;

import java.util.Set;
import java.util.concurrent.BlockingQueue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {

	public void getLinks(String url, Set<String> urls, BlockingQueue<String> rootUrlsQue) {

	    if (checkUrl(url, urls)) {
	    	System.out.println("Leaf url:"+url);
	        return;
	    }

	    urls.add(url);
	    
	    Document doc = null;
	    	
	    try {
	    	try {
	    		doc = Jsoup.connect(url).get();
	    	}catch(Exception e) {
	    		return;
	    	}
	        Elements elements = doc.select("a");
	        
	        for(Element element : elements){
	        	
	        	if (checkUrl(element.absUrl("href"), urls)) {
	    	    	continue;
	    	    }
	        	
	            if(element.absUrl("href").contains(url)) {
	            	rootUrlsQue.put(element.attr("abs:href"));
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	private boolean checkUrl(String url, Set<String> urls) {
		return urls.contains(url);
	}
	
	private void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }
	
	private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }

}
