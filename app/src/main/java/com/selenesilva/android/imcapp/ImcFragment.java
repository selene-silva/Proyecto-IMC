package com.selenesilva.android.imcapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ACER V5-471 on 16/06/2017.
 */




public class ImcFragment extends Fragment {
    // se declaran las variables que corresponden a cada uno de los elemetos que se visualizan en la pantalla
    EditText mCampoPeso;
    EditText mCampoEstatura;
    Button mBotonCalcular;
    Button mBotonLimpiar;
    TextView mEtiquetaImc;



    @Nullable
    @Override// DECLARACION DE LAS VARIABLES
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmento_imc, container, false);
        mCampoPeso = (EditText) v.findViewById(R.id.campo_peso);
        mCampoEstatura = (EditText) v.findViewById(R.id.campo_estatura);
        mBotonCalcular = (Button) v.findViewById(R.id.boton_calcular);
        mBotonLimpiar = (Button) v.findViewById(R.id.boton_limpiar);

        mBotonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //ACCION DEL BOTON CALCULAR
                String s = mCampoPeso.getText().toString();
                double peso = Double.parseDouble(s);
                s = mCampoEstatura.getText().toString();
                double estatura = Double.parseDouble(s);
                double imc = peso / (estatura * estatura);
                s = String.format("%2.2f", imc);
                mEtiquetaImc.setText(s);

            }


        });


        mBotonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //ACCION DEL BOTON LIMPIAR
                mCampoPeso.setText("");
                mCampoEstatura.setText("");
                mEtiquetaImc.setText("0.0");
            }


        });


        return v;

    }


}