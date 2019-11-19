package com.bitm.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();

        //DatabaseReference databaseReference1 = FirebaseDatabase.getInstance().getReference(); (For write in single line.)

//        //Write multiple data in Firebase using Hashmap..
//        Map<String,Object> usermap = new HashMap<>();
//        usermap.put("name", "Arifur Rahman");
//        usermap.put("age",25);
//        usermap.put("gender","Male");
//        usermap.put("userId","UID1");
//
//
//        DatabaseReference userDataRef = databaseReference.child("users").child("UID1");
//        userDataRef.setValue(usermap).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()) {
//                    Toast.makeText(MainActivity.this, "Successfully updated", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }).addOnCanceledListener(new OnCanceledListener() {
//            @Override
//            public void onCanceled() {
//                Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
//}

//        Write multiple data Using pojo class.
//        User user = new User("Arifur Rahman", 25, "Male");
//        user.setUserId("UID1");
//
//
//        DatabaseReference userDataRef = databaseReference.child("users").child("UID1");
//        userDataRef.setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()) {
//                    Toast.makeText(MainActivity.this, "Successfully updated", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }).addOnCanceledListener(new OnCanceledListener() {
//            @Override
//            public void onCanceled() {
//                Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
//}

        User user = new User("Arifur Rahman", 25, "Male");

        DatabaseReference userDataRef = databaseReference.child("users");
       //Push method for auto id generate...
        String userId = userDataRef.push().getKey();
        user.setUserId(userId);

        userDataRef.child(userId).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Successfully updated", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }).addOnCanceledListener(new OnCanceledListener() {
            @Override
            public void onCanceled() {
                Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_SHORT).show();
            }
        });

    }
}


