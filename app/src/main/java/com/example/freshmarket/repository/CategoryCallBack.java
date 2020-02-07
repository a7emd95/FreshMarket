package com.example.freshmarket.repository;

import com.example.freshmarket.models.Category;

import java.util.List;


public interface CategoryCallBack {
    void onSuccess(List<Category> categories);

    void onError(Throwable throwable);
}
