package lcc.hymnbook.lccadmin;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Adapter {
    public static class CustomAdapterSongs extends RecyclerView.Adapter<CustomAdapterSongs.viewHolder> {

        ArrayList<ItemModelSongs> arrayList;
        Context context;
        String language;

        CustomAdapterSongs(ArrayList<ItemModelSongs> arrayList, Context context, String language) {
            this.arrayList = arrayList;
            this.context = context;
            this.language = language;
        }


        @NonNull
        @Override
        public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(context).inflate(R.layout.home_song_list, viewGroup, false);


            return new viewHolder(view);

        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(viewHolder viewHolder, int position) {
            String songNumber = arrayList.get(position).getHymn_number();
            viewHolder.songkey.setText(arrayList.get(position).getHymn_key());
            if (language != null && language.equals("Langi")) {

                viewHolder.songName.setText(songNumber + ". " + arrayList.get(position).getHymn_title_langi());
                viewHolder.songverse1.setText(arrayList.get(position).get_1hymn_VERSE_langi());
                viewHolder.songchorus1.setText(arrayList.get(position).get_1hymn_chorus_langi());
                viewHolder.songverse2.setText(arrayList.get(position).get_2hymn_VERSE_langi());
                viewHolder.songchorus2.setText(arrayList.get(position).get_2hymn_chorus_langi());
                viewHolder.songverse3.setText(arrayList.get(position).get_3hymn_VERSE_langi());
                viewHolder.songchorus3.setText(arrayList.get(position).get_3hymn_chorus_langi());
                viewHolder.songverse4.setText(arrayList.get(position).get_4hymn_VERSE_langi());
                viewHolder.songchorus4.setText(arrayList.get(position).get_4hymn_chorus_langi());
                viewHolder.songverse5.setText(arrayList.get(position).get_5hymn_VERSE_langi());
                viewHolder.songchorus5.setText(arrayList.get(position).get_5hymn_chorus_langi());
                viewHolder.songverse6.setText(arrayList.get(position).get_6hymn_VERSE_langi());
                viewHolder.songchorus6.setText(arrayList.get(position).get_6hymn_chorus_langi());
                viewHolder.songverse7.setText(arrayList.get(position).get_7hymn_VERSE_langi());
                viewHolder.songchorus7.setText(arrayList.get(position).get_7hymn_chorus_langi());
            } else if (language != null && language.equals("Luganda")) {
                viewHolder.songName.setText(songNumber + ". " + arrayList.get(position).getHymn_title_luganda());
                viewHolder.songverse1.setText(arrayList.get(position).get_1hymn_VERSE_luganda());
                viewHolder.songchorus1.setText(arrayList.get(position).get_1hymn_chorus_luganda());
                viewHolder.songverse2.setText(arrayList.get(position).get_2hymn_VERSE_luganda());
                viewHolder.songchorus2.setText(arrayList.get(position).get_2hymn_chorus_luganda());
                viewHolder.songverse3.setText(arrayList.get(position).get_3hymn_VERSE_luganda());
                viewHolder.songchorus3.setText(arrayList.get(position).get_3hymn_chorus_luganda());
                viewHolder.songverse4.setText(arrayList.get(position).get_4hymn_VERSE_luganda());
                viewHolder.songchorus4.setText(arrayList.get(position).get_4hymn_chorus_luganda());
                viewHolder.songverse5.setText(arrayList.get(position).get_5hymn_VERSE_luganda());
                viewHolder.songchorus5.setText(arrayList.get(position).get_5hymn_chorus_luganda());
                viewHolder.songverse6.setText(arrayList.get(position).get_6hymn_VERSE_luganda());
                viewHolder.songchorus6.setText(arrayList.get(position).get_6hymn_chorus_luganda());
                viewHolder.songverse7.setText(arrayList.get(position).get_7hymn_VERSE_luganda());
                viewHolder.songchorus7.setText(arrayList.get(position).get_7hymn_chorus_luganda());
            } else if (language != null && language.equals("English")) {

                viewHolder.songName.setText(songNumber + ". " + arrayList.get(position).getHymn_title_english());
                viewHolder.songverse1.setText(arrayList.get(position).get_1hymn_VERSE_english());
                viewHolder.songchorus1.setText(arrayList.get(position).get_1hymn_chorus_english());
                viewHolder.songverse2.setText(arrayList.get(position).get_2hymn_VERSE_english());
                viewHolder.songchorus2.setText(arrayList.get(position).get_2hymn_chorus_english());
                viewHolder.songverse3.setText(arrayList.get(position).get_3hymn_VERSE_english());
                viewHolder.songchorus3.setText(arrayList.get(position).get_3hymn_chorus_english());
                viewHolder.songverse4.setText(arrayList.get(position).get_4hymn_VERSE_english());
                viewHolder.songchorus4.setText(arrayList.get(position).get_4hymn_chorus_english());
                viewHolder.songverse5.setText(arrayList.get(position).get_5hymn_VERSE_english());
                viewHolder.songchorus5.setText(arrayList.get(position).get_5hymn_chorus_english());
                viewHolder.songverse6.setText(arrayList.get(position).get_6hymn_VERSE_english());
                viewHolder.songchorus6.setText(arrayList.get(position).get_6hymn_chorus_english());
                viewHolder.songverse7.setText(arrayList.get(position).get_7hymn_VERSE_english());
                viewHolder.songchorus7.setText(arrayList.get(position).get_7hymn_chorus_english());
            }


            if (viewHolder.songchorus1.getText().toString().isEmpty()) {
                viewHolder.hymnNumber1.setVisibility(View.GONE);

                viewHolder.songchorus1.setVisibility(View.GONE);

            }
            if (viewHolder.songchorus2.getText().toString().isEmpty()) {
                viewHolder.hymnNumber2.setVisibility(View.GONE);

                viewHolder.songchorus2.setVisibility(View.GONE);

            }
            if (viewHolder.songchorus3.getText().toString().isEmpty()) {
                viewHolder.hymnNumber3.setVisibility(View.GONE);

                viewHolder.songchorus3.setVisibility(View.GONE);

            }
            if (viewHolder.songchorus4.getText().toString().isEmpty()) {
                viewHolder.hymnNumber4.setVisibility(View.GONE);

                viewHolder.songchorus4.setVisibility(View.GONE);

            }
            if (viewHolder.songchorus5.getText().toString().isEmpty()) {
                viewHolder.hymnNumber5.setVisibility(View.GONE);

                viewHolder.songchorus5.setVisibility(View.GONE);

            }
            if (viewHolder.songchorus6.getText().toString().isEmpty()) {
                viewHolder.hymnNumber6.setVisibility(View.GONE);

                viewHolder.songchorus6.setVisibility(View.GONE);

            }
            if (viewHolder.songchorus7.getText().toString().isEmpty()) {
                viewHolder.hymnNumber7.setVisibility(View.GONE);

                viewHolder.songchorus7.setVisibility(View.GONE);

            }
            /////////////////////
            if (viewHolder.songverse1.getText().toString().isEmpty()) {
                viewHolder.hymnNumber1.setVisibility(View.GONE);
                viewHolder.verseNUmber1.setVisibility(View.GONE);
                viewHolder.songchorus1.setVisibility(View.GONE);
                viewHolder.songverse1.setVisibility(View.GONE);

            }
            if (viewHolder.songverse2.getText().toString().isEmpty()) {
                viewHolder.hymnNumber2.setVisibility(View.GONE);
                viewHolder.verseNUmber2.setVisibility(View.GONE);
                viewHolder.songchorus2.setVisibility(View.GONE);
                viewHolder.songverse2.setVisibility(View.GONE);

            }
            if (viewHolder.songverse3.getText().toString().isEmpty()) {
                viewHolder.hymnNumber3.setVisibility(View.GONE);
                viewHolder.verseNUmber3.setVisibility(View.GONE);
                viewHolder.songchorus3.setVisibility(View.GONE);
                viewHolder.songverse3.setVisibility(View.GONE);
            }
            if (viewHolder.songverse4.getText().toString().isEmpty()) {
                viewHolder.hymnNumber4.setVisibility(View.GONE);
                viewHolder.verseNUmber4.setVisibility(View.GONE);
                viewHolder.songchorus4.setVisibility(View.GONE);
                viewHolder.songverse4.setVisibility(View.GONE);

            }
            if (viewHolder.songverse5.getText().toString().isEmpty()) {
                viewHolder.hymnNumber5.setVisibility(View.GONE);
                viewHolder.verseNUmber5.setVisibility(View.GONE);
                viewHolder.songchorus5.setVisibility(View.GONE);
                viewHolder.songverse5.setVisibility(View.GONE);

            }
            if (viewHolder.songverse6.getText().toString().isEmpty()) {
                viewHolder.hymnNumber6.setVisibility(View.GONE);
                viewHolder.verseNUmber6.setVisibility(View.GONE);
                viewHolder.songchorus6.setVisibility(View.GONE);
                viewHolder.songverse6.setVisibility(View.GONE);

            }
            if (viewHolder.songverse7.getText().toString().isEmpty()) {
                viewHolder.hymnNumber7.setVisibility(View.GONE);
                viewHolder.verseNUmber7.setVisibility(View.GONE);
                viewHolder.songchorus7.setVisibility(View.GONE);
                viewHolder.songverse7.setVisibility(View.GONE);

            }


        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class viewHolder extends RecyclerView.ViewHolder {
            //hymns
            TextView songName, songkey,
                    verseNUmber1, hymnNumber1,
                    verseNUmber2, hymnNumber2,
                    verseNUmber3, hymnNumber3,
                    verseNUmber4, hymnNumber4,
                    verseNUmber5, hymnNumber5,
                    verseNUmber6, hymnNumber6,
                    verseNUmber7, hymnNumber7,
                    songverse1,
                    songchorus1,
                    songverse2,
                    songchorus2,
                    songverse3,
                    songchorus3,
                    songverse4,
                    songchorus4,
                    songverse5,
                    songchorus5,
                    songverse6,
                    songchorus6,
                    songverse7,
                    songchorus7, indicatortextV;
            ImageView likes, indicatorimageV;

            public viewHolder(View itemView) {
                super(itemView);
                songName = itemView.findViewById(R.id.songName);
                songkey = itemView.findViewById(R.id.songkey);

                verseNUmber1 = itemView.findViewById(R.id.songverse_number1);
                hymnNumber1 = itemView.findViewById(R.id.songcorus_title1);
                verseNUmber2 = itemView.findViewById(R.id.songverse_number2);
                hymnNumber2 = itemView.findViewById(R.id.songcorus_title2);
                verseNUmber3 = itemView.findViewById(R.id.songverse_number3);
                hymnNumber3 = itemView.findViewById(R.id.songcorus_title3);
                verseNUmber4 = itemView.findViewById(R.id.songverse_number4);
                hymnNumber4 = itemView.findViewById(R.id.songcorus_title4);
                verseNUmber5 = itemView.findViewById(R.id.songverse_number5);
                hymnNumber5 = itemView.findViewById(R.id.songcorus_title5);
                verseNUmber6 = itemView.findViewById(R.id.songverse_number6);
                hymnNumber6 = itemView.findViewById(R.id.songcorus_title6);
                verseNUmber7 = itemView.findViewById(R.id.songverse_number7);
                hymnNumber7 = itemView.findViewById(R.id.songcorus_title7);

                songchorus1 = itemView.findViewById(R.id.songchorus1);
                songverse1 = itemView.findViewById(R.id.songverse1);
                songchorus2 = itemView.findViewById(R.id.songchorus2);
                songverse2 = itemView.findViewById(R.id.songverse2);
                songchorus3 = itemView.findViewById(R.id.songchorus3);
                songverse3 = itemView.findViewById(R.id.songverse3);
                songchorus4 = itemView.findViewById(R.id.songchorus4);
                songverse4 = itemView.findViewById(R.id.songverse4);
                songchorus5 = itemView.findViewById(R.id.songchorus5);
                songverse5 = itemView.findViewById(R.id.songverse5);
                songchorus6 = itemView.findViewById(R.id.songchorus6);
                songverse6 = itemView.findViewById(R.id.songverse6);
                songchorus7 = itemView.findViewById(R.id.songchorus7);
                songverse7 = itemView.findViewById(R.id.songverse7);
                likes = itemView.findViewById(R.id.likes_image);


            }
        }
    }

}

 class CustomAdapterHymns extends RecyclerView.Adapter<CustomAdapterHymns.viewHolder>{

    ArrayList<ItemModelSongs> arrayList;
Context context;
String language;

     public CustomAdapterHymns(ArrayList<ItemModelSongs> arrayList, Context context, String language) {
         this.arrayList = arrayList;
         this.context = context;
         this.language = language;
     }

     @NonNull
    @Override
    public CustomAdapterHymns.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.hymn_song_list, viewGroup, false);


        return new CustomAdapterHymns.viewHolder(view);
    }
    @SuppressLint({"SetTextI18n", "InflateParams"})
    @Override
    public  void onBindViewHolder(@NonNull CustomAdapterHymns.viewHolder viewHolder, int position) {
        viewHolder.itemView.setTag(arrayList.get(position).getHymn_number());

        String songName_inner = null;
if (language.equalsIgnoreCase(Variables.KEY_LANGUAGE_ENGLISH)){
   songName_inner   =  arrayList.get(position).getHymn_title_english();
}else if (language.equalsIgnoreCase(Variables.KEY_LANGUAGE_LUGANDA)){
    songName_inner   =  arrayList.get(position).getHymn_title_luganda();
}else if (language.equalsIgnoreCase(Variables.KEY_LANGUAGE_LANGI)){
    songName_inner   =  arrayList.get(position).getHymn_title_langi();
}

        String NewsongName;

        if (songName_inner !=null && !songName_inner.equalsIgnoreCase("null") ) {
            if (songName_inner.length() > 60) {
                NewsongName = songName_inner.substring(0, 60) + "...";

            } else {
                NewsongName = songName_inner;
            }
            viewHolder.container.setVisibility(View.VISIBLE);

            viewHolder.name.setText(arrayList.get(position).getHymn_number() + " " + NewsongName);
            //view holder for editing
        }else {
            viewHolder.name.setText("title not set");

            viewHolder.container.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        //hymns
        TextView name;
//        Button delete,edit;
        View container;
        public viewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            container = itemView.findViewById(R.id.container);
//            delete = itemView.findViewById(R.id.deleteBtn);
//            edit =  itemView.findViewById(R.id.editBtn);





        }
    }
}
