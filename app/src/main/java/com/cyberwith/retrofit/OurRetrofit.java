package com.cyberwith.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OurRetrofit {

    @GET("r8syw")
    Call<List<DataSet>> getDataSet();
}
