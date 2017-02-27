package com.example.gaetanociccone.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import com.example.gaetanociccone.app.R;
import com.example.gaetanociccone.app.adapter.NoteAdapter;
import com.example.gaetanociccone.app.database.Database;
import com.example.gaetanociccone.app.model.Note;

/**
 * Created by gaetanociccone on 20/02/17.
 */

public class NoteActivity extends AppCompatActivity {

    Intent intent;
    static RelativeLayout layout;
    RecyclerView noteRW;
    LinearLayoutManager layoutManager;
    NoteAdapter adapter;
    Database db;
    public static final String ACTION_MODE = "ACTION_MODE";
    private static final int REQUEST = 1001;
    public static final int REQUEST_EDIT = 1002;
    public static final int EDIT_MODE = 1;
    private static final int CREATE_MODE = 2;
    public static final String NOTE_TITLE_KEY = "NOTE_TITLE_KEY";
    public static final String NOTE_BODY_KEY = "NOTE_BODY_KEY";
    private static final String LAYOUT_MANAGER_KEY = "LAYOUT_MANAGER_KEY";
    private int STAGGERED_LAYOUT = 20;
    private int LINEAR_LAYOUT = 21;
    private int layoutManagerType = LINEAR_LAYOUT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);
        layout = (RelativeLayout) findViewById(R.id.id_activity_main);
        noteRW = (RecyclerView) findViewById(R.id.card_RecyclerView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new NoteAdapter(this);
        noteRW.setLayoutManager(layoutManager);
        noteRW.setAdapter(adapter);
        FloatingActionButton nuovaNotaBtn = (FloatingActionButton) findViewById(R.id.id_add_note_Btn);
        nuovaNotaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NoteActivity.this, AddActivity.class);
                startActivityForResult(intent, REQUEST);
            }
        });
        if(getIntent() != null) {
            if(getIntent().getAction() != null) {
                if(getIntent().getAction().equals(Intent.ACTION_SEND)) {
                    Intent intent = new Intent(NoteActivity.this, AddActivity.class);
                    intent.putExtra(ACTION_MODE, CREATE_MODE);
                    intent.putExtra(NOTE_BODY_KEY, getIntent().getStringExtra(Intent.EXTRA_TEXT));
                    startActivityForResult(intent, REQUEST);
                }
            }
        }
        db = new Database(this);
        adapter.setDataSet(db.getAllNotes());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            Note note = new Note(data.getStringExtra(AddActivity.TITOLO), data.getStringExtra(AddActivity.CONTENUTO));
            db.addNote(note);
            adapter.addNote(note);
        }
    }

}
