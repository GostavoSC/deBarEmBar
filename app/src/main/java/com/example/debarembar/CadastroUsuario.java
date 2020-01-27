package com.example.debarembar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.debarembar.model.User;
import com.example.debarembar.model.UserProfile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CadastroUsuario extends AppCompatActivity {

    EditText editTextNome;
    EditText editTextEndereco;

    String getNomeUser;
    String getEnderecoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        setTitle("Cadastro de Usuário");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        editTextNome = findViewById(R.id.editTextNome);
        editTextEndereco = findViewById(R.id.editTextEndereco);

        //Criando itens necessários para o cadastro de usuário;
        String nomeUser = String.valueOf(editTextNome.getText());
        String enderecoUser = String.valueOf(editTextEndereco.getText());

        //Criando SharedPreferences para salvar
        //nome e endereço do usuário.
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        //Adicionando componentes de cadastro no SharedPreferences
        //para salvá-los;
        edit.putString("name", nomeUser);
        edit.putString("adress", enderecoUser);
        edit.commit();
        //Itens no SharedPreferences salvos;

        /**
         * TODO: JSONObject > String > JSONObject
         */

        //Passando uma String para o SharedPreferences
        //getNomeUser = sharedPreferences.getString("name", null);
        //getEnderecoUser = sharedPreferences.getString("adress", null);

        /**
         * Criando um novo SharedPreferences para
         * puxar as informações de telefone
         * da tela de Login;
         */
        SharedPreferences telefoneShared = getSharedPreferences("user_preferences", MODE_PRIVATE);
        telefoneShared.getString("user_preferences", "");

        //JSONObject armazenando as informações de usuários
        //(nome e endereço);
        //Telefone será direcionado pelo Firebase;
        JSONObject jsonObject = new JSONObject();
        try {
            //same key?
            jsonObject.put("nomeJSON", nomeUser);
            jsonObject.put("enderecoJSON", enderecoUser);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Transformando JSONObject em um String para adicioná-lo
        //no SharedPreferences
        String StringJSONObject = String.valueOf(jsonObject);
        edit.putString("StringJSONObject", StringJSONObject);
        Log.i("StringJSON", StringJSONObject);

            Button btnOk = findViewById(R.id.btnOk);
            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent (v.getContext(), MainActivity.class);
                    startActivity(intent);
                }
            });

    }


}