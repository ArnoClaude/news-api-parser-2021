package com.arnoclaude.newsapiparser.controllers;

import com.arnoclaude.newsapiparser.services.NewsApiParserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.Arrays;

@Controller
public class NewsApiParserController {

    @GetMapping("/")
    public String home(Model model) throws IOException, InterruptedException {
        NewsApiParserService newsDataService = new NewsApiParserService();
        newsDataService.fetchData();
        model.addAttribute("totalResults", newsDataService.getNews().getTotalResults());
        model.addAttribute("articleList", Arrays.asList(newsDataService.getNews().getArticles()));

        return "home";

    }

}
