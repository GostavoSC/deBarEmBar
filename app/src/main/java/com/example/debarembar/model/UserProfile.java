package com.example.debarembar.model;

import android.content.Intent;
import android.os.Bundle;

import com.example.debarembar.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class UserProfile extends AppCompatActivity {
    private File arquivoFoto = null;
    private static final int REQUEST_TAKE_PHOTO = 123;
    //TextView editTelefone = findViewById(R.id.editTelefone);
    //TextView editEndereco = findViewById(R.id.editEndereco);
    //TextView editCPF = findViewById(R.id.editCPF);
    //TextView txtNomeUser = findViewById(R.id.txtNomeUser);

    Button btnOkMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Perfil de Usuário");

        editDados();

        btnOkMain = findViewById(R.id.btnOkMain);

        btnOkMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void editDados() {
        /**
         * Método pra juntar os parâmetros de auxDados
         * (onde cada variável recebe o valor do parâmetro);
         */
        /*
        auxDados(usuario.getEndereco(), editEndereco);
        auxDados(usuario.getTelefone(), editTelefone);
        auxDados(usuario.getCPF(), editCPF);
        auxDados(usuario.gettxtNomeUser(), txtNomeUser);
        Log.e("Metodo", "editDados");

         */
    }

    public void auxDados(String string, TextView textview) {
        /**
         * Método "auxDados" irá definir os valores do usuário
         * (nome, telefone, endereço e CPF) pelos parâmetros de String e TextView;
         */
        textview.setText(string);
        Log.e("Metodo", "auxDados " + string );
    }

}
