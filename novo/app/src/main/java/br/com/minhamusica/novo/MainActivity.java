package br.com.minhaempersa.alunoslista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener{
    List<String> Nomes = new ArrayList<String>();
    ListView listView;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nomes.add("Joao");
        Nomes.add("Maria");
        Nomes.add("Jose");
        Nomes.add("Emanuel");
        Nomes.add("Joaquim");

        Button bt = findViewById(R.id.adicionarButton);
        bt.setOnClickListener(this);

        listView = (ListView) findViewById(R.id.listaListView);
        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, Nomes);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onClick(View v) {
        EditText edittext = findViewById(R.id.nomesEditText);
        String Nome = edittext.getText().toString();

        Nomes.add(Nome);
        adapter.notifyDataSetChanged();

    }
}