package com.example.fragmentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CancionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentlistado fragmentListado = (fragmentlistado)getSupportFragmentManager().findFragmentById(R.id.frgListado);
        fragmentListado.setCancionListener(this);
    }
    public void onCancionSeleccionada(Cancion c) {
        boolean hayDetalle =(getSupportFragmentManager().findFragmentById(R.id.frgDetalle)!= null);
        if (hayDetalle) {
            ((FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle)).mostrarDetalle(c.getDuracion());
        }else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, c.getNombreCancion());
            startActivity(i);
        }
    }

    @Override
    public void onCorreoSeleccionado(Cancion c) {
        boolean hayDetalle =(getSupportFragmentManager().findFragmentById(R.id.frgDetalle)!= null);
        if (hayDetalle) {
            ((FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle)).mostrarDetalle(c.getNombreCancion());
        }else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, c.getNombreCancion());
            startActivity(i);
        }
    }
}