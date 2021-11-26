package mb.ganesh.simpleshoppingapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProducrHolder> {

    Context context;
    ArrayList<ProductModel> list;

    public ProductAdapter(Context context, ArrayList<ProductModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ProducrHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row , parent , false);
        return new ProducrHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProducrHolder holder, int position) {
        Log.e("model Data" , list.get(position).getName());

        holder.itemName.setText(list.get(position).getName());
        holder.itemPrice.setText( "Price : " + "₹"+ list.get(position).getPrice());
        holder.itemQuantity.setText("Quantity : "  + list.get(position).getQuantity());
        Glide.with(context).load(list.get(position).getImage()).into(holder.itemImage);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ProducrHolder extends RecyclerView.ViewHolder{


        TextView itemName ,itemQuantity , itemPrice ;
        ImageView itemImage;


        public ProducrHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemName = itemView.findViewById(R.id.itemName);
            itemQuantity = itemView.findViewById(R.id.itemQuantity);
            itemPrice = itemView.findViewById(R.id.itemPrice);
        }
    }
}
