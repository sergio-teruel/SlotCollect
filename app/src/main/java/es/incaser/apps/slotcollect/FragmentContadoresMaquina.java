package es.incaser.apps.slotcollect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by sergio on 28/09/14.
 */
public class FragmentContadoresMaquina extends Fragment {
    private static Cursor curMaquina;
    private static Cursor curRecaudacion;
    private static DbAdapter dbAdapter;

    EditText txtSal010Ant;
    EditText txtEnt010Ant;
    EditText txtEnt020Ant;
    EditText txtSal020Ant;
    EditText txtEnt050Ant;
    EditText txtEnt100Ant;
    EditText txtSal100Ant;
    EditText txtEnt200Ant;
    EditText txtEnt500Ant;
    EditText txtEnt1000Ant;

    //Contadores Actuales
    EditText txtEnt010;
    EditText txtSal010;
    EditText txtEnt020;
    EditText txtSal020;
    EditText txtEnt050;
    EditText txtEnt100;
    EditText txtSal100;
    EditText txtEnt200;
    EditText txtEnt500;
    EditText txtEnt1000;

    //Valores teoricos
    EditText txtJugadoTeorico;
    EditText txtPremioTeorico;
    EditText txtPartidas;

    private void bindAntData(View rootView){
        txtSal010Ant = (EditText)rootView.findViewById(R.id.txtSal010Ant);
        txtEnt010Ant = (EditText)rootView.findViewById(R.id.txtEnt010Ant);
        txtEnt020Ant = (EditText)rootView.findViewById(R.id.txtEnt020Ant);
        txtSal020Ant = (EditText)rootView.findViewById(R.id.txtSal020Ant);
        txtEnt050Ant = (EditText)rootView.findViewById(R.id.txtEnt050Ant);
        txtEnt100Ant = (EditText)rootView.findViewById(R.id.txtEnt100Ant);
        txtSal100Ant = (EditText)rootView.findViewById(R.id.txtSal100Ant);
        txtEnt200Ant = (EditText)rootView.findViewById(R.id.txtEnt200Ant);
        txtEnt500Ant = (EditText)rootView.findViewById(R.id.txtEnt500Ant);
        txtEnt1000Ant = (EditText)rootView.findViewById(R.id.txtEnt1000Ant);

        txtEnt010Ant.setText(getMaquina("INC_Entrada010"));

        txtSal010Ant.setText(getMaquina("INC_Salida010"));

        txtEnt020Ant.setText(getMaquina("INC_Entrada020"));
        txtSal020Ant.setText(getMaquina("INC_Salida020"));
        txtEnt050Ant.setText(getMaquina("INC_Entrada050"));
        txtEnt100Ant.setText(getMaquina("INC_Entrada100"));
        txtSal100Ant.setText(getMaquina("INC_Salida100"));
        txtEnt200Ant.setText(getMaquina("INC_Entrada200"));
        txtEnt500Ant.setText(getMaquina("INC_Entrada500"));
        txtEnt1000Ant.setText(getMaquina("INC_Entrada1000"));
    }

    private void bindActualData(View rootView) {
        txtEnt010 = (EditText)rootView.findViewById(R.id.txtEnt010);
        txtSal010 = (EditText)rootView.findViewById(R.id.txtSal010);
        txtEnt020 = (EditText)rootView.findViewById(R.id.txtEnt020);
        txtSal020 = (EditText)rootView.findViewById(R.id.txtSal020);
        txtEnt050 = (EditText)rootView.findViewById(R.id.txtEnt050);
        txtEnt100 = (EditText)rootView.findViewById(R.id.txtEnt100);
        txtSal100 = (EditText)rootView.findViewById(R.id.txtSal100);
        txtEnt200 = (EditText)rootView.findViewById(R.id.txtEnt200);
        txtEnt500 = (EditText)rootView.findViewById(R.id.txtEnt500);
        txtEnt1000 = (EditText)rootView.findViewById(R.id.txtEnt1000);

        txtJugadoTeorico = (EditText)rootView.findViewById(R.id.txtJugadoTeorico);
        txtPremioTeorico = (EditText)rootView.findViewById(R.id.txtPremioTeorico);
        txtPartidas = (EditText)rootView.findViewById(R.id.txtPartidas);

        txtEnt010.setText(getRecaudacion("INC_Entrada010"));
        txtSal010.setText(getRecaudacion("INC_Salida010"));
        txtEnt020.setText(getRecaudacion("INC_Entrada020"));
        txtSal020.setText(getRecaudacion("INC_Salida020"));
        txtEnt050.setText(getRecaudacion("INC_Entrada050"));
        txtEnt100.setText(getRecaudacion("INC_Entrada100"));
        txtSal100.setText(getRecaudacion("INC_Salida100"));
        txtEnt200.setText(getRecaudacion("INC_Entrada200"));
        txtEnt500.setText(getRecaudacion("INC_Entrada500"));
        txtEnt1000.setText(getRecaudacion("INC_Entrada1000"));

        txtJugadoTeorico.setText(getRecaudacion("INC_JugadoTeorico"));
        txtPremioTeorico.setText(getRecaudacion("INC_PremioTeorico"));
        txtPartidas.setText(getRecaudacion("INC_Partidas"));

    }
    
    private String getMaquina(String columna){
        return curMaquina.getString(curMaquina.getColumnIndex((columna)));
    }
    private String getRecaudacion(String columna){
        return curRecaudacion.getString(curRecaudacion.getColumnIndex(columna));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflamos la Vista que se debe mostrar en pantalla.
        View rootView = inflater.inflate(R.layout.fragment_slide_page_contadores, container,
                false);

        curMaquina = ScreenSlidePagerRecaudacion.curMaquina;
        bindAntData(rootView);

        curRecaudacion = ScreenSlidePagerRecaudacion.curRecaudacion;
        bindActualData(rootView);
        return rootView;
    }

    private void saveRecaudacion(){
        ContentValues values = new ContentValues();
        values.put("INC_Entrada010Ant", txtEnt010Ant.getText().toString());
        values.put("INC_Entrada020Ant", txtEnt020Ant.getText().toString());
        values.put("INC_Entrada050Ant", txtEnt050Ant.getText().toString());
        values.put("INC_Entrada100Ant", txtEnt100Ant.getText().toString());
        values.put("INC_Entrada200Ant", txtEnt200Ant.getText().toString());
        values.put("INC_Entrada500Ant", txtEnt500Ant.getText().toString());
        values.put("INC_Entrada1000Ant", txtEnt1000Ant.getText().toString());
        values.put("INC_Salida010Ant", txtSal010Ant.getText().toString());
        values.put("INC_Salida020Ant", txtSal020Ant.getText().toString());
        values.put("INC_Salida100Ant", txtSal100Ant.getText().toString());

        values.put("INC_Entrada010", txtEnt010.getText().toString());
        values.put("INC_Entrada020", txtEnt020.getText().toString());
        values.put("INC_Entrada050", txtEnt050.getText().toString());
        values.put("INC_Entrada100", txtEnt100.getText().toString());
        values.put("INC_Entrada200", txtEnt200.getText().toString());
        values.put("INC_Entrada500", txtEnt500.getText().toString());
        values.put("INC_Entrada1000", txtEnt1000.getText().toString());
        values.put("INC_Salida010", txtSal010.getText().toString());
        values.put("INC_Salida020", txtSal020.getText().toString());
        values.put("INC_Salida100", txtSal100.getText().toString());

        values.put("INC_JugadoTeorico", txtJugadoTeorico.getText().toString());
        values.put("INC_PremioTeorico", txtPremioTeorico.getText().toString());
        values.put("INC_Partidas", txtPartidas.getText().toString());

        int numRecords = ScreenSlidePagerRecaudacion.dbAdapter.updateRecord("INC_LineasRecaudacion", values,
                "CodigoEmpresa=? AND INC_CodigoMaquina=?",
                new String[]{getRecaudacion("CodigoEmpresa"), getRecaudacion("INC_CodigoMaquina")});
    }

    @Override
    public void onDestroy() {
        saveRecaudacion();
        super.onDestroy();
    }
}
