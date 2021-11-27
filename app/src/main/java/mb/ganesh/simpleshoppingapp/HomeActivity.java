package mb.ganesh.simpleshoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.card.MaterialCardView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {
    String jsonData = "";
    String api = null;
    ArrayList<MyProductModel> list = new ArrayList<>();
    RecyclerView recyclerView;
    MyProductsAdapter adapter;
    int[] images = {R.drawable.phone_pic, R.drawable.mens_cloth_pic, R.drawable.computer_pic, R.drawable.womens_cloth_pic, R.drawable.mens_cloth_pic};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.home));

        ApiHelper apiHelper = new ApiHelper();
        api = apiHelper.getTempDataApi();
        Log.e("API" , api);
        loadDBData(api);
        Log.e("JSON" , jsonData + "");



        recyclerView = findViewById(R.id.myProductRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        try {
            JSONObject jsonObject = new JSONObject(jsonData);

            Iterator<String> iterator = jsonObject.keys();

            while (iterator.hasNext()) {
                String keys = iterator.next();

                JSONArray array = jsonObject.getJSONArray(keys);

                list.add(new MyProductModel(keys , images[3] , array));
            }



            adapter = new MyProductsAdapter(HomeActivity.this , list);
            recyclerView.setAdapter(adapter);



        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void loadDBData(String url) {

//         need data... [ volley request ]



    }


}


//        startActivity(new Intent(HomeActivity.this , ProductListActivity.class).putExtra("pKey" , "Computer"));