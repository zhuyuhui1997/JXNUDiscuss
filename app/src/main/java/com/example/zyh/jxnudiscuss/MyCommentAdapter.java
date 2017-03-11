package com.example.zyh.jxnudiscuss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zyh on 17-3-5.
 */

public class MyCommentAdapter extends BaseAdapter {
    public MyCommentAdapter(Context context, List<Comment> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    Context context;
    private List<Comment>  commentList;
    @Override
    public int getCount() {
        return commentList.size();
    }

    @Override
    public Object getItem(int position) {
        return commentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null)
        {
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_comment,null);
            viewHolder.comment_name=(TextView)convertView.findViewById(R.id.comment_name);
            viewHolder.comment_content=(TextView)convertView.findViewById(R.id.comment_content);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.comment_content.setText(commentList.get(position).getContent());
        viewHolder.comment_name.setText(commentList.get(position).getUser_name());
        return  convertView;
    }

    public  void addcomment(Comment comment)
    {
        commentList.add(comment);
        notifyDataSetChanged();
    }

    static class ViewHolder{
        TextView comment_name;
        TextView comment_content;
    }
}
