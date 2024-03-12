package com;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.constiutionofindia.R;

import java.util.ArrayList;
import java.util.List;

public class Note_editerActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "NotePrefs";
    private static final String KEY_NOTE_COUNT = "NoteCount";

    private LinearLayout notesContainer;
    private List<Notes> notesList;
    private ImageView imageView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editer);

        imageView = findViewById(R.id.processback);

        notesContainer = findViewById(R.id.notesContainer);
        Button saveButton = findViewById(R.id.saveButton);

        notesList = new ArrayList<>();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNote();
            }
        });
        loadNotesFromPreferences();

        displayNotes();


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



    }

    private void displayNotes() {

        for (Notes notes : notesList) {
            createNoteView(notes);
        }
    }

    private void loadNotesFromPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int noteCount = sharedPreferences.getInt(KEY_NOTE_COUNT, 0);

        for (int i = 0; i < noteCount; i++) {
            String title = sharedPreferences.getString("note_title_" + i, "");
            String content = sharedPreferences.getString("note_content_" + i, "");

            Notes notes = new Notes();
            notes.setTitle(title);
            notes.setContent(content);

            notesList.add(notes);
        }
    }

    private void saveNote() {
        EditText titleEditText = findViewById(R.id.titleEditText);
        EditText contentEditText = findViewById(R.id.contentEditText);

        String title = titleEditText.getText().toString();
        String content = contentEditText.getText().toString();

        if (!title.isEmpty() && !content.isEmpty()) {
            Notes notes = new Notes();
            notes.setTitle(title);
            notes.setContent(content);

            notesList.add(notes);
            saveNotesToPreferences();

            createNoteView(notes);
            clearInputField();

        }
    }

    private void clearInputField() {

        EditText titleEditText = findViewById(R.id.titleEditText);
        EditText contentEditText = findViewById(R.id.contentEditText);

        titleEditText.getText().clear();
        contentEditText.getText().clear();
    }

    private void createNoteView(final Notes notes) {
        View noteView = getLayoutInflater().inflate(R.layout.note_item, null);
        TextView titleTextView = noteView.findViewById(R.id.titleTextView);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView contentTextView = noteView.findViewById(R.id.contentTextView); // assuming contentTextView is a TextView

        titleTextView.setText(notes.getTitle());
        contentTextView.setText(notes.getContent());

        noteView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showDeleteDialog(notes);
                return true;
            }
        });

        notesContainer.addView(noteView);
    }



    private void showDeleteDialog(final Notes notes) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete this note");
        builder.setMessage("Are you sure you want to delete this note?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteNoteAndRefresh(notes);
            }

        });
        builder.setNegativeButton("Cancle", null);
        builder.show();
    }

    // ...

    private void deleteNoteAndRefresh(Notes notes) {
        notesList.remove(notes);
        saveNotesToPreferences();
        refreshNoteViews();  // Add this line to refresh the UI
    }

    private void refreshNoteViews() {

        notesContainer.removeAllViews();
        displayNotes();
    }


    private void saveNotesToPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_NOTE_COUNT, notesList.size());
        for (int i = 0; i < notesList.size(); i++) {
            Notes notes = notesList.get(i);
            editor.putString("note_title_" + i, notes.getTitle());
            editor.putString("note_content_" + i, notes.getContent());  // Add underscore here
        }

        editor.apply();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

