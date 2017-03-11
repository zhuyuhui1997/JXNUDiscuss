package com.example.zyh.jxnudiscuss;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by zyh on 17-3-4.
 */

public class MainActivity_theme_fragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView  mainActivity_themelist_listview;
    private List<Theme> themeList;
    private  MyThemesAdapter myThemesAdapter;
    private  CommonUser commonUser;

    public  void onAttach(Activity activity)
    {
        super.onAttach(activity);
        themeList=getThemeList();
        commonUser= BmobUser.getCurrentUser(CommonUser.class);
        myThemesAdapter=new MyThemesAdapter(activity,R.layout.mainactivity_singletheme,themeList);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       Theme theme=themeList.get(position);
        ThemeActivity.actionStart(getActivity(),theme.getTheme_Title(),theme.getTheme_Content());
    }

    public  View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle bundle)
    {
        View view=inflater.inflate(R.layout.mainactivity_themes_titles,container,false);
        mainActivity_themelist_listview=(ListView)view.findViewById(R.id.mainActivty_themeList_listview);
        mainActivity_themelist_listview.setAdapter(myThemesAdapter);
        mainActivity_themelist_listview.setOnItemClickListener(this);
        return  view;
    }


    private  List<Theme> getThemeList()
    {
        themeList=new ArrayList<Theme>();
        Theme theme=new Theme();
        theme.setTheme_Title("hello friend");
        theme.setTheme_Content("welcome come to join us");
        themeList.add(theme);
        return  themeList;
        //BmobQuery<Theme> bmobQuery = new BmobQuery<Theme>();
        //bmobQuery.findObjects(new FindListener<Theme>() {
          //  @Override
          //  public void done(List<Theme> list, BmobException e) {
         //       themeList=list;
         //   }
      //  });

      //  return  themeList;
    }
    public  void addTheme(Theme theme)
    {

            Toast.makeText(getActivity(),"please login",Toast.LENGTH_LONG).show();

            myThemesAdapter.addThemes(theme);



    }


}
