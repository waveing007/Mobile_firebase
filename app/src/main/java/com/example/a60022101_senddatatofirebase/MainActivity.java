package com.example.a60022101_senddatatofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText name, studentLastN, Number;
    private Button send;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("students");
        name = (EditText) findViewById(R.id.name);
        studentLastN = (EditText) findViewById(R.id.lastname);
        Number = (EditText) findViewById(R.id.number);

        send = (Button) findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStudents();
            }
        });
    }

    public void  addStudents(){

        String studentName = name.getText().toString();
        String studentLastName = studentLastN.getText().toString();
        String studentNumber   = Number.getText().toString();

        if(!TextUtils.isEmpty(studentName) && !TextUtils.isEmpty(studentLastName)){

            String id = databaseReference.push().getKey();

            Students students = new Students(id,studentName,studentLastName,studentNumber);

            databaseReference.child(id).setValue(students);

            name.setText("");
            studentLastN.setText("");
            Number.setText("");

        }
        else {
            Toast.makeText(MainActivity.this,"Please Type The Student Name or StudentNumber",Toast.LENGTH_LONG).show();
        }
    }
}
