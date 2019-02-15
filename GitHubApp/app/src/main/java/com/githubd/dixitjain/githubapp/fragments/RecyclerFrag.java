package com.githubd.dixitjain.githubapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.githubd.dixitjain.githubapp.R;
import com.githubd.dixitjain.githubapp.adapters.RecyclerAdapter;
import com.githubd.dixitjain.githubapp.model.Item;
import com.githubd.dixitjain.githubapp.networks.ApiBuilder;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class RecyclerFrag extends Fragment {


    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    CompositeDisposable compositeDisposable;
    List<Item> data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        assert getArguments() != null;
        String search = getArguments().getString("SEACH_KEY");

        View view = inflater.inflate(R.layout.recycler_frag, container, false);

         //RecyclerView Creation
        recyclerView = view.findViewById(R.id.content_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        netwrokOp(search);


        return view;
    }

     //API call using RxJava
    private void netwrokOp(String search) {


        compositeDisposable = new CompositeDisposable();

        try {

            compositeDisposable.add(
                    ApiBuilder.getApiBuilder(search)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(results -> {

                                data = results.getItems();

                                    adapter = new RecyclerAdapter(data);
                                    recyclerView.setAdapter(adapter);

                            }));


        } catch (Exception e) {

            System.out.println(e.toString());

        }
    }

    @Override
    public void onStop() {
        super.onStop();

        compositeDisposable.dispose();

    }

}
