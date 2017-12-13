package com.example.logonrm.pizzaria;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActiviy extends AppCompatActivity {

    @BindView(R.id.login) TextInputLayout login;

    @BindView(R.id.senha) TextInputLayout senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activiy);

        ButterKnife.bind(this);

        login.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validarUsuario();
            }
        });

        senha.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validarSenha();
            }
        });
    }

    @OnClick(R.id.btnConectar)
    public void conectar(){
        if(validarUsuario() && validarSenha()){
            Intent perfil = new Intent(this, MainActivity.class);
            perfil.putExtra("NomeUsuario",login.getEditText().getText().toString());
            startActivity(perfil);
        }
    }

    private boolean validarUsuario() {
        if (login.getEditText().getText().toString().isEmpty()){
            login.setError("Digite seu login");
            return false;
        }else{
            login.setError(null);
            return true;
        }
    }

    private boolean validarSenha() {
        if (senha.getEditText().getText().toString().isEmpty()){
            senha.setError("Digite sua senha");
            return false;
        }else{
            senha.setError(null);
            return true;
        }
    }
}
