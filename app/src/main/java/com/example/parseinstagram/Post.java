package com.example.parseinstagram;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Post")
public class Post  extends ParseObject {

    public static final String KEY_DESCRIPTION =  "description";
    public static final String KEY_IMAGE =  "image";
    public static final String KEY_USER =  "user";

    public String getDesciption(){
        return getString(KEY_DESCRIPTION);
    }

    public void setDesciption(String desciption){
        put(KEY_DESCRIPTION, desciption);
    }

    public ParseFile getImage() {
        return getParseFile(KEY_IMAGE);
    }

    public void setImage (ParseFile parseFile){
        put(KEY_IMAGE, parseFile);
    }

    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser parseUser){
        put(KEY_USER, parseUser);
    }
}
