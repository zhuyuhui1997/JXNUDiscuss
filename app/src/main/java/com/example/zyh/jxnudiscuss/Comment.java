package com.example.zyh.jxnudiscuss;

import android.util.Log;

import cn.bmob.v3.BmobObject;

/**
 * Created by zyh on 17-3-5.
 */

public class Comment extends BmobObject{
    private  String commnet_content;    // ping lun nei rong
    private  String user_name;          // ping lun yonghu
    private  Theme theme;



    public  Comment(String commnet_content,String user_name)
    {
        this.commnet_content=commnet_content;
        this.user_name=user_name;
    }
    public String getContent() {
        return commnet_content;
    }

    public void setContent(String commnet_content) {
        this.commnet_content = commnet_content;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}
