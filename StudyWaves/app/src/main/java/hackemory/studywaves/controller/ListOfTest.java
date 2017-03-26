package hackemory.studywaves.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import hackemory.studywaves.R;
import hackemory.studywaves.model.Model;
import hackemory.studywaves.model.Test;

public class ListOfTest extends AppCompatActivity {

    private ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //Step 1.  Setup the recycler view by getting it from our layout in the main window
        listview = (ListView) findViewById(R.id.test_list_display);
        //Step 2.  Hook up the adapter to the view
        Model model = Model.getInstance();
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android.R.id.text1, model.convertTestToString());
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), TestTrialsPage.class);
                Bundle bundle1 = new Bundle();
                bundle1.putInt("item", position);
                intent.putExtras(bundle1);
                startActivity(intent);
            }
        });

    }


    public void addTestPage(View view) {
        Intent intent = new Intent(this, AddTestPage.class);
        startActivity(intent);
    }

    public void testTrialsPage(View view) {
        Intent intent = new Intent(this, TestTrialsPage.class);
        startActivity(intent);
    }

}
