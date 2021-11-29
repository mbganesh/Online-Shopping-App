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
import android.widget.ProgressBar;
import android.widget.TextView;
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
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
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

    //    Loader
    ProgressBar loader;
    TextView loaderText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.home));

        loader = findViewById(R.id.homeLoader);
        loaderText = findViewById(R.id.homeLoaderText);

        ApiHelper apiHelper = new ApiHelper();
        api = apiHelper.getTempDataApi();

        recyclerView = findViewById(R.id.myProductRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    public void volleyPost(JSONObject obj) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, api, obj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.e("response", response.toString());
                jsonData = response + "";
                try {
                    JSONObject jsonObject = new JSONObject(jsonData);
                    Iterator<String> iterator = jsonObject.keys();
                    while (iterator.hasNext()) {
                        String keys = iterator.next();
                        JSONArray array = jsonObject.getJSONArray(keys);
                        list.add(new MyProductModel(keys, images[3], array));
                    }
                    adapter = new MyProductsAdapter(HomeActivity.this, list);
                    recyclerView.setAdapter(adapter);

                    loader.setVisibility(View.GONE);
                    loaderText.setVisibility(View.GONE);

                } catch (JSONException e) {
                    View v = findViewById(android.R.id.content);
                    Snackbar.make(v, "502 Server Error", Snackbar.LENGTH_LONG).setBackgroundTint(ContextCompat.getColor(HomeActivity.this, R.color.design_default_color_error)).show();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                View v = findViewById(android.R.id.content);
                Snackbar.make(v, "503 Server Down", Snackbar.LENGTH_LONG).setBackgroundTint(ContextCompat.getColor(HomeActivity.this, R.color.design_default_color_error)).show();
                Log.e("ERRor  ", error.getMessage() + ".");
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    private void loadDBData() {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("user", "admin");
            Log.e("admin", jsonData.toString());
            volleyPost(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadDBData();
    }
}