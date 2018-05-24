package com.example.android.newsapp.models;

public class News {
    private int mArticleThumbnailImageResource;
    private String mArticleWebPublicationDate;
    private String mArticleHeadline;
    private String mArticleSection;
    private String mArticleAuthor;
    private String mWebUrl;

    public News(int articleThumbnailImageResource,
                String articleWebPublicationDate,
                String articleHeadline,
                String articleSection,
                String articleAuthor,
                String webUrl){
        mArticleThumbnailImageResource = articleThumbnailImageResource;
        mArticleWebPublicationDate = articleWebPublicationDate;
        mArticleHeadline = articleHeadline;
        mArticleSection = articleSection;
        mArticleAuthor = articleAuthor;
        mWebUrl = webUrl;


    }

    public News(String articleWebPublicationDate,
                String articleHeadline,
                String articleSection,
                String articleAuthor,
                String webUrl){
        mArticleWebPublicationDate = articleWebPublicationDate;
        mArticleHeadline = articleHeadline;
        mArticleSection = articleSection;
        mArticleAuthor = articleAuthor;
        mWebUrl = webUrl;
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

    public String getArticleSection(){
        return mArticleSection;
    }

    public String getArticleAuthor(){
        return mArticleAuthor;
    }

    public String getWebUrl(){
        return mWebUrl;
    }
}
