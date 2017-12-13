package com.example.logonrm.pizzaria;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PerfilUsuario extends AppCompatActivity {

    String usuario;

    @BindView(R.id.nomeUsuario)
    TextView nomeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        ButterKnife.bind(this);

        if (getIntent() != null) {
            usuario = getIntent().getStringExtra("NomeUsuario");
        }

        nomeUsuario.setText(usuario);
    }
}
