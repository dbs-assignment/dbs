package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PostNormalisation extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_normalisation);

        TextView textView = findViewById(R.id.tv_decompostion);
        textView.setText(PreNormalisationActivity.hNFPlusOne);
        ListView lv = findViewById(R.id.listview_rlns);

        DecompKeys decompKeys = new DecompKeys();
        List<String> listOfStrings = new ArrayList<>();
        HashMap<String, Set<String>> finalmap = decompKeys.decompsedkeys(MainActivity.h,PreNormalisationActivity.decomposedRlns);
        int i=1;
        for (Map.Entry<String,Set<String>> entry : finalmap.entrySet()){
            listOfStrings.add("R"+i +" (" +entry.getKey().chars().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining(", "))+")");
            listOfStrings.add("CKs: "+entry.getValue().toString());
            listOfStrings.add("");
            i++;
        }
//        PreNormalisationActivity.decomposedRlns.stream().map(e -> {
//        List<String> listOfStrings = PreNormalisationActivity.decomposedRlns.stream().map(
//                s -> s.chars().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining(", "))
//        ).collect(Collectors.toList());
//
//        for(int i=0; i<listOfStrings.size(); i++)
//            listOfStrings.add(i, "R"+(i+1)+" ("+listOfStrings.remove(i)+")");

        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listOfStrings));

    }


}
