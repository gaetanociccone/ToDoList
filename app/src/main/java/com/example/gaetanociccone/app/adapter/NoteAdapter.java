package com.example.gaetanociccone.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gaetanociccone.app.R;
import com.example.gaetanociccone.app.model.Note;

import java.util.ArrayList;

/**
 * Created by gaetanociccone on 20/02/17.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteVH> {

    private static Context context;
    public ArrayList<Note> dataSet = new ArrayList<>();

    public NoteAdapter(Context c) {
        context = c;
    }

    public class NoteVH extends RecyclerView.ViewHolder {

        TextView title, body;

        public NoteVH(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.id_title);
            body = (TextView) itemView.findViewById(R.id.id_body);
        }
    }

    @Override
    public NoteVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card, parent, false);
        return new NoteVH(v);
    }

    @Override
    public void onBindViewHolder(NoteVH holder, int position) {
        Note note = dataSet.get(position);
        holder.title.setText(note.getTitle());
        holder.body.setText(note.getBody());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void addNote(Note note) {
        dataSet.add(0,note);
        notifyItemInserted(0);
    }

    public void setDataSet(ArrayList<Note> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

}
