package com.prudential.webcrawler;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.prudential.webcrawler.domain.ChildPageCrawler;
import com.prudential.webcrawler.domain.RootPageCrawler;

public class WebCrawler {
	
	//private static final String homePage = "http://www.prudential.co.uk";
	private static Set<String> urls;
	private static BlockingQueue<String> que;
	
	public static void main(String[] args) {
		
		if (args.length <= 0) {
			System.out.println("Usage : java -jar <jarname> url");
			return;
		}
		
		System.out.println("starting program....");
		System.out.println("Root page URL:"+args[0]);
		
		urls = new HashSet<String>();
		que = new LinkedBlockingQueue<String>();
		
		new Thread(new RootPageCrawler(args[0], urls, que)).start();
		new Thread(new ChildPageCrawler(args[0], que)).start();
	}
}
