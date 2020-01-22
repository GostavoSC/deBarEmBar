package com.example.debarembar.model;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.example.debarembar.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class UserProfile extends AppCompatActivity {
    //TextView editTelefone = findViewById(R.id.editTelefone);
    //TextView editEndereco = findViewById(R.id.editEndereco);
    //TextView editCPF = findViewById(R.id.editCPF);
    //TextView txtNomeUser = findViewById(R.id.txtNomeUser);

    ImageView imagebtnMudarFoto;
    ImageView fotoPerfil;
    Button btnSave = findViewById(R.id.btnSave);
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Perfil de Usuário");

        editDados();
        savePhoto();

        imagebtnMudarFoto = findViewById(R.id.imagebtnMudarFoto);
        imagebtnMudarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences;
            }
        });

    }

    public void editDados() {
        /**
         * Método pra juntar os parâmetros de auxDados
         * (onde cada variável recebe o valor do parâmetro);
         */
        /*
        auxDados(user.getEndereco(), editEndereco);
        auxDados(user.getTelefone(), editTelefone);
        auxDados(user.getCPF(), editCPF);
        auxDados(user.gettxtNomeUser(), txtNomeUser);
         */
        Log.e("Metodo", "editDados");
    }

    public void auxDados(String string, TextView textview) {
        /**
         * Método "auxDados" irá definir os valores do usuário
         * (nome, telefone, endereço e CPF) pelos parâmetros de String e TextView;
         */
        textview.setText(string);
        Log.e("Metodo", "auxDados " + string );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        imagebtnMudarFoto = findViewById(R.id.imagebtnMudarFoto);
        fotoPerfil = findViewById(R.id.fotoPerfil);
        fotoPerfil.setImageBitmap(bitmap);

    }

    public void savePhoto(){

    }
}
