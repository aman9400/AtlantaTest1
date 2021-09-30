package com.example.atlantatest1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.atlantatest1.bean.Example;
import com.example.atlantatest1.database.MyDatabase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelUser extends ViewModel {

    private MutableLiveData<List<Example>> userList;

    public ViewModelUser() {
       userList = new MutableLiveData<>();
    }

    public  MutableLiveData<List<Example>> getUserList(){
        return userList;
    }
    public void getApiResponse() {

        Call<List<Example>> call = RetrofitClient.getInstance().getMyApi().getUserData();
        call.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {

                userList.postValue(response.body());


            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {
                userList.postValue(null);

            }

        });
    }

}
