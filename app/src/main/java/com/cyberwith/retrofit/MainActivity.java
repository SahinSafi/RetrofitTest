package com.cyberwith.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);

        final Call<List<DataSet>> dataList = ourRetrofit.getDataSet();
        dataList.enqueue(new Callback<List<DataSet>>() {
            @Override
            public void onResponse(Call<List<DataSet>> call, Response<List<DataSet>> response) {
                showData(response.body());
            }

            @Override
            public void onFailure(Call<List<DataSet>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), " Error ", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showData(List<DataSet> dataSets){

        RAdapter adapter = new RAdapter(MainActivity.this, dataSets);
        recyclerView.setAdapter(adapter);

    }
}
