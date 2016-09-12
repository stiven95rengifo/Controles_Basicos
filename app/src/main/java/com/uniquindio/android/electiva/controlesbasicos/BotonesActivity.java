package com.uniquindio.android.electiva.controlesbasicos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * @author Stiven Alejandro Rengifo Ospina
 * @version 1.0
 * Prueba repositorio
 */
public class BotonesActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnNormal;
    private ToggleButton btnToggle;
    private ImageButton btnImage;
    private Switch btnSwitch;
    private FloatingActionButton btnFloat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.botones_activity);

        btnNormal = (Button) findViewById(R.id.id_btn_normal);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarMensaje(BotonesActivity.this,"Botón básico");
            }
        });

        btnToggle = (ToggleButton) findViewById(R.id.id_btn_toggle);
        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnToggle.isChecked()) {
                    mostrarMensaje(BotonesActivity.this,"Encendido");
                } else {
                    mostrarMensaje(BotonesActivity.this,"Apagado");
                }
            }
        });

        btnImage = (ImageButton) findViewById(R.id.id_btn_image);
        btnImage.setOnClickListener(this);

        btnSwitch = (Switch) findViewById(R.id.id_btn_switch);
        btnSwitch.setOnClickListener(this);

        btnFloat = (FloatingActionButton) findViewById(R.id.id_btn_flotante);
        btnFloat.setOnClickListener(this);


    }

    /**
     * Metodo que permite mostrar los mensajes que se quiere mostrar
     *
     * @param mensaje el cual se va mostrar
     */
    public static void mostrarMensaje(Context context,String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }

    /**
     * Metodo que permite realizar el evento de un boton
     *
     * @param v evento el cual realiza un boton
     */
    @Override
    public void onClick(View v) {

        if (v.getId() == btnImage.getId())
            mostrarMensaje(this,"Boton Imagen");

        if (v.getId() == btnSwitch.getId()) {
            if (btnSwitch.isChecked()) {
                mostrarMensaje(this, "Switch Encendido");
            }else {
                mostrarMensaje(this, "Switch Apagado");
            }
        }

        if (v.getId() == btnFloat.getId()) {
            mostrarMensaje(this, "Boton Flotante");
            startActivity(new Intent(this, OtrosControlesBasicosActivity.class));
        }
    }
}
