package com.example.debarembar.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.debarembar.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Login extends AppCompatActivity {


    private static final String TAG = "1";
    Button btnEnviar, btnVerificar;
    EditText txtPhone;
    String v1erificationId;
    FirebaseAuth mAuth;
    ImageView imgLoading;

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = null;
    PhoneAuthCredential credential;
    String phoneNumber = "";
    String code;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imgLoading= findViewById(R.id.imgLoading);

        setContentView(R.layout.activity_login);
        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);
        if (!phoneNumber.equalsIgnoreCase(preferences.getString("telefoneUser",""))){
            Intent intent = new Intent(Login.this, CompartilharLista.class);
            intent.putExtra("numeroUser",preferences.getString("telefoneUser","") );
            startActivity(intent);
            finish();
        }else {

            txtPhone = findViewById(R.id.editText);
            txtPhone.setText("+55");
            btnVerificar = findViewById(R.id.btnVerificar);
            mAuth = FirebaseAuth.getInstance();
            btnVerificar.setEnabled(false);
            btnEnviar = findViewById(R.id.btnEnviar);
            btnEnviar.setText("Enviar");
            imgLoading= findViewById(R.id.imgLoading);
            btnEnviar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    phoneNumber = String.valueOf(txtPhone.getText());

                    Glide.with(Login.this)
                            .load(R.drawable.loading)
                            .into(imgLoading);
                    verificaEstado();


                }
            });


            mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                @Override
                public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                    credential = phoneAuthCredential;
                    Log.e(TAG, "onVerificationCompleted:" + credential);

                    signInWithPhoneAuthCredential(credential);


                }

                @Override
                public void onVerificationFailed(FirebaseException e) {
                    Log.w(TAG, "onVerificationFailed", e);

                    if (e instanceof FirebaseAuthInvalidCredentialsException) {
                        // Invalid request
                        // ...
                    } else if (e instanceof FirebaseTooManyRequestsException) {
                        // The SMS quota for the project has been exceeded
                        // ...
                    }
                }

                @Override
                public void onCodeSent(@NonNull final String verificationId,
                                       @NonNull PhoneAuthProvider.ForceResendingToken token) {
                    // The SMS verification code has been sent to the provided phone number, we
                    // now need to ask the user to enter the code and then construct a credential
                    // by combining the code with a verification ID.
                    Log.d(TAG, "onCodeSent:" + verificationId);
                    imgLoading.setVisibility(View.INVISIBLE);
                    txtPhone.setText("");
                    txtPhone.setHint("Codigo");
                    // Save verification ID and resending token so we can use them later
                    btnVerificar.setEnabled(true);
                    btnEnviar.setEnabled(false);
                    v1erificationId = verificationId;
                    // mostrar interface para o usuario digitar o codigo
                    btnVerificar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            code = String.valueOf(txtPhone.getText());
                            Log.e("code", code);
                            imgLoading.setVisibility(View.VISIBLE);
                            onVerificationCompleted(PhoneAuthProvider.getCredential(verificationId, String.valueOf(code)));
                        }
                    });

                }
            };
        }
    }


    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        imgLoading.setVisibility(View.INVISIBLE);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.e(TAG, "signInWithCredential:success");

                            FirebaseUser user = task.getResult().getUser();
                            user.sendEmailVerification();
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            intent.putExtra("numeroUser", user.getPhoneNumber());
                            SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("telefoneUser", user.getPhoneNumber());
                            editor.apply();

                            startActivity(intent);
                            finish();


                            // ...
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                            }
                        }
                    }
                });
    }

    public void verificaEstado() {
        // OnVerificationStateChangedCallbacks*/
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);
    }
}




