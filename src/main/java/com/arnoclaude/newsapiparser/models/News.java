package com.arnoclaude.newsapiparser.models;

public class News {

    private String status;
    private int totalResults;
    private Article[] articles;

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public Article[] getArticles() {
        return articles;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public void setArticles(Article[] articles) {
        this.articles = articles;
    }
}
