package mb.ganesh.simpleshoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

public class HomeActivity extends AppCompatActivity {



    MaterialCardView computerCard , mensCard , womensCard , phoneCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        getWindow().setStatusBarColor(ContextCompat.getColor(this , R.color.home));

        computerCard = findViewById(R.id.computerCard);
        mensCard = findViewById(R.id.menCard);
        womensCard = findViewById(R.id.wommenCard);
        phoneCard = findViewById(R.id.phoneCard);

        computerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this , ProductListActivity.class).putExtra("pKey" , "Computer"));
            }
        });

        mensCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this , ProductListActivity.class).putExtra("pKey" , "MensCloths"));
            }
        });

        womensCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this , ProductListActivity.class).putExtra("pKey" , "WomensCloths"));
            }
        });

        phoneCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this , ProductListActivity.class).putExtra("pKey" , "Mobile"));
            }
        });






//        String user = getIntent().getStringExtra("userData");








    }
}