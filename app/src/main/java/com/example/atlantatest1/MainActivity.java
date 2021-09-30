package com.example.atlantatest1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.atlantatest1.bean.Example;
import com.example.atlantatest1.database.MyDatabase;
import com.example.atlantatest1.database.Store;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

   List<Example> examples;
    private RecyclerView recyclerUser;
    ViewModelUser viewModelUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerUser = findViewById(R.id.recyclerUser);
        recyclerUser.setHasFixedSize(true);
        recyclerUser.setLayoutManager(new LinearLayoutManager(this));

        AdapterUserList adapterUserList = new AdapterUserList(this, examples);
        recyclerUser.setAdapter(adapterUserList);



//        getApiResponse();

      viewModelUser =  ViewModelProviders.of(this).get(ViewModelUser.class);
      viewModelUser.getUserList().observe(this, new Observer<List<Example>>() {
          @Override
          public void onChanged(List<Example> examples) {
              if (examples != null){
                  examples = examples;
                  adapterUserList.setData(examples);



                 Store[] userData = MyDatabase.getDatabase(MainActivity.this).userDao().totalStoreUserData();
                 if(userData != null){
                     for (int i = 0; i <examples.size() ; i++) {
                         MyDatabase.getDatabase(MainActivity.this).userDao().insertIntoTable(examples.get(i).getName(), examples.get(i).getEmail()
                                 , examples.get(i).getPhone());

                     }
                 }


              }
          }
      });
      viewModelUser.getApiResponse();
    }


}