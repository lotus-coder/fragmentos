package com.example.fragmentos;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class fragmentlistado extends Fragment {

    private Cancion[] datos = {
            new Cancion ("Persona 1", "Cancion 1", "Texto del Cancion 1"),
            new Cancion ("Persona 2", "Cancion 2", "Texto del Cancion 2"),
            new Cancion ("Persona 3", "Cancion 3", "Texto del Cancion 3"),
            new Cancion ("Persona 4", "Cancion 4", "Texto del Cancion 4"),
            new Cancion ("Persona 5", "Cancion 5", "Texto del Cancion 5"),
            new Cancion ("Persona 6", "Cancion 6", "Texto del Cancion 6"),
            new Cancion ("Persona 7", "Cancion 7", "Texto del Cancion 7")
    };
    private ListView lstListado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lstListado = (ListView)getView().findViewById(R.id.lstCanciones);
        lstListado.setAdapter(new AdaptadorCancion(this));
        //Asignamos el evento onItemClick() a la lista de los correos
        lstListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listener != null)
                    listener.onCorreoSeleccionado((Cancion)lstListado.getAdapter().getItem(position));
                }
            });
    }

    class AdaptadorCancion extends ArrayAdapter<Cancion> {
        Activity context;
        AdaptadorCancion(Fragment context) {
            super(context.getActivity(), R.layout.listitem_cancion, datos);
            this.context = context.getActivity();
        }
        @NonNull
        @Override
        public View getView(int position,@Nullable View convertView,@NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_cancion, null);

            TextView lblDe = (TextView) item.findViewById(R.id.nomCancion);
            lblDe.setText(datos[position].getNombreCancion());

            TextView lblAsunto = (TextView)item.findViewById(R.id.nomAutor);
            lblAsunto.setText(datos[position].getAutor());
            return (item);
        }
    }
}