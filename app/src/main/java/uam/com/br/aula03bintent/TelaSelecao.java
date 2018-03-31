package uam.com.br.aula03bintent;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

public class TelaSelecao extends ListActivity {

    public static final String EXTRA_ESTADO="estado";
    public static final String EXTRA_RESULTADO="result";
    private String estados[], estado;
    private int posicao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        estados=getResources().getStringArray(R.array.estados);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, estados));
        estado = getIntent().getStringExtra(EXTRA_ESTADO);
        if(estado!=null){
            posicao = Arrays.asList(estados).indexOf(estado);
            getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
            getListView().setItemChecked(posicao, true);
        }
        //setContentView(R.layout.activity_tela_selecao);
    }

    protected void onListItemClick(ListView l, View v, int posicao, long id){
        String resultado = l.getItemAtPosition(posicao).toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_RESULTADO, resultado);
        setResult(RESULT_OK, intent);
        finish();
    }


}
