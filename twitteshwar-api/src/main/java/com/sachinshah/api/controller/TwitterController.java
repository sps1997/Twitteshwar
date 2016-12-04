package com.sachinshah.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sachinshah.api.model.Event;

@RestController
public class TwitterController {

	TwitterTemplate twitter = new TwitterTemplate("IvWeO2ISPSLXHP6ST8AzvvdYD",
			"EutS2ndvIJwfpibtvtSovMcdBIPkuztFI5bLwwluta4dxaL0Bz", "804870011546284032-IZa9nYfCC7wu5Box22eFAl6UICxbYAB",
			"yvCJfG4xmnIzvjbRZZ7PyPwDq1t9h6kR00sPKLAiUxrzA");

	private Gson gson = new GsonBuilder().create();

	@RequestMapping("/api/profile")
	public ResponseEntity<String> profile(@RequestParam(name = "callback") String callback) {
		String profile = gson.toJson(twitter.userOperations().getUserProfile());
		
		System.out.println(profile);
		
		return ResponseEntity
				.ok(String.format("%s (%s);", callback, profile));

	}

	@RequestMapping("/api/info")
	public String twitterInfo() {
		return twitter.toString();
	}

	@RequestMapping("/api/tweets")
	public ResponseEntity<String> getTweets(@RequestParam(name = "callback") String callback) {

		List<org.springframework.social.twitter.api.Tweet> tweets = twitter.timelineOperations().getHomeTimeline();

		return ResponseEntity.ok(String.format("%s (%s);", callback, gson.toJson(tweets)));

	}

	@RequestMapping(value = "/api/postTweet", method = RequestMethod.POST)
	public ResponseEntity<String> postTweet(@RequestBody String message) {

		System.out.println("Post method called..." + message);

		twitter.timelineOperations().updateStatus(message);

		return ResponseEntity.ok("{\"result\":\"OK\"}");

	}

}
