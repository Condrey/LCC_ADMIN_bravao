package lcc.hymnbook.lccadmin;

import android.content.SharedPreferences;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class Variables {

     static final String KEY_EDITOR_TYPE="editor_type";
     static final String KEY_EMAIL = "email";
     static final String KEY_FIRST_NAME = "first_name";
     static final String KEY_FULL_NAME = "full_name";
     static final String KEY_IMAGE = "image";
     static final String KEY_OTHER_NAME = "other_name";
     static final String KEY_PASSWORD = "password";
     static final String KEY_PROFESSION = "profession";
     static final String KEY_SUR_NAME = "sur_name";
     static final String KEY_TYPE = "type";
     static   SharedPreferences pref;
     public static final String MY_PREFERENCE = "MySharedPref";

     static final String PREF_IS_LOGGED_IN = "is logged in";
     static final String KEY_HYMN_NUMBER = "hymn_number";
     static  FirebaseFirestore db_user = FirebaseFirestore.getInstance();
     static  CollectionReference noteBookRefAdmin = db_user.collection("admin");
     static  CollectionReference noteBooRefSongs = db_user.collection("songs");
//     HashMap<Object,String> upload = new HashMap<>();
//        upload.put(Variables.KEY_EDITOR_TYPE,"Admin");
//        upload.put(Variables.KEY_EMAIL,"wangzdrey@gmail.com");
//        upload.put(Variables.KEY_FIRST_NAME,"Coundrey");
//        upload.put(Variables.KEY_FULL_NAME,"Ogwang Coundrey James");
//        upload.put(Variables.KEY_IMAGE,"Admin");
//        upload.put(Variables.KEY_OTHER_NAME,"James");
//        upload.put(Variables.KEY_PASSWORD,"james");
//        upload.put(Variables.KEY_PROFESSION,"Dr.");
//        upload.put(Variables.KEY_SUR_NAME,"Ogwang");
//        upload.put(Variables.KEY_TYPE,"editor");
//        Variables.noteBookRefAdmin.document("wangzdrey@gmail.com").set(upload);
}
