package mb.ganesh.simpleshoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

public class ProductDetailsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String item = null;
    JSONObject object = null;
    ImageView imageDetail;
    TextView titleDetail , descriptionDetail , priceDetail;
    MaterialButton placeOrderBtn;
    Spinner spinnerQuantity;

     String[] count;
     String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        item = getIntent().getStringExtra("item");
        Log.e("detail",item);

        imageDetail = findViewById(R.id.imageDetail);
        titleDetail = findViewById(R.id.titleDetail);
        descriptionDetail = findViewById(R.id.descriptionDetail);
        priceDetail = findViewById(R.id.priceDetail);
        placeOrderBtn = findViewById(R.id.placeOrderBtn);
        spinnerQuantity = findViewById(R.id.itemQuantity);


//        random
        descriptionDetail.setText(generateRandomWords(100));

        try {
            object = new JSONObject(item);
            price = object.getString("price");
            int size = Integer.parseInt(object.getString("quantity"));
            count = new String[size];

            for (int i = 0; i < size; i++) {
                count[i] = "" + (i+1);
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(ProductDetailsActivity.this,
                android.R.layout.simple_spinner_item,count);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerQuantity.setAdapter(adapter);
        spinnerQuantity.setOnItemSelectedListener(ProductDetailsActivity.this);

        try {
            object = new JSONObject(item);
            titleDetail.setText(object.getString("name"));
            priceDetail.setText(" ₹ "+ price);
            Glide.with(ProductDetailsActivity.this).load(object.getString("image")).into(imageDetail);

        } catch (JSONException e) {
            e.printStackTrace();
        }


//        place an order
        placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProductDetailsActivity.this, "Order Placed.", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        int displayAmount = Integer.parseInt(count[i]) * Integer.parseInt(price);

        String finalAmo = getAmountFormat(displayAmount);

        priceDetail.setText(" ₹ " + finalAmo);

    }

    private String getAmountFormat(int displayAmount) {
        return NumberFormat.getNumberInstance(Locale.getDefault()).format(displayAmount);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public static String generateRandomWords(int numberOfWords)
    {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }

        String out =null;
        for (int i = 0; i < randomStrings.length; i++) {
            out += randomStrings[i] + " ";
        }

        return out;
    }
}