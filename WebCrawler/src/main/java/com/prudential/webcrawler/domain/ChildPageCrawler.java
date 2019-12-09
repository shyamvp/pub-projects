package com.prudential.webcrawler.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ChildPageCrawler implements Runnable {

	private BlockingQueue<String> rootUrlsQue;
	private Set<String> urls;
	private ExecutorService es;
	private final String homeUrl;

	public ChildPageCrawler(String homeUrl, BlockingQueue<String> rootUrlsQue) {
		this.rootUrlsQue = rootUrlsQue;
		this.urls = new HashSet<String>();
		this.homeUrl = homeUrl;
		es = Executors.newFixedThreadPool(10);
	}

	public void run() {
		try {
			while (true) {
				es.execute(new Runnable() {
					public void run() {
						try {
							getLinks(rootUrlsQue.take(), urls);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getLinks(String url, Set<String> urls) {

		if (urls.contains(url)) {
			System.out.println("Leaf url:" + url);
			return;
		}

		urls.add(url);
		Document doc = null;

		try {
			try {
				doc = Jsoup.connect(url).get();
			} catch (Exception e) {
				System.out.println("Not VAlid:" + url);
				return;
			}

			Elements elements = doc.select("a");

			for (Element element : elements) {

				if (urls.contains(element.attr("abs:href"))) {
					continue;
				}

				if (element.absUrl("href").contains(homeUrl)) {
					System.out.println("Child Url:"+element.absUrl("href"));
					new Thread(new RootPageCrawler(element.absUrl("href"), urls, rootUrlsQue)).start(); 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
