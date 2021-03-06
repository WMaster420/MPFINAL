package com.example.mpfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mpfinalproject.api_interfaces.JsonPlaceHolderApi;
import com.example.mpfinalproject.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private TextView text_view_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getdata();
    }
    private void getdata(){
        text_view_result = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://192.168.1.18:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi JsonPHApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call = JsonPHApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    text_view_result.setText("Code: "+response.code());
                    return;
                }

                List<Post> posts = response.body();
                for (Post posts1:posts) {
                    String content = "";
                    content += "\n\n Name: " + posts1.getName();
                    content += "\nEmail: " + posts1.getEmail();
                    content += "\nGrades: " + posts1.getGrades();

                    text_view_result.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
                text_view_result.setText(t.getMessage());
            }
        });
    }
}