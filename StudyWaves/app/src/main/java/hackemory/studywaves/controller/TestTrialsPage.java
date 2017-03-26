package hackemory.studywaves.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import hackemory.studywaves.R;
import hackemory.studywaves.model.Model;
import hackemory.studywaves.model.Test;

public class TestTrialsPage extends AppCompatActivity {

    private Test test;
    private TextView testView;
    private TextView testerView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_trials_page);
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

        Model model = Model.getInstance();
        Bundle extras = getIntent().getExtras();
        test = model.getTests().get(extras.getInt("item"));

        testView = (TextView) findViewById(R.id.textView);
        testerView = (TextView) findViewById(R.id.textView2);
        testView.setText(test.getTestName());
        testerView.setText(test.getTester());
        listView = (ListView) findViewById(R.id.trial_list);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android.R.id.text1, test.trialsToSting());
        listView.setAdapter(adapter);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent intent = new Intent(view.getContext(), .class);
                //Bundle bundle1 = new Bundle();
                //bundle1.putInt("item", position);
                //intent.putExtras(bundle1);
                //startActivity(intent);
            }
        });
    }

    public void recordingPage(View view) {
        Intent intent = new Intent(this, RecordingPage.class);
        startActivity(intent);
    }
}
