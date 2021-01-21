package com.example.mpfinalproject;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mpfinalproject.api_interfaces.JsonPlaceHolderApi;
import com.example.mpfinalproject.models.Post;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class entry_upload extends AppCompatActivity{
    private Button retrieve, upload;
    private EditText name, email, grades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_upload);
        name=findViewById(R.id.nameT);
        email=findViewById(R.id.emailT);
        grades=findViewById(R.id.gradesT);
        retrieve=findViewById(R.id.retrieveB);
        upload=findViewById(R.id.uploadB);

        upload.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addPost();
            }
        });
        retrieve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(entry_upload.this,MainActivity.class));
            }
        });
    }
    void addPost() {
        String str1 = name.getText().toString().trim();
        String str2 = email.getText().toString().trim();
        int str3 = Integer.parseInt(String.valueOf(grades));


        Post pt = new Post(str1, str2, str3);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<Post> call = jsonPlaceHolderApi.createPost(pt);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    startActivity(new Intent(entry_upload.this, MainActivity.class));
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(entry_upload.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
}
}
