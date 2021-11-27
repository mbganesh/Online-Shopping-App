package mb.ganesh.simpleshoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class ProductListActivity extends AppCompatActivity {

    String json = null;

    RecyclerView recyclerView;
    ArrayList<ProductModel> list = new ArrayList<>();

    TextView productTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.col_black));
        json = getIntent().getStringExtra("proData");
        Log.e("ListArr", json);

        recyclerView = findViewById(R.id.productRecyclerView);
        productTitle = findViewById(R.id.productTitle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productTitle.setText("New Products");

        try {

            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String name = object.getString("Name");
                String quantity = object.getString("Quantity");
                String price = object.getString("Price");
                String image = object.getString("Image");
                list.add(new ProductModel(name, quantity, price, image));
            }

            recyclerView.setAdapter(new ProductAdapter(ProductListActivity.this, list));


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}