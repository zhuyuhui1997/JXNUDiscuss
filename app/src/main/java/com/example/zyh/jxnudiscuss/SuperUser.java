package com.example.zyh.jxnudiscuss;

import java.util.List;

/**
 * Created by zyh on 17-3-9.
 */

public class SuperUser extends CommonUser {
    private List<Theme>   themeList;

    public List<Theme> getThemeList() {
        return themeList;
    }

    public void setThemeList(List<Theme> themeList) {
        this.themeList = themeList;
    }
}
