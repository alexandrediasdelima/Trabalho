package fiap.com.br.trabalho;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import fiap.com.br.trabalho.adapter.ListaCarroAdapter;
import fiap.com.br.trabalho.dao.CarroDAO;
import fiap.com.br.trabalho.model.Carro;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tilNomeCarro;
    private TextInputLayout tilMarca;
    private TextInputLayout tilCor;
    private TextInputLayout tilAno;
    private TextInputLayout tilValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tilNomeCarro = (TextInputLayout) findViewById(R.id.tilNomeCarro);
        tilMarca = (TextInputLayout) findViewById(R.id.tilMarca);
        tilCor = (TextInputLayout) findViewById(R.id.tilCor);
        tilAno = (TextInputLayout) findViewById(R.id.tilAno);
        tilValor = (TextInputLayout) findViewById(R.id.tilValor);
    }


    public void cadastrar(View v) {

        CarroDAO carroDAO = new CarroDAO(this);
        Carro carro = new Carro();

        carro.setNome(tilNomeCarro.getEditText().getText().toString());
        carro.setMarca(tilMarca.getEditText().getText().toString());
        carro.setCor(tilCor.getEditText().getText().toString());
        carro.setAno(tilAno.getEditText().getText().toString());
        carro.setValor(tilValor.getEditText().getText().toString());

        carroDAO.add(carro);

        startActivity(new Intent(this, ItemActivity.class));
        finish();

    }

}
