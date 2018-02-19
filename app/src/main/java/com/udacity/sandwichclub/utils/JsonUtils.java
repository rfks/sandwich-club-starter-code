package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        String mainName = new String();
        List<String> alsoKnownAs = new ArrayList<String>();
        String placeOfOrigin = new String();
        String description = new String();
        String image = new String();
        List<String> ingredients = new ArrayList<String>();
    try {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject name = jsonObject.getJSONObject("name");
        mainName = name.getString("mainName");
        JSONArray jsonArray = name.getJSONArray("alsoKnownAs");
        for (int i = 0; i < jsonArray.length(); i++) {
            alsoKnownAs.add(jsonArray.getString(i));
        }
        placeOfOrigin = jsonObject.getString("placeOfOrigin");
        description = jsonObject.getString("description");
        image = jsonObject.getString("image");
        jsonArray = jsonObject.getJSONArray("ingredients");
        for (int i = 0; i < jsonArray.length(); i++) {
            ingredients.add(jsonArray.getString(i));
        }
    }
    catch (JSONException e){
        return null;
    }
        Sandwich sandwich = new Sandwich(mainName,alsoKnownAs,placeOfOrigin,description,image,ingredients);
        return sandwich;
    }
}
