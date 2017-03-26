package hackemory.studywaves.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import hackemory.studywaves.R;
import hackemory.studywaves.model.Model;
import hackemory.studywaves.model.Test;

public class TestTrialsPage extends AppCompatActivity {
    private Test test;

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
        test = model.getTests().get(Integer.parseInt(getIntent().getExtras().getString("item")));
    }

    public void recordingPage(View view) {
        Intent intent = new Intent(this, RecordingPage.class);
        startActivity(intent);
    }
}
