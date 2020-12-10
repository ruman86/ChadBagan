package club.innovinc.bagan;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailsActivity extends AppCompatActivity {

    Context context;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    DetailsModel detailsModel;
    String getSrl;
    ImageView detailsimg;
    TextView conTitle, conDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        context = getApplicationContext();
        getSrl = getIntent().getStringExtra("contid");
        detailsimg = findViewById(R.id.detailsimg);
        conTitle = findViewById(R.id.conTitle);
        conDetails = findViewById(R.id.conDetails);

        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();
        ApiService service = retrofit.create(ApiService.class);
        Call<DetailsModel> culList = service.getSingleDetails(getSrl);
        culList.enqueue(new Callback<DetailsModel>() {

            @Override
            public void onResponse(Call<DetailsModel> call, Response<DetailsModel> response) {

                detailsModel = response.body();
                Picasso.Builder builder = new Picasso.Builder(context);
                builder.downloader(new OkHttp3Downloader(context));
                builder.build().load(detailsModel.getConpreview())
                        .placeholder((R.drawable.ic_launcher_background)).error(R.drawable.ic_launcher_background)
                        .into(detailsimg);

                conTitle.setText(detailsModel.getSubject());
                conDetails.setText(detailsModel.getContentdetails());
            }

            @Override
            public void onFailure(Call<DetailsModel> call, Throwable t) {

            }
        });
    }
}