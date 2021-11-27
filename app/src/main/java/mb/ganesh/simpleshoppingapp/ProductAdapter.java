package mb.ganesh.simpleshoppingapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.sql.StatementEvent;

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
        String name = list.get(position).getName();
        String price = list.get(position).getPrice();
        String quantity = list.get(position).getQuantity();
        String image = list.get(position).getImage();

        holder.itemName.setText(name);
        holder.itemPrice.setText( "Price : " + "₹"+  getAmountFormat(price));
        holder.itemQuantity.setText("Quantity : "  + quantity);
        Glide.with(context).load(image).into(holder.itemImage);

        holder.itemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject currData = new JSONObject();
                try {
                    currData.put("name", name);
                    currData.put("price", price);
                    currData.put("quantity", quantity);
                    currData.put("image", image);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.e("Current Data" , currData.toString());
                context.startActivity(new Intent(context , ProductDetailsActivity.class).putExtra("item" , currData.toString()));
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ProducrHolder extends RecyclerView.ViewHolder{


        TextView itemName ,itemQuantity , itemPrice ;
        ImageView itemImage;
        MaterialCardView itemCard;

        public ProducrHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemName = itemView.findViewById(R.id.itemName);
            itemQuantity = itemView.findViewById(R.id.itemQuantity);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            itemCard = itemView.findViewById(R.id.itemCard);
        }
    }

    private String getAmountFormat(String price) {
        int pri = Integer.parseInt(price);

        return NumberFormat.getNumberInstance(Locale.getDefault()).format(pri);

    }

}
