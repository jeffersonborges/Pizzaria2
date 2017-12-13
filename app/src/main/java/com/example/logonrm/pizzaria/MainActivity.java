package com.example.logonrm.pizzaria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import  com.example.logonrm.pizzaria.model.Pedido;

public class MainActivity extends AppCompatActivity {

    String usuario;

    @BindView(R.id.nomeUsuario)
    TextView nomeUsuario;

    @BindView(R.id.chkAtum)
    CheckBox chkAtum;

    @BindView(R.id.chkBacon)
    CheckBox chkBacon;

    @BindView(R.id.chkCalabresa)
    CheckBox chkCalabresa;

    @BindView(R.id.chkLombinho)
    CheckBox chkLombinho;

    @BindView(R.id.rgTamanho)
    RadioGroup rgTamanho;

    @BindView(R.id.spPagamento)
    Spinner spPagamento;

    @BindView(R.id.btnFecharPedido)
    Button btnFecharPedido;

    Pedido pedido = new Pedido();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if (getIntent() != null) {
            usuario = getIntent().getStringExtra("NomeUsuario");
        }

        nomeUsuario.setText(usuario);
        setListenerCheckbox(chkBacon);
        setListenerCheckbox(chkCalabresa);
        setListenerCheckbox(chkLombinho);
        setListenerCheckbox(chkAtum);

    }



    @OnClick(R.id.btnFecharPedido)
    public void fecharPedido(){
        pedido.setCliente(usuario);
        pedido.setTamanho(getTamanhoSelecionado());
        pedido.setFormaPagamento(spPagamento.getSelectedItem().toString());

        Intent confirmarPedido = new Intent(this,ConfirmarPedidoActivity.class);
        confirmarPedido.putExtra("PEDIDO",pedido);
        startActivity(confirmarPedido);

    }


    public void setListenerCheckbox(final CheckBox checkbox){
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    pedido.addSabor(checkbox.getText().toString());
                }else{
                    pedido.removeSabor(checkbox.getText().toString());
                }
            }
        });
    }

    public String getTamanhoSelecionado(){
        return ((RadioButton)findViewById(rgTamanho.getCheckedRadioButtonId())).getText().toString();
    }
}
