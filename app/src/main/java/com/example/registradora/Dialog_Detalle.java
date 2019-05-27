package com.example.registradora;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class Dialog_Detalle extends AppCompatDialogFragment {

    private EditText dPrecio;
    private EditText dDetalle;
    private DialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog, null);

        builder.setView(v)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int precio = Integer.parseInt(dPrecio.getText().toString());
                        String detalle = dDetalle.getText().toString();
                        listener.obtenerTextos(precio, detalle);
                    }
                });
        dPrecio = v.findViewById(R.id.precio);
        dDetalle = v.findViewById(R.id.detalle);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "Implementar DialogListener");
        }
    }

    public interface DialogListener {
        void obtenerTextos(int precio, String detalle);
    }
}
