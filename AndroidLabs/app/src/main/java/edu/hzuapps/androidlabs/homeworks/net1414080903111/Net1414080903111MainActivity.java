﻿package edu.hzuapps.androidlabs.homeworks.net1414080903111;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends Activity implements AdapterView.OnItemLongClickListener {
    private List<String> note_names;
    private NoteDatabaseHelper dbHelper;
    ListView noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new NoteDatabaseHelper(this, "NoteList.db", null, 1);

        note_names = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                MainActivity.this, android.R.layout.simple_list_item_1, note_names
        );
        noteList = (ListView) findViewById(R.id.note_list);
        noteList.setAdapter(adapter);
        showNoteList();
        noteList.setOnItemLongClickListener(this);

        Button addNote = (Button) findViewById(R.id.addNote);
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*在数据库添加文件名，创建时间和id
                在EditNoteActivity中打开该笔记文件
                 */
                DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);
                String t = df.format(new Date());
                String NewNote = "new note";
                try {
                    FileOutputStream out = openFileOutput(NewNote, MODE_APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", NewNote);
                values.put("time", t);
                long RowId = db.insert("note", null, values);

                Intent intent = new Intent(MainActivity.this, EditNoteActivity.class);
                intent.putExtra("note_name", NewNote);
                intent.putExtra("id", RowId);
                startActivity(intent);
            }
        });

        noteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ViewContentActivity.class);
                String name = note_names.get(position);
                intent.putExtra("note_name", name);
                startActivity(intent);
            }
        });
    }

    private void showNoteList() {
        /*从数据库中得到笔记文件名列表
        显示到MainActivity中
         */
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("note", new String[]{"name"},
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                note_names.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("delete")
                .setMessage("delete this note?")
                .setPositiveButton("delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        note_names.remove(position);

                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        String note_name = note_names.get(position);
                        db.delete("note", "name=?", new String[]{note_name});

                        noteList.deferNotifyDataSetChanged();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(true)
                .show();
        return false;
    }
}
