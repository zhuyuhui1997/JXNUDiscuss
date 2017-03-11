package com.example.zyh.jxnudiscuss;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobUser;

/**
 * Created by zyh on 17-3-9.
 */

public class ThemeActivity extends Activity {
  //  private TextView themeActivity_theme_title_tv;
   // private  TextView themeActivity_theme_content_tv;
    private ListView  themeActivity_commentList_listview;
    private List<Comment>  commentList;
    private EditText themeActivity_comment_content_edit;
    private Button themeActivity_send_comment_btn;
    private  MyCommentAdapter myCommentAdapter;
    private  CommonUser commonUser;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themeactivity);
        commonUser= BmobUser.getCurrentUser(CommonUser.class);
        init();
        String Theme_title=getIntent().getStringExtra("theme_title");
        String Theme_content=getIntent().getStringExtra("theme_content");
        ThemeActivity_theme_fragment themeActivity_theme_fragment=(ThemeActivity_theme_fragment)
                getFragmentManager().findFragmentById( R.id.ThemeActivity_theme_fragment);
        themeActivity_theme_fragment.refresh(Theme_title,Theme_content);

        ActivityCollector.addActivity(this);
        themeActivity_send_comment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendComment();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    public  void init()
    {
        themeActivity_commentList_listview=(ListView)findViewById(R.id.thmemActivity_comment_listview);
        commentList=new ArrayList<Comment>();
         myCommentAdapter=new MyCommentAdapter(this,commentList);
        themeActivity_commentList_listview.setAdapter(myCommentAdapter);
     //   themeActivity_theme_title_tv=(TextView)findViewById(R.id.themeActivity_theme_title_tv);
       // themeActivity_theme_content_tv=(TextView)findViewById(R.id.themeActivity_theme_content_tv);
        themeActivity_send_comment_btn=(Button)findViewById(R.id.themeActivity_comment_send_btn);
        themeActivity_comment_content_edit=(EditText)findViewById(R.id.themeActivity_comment_edit);
    }
    public  void sendComment()
    {
        if(themeActivity_comment_content_edit.getText().toString().equals(""))
        {
            Toast.makeText(this,"null text",Toast.LENGTH_SHORT).show();
        }
        else {
            if(commonUser==null){
               Toast.makeText(this,"please login",Toast.LENGTH_LONG);
            }
            else{
                Comment comment=new Comment(commonUser.getUsername(),themeActivity_comment_content_edit.getText().toString());
                myCommentAdapter.addcomment(comment);
                themeActivity_comment_content_edit.setText("");
                Toast.makeText(this,"send comment ok",Toast.LENGTH_SHORT).show();
            }


        }
    }

    public static void actionStart(Context context,String Theme_title,String Theme_content)
    {
        Intent intent=new Intent(context,ThemeActivity.class);
        intent.putExtra("theme_title",Theme_title);
        intent.putExtra("theme_content",Theme_content);
        context.startActivity(intent);
    }
}
