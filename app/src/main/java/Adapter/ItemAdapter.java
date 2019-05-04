package Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.onlineclothingshopping.ItemModel;
import com.onlineclothingshopping.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    Context mContext;
    List<ItemModel> itemModelList;


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
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        ItemModel itemModel=itemModelList.get(i);

        itemViewHolder.imgview.setImageResource(itemModel.getImage_id());
        itemViewHolder.itemname.setText(itemModel.getItem_name());
        itemViewHolder.itemprice.setText(itemModel.getItem_price());
        itemViewHolder.itemdescription.setText(itemModel.getItem_description());

    }

    @Override
    public int getItemCount() {
        return itemModelList.size();
    }


}
