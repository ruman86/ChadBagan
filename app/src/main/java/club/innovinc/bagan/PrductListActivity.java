package club.innovinc.bagan;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import club.innovinc.bagan.model.ProductContentModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PrductListActivity extends AppCompatActivity {

    Context context;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    List<ProductContentModel> productContentModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prduct_list);

        context = getApplicationContext();
        recyclerView = findViewById(R.id.rov_product_list);
        String cate = getIntent().getStringExtra("cate");
        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<ProductContentModel>> productList = apiService.getProductList(cate);
        productList.enqueue(new Callback<List<ProductContentModel>>() {
            @Override
            public void onResponse(Call<List<ProductContentModel>> call, Response<List<ProductContentModel>> response) {
                if(response.isSuccessful()){
                    productContentModelList = response.body();
                    ProductContentAdapter productContentAdapter = new ProductContentAdapter(context, productContentModelList);
                    recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
                    recyclerView.setAdapter(productContentAdapter);

                    productContentAdapter.setOnItemClickListener(new ProductContentAdapter.PClickListener() {
                        @Override
                        public void onItemClick(int position, View v) {
                            String productId = productContentModelList.get(position).getSrl();
                            Intent intent = new Intent(PrductListActivity.this, WebViewActivity.class);
                            intent.putExtra("productid", productId);
                            startActivity(intent);
                            Toast.makeText(PrductListActivity.this, "Click", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<ProductContentModel>> call, Throwable t) {

            }
        });

    }
}