package mb.ganesh.simpleshoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONObject;

public class SignInActivity extends AppCompatActivity {

    MaterialButton signInBtn;
    TextView signUpBtn;
    TextInputLayout phoneNoFieldLayout , passwordFieldLayout;
    TextInputEditText phoneNoField , passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        signInBtn = findViewById(R.id.signInBtn);
        signUpBtn = findViewById(R.id.signUpBtn);
        phoneNoField = findViewById(R.id.phoneNoField);
        phoneNoFieldLayout = findViewById(R.id.phoneNoFieldLayout);
        passwordFieldLayout = findViewById(R.id.passwordFieldLayout);
        passwordField = findViewById(R.id.passwordField);

//        signUpBtn page
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this , SignUpActivity.class));
            }
        });


//        remove err msg while typing...
        phoneNoField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                phoneNoFieldLayout.setErrorEnabled(false);
                phoneNoFieldLayout.setError("");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        passwordField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                passwordFieldLayout.setErrorEnabled(false);
                passwordFieldLayout.setError("");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

//        signInBtn onClick
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = phoneNoField.getText().toString().trim();
                String pa = passwordField.getText().toString().trim();

                if(TextUtils.isEmpty(ph) || TextUtils.isEmpty(pa)){
                    phoneNoFieldLayout.setErrorEnabled(true);
                    phoneNoFieldLayout.setError("Please Enter Phone Number");
                    passwordFieldLayout.setErrorEnabled(true);
                    passwordFieldLayout.setError("Please Enter Password");
                }else {
                    try {
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("phoneNo" , ph);
                        jsonObject.put("password" , pa);
                        startActivity(new Intent(SignInActivity.this , HomeActivity.class).putExtra("userData" , jsonObject.toString()));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}