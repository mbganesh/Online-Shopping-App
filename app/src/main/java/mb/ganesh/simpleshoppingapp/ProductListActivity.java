package mb.ganesh.simpleshoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    String json = "{ \"Mobile\": [{ \"Name\": \"Galaxy M31\", \"Price\": \"20000\", \"Quantity\": \"20\", \"Image\": \"https://i.postimg.cc/D00HRVQm/galaxym31.jpg\" }, { \"Name\": \"Redmi Note 9\", \"Price\": \"13000\", \"Quantity\": \"30\", \"Image\": \"https://i.postimg.cc/W3cTg4vj/Redmi.jpg\" }, { \"Name\": \"Poco X2\", \"Price\": \"14000\", \"Quantity\": \"10\", \"Image\": \"https://i.postimg.cc/YqR07QwF/poco.jpg\" }, { \"Name\": \"Galaxy M31\", \"Price\": \"20000\", \"Quantity\": \"20\", \"Image\": \"https://i.postimg.cc/D00HRVQm/galaxym31.jpg\" }, { \"Name\": \"Redmi Note 9\", \"Price\": \"13000\", \"Quantity\": \"30\", \"Image\": \"https://i.postimg.cc/W3cTg4vj/Redmi.jpg\" }, { \"Name\": \"Poco X2\", \"Price\": \"14000\", \"Quantity\": \"10\", \"Image\": \"https://i.postimg.cc/YqR07QwF/poco.jpg\" }, { \"Name\": \"Galaxy M31\", \"Price\": \"20000\", \"Quantity\": \"20\", \"Image\": \"https://i.postimg.cc/D00HRVQm/galaxym31.jpg\" }, { \"Name\": \"Redmi Note 9\", \"Price\": \"13000\", \"Quantity\": \"30\", \"Image\": \"https://i.postimg.cc/W3cTg4vj/Redmi.jpg\" }, { \"Name\": \"Poco X2\", \"Price\": \"14000\", \"Quantity\": \"10\", \"Image\": \"https://i.postimg.cc/YqR07QwF/poco.jpg\" }, { \"Name\": \"Galaxy M31\", \"Price\": \"20000\", \"Quantity\": \"20\", \"Image\": \"https://i.postimg.cc/D00HRVQm/galaxym31.jpg\" }, { \"Name\": \"Redmi Note 9\", \"Price\": \"13000\", \"Quantity\": \"30\", \"Image\": \"https://i.postimg.cc/W3cTg4vj/Redmi.jpg\" }, { \"Name\": \"Poco X2\", \"Price\": \"14000\", \"Quantity\": \"10\", \"Image\": \"https://i.postimg.cc/YqR07QwF/poco.jpg\" } ], \"MensCloths\": [{ \"Name\": \"Designer Printed casual Shirts\", \"Price\": \"549\", \"Quantity\": \"5\", \"Image\": \"https://i.postimg.cc/15gH80yk/casula.jpg\" }, { \"Name\": \"Brocade Nehru Jacket in Light Beige\", \"Price\": \"3485\", \"Quantity\": \"20\", \"Image\": \"https://i.postimg.cc/qq63vL2Q/nehru-jacket-in-light-beige.jpg\" }, { \"Name\": \"Black and Grey color Rayon fabric Jodhpuri Suit \", \"Price\": \"9845\", \"Quantity\": \"20\", \"Image\": \"https://i.postimg.cc/9fxb4Lqj/jacket.jpg\" }, { \"Name\": \"Designer Printed casual Shirts\", \"Price\": \"549\", \"Quantity\": \"5\", \"Image\": \"https://i.postimg.cc/15gH80yk/casula.jpg\" }, { \"Name\": \"Brocade Nehru Jacket in Light Beige\", \"Price\": \"3485\", \"Quantity\": \"20\", \"Image\": \"https://i.postimg.cc/qq63vL2Q/nehru-jacket-in-light-beige.jpg\" }, { \"Name\": \"Black and Grey color Rayon fabric Jodhpuri Suit \", \"Price\": \"9845\", \"Quantity\": \"20\", \"Image\": \"https://i.postimg.cc/9fxb4Lqj/jacket.jpg\" }, { \"Name\": \"Designer Printed casual Shirts\", \"Price\": \"549\", \"Quantity\": \"5\", \"Image\": \"https://i.postimg.cc/15gH80yk/casula.jpg\" }, { \"Name\": \"Brocade Nehru Jacket in Light Beige\", \"Price\": \"3485\", \"Quantity\": \"20\", \"Image\": \"https://i.postimg.cc/qq63vL2Q/nehru-jacket-in-light-beige.jpg\" }, { \"Name\": \"Black and Grey color Rayon fabric Jodhpuri Suit \", \"Price\": \"9845\", \"Quantity\": \"20\", \"Image\": \"https://i.postimg.cc/9fxb4Lqj/jacket.jpg\" } ], \"Computer\": [{ \"Name\": \"2021 Apple iMac\", \"Price\": \"139,900\", \"Quantity\": \"10\", \"Image\": \"https://i.postimg.cc/rFRMpH35/apple.jpg\" }, { \"Name\": \"Dell Inspiron 7790\", \"Price\": \"50000\", \"Quantity\": \"20\", \"Image\": \"https://i.postimg.cc/VvpwR9rS/Dell.jpg\" }, { \"Name\": \"Hp \", \"Price\": \"9845\", \"Quantity\": \"20\", \"Image\": \"https://i.postimg.cc/MTG8J31M/hp.jpg\" }, { \"Name\": \"2021 Apple iMac\", \"Price\": \"139,900\", \"Quantity\": \"10\", \"Image\": \"https://i.postimg.cc/rFRMpH35/apple.jpg\" }, { \"Name\": \"Dell Inspiron 7790\", \"Price\": \"50000\", \"Quantity\": \"20\", \"Image\": \"https://i.postimg.cc/VvpwR9rS/Dell.jpg\" }, { \"Name\": \"Hp \", \"Price\": \"9845\", \"Quantity\": \"20\", \"Image\": \"https://i.postimg.cc/MTG8J31M/hp.jpg\" }, { \"Name\": \"2021 Apple iMac\", \"Price\": \"139,900\", \"Quantity\": \"10\", \"Image\": \"https://i.postimg.cc/rFRMpH35/apple.jpg\" }, { \"Name\": \"Dell Inspiron 7790\", \"Price\": \"50000\", \"Quantity\": \"20\", \"Image\": \"https://i.postimg.cc/VvpwR9rS/Dell.jpg\" }, { \"Name\": \"Hp \", \"Price\": \"9845\", \"Quantity\": \"20\", \"Image\": \"https://i.postimg.cc/MTG8J31M/hp.jpg\" } ], \"WomensCloths\": [{ \"Name\": \"Chudi\", \"Price\": \"2500\", \"Quantity\": \"50\", \"Image\": \"https://i.postimg.cc/nrmxgMQS/chudi.jpg\" }, { \"Name\": \"Jump Suit\", \"Price\": \"3000\", \"Quantity\": \"40\", \"Image\": \"https://i.postimg.cc/qMXV3PcK/jumpsuit.jpg\" }, { \"Name\": \"Girls Skater\", \"Price\": \"5000\", \"Quantity\": \"10\", \"Image\": \"https://i.postimg.cc/3RpbHGnG/skater.jpg\" }, { \"Name\": \"Chudi\", \"Price\": \"2500\", \"Quantity\": \"50\", \"Image\": \"https://i.postimg.cc/nrmxgMQS/chudi.jpg\" }, { \"Name\": \"Jump Suit\", \"Price\": \"3000\", \"Quantity\": \"40\", \"Image\": \"https://i.postimg.cc/qMXV3PcK/jumpsuit.jpg\" }, { \"Name\": \"Girls Skater\", \"Price\": \"5000\", \"Quantity\": \"10\", \"Image\": \"https://i.postimg.cc/3RpbHGnG/skater.jpg\" } ] }";

    String key = null;

//    Load Product Data

    RecyclerView recyclerView;
    ProductAdapter adapter;
    ArrayList<ProductModel> list = new ArrayList<>();

    TextView productTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        key = getIntent().getStringExtra("pKey");
        Log.e("KEY" , key + "");

        recyclerView = findViewById(R.id.productRecyclerView);
        productTitle = findViewById(R.id.productTitle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productTitle.setText(key);


        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONArray jsonArray = jsonObject.getJSONArray(key);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String  name = object.getString("Name");
                String  quantity = object.getString("Quantity");
                String  price = object.getString("Price");
                String  image = object.getString("Image");

                list.add(new ProductModel(name , quantity , price ,image));

            }

            recyclerView.setAdapter(new ProductAdapter(ProductListActivity.this , list));


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}