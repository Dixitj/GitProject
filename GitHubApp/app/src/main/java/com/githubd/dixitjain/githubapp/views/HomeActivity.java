package com.githubd.dixitjain.githubapp.views;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.githubd.dixitjain.githubapp.R;
import com.githubd.dixitjain.githubapp.databinding.ActivityHomeBinding;
import com.githubd.dixitjain.githubapp.fragments.RecyclerFrag;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding activityHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Inflating Layout using Databinding
        activityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);

    }

    // onClick Search Button
    public void homeClick(View v) {

        String searchData = activityHomeBinding.searchText.getText().toString();

        if (searchData.equals(""))
            Toast.makeText(this, R.string.messageSearch, Toast.LENGTH_SHORT).show();

        else
            fragOperation(searchData);

    }


 //Fragment Transition
    private void fragOperation(String search){

            Bundle searchQuery = new Bundle();
            searchQuery.putString("SEACH_KEY",search);

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft =  fm.beginTransaction();
            RecyclerFrag recyclerFrag = new RecyclerFrag();
            recyclerFrag.setArguments(searchQuery);

            ft.replace(R.id.contentFrame,recyclerFrag)
                    .addToBackStack(null)
                    .commit();
        }


    }


