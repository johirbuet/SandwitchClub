package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject object = new JSONObject(json);
            JSONObject nameJson = object.getJSONObject("name");
            List<String> ingredients = new ArrayList<>();
            List<String> alias = new ArrayList<>();
            JSONArray ings = object.getJSONArray("ingredients");
            JSONArray als = nameJson.getJSONArray("alsoKnownAs");
            for(int i =0; i < ings.length(); i++) {
                ingredients.add(ings.get(i).toString());
            }
            for(int i =0; i < als.length(); i++) {
                alias.add(als.get(i).toString());
            }
            sandwich.setMainName(nameJson.getString("mainName"));
            sandwich.setDescription(object.getString("description"));
            sandwich.setPlaceOfOrigin(object.getString("placeOfOrigin"));
            sandwich.setImage(object.getString("image"));
            sandwich.setIngredients(ingredients);
            sandwich.setAlsoKnownAs(alias);
        } catch (JSONException e) {
            Log.e("JsonUtils",e.getMessage());
        }

        return sandwich;
    }
}
