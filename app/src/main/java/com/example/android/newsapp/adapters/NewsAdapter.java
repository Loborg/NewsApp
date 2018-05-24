package com.example.android.newsapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.newsapp.R;
import com.example.android.newsapp.forms.SciTechFragment;
import com.example.android.newsapp.models.News;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private int mListItemLayoutID;
    private ArrayList<News> mNewsList;

    public NewsAdapter(int listItemLayoutID, ArrayList<News> newsList){
        mListItemLayoutID = listItemLayoutID;
        mNewsList = newsList;
    }

    @Override
    public int getItemCount() {
        if (mNewsList == null){
            return 0;
        } else{
            return mNewsList.size();
        }
    }

    //Helper method to add data to the adapter from external source
    //Source: https://stackoverflow.com/questions/32419282/how-to-give-recyclerview-adapter-new-data-from-asynctaskloader
    public void setData(ArrayList<News> data, TextView emptyView, Context context, boolean isConnected){
        if(null != data && !data.isEmpty()){
            synchronized(mNewsList){
                mNewsList.clear();
                mNewsList.addAll(data);
            }
            notifyDataSetChanged();
        } else if (!isConnected) {
            emptyView.setText(context.getResources().getString(R.string.empty_view_text_no_connection));
            emptyView.setVisibility(View.VISIBLE);
        } else {
            emptyView.setText(context.getResources().getString(R.string.empty_view_text_no_data));
            emptyView.setVisibility(View.VISIBLE);
        }
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mListItemLayoutID, parent, false);
        return new NewsHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {

        ImageView articleTombnail = holder.articleThumbnail;
        if (mNewsList.get(position).getArticleThumbnailImageResource() == 0){
            articleTombnail.setVisibility(View.GONE);
        } else {
            articleTombnail.setImageResource(mNewsList.get(position).getArticleThumbnailImageResource());
        }

        TextView articleWebPublicationDate = holder.articleWebPublicationDate;
        articleWebPublicationDate.setText(mNewsList.get(position).getArticleWebPublicationDate());

        TextView articleHeadline = holder.articleHeadline;
        articleHeadline.setText(mNewsList.get(position).getArticleHeadline());

        TextView articleSection = holder.articleSection;
        articleSection.setText(mNewsList.get(position).getArticleSection());

        TextView articleAuthor = holder.articleAuthor;
        articleAuthor.setText(mNewsList.get(position).getArticleAuthor());

        holder.webUrl = mNewsList.get(position).getWebUrl();
    }

    static class NewsHolder extends RecyclerView.ViewHolder{

        private ImageView articleThumbnail;
        private TextView articleWebPublicationDate;
        private TextView articleHeadline;
        private TextView articleSection;
        private TextView articleAuthor;
        private String webUrl;

        public NewsHolder(View itemView, final Context context) {
            super(itemView);
            articleThumbnail = itemView.findViewById(R.id.news_tobnil);
            articleWebPublicationDate = itemView.findViewById(R.id.news_pub_date);
            articleHeadline = itemView.findViewById(R.id.news_headline);
            articleSection = itemView.findViewById(R.id.news_section);
            articleAuthor = itemView.findViewById(R.id.news_author);

            //Handles the click of an item, and intents the given URL, the URL is populated in the onBindViewHolder method
            //TLDR: Az Adapter logikájából kifolyólag a Holderben megadott Stringhez is bindelni kell az adatokat úgy mint-ha egy View lenne!
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webUrl));
                    context.startActivity(intent);
                }
            });
        }
    }
}
