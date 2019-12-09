package com.prudential.webcrawler.domain;

import java.util.Set;
import java.util.concurrent.BlockingQueue;

import com.prudential.webcrawler.service.Crawler;

public class RootPageCrawler implements Runnable{

	private BlockingQueue<String> rootUrlsQue;
	private String rootUrl;
	private Set<String> urls;
	private Crawler crawler;
	
	public RootPageCrawler(String rootUrl, Set<String> urls, BlockingQueue<String> rootUrlsQue) {
		this.rootUrlsQue = rootUrlsQue;
		this.rootUrl = rootUrl;
		this.urls = urls;
		this.crawler = new Crawler();
	}

	public void run() {
		crawler.getLinks(rootUrl, urls, rootUrlsQue);
	}
}
