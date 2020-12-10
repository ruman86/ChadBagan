package club.innovinc.bagan;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import club.innovinc.bagan.model.CultivationList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ItemListActivity extends AppCompatActivity {

    Context context;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    List<CultivationList> cultivationLists;
    String cate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        cate = getIntent().getStringExtra("cate");
        Log.d("Get Cate", cate);
        context = getApplicationContext();
        recyclerView  = findViewById(R.id.rov_cultivation_list);

        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();
        ApiService service = retrofit.create(ApiService.class);
        Call<List<CultivationList>> culList = service.getContent(cate);
        culList.enqueue(new Callback<List<CultivationList>>() {
            @Override
            public void onResponse(Call<List<CultivationList>> call, Response<List<CultivationList>> response) {
             if(response.isSuccessful()) {
                 cultivationLists = response.body();
                 CultivationAdapter cultivationAdapter = new CultivationAdapter(context, cultivationLists);

                 RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                 recyclerView.setLayoutManager(layoutManager);
                 recyclerView.setAdapter(cultivationAdapter);
                 cultivationAdapter.setOnItemClickListener(new CultivationAdapter.ClickListener() {
                     @Override
                     public void onItemClick(int position, View v) {
                         String csrl = cultivationLists.get(position).getSrl();
                         //Toast.makeText(ItemListActivity.this, "Content serial"+csrl, Toast.LENGTH_LONG).show();
                         Intent intent  = new Intent(ItemListActivity.this, DetailsActivity.class);
                         intent.putExtra("contid", csrl);
                         startActivity(intent);
                     }
                 });
             }
            }

            @Override
            public void onFailure(Call<List<CultivationList>> call, Throwable t) {

            }
        });

    }
}