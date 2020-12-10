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

import club.innovinc.bagan.model.CultivationList;

public class CultivationAdapter extends RecyclerView.Adapter<CultivationAdapter.CustomViewHolder> {

private Context context;
private List<CultivationList> cultivationModelLists;
    private static ClickListener mClickListener;

public CultivationAdapter(Context context, List<CultivationList> cultivationLists){
    this.context = context;
    this.cultivationModelLists = cultivationLists;
}

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_list_view, parent, false);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(cultivationModelLists.get(position).getConpreview())
                .placeholder((R.drawable.ic_launcher_background)).error(R.drawable.ic_launcher_background)
                .into(holder.cropImageView);
        holder.cropTitleTv.setText(cultivationModelLists.get(position).getSubject());
    }
    @Override
    public int getItemCount() {
        return cultivationModelLists.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView cropImageView;
        TextView cropTitleTv;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            cropImageView = itemView.findViewById(R.id.cropImage);
            cropTitleTv = itemView.findViewById(R.id.tvCropTitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mClickListener.onItemClick(getAdapterPosition(), v);
        }


    }
    public void setOnItemClickListener(ClickListener clickListener) {
        CultivationAdapter.mClickListener = clickListener;
    }
    public interface ClickListener {
        void onItemClick(int position, View v);
    }
}
