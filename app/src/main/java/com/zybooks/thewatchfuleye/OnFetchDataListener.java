package com.zybooks.thewatchfuleye;

import com.zybooks.thewatchfuleye.Model.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {
    void onFetchData(List<NewsHeadlines> list, String message);
    void onError(String message);
}
