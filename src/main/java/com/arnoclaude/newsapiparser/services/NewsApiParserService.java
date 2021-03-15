package com.arnoclaude.newsapiparser.services;

import com.arnoclaude.newsapiparser.models.Article;
import com.arnoclaude.newsapiparser.models.News;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.stream.Stream;

import static com.arnoclaude.newsapiparser.services.ArticleFilter.*;

@Service
public class NewsApiParserService {

    private final static String URL = "https://newsapi.org/v2/everything?q=Apple&from=2021-03-14&sortBy=popularity&apiKey=e80a9dfc9aca407f92b1fed20128b8d0";
    private static News news; // the http response we are getting from the api call

    public static void main(String[] args) throws IOException, InterruptedException {
        fetchData();
    }

    @PostConstruct
    public static void fetchData() throws IOException, InterruptedException {

        // 1. Create HTTP request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // 2. Convert json response into news variable
        Gson gson = new Gson();
        news = gson.fromJson(response.body(), News.class);
    }

    public static void filterArticles(ArticleFilter filter, String word) {
        switch (filter) {
            case SOURCENAME:
                news.setArticles(Arrays.stream(news.getArticles())
                        .filter(article -> article.getSource().getName().equals(word))
                        .toArray(Article[]::new));
            case AUTHOR:
                news.setArticles(Arrays.stream(news.getArticles())
                        .filter(article -> article.getSource().getName().equals(word))
                        .toArray(Article[]::new));
            case TITLE:
                news.setArticles(Arrays.stream(news.getArticles())
                        .filter(article -> article.getSource().getName().equals(word))
                        .toArray(Article[]::new));
            default:
                return;
        }
    }

    public News getNews() {
        return news;
    }
}
