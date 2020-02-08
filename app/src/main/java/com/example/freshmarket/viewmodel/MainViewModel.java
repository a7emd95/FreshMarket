package com.example.freshmarket.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.freshmarket.models.Category;
import com.example.freshmarket.repository.CategoryCallBack;
import com.example.freshmarket.repository.CategoryRepository;

import java.util.List;


public class MainViewModel extends ViewModel implements CategoryCallBack {

    private MutableLiveData<List<Category>> _categoriesLiveData = new MutableLiveData<>();
    public LiveData<List<Category>> categoriesLiveData = _categoriesLiveData;

    CategoryRepository categoryRepository;

    public MainViewModel() {
        categoryRepository = new CategoryRepository(this);
    }


    public void getCategories() {
        categoryRepository.getCategories();
    }

    @Override
    public void onSuccess(List<Category> categories) {

        _categoriesLiveData.postValue(categories);
    }

    @Override
    public void onError(Throwable throwable) {

    }
}
