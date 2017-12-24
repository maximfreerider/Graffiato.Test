package com.example.user.stepan.graffiato;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Graffiato1 extends AppCompatActivity implements  ValueEventListener {
    TextView nameTv;
    TextView descriptionTv;
    ImageView main_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nameTv = (TextView)findViewById(R.id.nameText);
        descriptionTv = (TextView)findViewById(R.id.description);
        main_image = (ImageView) findViewById(R.id.main_image);
        setContentView(R.layout.activity_graffiato1);
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("places/-L12KVMHdPyZ8HTzoNJ_");
        myRef.addValueEventListener(this);
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Model model = dataSnapshot.getValue(Model.class);
        nameTv.setText(model.getName());
        descriptionTv.setText(model.getDescription());
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}

