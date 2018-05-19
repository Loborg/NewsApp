package com.example.android.newsapp.models;

public class News {
    private int mArticleThumbnailImageResource;
    private String mArticleWebPublicationDate;
    private String mArticleHeadline;
    private String mArticleAuthor;

    public News(int articleThumbnailImageResource, String articleWebPublicationDate, String articleHeadline, String articleAuthor){
        mArticleThumbnailImageResource = articleThumbnailImageResource;
        mArticleWebPublicationDate = articleWebPublicationDate;
        mArticleHeadline = articleHeadline;
        mArticleAuthor = articleAuthor;
    }

    public News(String articleWebPublicationDate, String articleHeadline, String articleAuthor){
        mArticleWebPublicationDate = articleWebPublicationDate;
        mArticleHeadline = articleHeadline;
        mArticleAuthor = articleAuthor;
    }

    public int getArticleThumbnailImageResource(){
        return mArticleThumbnailImageResource;
    }

    public String getArticleWebPublicationDate(){
        return mArticleWebPublicationDate;
    }

    public String getArticleHeadline(){
        return mArticleHeadline;
    }

    public String getArticleAuthor(){
        return mArticleAuthor;
    }
}
