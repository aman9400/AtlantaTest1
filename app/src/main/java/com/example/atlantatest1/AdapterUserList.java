package com.example.atlantatest1;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atlantatest1.bean.Example;

import java.util.List;

public class AdapterUserList extends RecyclerView.Adapter<AdapterUserList.UserDataholder> {
    Context context;
    List<Example> userL;


    public AdapterUserList(Context context, List<Example> userL) {
        this.context = context;
        this.userL = userL;

    }

    public void setData(List<Example> userL){
        this.userL = userL;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserDataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycleruserlist, parent, false);
        return new AdapterUserList.UserDataholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserDataholder holder, int position) {


        holder.name.setText(userL.get(position).getName());
        holder.email.setText(userL.get(position).getEmail());
        holder.phone.setText(userL.get(position).getPhone());
        holder.cl1.setOnClickListener(v->{
            Toast.makeText(context, userL.get(position).getName(), Toast.LENGTH_SHORT).show();
        });
    }



    @Override
    public int getItemCount() {
        if (userL != null){
        return userL.size();}
        else {
            return 0;
        }
    }

    public class UserDataholder extends RecyclerView.ViewHolder {
        TextView name, email, phone;
        ConstraintLayout cl1;
        public UserDataholder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            phone = itemView.findViewById(R.id.phone);
            cl1 = itemView.findViewById(R.id.cl1);
        }
    }
}
