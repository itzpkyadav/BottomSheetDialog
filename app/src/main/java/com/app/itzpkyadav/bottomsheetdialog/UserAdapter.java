package com.app.itzpkyadav.bottomsheetdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialog;

/**
 * Created by Itzpkyadav (itzpkyadav@gmail.com) on 20-01-2021
 * Copyright (c) 2021 itzpkyadav@gmail.com
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ProductHolder> {
    UserList userList;
    Context context;

    public UserAdapter(UserList userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list, parent, false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        UserList.Datum datum = userList.getData().get(position);
        final String primage = datum.getAvatar();
        final String Name = datum.getFirst_name() + " " + datum.getLast_name();
        final String Email = datum.getEmail();

        Glide.with(context).load(primage).into(holder.imageView);
        holder.name.setText(Name);
        holder.email.setText(Email);
        holder.addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialog bt = new BottomSheetDialog(context, R.style.BottomSheetDialogTheme);
                View view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_lay, null);
                view.findViewById(R.id.btn_addtocart).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "add to cart", Toast.LENGTH_LONG).show();
                        bt.dismiss();
                    }
                });
                ImageView imageView = view.findViewById(R.id.my_image);
                Glide.with(context).load(primage).into(imageView);
                TextView name = view.findViewById(R.id.txt_prname);
                name.setText(Name);

                TextView price = view.findViewById(R.id.txt_email);
                price.setText(Email);

                bt.setContentView(view);
                bt.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.getData().size();
    }

    public class ProductHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, email;
        Button addtocart;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.primage);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            addtocart = itemView.findViewById(R.id.addTocart);

        }
    }
}