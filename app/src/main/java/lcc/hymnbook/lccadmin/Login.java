package lcc.hymnbook.lccadmin;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

public class Login extends AppCompatActivity {
    TextInputEditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Variables.pref = getSharedPreferences(Variables.MY_PREFERENCE, MODE_PRIVATE);

        password = findViewById(R.id.password);
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                showAdmins(editable.toString());

            }
        });



    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onStart();
    }
    @Override
    protected void onStart() {
        super.onStart();
        isLoggedIn();

    }
    private void isLoggedIn() {

        if (Variables.pref.getBoolean(Variables.PREF_IS_LOGGED_IN, false)){
            Intent intent = new Intent(Login.this, MainActivity.class);
            intent.putExtra("password",Variables.pref.getString(Variables.KEY_PASSWORD,null));
            intent.putExtra("language",Variables.pref.getString(Variables.KEY_TYPE,null));
            startActivity(intent);
        }else{

        }
    }

    private void showAdmins(String password) {
        Variables.noteBookRefAdmin
                .whereEqualTo(Variables.KEY_PASSWORD,password)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        for (DocumentSnapshot documentSnapshot : value){
                      AdminNote note = documentSnapshot.toObject(AdminNote.class);
                            assert note != null;
                            if (password.equals(note.getPassword())){
                                Intent intent = new Intent(Login.this, MainActivity.class);
                                intent.putExtra("password",note.getPassword());
                                intent.putExtra("language",note.getType());
                                Variables.pref.edit().putString(Variables.KEY_PASSWORD,note.getPassword()).apply();
                                Variables.pref.edit().putString(Variables.KEY_TYPE,note.getType()).apply();
                                startActivity(intent);
                            }
                        }
                    }
                });
    }

}
