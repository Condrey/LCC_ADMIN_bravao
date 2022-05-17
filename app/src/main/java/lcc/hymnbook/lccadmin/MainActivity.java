package lcc.hymnbook.lccadmin;

import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.errorprone.annotations.Var;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;


public class MainActivity extends AppCompatActivity {
    MaterialToolbar toolbar;
    String intentPassword,intentLanguage;
    BottomNavigationView navigationView;
    Menu bottom_nav_menu;
    MenuItem bottom_nav_home,bottom_nav_hymns,bottom_nav_account;
    RecyclerView recyclerViewHome,recyclerViewHymn;
    View homeView, hymnView, accountView;
    ItemTouchHelper itemTouchHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        intentPassword = getIntent().getStringExtra("password");
        intentLanguage = getIntent().getStringExtra("language");
        showDetails(intentPassword);
        homeView = findViewById(R.id.homeFragment);
        hymnView = findViewById(R.id.hymnFragment);
        accountView = findViewById(R.id.accountFragment);

        Variables.pref = getSharedPreferences(Variables.MY_PREFERENCE, MODE_PRIVATE);

        toolbar  = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationBarView);
        recyclerViewHome = findViewById(R.id.recycler_view_home);
        itemTouchHelper = new ItemTouchHelper(simpleCallback);

        recyclerViewHymn = findViewById(R.id.recycler_view_hymn);
        bottom_nav_menu = navigationView.getMenu();
        bottom_nav_home = bottom_nav_menu.findItem(R.id.home);
        navigationView.setSelectedItemId(R.id.home);
        bottom_nav_home.setIcon(getResources().getDrawable(R.drawable.home_activated));


        bottom_nav_hymns = bottom_nav_menu.findItem(R.id.hymns);
        bottom_nav_hymns.setIcon(getResources().getDrawable(R.drawable.hymns));

        bottom_nav_account = bottom_nav_menu.findItem(R.id.account);
        bottom_nav_account.setIcon(getResources().getDrawable(R.drawable.account));


        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.home:
                        bottom_nav_home.setIcon(getResources().getDrawable(R.drawable.home_activated));
                        bottom_nav_hymns.setIcon(getResources().getDrawable(R.drawable.hymns));
                        bottom_nav_account.setIcon(getResources().getDrawable(R.drawable.account));

                        homeView.setVisibility(View.VISIBLE);
                        accountView.setVisibility(View.GONE);
                        hymnView.setVisibility(View.GONE);
                        showHomeSongs("6",intentLanguage);

                        return true;
                    case R.id.hymns:
                        bottom_nav_home.setIcon(getResources().getDrawable(R.drawable.home));
                        bottom_nav_hymns.setIcon(getResources().getDrawable(R.drawable.hymns_activated));
                        bottom_nav_account.setIcon(getResources().getDrawable(R.drawable.account));

                        homeView.setVisibility(View.GONE);
                        accountView.setVisibility(View.GONE);
                        hymnView.setVisibility(View.VISIBLE);
                        showHymnSongs();
                        return true;
                    case R.id.account:
                        bottom_nav_home.setIcon(getResources().getDrawable(R.drawable.home));
                        bottom_nav_hymns.setIcon(getResources().getDrawable(R.drawable.hymns));
                        bottom_nav_account.setIcon(getResources().getDrawable(R.drawable.account_activated));

                        homeView.setVisibility(View.GONE);
                        accountView.setVisibility(View.VISIBLE);
                        hymnView.setVisibility(View.GONE);
                        return true;
                }
                return false;
            }
        });



    }
    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            final int previous;
            String hymnNumber = Variables.pref.getString(Variables.KEY_HYMN_NUMBER,null);
            String hymnLanguage = Variables.pref.getString(Variables.KEY_TYPE,null);
            final int next = Integer.parseInt(hymnNumber)+1;

            if(Integer.parseInt(hymnNumber)==1){
                previous = 1 ;

            }else{
                previous=Integer.parseInt(hymnNumber)-1;

            }


            switch (direction){
                case ItemTouchHelper.LEFT:
//                    sh.edit().putString(KEY_NUMBER,String.valueOf(next)).apply();
                    showHomeSongs(String.valueOf(next), hymnLanguage);
                    break;
                case ItemTouchHelper.RIGHT:
//                    sh.edit().putString(KEY_NUMBER,String.valueOf(previous)).apply();

                    showHomeSongs(String.valueOf(previous), hymnLanguage);
                    break;

            }
        }
//        putting the colors man

        @Override
        public void onChildDraw(@NonNull Canvas c,
                                @NonNull RecyclerView recyclerView,
                                @NonNull RecyclerView.ViewHolder viewHolder,
                                float dX,
                                float dY,
                                int actionState,
                                boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(MainActivity.this,c,recyclerView,viewHolder, dX,dY,actionState,isCurrentlyActive)
//                   .addSwipeLeftBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.swipeColor))
//                   .addSwipeLeftActionIcon(R.drawable.ic_baseline_arrow_previous_ios_24)
//                   .addSwipeRightBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.swipeColor))
//                   .addSwipeRightActionIcon(R.drawable.ic_baseline_arrow_next_ios_24)
//                   .addSwipeRightLabel("Next")
//                   .addSwipeLeftLabel("Previous")
                    .create()
                    .decorate();

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }



    };

    private void showHymnSongs() {
        Variables.noteBooRefSongs.orderBy(Variables.KEY_HYMN_NUMBER).addSnapshotListener((queryDocumentSnapshots, e) -> {
            if (e != null){
                return;
            }
           ArrayList<ItemModelSongs> arrayList = new ArrayList<>();
            String data;

            for (QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots){
                SongNote note = documentSnapshot.toObject(SongNote.class);
                note.setDocumentID(documentSnapshot.getId());
                ItemModelSongs itemModel = new ItemModelSongs();
                String name = note.getHymn_title_english();
                String langi = note.getHymn_title_langi();
                String luganda = note.getHymn_title_luganda();
                String hymnNumber = note.getHymn_number();
                String hymnKey = note.getHymn_key();
                data =name;
                itemModel.setHymn_title_english(data);
                itemModel.setHymn_title_langi(langi);
                itemModel.setHymn_title_luganda(luganda);
                itemModel.setHymn_number(hymnNumber);
                itemModel.setHymn_key(hymnKey);

                itemModel.set_1hymn_chorus_english(note.get_1hymn_chorus_english());
                itemModel.set_2hymn_chorus_english(note.get_2hymn_chorus_english());
                itemModel.set_3hymn_chorus_english(note.get_3hymn_chorus_english());
                itemModel.set_4hymn_chorus_english(note.get_4hymn_chorus_english());
                itemModel.set_5hymn_chorus_english(note.get_5hymn_chorus_english());
                itemModel.set_7hymn_chorus_english(note.get_7hymn_chorus_english());
                itemModel.set_6hymn_chorus_english(note.get_6hymn_chorus_english());

                itemModel.set_1hymn_VERSE_english(note.get_1hymn_VERSE_english());
                itemModel.set_2hymn_VERSE_english(note.get_2hymn_VERSE_english());
                itemModel.set_3hymn_VERSE_english(note.get_3hymn_VERSE_english());
                itemModel.set_4hymn_VERSE_english(note.get_4hymn_VERSE_english());
                itemModel.set_5hymn_VERSE_english(note.get_5hymn_VERSE_english());
                itemModel.set_6hymn_VERSE_english(note.get_6hymn_VERSE_english());
                itemModel.set_7hymn_VERSE_english(note.get_7hymn_VERSE_english());

                itemModel.set_1hymn_chorus_langi(note.get_1hymn_chorus_langi());
                itemModel.set_2hymn_chorus_langi(note.get_2hymn_chorus_langi());
                itemModel.set_3hymn_chorus_langi(note.get_3hymn_chorus_langi());
                itemModel.set_4hymn_chorus_langi(note.get_4hymn_chorus_langi());
                itemModel.set_5hymn_chorus_langi(note.get_5hymn_chorus_langi());
                itemModel.set_7hymn_chorus_langi(note.get_7hymn_chorus_langi());
                itemModel.set_6hymn_chorus_langi(note.get_6hymn_chorus_langi());

                itemModel.set_1hymn_VERSE_langi(note.get_1hymn_VERSE_langi());
                itemModel.set_2hymn_VERSE_langi(note.get_2hymn_VERSE_langi());
                itemModel.set_3hymn_VERSE_langi(note.get_3hymn_VERSE_langi());
                itemModel.set_4hymn_VERSE_langi(note.get_4hymn_VERSE_langi());
                itemModel.set_5hymn_VERSE_langi(note.get_5hymn_VERSE_langi());
                itemModel.set_6hymn_VERSE_langi(note.get_6hymn_VERSE_langi());
                itemModel.set_7hymn_VERSE_langi(note.get_7hymn_VERSE_langi());

                itemModel.set_1hymn_chorus_luganda(note.get_1hymn_chorus_luganda());
                itemModel.set_2hymn_chorus_luganda(note.get_2hymn_chorus_luganda());
                itemModel.set_3hymn_chorus_luganda(note.get_3hymn_chorus_luganda());
                itemModel.set_4hymn_chorus_luganda(note.get_4hymn_chorus_luganda());
                itemModel.set_5hymn_chorus_luganda(note.get_5hymn_chorus_luganda());
                itemModel.set_7hymn_chorus_luganda(note.get_7hymn_chorus_luganda());
                itemModel.set_6hymn_chorus_luganda(note.get_6hymn_chorus_luganda());

                itemModel.set_1hymn_VERSE_luganda(note.get_1hymn_VERSE_luganda());
                itemModel.set_2hymn_VERSE_luganda(note.get_2hymn_VERSE_luganda());
                itemModel.set_3hymn_VERSE_luganda(note.get_3hymn_VERSE_luganda());
                itemModel.set_4hymn_VERSE_luganda(note.get_4hymn_VERSE_luganda());
                itemModel.set_5hymn_VERSE_luganda(note.get_5hymn_VERSE_luganda());
                itemModel.set_6hymn_VERSE_luganda(note.get_6hymn_VERSE_luganda());
                itemModel.set_7hymn_VERSE_luganda(note.get_7hymn_VERSE_luganda());

                arrayList.add(itemModel);

            }

            recyclerViewHymn.setAdapter(new CustomAdapterHymns(arrayList,MainActivity.this));

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
        showHomeSongs(Variables.pref.getString(Variables.KEY_HYMN_NUMBER,"1"),intentLanguage);

    }

    private void isLoggedIn() {
        Variables.pref.edit().putBoolean(Variables.PREF_IS_LOGGED_IN,true).apply();
    }

    public void showHomeSongs(String queryIndex, String queryLanguage) {
Variables.noteBooRefSongs.whereEqualTo(Variables.KEY_HYMN_NUMBER,queryIndex)
        .limit(1)
        .addSnapshotListener(new EventListener<QuerySnapshot>() {
            ArrayList<ItemModelSongs> arrayList = new ArrayList<>();
            @Override
            public void onEvent(@androidx.annotation.Nullable QuerySnapshot value, @androidx.annotation.Nullable FirebaseFirestoreException error) {

                for(QueryDocumentSnapshot snapshot: value){
                    SongNote note = snapshot.toObject(SongNote.class);
                    ItemModelSongs itemModel = new ItemModelSongs();
                    if (queryLanguage != null && queryLanguage.equals("Luganda")){


                        itemModel.setHymn_title_luganda(note.getHymn_title_luganda());
                        itemModel.set_1hymn_chorus_luganda(note.get_1hymn_chorus_luganda());
                        itemModel.set_2hymn_chorus_luganda(note.get_2hymn_chorus_luganda());
                        itemModel.set_3hymn_chorus_luganda(note.get_3hymn_chorus_luganda());
                        itemModel.set_4hymn_chorus_luganda(note.get_4hymn_chorus_luganda());
                        itemModel.set_5hymn_chorus_luganda(note.get_5hymn_chorus_luganda());
                        itemModel.set_7hymn_chorus_luganda(note.get_7hymn_chorus_luganda());
                        itemModel.set_6hymn_chorus_luganda(note.get_6hymn_chorus_luganda());

                        itemModel.set_1hymn_VERSE_luganda(note.get_1hymn_VERSE_luganda());
                        itemModel.set_2hymn_VERSE_luganda(note.get_2hymn_VERSE_luganda());
                        itemModel.set_3hymn_VERSE_luganda(note.get_3hymn_VERSE_luganda());
                        itemModel.set_4hymn_VERSE_luganda(note.get_4hymn_VERSE_luganda());
                        itemModel.set_5hymn_VERSE_luganda(note.get_5hymn_VERSE_luganda());
                        itemModel.set_6hymn_VERSE_luganda(note.get_6hymn_VERSE_luganda());
                        itemModel.set_7hymn_VERSE_luganda(note.get_7hymn_VERSE_luganda());
                    }else if (queryLanguage != null && queryLanguage.equals("Langi")){

                        itemModel.setHymn_title_langi(note.getHymn_title_langi());
                        itemModel.set_1hymn_chorus_langi(note.get_1hymn_chorus_langi());
                        itemModel.set_2hymn_chorus_langi(note.get_2hymn_chorus_langi());
                        itemModel.set_3hymn_chorus_langi(note.get_3hymn_chorus_langi());
                        itemModel.set_4hymn_chorus_langi(note.get_4hymn_chorus_langi());
                        itemModel.set_5hymn_chorus_langi(note.get_5hymn_chorus_langi());
                        itemModel.set_7hymn_chorus_langi(note.get_7hymn_chorus_langi());
                        itemModel.set_6hymn_chorus_langi(note.get_6hymn_chorus_langi());

                        itemModel.set_1hymn_VERSE_langi(note.get_1hymn_VERSE_langi());
                        itemModel.set_2hymn_VERSE_langi(note.get_2hymn_VERSE_langi());
                        itemModel.set_3hymn_VERSE_langi(note.get_3hymn_VERSE_langi());
                        itemModel.set_4hymn_VERSE_langi(note.get_4hymn_VERSE_langi());
                        itemModel.set_5hymn_VERSE_langi(note.get_5hymn_VERSE_langi());
                        itemModel.set_6hymn_VERSE_langi(note.get_6hymn_VERSE_langi());
                        itemModel.set_7hymn_VERSE_langi(note.get_7hymn_VERSE_langi());
                    }else{

                        itemModel.setHymn_title_english(note.getHymn_title_english());
                        itemModel.set_1hymn_chorus_english(note.get_1hymn_chorus_english());
                        itemModel.set_2hymn_chorus_english(note.get_2hymn_chorus_english());
                        itemModel.set_3hymn_chorus_english(note.get_3hymn_chorus_english());
                        itemModel.set_4hymn_chorus_english(note.get_4hymn_chorus_english());
                        itemModel.set_5hymn_chorus_english(note.get_5hymn_chorus_english());
                        itemModel.set_7hymn_chorus_english(note.get_7hymn_chorus_english());
                        itemModel.set_6hymn_chorus_english(note.get_6hymn_chorus_english());

                        itemModel.set_1hymn_VERSE_english(note.get_1hymn_VERSE_english());
                        itemModel.set_2hymn_VERSE_english(note.get_2hymn_VERSE_english());
                        itemModel.set_3hymn_VERSE_english(note.get_3hymn_VERSE_english());
                        itemModel.set_4hymn_VERSE_english(note.get_4hymn_VERSE_english());
                        itemModel.set_5hymn_VERSE_english(note.get_5hymn_VERSE_english());
                        itemModel.set_6hymn_VERSE_english(note.get_6hymn_VERSE_english());
                        itemModel.set_7hymn_VERSE_english(note.get_7hymn_VERSE_english());
                    }

                    itemModel.setHymn_number(note.getHymn_number());
                    itemModel.setHymn_key(note.getHymn_key());
                    arrayList.add(itemModel);
                }

                if (value.size()>0){
                        Variables.pref.edit().putString(Variables.KEY_HYMN_NUMBER,queryIndex).apply();
                    itemTouchHelper.attachToRecyclerView(recyclerViewHome);

                    recyclerViewHome.setAdapter(new Adapter.CustomAdapterSongs(arrayList,MainActivity.this,intentLanguage));

                }else {
//                            Toast.makeText(this, "no vals for "+intentLanguage, Toast.LENGTH_SHORT).show();
//                            String savedIndex = Variables.pref.getString(Variables.KEY_HYMN_NUMBER,"1");
//                            noSearchResultOrNoInternet(savedIndex,queryIndex,queryLanguage);


                    }

            }
        });




    }

    private void showDetails(String intentPassword) {

        Variables.noteBookRefAdmin
                .whereEqualTo(Variables.KEY_PASSWORD,intentPassword)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        for (DocumentSnapshot documentSnapshot : value){
                            AdminNote note = documentSnapshot.toObject(AdminNote.class);
                            toolbar.setTitle(R.string.app_name);
                            toolbar.setSubtitle(note.getEditor_type()+"•"+note.getType());
                        }
                    }
                });

    }
}