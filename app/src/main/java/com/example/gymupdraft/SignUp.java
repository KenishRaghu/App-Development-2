package com.example.gymupdraft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {

    private ImageView imgBack;
    private TextInputLayout txtFullNameLayout, txtEmailLayout, txtPasswordLayout, txtRePasswordLayout, txtPhoneLayout;
    private EditText edtTxtFullName, edtTxtEmail, edtTxtPassword, edtTxtRePassword, edtTxtPhone;
    private MaterialButton btnCreate;
    private Button btnLoginBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        imgBack = findViewById(R.id.signUp_back_btn);
        txtFullNameLayout = findViewById(R.id.txtFullNameLayout);
        txtEmailLayout = findViewById(R.id.txtEmailLayout);
        txtPasswordLayout = findViewById(R.id.txtPasswordLayout);
        txtRePasswordLayout = findViewById(R.id.txtRePasswordLayout);
        txtPhoneLayout = findViewById(R.id.txtPhoneLayout);
        btnCreate = findViewById(R.id.btnCreate);
        btnLoginBack = findViewById(R.id.btnLoginBack);

        edtTxtFullName = findViewById(R.id.edtTxtFullName);
        edtTxtEmail = findViewById(R.id.edtTxtEmail);
        edtTxtPassword = findViewById(R.id.edtTxtPassword);
        edtTxtRePassword = findViewById(R.id.edtTxtRePassword);
        edtTxtPhone = findViewById(R.id.edtTxtPhone);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, GymLogin.class);
                startActivity(intent);
            }
        });

        btnLoginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, GymLogin.class);
                startActivity(intent);
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateFields()){
                    /*edtTxtFullName.setText("");
                    edtTxtEmail.setText("");
                    edtTxtPassword.setText("");
                    edtTxtRePassword.setText("");
                    edtTxtPhone.setText("");*/

                    Toast.makeText(SignUp.this, "Successfully Created Account", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUp.this, GymLogin.class);
                    startActivity(intent);
                }
            }
        });
    }

    public boolean validateFields(){
        if(!validateFullName() | !validateEmail() | !validatePassword() | !validateRePassword() | !validatePhone()){
            return false;
        }
        return true;
    }


    private boolean validateFullName(){

        String val = txtFullNameLayout.getEditText().getText().toString().trim();

        if(val.isEmpty()){
            txtFullNameLayout.setError("Field Can not be Empty");
            edtTxtFullName.setText("");
            return false;
        }
        else{
            txtFullNameLayout.setError(null);
            txtFullNameLayout.setEnabled(false);
            return true;
        }
    }

    /*private boolean validateUsername(){

        String val = txtUsernameLayout.getEditText().getText().toString().trim();
        String checkSpaces = "\\A\\w{1,20}\\z";


        if(val.isEmpty()){
            txtFullNameLayout.setError("Field Can not be Empty");
            return false;
        }
        else if(val.length() > 20){
            txtUsernameLayout.setError("UserName is too Large");
            return false;
        }
        else if(!val.matches(checkSpaces)){
            txtUsernameLayout.setError("NO White Spaces are allowed");
            return false;
        }
        else{
            txtFullNameLayout.setError(null);
            txtFullNameLayout.setEnabled(false);
            return true;
        }
    }*/

    private boolean validateEmail(){

        String val = txtEmailLayout.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(val.isEmpty()){
            txtEmailLayout.setError("Field Can not be Empty");
            edtTxtEmail.setText("");
            return false;
        }
        else if (!val.matches(checkEmail)){
            txtEmailLayout.setError("Invalid Email");
            edtTxtEmail.setText("");
            return false;
        }
        else{
            txtEmailLayout.setError(null);
            txtEmailLayout.setEnabled(false);
            return true;
        }
    }

    private boolean validatePassword(){

        String val = txtPasswordLayout.getEditText().getText().toString().trim();
        String checkPassword = "^" + "(?=.*[0-9])" + "(?=.*[a-z])" + "(?=.*[A-Z])" + "(?=.*[a-zA-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$)" + ".{4,}" + "$";

        if(val.isEmpty()){
            txtPasswordLayout.setError("Field Can not be Empty");
            edtTxtPassword.setText("");
            return false;
        }
        else if (!val.matches(checkPassword)){
            txtPasswordLayout.setError("Password should contain 4 Characters");
            edtTxtPassword.setText("");
            return false;
        }

        else{
            txtPasswordLayout.setError(null);
            txtPasswordLayout.setEnabled(false);
            return true;
        }
    }

    private boolean validateRePassword(){

        String val = txtRePasswordLayout.getEditText().getText().toString().trim();
        //String checkPassword = "^" + "(?=.*[0-9])" + "(?=.*[a-z])" + "(?=.*[A-Z])" + "(?=.*[a-zA-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$)" + ".{4,}" + "$";

        if(val.isEmpty()){
            txtRePasswordLayout.setError("Field Can not be Empty");
            edtTxtRePassword.setText("");
            return false;
        }
        else if (!val.matches(txtPasswordLayout.getEditText().getText().toString().trim())){
            txtRePasswordLayout.setError("Password Do not Match");
            edtTxtRePassword.setText("");
            return false;
        }

        else{
            txtRePasswordLayout.setError(null);
            txtRePasswordLayout.setEnabled(false);
            return true;
        }
    }

    private boolean validatePhone(){

        String val = txtPhoneLayout.getEditText().getText().toString().trim();
        String checkPhone = "\\A\\w{1,10}\\z";
        if(val.isEmpty()){
            txtPhoneLayout.setError("Field Can not be Empty");
            edtTxtPhone.setText("");
            return false;
        }
        else if (!val.matches(checkPhone)){
            txtPhoneLayout.setError("Invalid Email");
            edtTxtPhone.setText("");
            return false;
        }
        else if (val.length() > 10){
            txtPhoneLayout.setError("Phone length exceeds");
            edtTxtPhone.setText("");
            return false;
        }
        else{
            txtPhoneLayout.setError(null);
            txtPhoneLayout.setEnabled(false);
            return true;
        }
    }

}