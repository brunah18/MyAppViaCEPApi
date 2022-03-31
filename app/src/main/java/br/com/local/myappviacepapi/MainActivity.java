package br.com.local.myappviacepapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Button btnBuscarCep;
    EditText txtCep;
    TextView cep;

    TextView txtLagradouro;
    TextView txtComplemento;
    TextView txtBairro;
    TextView txtCidade;
    TextView txtEstado;
    TextView lblResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtLagradouro = findViewById(R.id.txtLagradouro);
        txtComplemento = findViewById(R.id.txtComplemento);

        txtBairro = findViewById(R.id.txtBairro);
        txtCidade = findViewById(R.id.txtCidade);
        txtEstado = findViewById(R.id.txtEstado);


        txtCep = findViewById(R.id.txtCep);
        lblResposta = findViewById(R.id.lblResposta);
        btnBuscarCep = findViewById(R.id.btnBuscaCep);

        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // String endereco = txtCep.getText().toString().trim();

                try {
                    //preencher o cep no lblResposta do layout
                    CEP retorno = new HttpService(txtCep.getText().toString().trim()).execute().get();
                    txtLagradouro.setText("Logradouro: "+retorno.getLogradouro());
                    txtComplemento.setText("Complemento: "+retorno.getComplemento());
                    txtBairro.setText("Bairro: "+retorno.getBairro());
                    txtCidade.setText("Cidade: "+retorno.getLocalidade());
                    txtEstado.setText("Estado: "+retorno.getUf());





                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}