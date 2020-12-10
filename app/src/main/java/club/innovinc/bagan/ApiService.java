package club.innovinc.bagan;

import java.util.List;

import club.innovinc.bagan.model.CultivationList;
import club.innovinc.bagan.model.ProductContentModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("chaadbagan/content.php")
    Call<List<CultivationList>> getContent(@Query("tipscat") String tipscat);

    @GET("chaadbagan/speccontent.php")
    Call<DetailsModel> getSingleDetails(@Query("csrl") String csrl);


    @GET("chaadbagan/productinfo.php")
    Call<List<ProductContentModel>> getProductList(@Query("category") String category);

}
