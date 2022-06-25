package com.example.zofyamobile;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zofyamobile.databinding.ActivityItemDetailBinding;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import classes.Item;
import classes.ZofyaFetchResults;
import interfaces.ZofyaAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class ItemDetailHostActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private static final String TAG = "Zofya";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityItemDetailBinding binding = ActivityItemDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment_item_detail);
        NavController navController = navHostFragment.getNavController();
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.
                Builder(navController.getGraph())
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:7004")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getItemInformation();
        /*
        ZofyaAPIService zofyaApiService = retrofit.create(ZofyaAPIService.class);
        Call call = zofyaApiService.getItem();

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    // ArrayList pokemonList = response.body().getResults();
                    View recyclerView = findViewById(R.id.item_list);
                    assert recyclerView != null;
                    // setupRecyclerView((RecyclerView) recyclerView, pokemonList);
                } else {
                    Log.d("Error", "Something happened");
                    return;
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("Error", t.toString());
            }
        });*/
    }

    private void getItemInformation() {
        ZofyaAPIService zofyaApiService = retrofit.create(ZofyaAPIService.class);
        Call<ZofyaFetchResults> call = zofyaApiService.getItem();

        call.enqueue(new Callback<ZofyaFetchResults>() {
            @Override
            public void onResponse(Call<ZofyaFetchResults> call, Response<ZofyaFetchResults> response) {
                if (response.isSuccessful()) {
                    ZofyaFetchResults zofyaFetchResults = response.body();
                    ArrayList<Item> items = zofyaFetchResults.getResults();

                    for (int i = 0; i < items.size(); i++) {
                        Item item = items.get(i);
                        Log.i(TAG, "Item: " + item.getName());
                    }
                } else {
                    Log.e(TAG, "onResponse" + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ZofyaFetchResults> call, Throwable t) {
                Log.e(TAG, "onFailure" + t.getMessage());
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_item_detail);
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}