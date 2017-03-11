package com.example.zyh.jxnudiscuss;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zyh on 17-3-4.
 */

public class ThemeActivity_theme_fragment extends Fragment {
    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.themeactivity_theme_fragment,container,false);
        return view;
    }

    public  void refresh(String newsTitle,String newsContent)
    {
        View vis= view.findViewById(R.id.visible);
        vis.setVisibility(View.VISIBLE);
        TextView themeActivity_theme_title_tv=(TextView)view.findViewById(R.id.themeActivity_theme_title_tv);
        TextView themeActivity_theme_content_tv=(TextView)view.findViewById(R.id.themeActivity_theme_content_tv);
        themeActivity_theme_title_tv.setText(newsTitle);
        themeActivity_theme_content_tv.setText(newsContent);
    }
}
