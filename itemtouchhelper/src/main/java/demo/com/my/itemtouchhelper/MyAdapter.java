package demo.com.my.itemtouchhelper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhaopeng on 2018/4/23.
 */

public class MyAdapter extends RecyclerView.Adapter {

    private List<Integer> mDataList = new ArrayList<>();

    public MyAdapter(){
        for(int i = 0; i < 30; i++){
            mDataList.add(i);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_child, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyHolder && position < mDataList.size()){
            MyHolder mHolder = (MyHolder) holder;
            mHolder.textView.setText(mDataList.get(position).toString());
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void onItemMoved(int oldPos, int newPos){
        if(oldPos < newPos){
            for(int i = oldPos; i < newPos; i++){
                Collections.swap(mDataList, i, i + 1);
            }
        }else{
            for(int i = oldPos; i > newPos; i--){
                Collections.swap(mDataList, i, i - 1);
            }
        }
        notifyItemMoved(oldPos, newPos);
    }

    public void onItemRemoved(int pos){
        mDataList.remove(pos);
        notifyItemRemoved(pos);
    }

    static class MyHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.root_view);
        }
    }
}
