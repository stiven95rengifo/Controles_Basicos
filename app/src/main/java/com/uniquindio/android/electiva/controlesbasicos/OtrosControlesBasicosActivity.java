package com.uniquindio.android.electiva.controlesbasicos;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Stiven Alejandro Rengifo Ospina
 * @version 1.0
 */
public class OtrosControlesBasicosActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView image;
    private TextView titulo;
    private EditText campoDeTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otros_controles_basicos_activity);

        image = (ImageView) findViewById(R.id.releses_android);
        image.setOnClickListener(this);
        image.setImageResource(R.drawable.image1);
        //Para que sirve ese setTag(.)???
        //Al parecer funciona como esl Hasmap, guardando la imagen como un numero entero, mucho mas facil de obtener
        image.setTag(R.drawable.image1);

        titulo = (TextView) findViewById(R.id.texto_controles_dos);
        BotonesActivity.mostrarMensaje(this, titulo.getText().toString());
        titulo.setText(" Desarrollando en android ");
        titulo.setBackgroundColor(Color.YELLOW);

        campoDeTexto = (EditText) findViewById(R.id.editText);
        campoDeTexto.setText("Hola mundo!!!");
        BotonesActivity.mostrarMensaje(this, campoDeTexto.getText().toString());
    }

    /**
     * Metodo que permite modificar la fuente de un campoDeTexto
     */
    private  void modificarFuente(){

        if(campoDeTexto.getText().toString().length()>5){
            Editable txtEditable = campoDeTexto.getText();

            //modifica el tipo de fuente
            txtEditable.setSpan(new TypefaceSpan("sans-serif-condensed"),0, txtEditable.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            //modifica el color de la fuente
            txtEditable.setSpan(new ForegroundColorSpan(Color.YELLOW),0, txtEditable.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            //modifica el estilo de fuente
            txtEditable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, txtEditable.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            //modifica el tamaño de la fuente. El valor boleano es para indicar la independencia del tamaño agregado
            //con respecto a la densida depixeles del dispositivo
            txtEditable.setSpan(new AbsoluteSizeSpan(30, true), 0, txtEditable.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }


    /**
     * Metodo que permite realizar el evento de un boton
     *
     * @param v evento el cual realiza un boton
     */
    @Override
    public void onClick(View v) {

        if (image.getId() == v.getId()) {
            Integer idCurrentDrawable = (Integer) image.getTag();
            if (idCurrentDrawable == R.drawable.image1) {
                image.setImageResource(R.drawable.imagen2);
                image.setTag(R.drawable.imagen2);
                modificarFuente();
            } else {
                image.setImageResource(R.drawable.image1);
                image.setTag(R.drawable.image1);
                campoDeTexto.setText("Hola mundo!!!");

            }
        }
    }
}
