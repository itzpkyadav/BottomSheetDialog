package com.app.itzpkyadav.bottomsheetdialog;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    Button btn_prev, btn_next;
    TextView tv_no_data;
    UserList userList;
    int page_number = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv_no_data = findViewById(R.id.tv_no_data);
        recyclerView = findViewById(R.id.recycler_view);
        btn_prev = findViewById(R.id.btn_prev);
        btn_next = findViewById(R.id.btn_next);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        btn_prev.setOnClickListener(this);
        btn_next.setOnClickListener(this);
        getListData(page_number);
    }

    private void getListData(int page_number) {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setMessage("Loading data...");
        dialog.setCancelable(false);
        dialog.show();

        Call<UserList> call = MyRetrofit.getInstance().productApi().doGetUserList(String.valueOf(page_number));
        call.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                userList = response.body();
                if (userList.getData().size() > 0) {
                    tv_no_data.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    UserAdapter adapter = new UserAdapter(userList, MainActivity.this);
                    if (userList.getPage() == 1) {
                        btn_prev.setVisibility(View.INVISIBLE);
                        btn_next.setVisibility(View.VISIBLE);
                    } else if (userList.getPage() == 2) {
                        btn_next.setVisibility(View.INVISIBLE);
                        btn_prev.setVisibility(View.VISIBLE);
                    }
                    recyclerView.setAdapter(adapter);
                } else {
                    tv_no_data.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }
                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_prev:
                page_number--;
                getListData(page_number);
                break;
            case R.id.btn_next:
                page_number++;
                getListData(page_number);
                break;
        }
    }
}