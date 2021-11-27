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

import java.util.ArrayList;

public class MyProductsAdapter extends RecyclerView.Adapter<MyProductsAdapter.MyProductHolder> {

    Context context;
    ArrayList<MyProductModel> productList;


    public MyProductsAdapter(Context context, ArrayList<MyProductModel> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public MyProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_product_row , parent , false);
        return new MyProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyProductHolder holder, int position) {
        holder.proTitle.setText(productList.get(position).getTitle());
        Glide.with(context).load(productList.get(position).getImage()).into(holder.proImage);
        holder.proCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Data" , productList.get(position).getArray() + "");
                context.startActivity(new Intent(context , ProductListActivity.class).putExtra("proData" , productList.get(position).getArray() + ""));
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyProductHolder extends RecyclerView.ViewHolder{
        MaterialCardView proCard;
        ImageView proImage;
        TextView proTitle;
        public MyProductHolder(@NonNull View itemView) {
            super(itemView);

            proCard = itemView.findViewById(R.id.proCard);
            proImage = itemView.findViewById(R.id.proImg);
            proTitle = itemView.findViewById(R.id.proTitle);

        }
    }
}
