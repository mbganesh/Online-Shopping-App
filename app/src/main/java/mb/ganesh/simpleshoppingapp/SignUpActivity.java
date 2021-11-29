package mb.ganesh.simpleshoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;

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

public class SignUpActivity extends AppCompatActivity {

    TextInputLayout userNameFieldLayout, phoneNoFieldLayout, passwordFieldLayout;
    TextInputEditText userNameField, phoneNoField, passwordField;
    MaterialButton signUpBtn;
    TextView signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        getWindow().setStatusBarColor(ContextCompat.getColor(this , R.color.signs));

        userNameField = findViewById(R.id.userNameField);
        phoneNoField = findViewById(R.id.phoneNoField);
        passwordField = findViewById(R.id.passwordField);

        userNameFieldLayout = findViewById(R.id.userNameFieldLayout);
        phoneNoFieldLayout = findViewById(R.id.phoneNoFieldLayout);
        passwordFieldLayout = findViewById(R.id.passwordFieldLayout);

        signUpBtn = findViewById(R.id.signUpBtn);
        signInBtn = findViewById(R.id.signInBtn);

//        signInBtn page
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
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
        userNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                userNameFieldLayout.setErrorEnabled(false);
                userNameFieldLayout.setError("");
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


//        signUpBtn onClick
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String us = userNameField.getText().toString().trim();
                String ph = phoneNoField.getText().toString().trim();
                String pa = passwordField.getText().toString().trim();

                if (TextUtils.isEmpty(us) && TextUtils.isEmpty(ph) && TextUtils.isEmpty(pa)) {
                    userNameFieldLayout.setError("Please enter user name");
                    phoneNoFieldLayout.setError("Please enter phone no");
                    passwordFieldLayout.setError("Please enter password");
                    userNameFieldLayout.setErrorEnabled(true);
                    phoneNoFieldLayout.setErrorEnabled(true);
                    passwordFieldLayout.setErrorEnabled(true);
                    return;
                }

                if (TextUtils.isEmpty(us)) {
                    userNameFieldLayout.setError("Please enter user name");
                    userNameFieldLayout.setErrorEnabled(true);
                } else if (TextUtils.isEmpty(ph)) {
                    phoneNoFieldLayout.setError("Please enter phone no");
                    phoneNoFieldLayout.setErrorEnabled(true);
                } else if (TextUtils.isEmpty(pa)) {
                    passwordFieldLayout.setError("Please enter password");
                    passwordFieldLayout.setError("Please enter password");
                } else {
                    try {
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("userName", us);
                        jsonObject.put("phoneNo", ph);
                        jsonObject.put("password", pa);
                        startActivity(new Intent(SignUpActivity.this, HomeActivity.class).putExtra("userData", jsonObject.toString()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });


    }
}