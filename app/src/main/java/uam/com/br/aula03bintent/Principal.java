package uam.com.br.aula03bintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_ESTADO=1;
    private static final String STATE_ESTADO="estado";
    private Button btEstado;
    private String estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btEstado =(Button) findViewById(R.id.btnEstado);
        btEstado.setOnClickListener(this);
        if(savedInstanceState!=null){
            estado = savedInstanceState.getString(STATE_ESTADO);
            btEstado.setText(estado);


        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, TelaSelecao.class);
        intent.putExtra(TelaSelecao.EXTRA_ESTADO, estado);
        startActivityForResult(intent, REQUEST_ESTADO);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode==REQUEST_ESTADO){
            estado = data.getStringExtra(TelaSelecao.EXTRA_RESULTADO);
            if(estado!=null){
                btEstado.setText(estado);
            }
        }
    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(STATE_ESTADO, estado);
    }
}
