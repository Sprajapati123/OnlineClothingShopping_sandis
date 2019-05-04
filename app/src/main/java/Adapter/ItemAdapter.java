package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.onlineclothingshopping.Dashboard;
import com.onlineclothingshopping.DetailActivity;
import com.onlineclothingshopping.ItemModel;
import com.onlineclothingshopping.Items;
import com.onlineclothingshopping.MainActivity;
import com.onlineclothingshopping.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    Context mContext;
    List<ItemModel> itemModelList;
    ItemModel itemModel;


    public ItemAdapter(Context mContext, List<ItemModel> itemModelList) {
        this.mContext = mContext;
        this.itemModelList = itemModelList;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imgview;
        TextView itemname,itemprice,itemdescription;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imgview=itemView.findViewById(R.id.imgview);
            itemname=itemView.findViewById(R.id.name);
            itemprice=itemView.findViewById(R.id.price);
            itemdescription=itemView.findViewById(R.id.description);

        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_description,viewGroup,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, final int i) {
        final ItemModel itemModel = itemModelList.get(i);

        itemViewHolder.imgview.setImageResource(itemModel.getImage_id());
        itemViewHolder.itemname.setText(itemModel.getItem_name());
        itemViewHolder.itemprice.setText(itemModel.getItem_price());
        itemViewHolder.itemdescription.setText(itemModel.getItem_description());

        itemViewHolder.imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, DetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("image",itemModel.getImage_id());
                intent.putExtra("name",itemModel.getItem_name());
                intent.putExtra("price",itemModel.getItem_price());
                intent.putExtra("desc",itemModel.getItem_description());


                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return itemModelList.size();
    }


}
