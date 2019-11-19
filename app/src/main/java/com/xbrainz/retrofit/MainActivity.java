package com.xbrainz.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String base_url = "https://jsonplaceholder.typicode.com/";
    private String TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<ApiModel>> listCall = api.getData();

        listCall.enqueue(new Callback<List<ApiModel>>() {
            @Override
            public void onResponse(Call<List<ApiModel>> call, Response<List<ApiModel>> response) {
                Log.d("response",response.body().toString());
                Toast.makeText(getApplicationContext(),response.body().get(0).getBody(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ApiModel>> call, Throwable t) {
                Log.d(TAG,t.getMessage());
            }
        });

    }
}
