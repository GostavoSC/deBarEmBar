package com.example.debarembar.model;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import static android.media.MediaRecorder.VideoSource.CAMERA;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import com.example.debarembar.R;
import com.example.debarembar.controller.MainActivity;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserProfile extends AppCompatActivity {
    private File arquivoFoto = null;
    private static final int REQUEST_TAKE_PHOTO = 123;
    //TextView editTelefone = findViewById(R.id.editTelefone);
    //TextView editEndereco = findViewById(R.id.editEndereco);
    //TextView editCPF = findViewById(R.id.editCPF);
    //TextView txtNomeUser = findViewById(R.id.txtNomeUser);

    ImageView imagebtnMudarFoto;
    ImageView fotoPerfil;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Perfil de Usuário");
        fotoPerfil = findViewById(R.id.fotoPerfil);

        SharedPreferences shared = getSharedPreferences("preferences", MODE_PRIVATE);

        editDados();



        btnSave = findViewById(R.id.btnSave);

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

                String img = String.valueOf(fotoPerfil);
                Log.e("img", img);

                SharedPAPI(img);
                //selectPhoto();

                SharedPreferences foto = getSharedPreferences("Foto", MODE_PRIVATE);
                SharedPreferences.Editor edit = foto.edit();
                edit.putString("Last", String.valueOf(fotoPerfil));
                edit.apply();

                String armz = String.valueOf(fotoPerfil);


                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);

                Context context = getApplicationContext();
                CharSequence text = "Alterações salvas";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

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
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        imagebtnMudarFoto = findViewById(R.id.imagebtnMudarFoto);
        fotoPerfil = findViewById(R.id.fotoPerfil);
        fotoPerfil.setImageBitmap(bitmap);
        Log.e("fotoPerfil", String.valueOf(fotoPerfil));

        SharedPreferences sharedPreferences;
        sharedPreferences = getSharedPreferences("Foto", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("Last", String.valueOf(fotoPerfil));
        edit.apply();
    }


    public void SharedPAPI(String img){
        SharedPreferences sharedPreferences = getSharedPreferences("Foto", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("Last", img);
        edit.apply();
    }



    public void selectPhoto(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");

        startActivityForResult(Intent.createChooser(intent, "selecionarimagem"),1);

    }

}
