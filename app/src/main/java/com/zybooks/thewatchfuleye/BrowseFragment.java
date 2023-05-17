package com.zybooks.thewatchfuleye;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.zybooks.thewatchfuleye.Model.NewsApiResponse;
import com.zybooks.thewatchfuleye.Model.NewsHeadlines;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class BrowseFragment extends Fragment /*implements SelectListener*/{
    //String url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=7210bfdc9d704f72824900a1d01936a4";
    //String url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=7210bfdc9d704f72824900a1d01936a4";
    //String apikey = "86f9290c0df9150f4836f7e20dd6822b";
    //String url = "https://gnews.io/api/v4/search?q=example&lang=en&country=us&max=10&apikey=" + apikey;
    RecyclerView recyclerView;
    CustomAdapter adapter;

    ProgressDialog dialog;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View browseView = inflater.inflate(R.layout.fragment_browse, container, false);

        dialog = new ProgressDialog(getActivity());
        dialog.setTitle("Fetching news articles..");
        dialog.show();

        RequestManager manager = new RequestManager(getActivity());
        manager.getNewsHeadlines(listener, "general", null);



        return browseView;
    }

    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {
            showNews(list);
            dialog.dismiss();
        }

        @Override
        public void onError(String message) {

        }
        private void showNews(List<NewsHeadlines> list) {
            recyclerView = getView().findViewById(R.id.headlines);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
            adapter = new CustomAdapter(getActivity(), list);
            recyclerView.setAdapter(adapter);
        }
    };


    /*@Override
    public void OnNewsClicked(NewsHeadlines headlines) {
        startActivity(new Intent(getActivity(), DetailsActivity.class)
                .putExtra("data", headlines));

    }*/



}


