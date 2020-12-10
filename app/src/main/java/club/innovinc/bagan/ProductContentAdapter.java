package club.innovinc.bagan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import club.innovinc.bagan.model.ProductContentModel;

public class ProductContentAdapter extends RecyclerView.Adapter<ProductContentAdapter.CustomViewHolder> {

    private static PClickListener mClickListener;
    private Context context;
    private List<ProductContentModel> productContentModelList;

    public ProductContentAdapter(Context context, List<ProductContentModel>productContentModelList){
        this.context = context;
        this.productContentModelList = productContentModelList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.product_item_list, parent, false);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(productContentModelList.get(position).getProductImage())
                .placeholder((R.drawable.ic_launcher_background)).error(R.drawable.ic_launcher_background)
                .into(holder.productImageView);
        holder.productTitleTv.setText(productContentModelList.get(position).getProductname());
    }

    @Override
    public int getItemCount() {
        return productContentModelList.size();
    }


    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView productImageView;
        TextView productTitleTv;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            productImageView = itemView.findViewById(R.id.tvProductImage);
            productTitleTv = itemView.findViewById(R.id.tvProductTitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(PClickListener clickListener) {
        ProductContentAdapter.mClickListener = clickListener;
    }

    public interface PClickListener {
        void onItemClick(int position, View v);
    }
}
