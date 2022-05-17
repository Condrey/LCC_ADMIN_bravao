package lcc.hymnbook.lccadmin;

import com.google.firebase.firestore.Exclude;

public class ItemModel {
}

class ItemModelSongs {

        String hymn_no;
         String title;
         String time;
         String hymn;
         String documentID;
         String favorite;
         String hymn_number;
         String hymn_title_english;
         String hymn_title_langi;
         String hymn_title_luganda;
         String hymn_key;

         String _1hymn_chorus_english;
         String _1hymn_chorus_langi;
         String _1hymn_chorus_luganda;
         String _2hymn_chorus_english;
         String _2hymn_chorus_langi;
         String _2hymn_chorus_luganda;
         String _3hymn_chorus_english;
         String _3hymn_chorus_langi;
         String _3hymn_chorus_luganda;
         String _4hymn_chorus_english;
         String _4hymn_chorus_langi;
         String _4hymn_chorus_luganda;
         String _5hymn_chorus_english;
         String _5hymn_chorus_langi;
         String _5hymn_chorus_luganda;
         String _6hymn_chorus_english;
         String _6hymn_chorus_langi;
         String _6hymn_chorus_luganda;
         String _7hymn_chorus_english;
         String _7hymn_chorus_langi;
         String _7hymn_chorus_luganda;





         String _1hymn_VERSE_english;
         String _1hymn_VERSE_langi;
         String _1hymn_VERSE_luganda;
         String _2hymn_VERSE_english;
         String _2hymn_VERSE_langi;
         String _2hymn_VERSE_luganda;
         String _3hymn_VERSE_english;
         String _3hymn_VERSE_langi;
         String _3hymn_VERSE_luganda;
         String _4hymn_VERSE_english;
         String _4hymn_VERSE_langi;
         String _4hymn_VERSE_luganda;
         String _5hymn_VERSE_english;
         String _5hymn_VERSE_langi;
         String _5hymn_VERSE_luganda;
         String _6hymn_VERSE_english;
         String _6hymn_VERSE_langi;
         String _6hymn_VERSE_luganda;
         String _7hymn_VERSE_english;
         String _7hymn_VERSE_langi;
         String _7hymn_VERSE_luganda;

    public  ItemModelSongs(){
        //public no arg constructor  needed
    }

    public String getHymn_no() {
        return hymn_no;
    }

    public void setHymn_no(String hymn_no) {
        this.hymn_no = hymn_no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHymn() {
        return hymn;
    }

    public void setHymn(String hymn) {
        this.hymn = hymn;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String getHymn_number() {
        return hymn_number;
    }

    public void setHymn_number(String hymn_number) {
        this.hymn_number = hymn_number;
    }

    public String getHymn_title_english() {
        return hymn_title_english;
    }

    public void setHymn_title_english(String hymn_title_english) {
        this.hymn_title_english = hymn_title_english;
    }

    public String getHymn_title_langi() {
        return hymn_title_langi;
    }

    public void setHymn_title_langi(String hymn_title_langi) {
        this.hymn_title_langi = hymn_title_langi;
    }

    public String getHymn_title_luganda() {
        return hymn_title_luganda;
    }

    public void setHymn_title_luganda(String hymn_title_luganda) {
        this.hymn_title_luganda = hymn_title_luganda;
    }

    public String getHymn_key() {
        return hymn_key;
    }

    public void setHymn_key(String hymn_key) {
        this.hymn_key = hymn_key;
    }

    public String get_1hymn_chorus_english() {
        return _1hymn_chorus_english;
    }

    public void set_1hymn_chorus_english(String _1hymn_chorus_english) {
        this._1hymn_chorus_english = _1hymn_chorus_english;
    }

    public String get_1hymn_chorus_langi() {
        return _1hymn_chorus_langi;
    }

    public void set_1hymn_chorus_langi(String _1hymn_chorus_langi) {
        this._1hymn_chorus_langi = _1hymn_chorus_langi;
    }

    public String get_1hymn_chorus_luganda() {
        return _1hymn_chorus_luganda;
    }

    public void set_1hymn_chorus_luganda(String _1hymn_chorus_luganda) {
        this._1hymn_chorus_luganda = _1hymn_chorus_luganda;
    }

    public String get_2hymn_chorus_english() {
        return _2hymn_chorus_english;
    }

    public void set_2hymn_chorus_english(String _2hymn_chorus_english) {
        this._2hymn_chorus_english = _2hymn_chorus_english;
    }

    public String get_2hymn_chorus_langi() {
        return _2hymn_chorus_langi;
    }

    public void set_2hymn_chorus_langi(String _2hymn_chorus_langi) {
        this._2hymn_chorus_langi = _2hymn_chorus_langi;
    }

    public String get_2hymn_chorus_luganda() {
        return _2hymn_chorus_luganda;
    }

    public void set_2hymn_chorus_luganda(String _2hymn_chorus_luganda) {
        this._2hymn_chorus_luganda = _2hymn_chorus_luganda;
    }

    public String get_3hymn_chorus_english() {
        return _3hymn_chorus_english;
    }

    public void set_3hymn_chorus_english(String _3hymn_chorus_english) {
        this._3hymn_chorus_english = _3hymn_chorus_english;
    }

    public String get_3hymn_chorus_langi() {
        return _3hymn_chorus_langi;
    }

    public void set_3hymn_chorus_langi(String _3hymn_chorus_langi) {
        this._3hymn_chorus_langi = _3hymn_chorus_langi;
    }

    public String get_3hymn_chorus_luganda() {
        return _3hymn_chorus_luganda;
    }

    public void set_3hymn_chorus_luganda(String _3hymn_chorus_luganda) {
        this._3hymn_chorus_luganda = _3hymn_chorus_luganda;
    }

    public String get_4hymn_chorus_english() {
        return _4hymn_chorus_english;
    }

    public void set_4hymn_chorus_english(String _4hymn_chorus_english) {
        this._4hymn_chorus_english = _4hymn_chorus_english;
    }

    public String get_4hymn_chorus_langi() {
        return _4hymn_chorus_langi;
    }

    public void set_4hymn_chorus_langi(String _4hymn_chorus_langi) {
        this._4hymn_chorus_langi = _4hymn_chorus_langi;
    }

    public String get_4hymn_chorus_luganda() {
        return _4hymn_chorus_luganda;
    }

    public void set_4hymn_chorus_luganda(String _4hymn_chorus_luganda) {
        this._4hymn_chorus_luganda = _4hymn_chorus_luganda;
    }

    public String get_5hymn_chorus_english() {
        return _5hymn_chorus_english;
    }

    public void set_5hymn_chorus_english(String _5hymn_chorus_english) {
        this._5hymn_chorus_english = _5hymn_chorus_english;
    }

    public String get_5hymn_chorus_langi() {
        return _5hymn_chorus_langi;
    }

    public void set_5hymn_chorus_langi(String _5hymn_chorus_langi) {
        this._5hymn_chorus_langi = _5hymn_chorus_langi;
    }

    public String get_5hymn_chorus_luganda() {
        return _5hymn_chorus_luganda;
    }

    public void set_5hymn_chorus_luganda(String _5hymn_chorus_luganda) {
        this._5hymn_chorus_luganda = _5hymn_chorus_luganda;
    }

    public String get_6hymn_chorus_english() {
        return _6hymn_chorus_english;
    }

    public void set_6hymn_chorus_english(String _6hymn_chorus_english) {
        this._6hymn_chorus_english = _6hymn_chorus_english;
    }

    public String get_6hymn_chorus_langi() {
        return _6hymn_chorus_langi;
    }

    public void set_6hymn_chorus_langi(String _6hymn_chorus_langi) {
        this._6hymn_chorus_langi = _6hymn_chorus_langi;
    }

    public String get_6hymn_chorus_luganda() {
        return _6hymn_chorus_luganda;
    }

    public void set_6hymn_chorus_luganda(String _6hymn_chorus_luganda) {
        this._6hymn_chorus_luganda = _6hymn_chorus_luganda;
    }

    public String get_7hymn_chorus_english() {
        return _7hymn_chorus_english;
    }

    public void set_7hymn_chorus_english(String _7hymn_chorus_english) {
        this._7hymn_chorus_english = _7hymn_chorus_english;
    }

    public String get_7hymn_chorus_langi() {
        return _7hymn_chorus_langi;
    }

    public void set_7hymn_chorus_langi(String _7hymn_chorus_langi) {
        this._7hymn_chorus_langi = _7hymn_chorus_langi;
    }

    public String get_7hymn_chorus_luganda() {
        return _7hymn_chorus_luganda;
    }

    public void set_7hymn_chorus_luganda(String _7hymn_chorus_luganda) {
        this._7hymn_chorus_luganda = _7hymn_chorus_luganda;
    }

    public String get_1hymn_VERSE_english() {
        return _1hymn_VERSE_english;
    }

    public void set_1hymn_VERSE_english(String _1hymn_VERSE_english) {
        this._1hymn_VERSE_english = _1hymn_VERSE_english;
    }

    public String get_1hymn_VERSE_langi() {
        return _1hymn_VERSE_langi;
    }

    public void set_1hymn_VERSE_langi(String _1hymn_VERSE_langi) {
        this._1hymn_VERSE_langi = _1hymn_VERSE_langi;
    }

    public String get_1hymn_VERSE_luganda() {
        return _1hymn_VERSE_luganda;
    }

    public void set_1hymn_VERSE_luganda(String _1hymn_VERSE_luganda) {
        this._1hymn_VERSE_luganda = _1hymn_VERSE_luganda;
    }

    public String get_2hymn_VERSE_english() {
        return _2hymn_VERSE_english;
    }

    public void set_2hymn_VERSE_english(String _2hymn_VERSE_english) {
        this._2hymn_VERSE_english = _2hymn_VERSE_english;
    }

    public String get_2hymn_VERSE_langi() {
        return _2hymn_VERSE_langi;
    }

    public void set_2hymn_VERSE_langi(String _2hymn_VERSE_langi) {
        this._2hymn_VERSE_langi = _2hymn_VERSE_langi;
    }

    public String get_2hymn_VERSE_luganda() {
        return _2hymn_VERSE_luganda;
    }

    public void set_2hymn_VERSE_luganda(String _2hymn_VERSE_luganda) {
        this._2hymn_VERSE_luganda = _2hymn_VERSE_luganda;
    }

    public String get_3hymn_VERSE_english() {
        return _3hymn_VERSE_english;
    }

    public void set_3hymn_VERSE_english(String _3hymn_VERSE_english) {
        this._3hymn_VERSE_english = _3hymn_VERSE_english;
    }

    public String get_3hymn_VERSE_langi() {
        return _3hymn_VERSE_langi;
    }

    public void set_3hymn_VERSE_langi(String _3hymn_VERSE_langi) {
        this._3hymn_VERSE_langi = _3hymn_VERSE_langi;
    }

    public String get_3hymn_VERSE_luganda() {
        return _3hymn_VERSE_luganda;
    }

    public void set_3hymn_VERSE_luganda(String _3hymn_VERSE_luganda) {
        this._3hymn_VERSE_luganda = _3hymn_VERSE_luganda;
    }

    public String get_4hymn_VERSE_english() {
        return _4hymn_VERSE_english;
    }

    public void set_4hymn_VERSE_english(String _4hymn_VERSE_english) {
        this._4hymn_VERSE_english = _4hymn_VERSE_english;
    }

    public String get_4hymn_VERSE_langi() {
        return _4hymn_VERSE_langi;
    }

    public void set_4hymn_VERSE_langi(String _4hymn_VERSE_langi) {
        this._4hymn_VERSE_langi = _4hymn_VERSE_langi;
    }

    public String get_4hymn_VERSE_luganda() {
        return _4hymn_VERSE_luganda;
    }

    public void set_4hymn_VERSE_luganda(String _4hymn_VERSE_luganda) {
        this._4hymn_VERSE_luganda = _4hymn_VERSE_luganda;
    }

    public String get_5hymn_VERSE_english() {
        return _5hymn_VERSE_english;
    }

    public void set_5hymn_VERSE_english(String _5hymn_VERSE_english) {
        this._5hymn_VERSE_english = _5hymn_VERSE_english;
    }

    public String get_5hymn_VERSE_langi() {
        return _5hymn_VERSE_langi;
    }

    public void set_5hymn_VERSE_langi(String _5hymn_VERSE_langi) {
        this._5hymn_VERSE_langi = _5hymn_VERSE_langi;
    }

    public String get_5hymn_VERSE_luganda() {
        return _5hymn_VERSE_luganda;
    }

    public void set_5hymn_VERSE_luganda(String _5hymn_VERSE_luganda) {
        this._5hymn_VERSE_luganda = _5hymn_VERSE_luganda;
    }

    public String get_6hymn_VERSE_english() {
        return _6hymn_VERSE_english;
    }

    public void set_6hymn_VERSE_english(String _6hymn_VERSE_english) {
        this._6hymn_VERSE_english = _6hymn_VERSE_english;
    }

    public String get_6hymn_VERSE_langi() {
        return _6hymn_VERSE_langi;
    }

    public void set_6hymn_VERSE_langi(String _6hymn_VERSE_langi) {
        this._6hymn_VERSE_langi = _6hymn_VERSE_langi;
    }

    public String get_6hymn_VERSE_luganda() {
        return _6hymn_VERSE_luganda;
    }

    public void set_6hymn_VERSE_luganda(String _6hymn_VERSE_luganda) {
        this._6hymn_VERSE_luganda = _6hymn_VERSE_luganda;
    }

    public String get_7hymn_VERSE_english() {
        return _7hymn_VERSE_english;
    }

    public void set_7hymn_VERSE_english(String _7hymn_VERSE_english) {
        this._7hymn_VERSE_english = _7hymn_VERSE_english;
    }

    public String get_7hymn_VERSE_langi() {
        return _7hymn_VERSE_langi;
    }

    public void set_7hymn_VERSE_langi(String _7hymn_VERSE_langi) {
        this._7hymn_VERSE_langi = _7hymn_VERSE_langi;
    }

    public String get_7hymn_VERSE_luganda() {
        return _7hymn_VERSE_luganda;
    }

    public void set_7hymn_VERSE_luganda(String _7hymn_VERSE_luganda) {
        this._7hymn_VERSE_luganda = _7hymn_VERSE_luganda;
    }
}
