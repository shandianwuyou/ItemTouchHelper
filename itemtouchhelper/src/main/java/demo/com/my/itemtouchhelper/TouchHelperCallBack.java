package demo.com.my.itemtouchhelper;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by zhaopeng on 2018/4/23.
 */

public class TouchHelperCallBack extends ItemTouchHelper.Callback {

    private MyAdapter mAdapter;

    public TouchHelperCallBack(MyAdapter adapter){
        this.mAdapter = adapter;
    }
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //左滑右滑删除
        int swipFlag = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        //上滑下滑移动
        int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        return makeMovementFlags(dragFlag, swipFlag);
    }

    //上下移动的时候调用
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int oldPos = viewHolder.getAdapterPosition();
        int newPos = target.getAdapterPosition();
        mAdapter.onItemMoved(oldPos, newPos);
        return true;
    }

    //左右滑动的时候调用
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mAdapter.onItemRemoved(viewHolder.getAdapterPosition());
    }

    //操作的item,加个选中的背景
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if(actionState != ItemTouchHelper.ACTION_STATE_IDLE){
            viewHolder.itemView.setBackgroundColor(Color.parseColor("#ff0000"));
        }
    }

    //左右滑动时删除的view，恢复背景
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setBackgroundColor(Color.TRANSPARENT);
    }
}
