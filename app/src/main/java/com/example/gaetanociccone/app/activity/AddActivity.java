package com.example.gaetanociccone.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import com.example.gaetanociccone.app.R;

/**
 * Created by gaetanociccone on 20/02/17.
 */

public class AddActivity extends AppCompatActivity {

    static final String TITOLO = "titolo";
    static final String CONTENUTO = "contenuto";
    EditText title, content;
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        title = (EditText) findViewById(R.id.id_add_titolo);
        content = (EditText) findViewById(R.id.id_add_contenuto);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_confirm, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.id_action_confirm) {
            insertNote();
            return true;
        }
        if(item.getItemId() == android.R.id.home) {
            setResult(Activity.RESULT_CANCELED);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void insertNote() {
        Intent intent = new Intent();
        intent.putExtra(TITOLO, title.getText().toString());
        intent.putExtra(CONTENUTO, content.getText().toString());
        if(!title.getText().toString().isEmpty() && !content.getText().toString().isEmpty()) {
            setResult(Activity.RESULT_OK, intent);
            finish();
        } else {
            Toast.makeText(this, "Completa i campi richiesti!", Toast.LENGTH_SHORT).show();
        }
    }

    public void modifyNote() {
        //
    }

    public void deleteNote() {
        //
    }

}
