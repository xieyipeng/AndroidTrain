package com.example.wintertrain.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.wintertrain.R;
import com.example.wintertrain.bean.User;
import java.util.List;

/**
 * Created by 解奕鹏 on 2018/1/21.
 */

public class RecycleAdopter extends RecyclerView.Adapter<RecycleAdopter.RecycleViewHolder> {

    private List<User> mUserList;

    public RecycleAdopter(List<User> mUserList) {
        this.mUserList = mUserList;
    }

    /**
     * 创建并加载一个 itemView、并且传递给 ViewHolder
     *
     * @param parent   父
     * @param viewType 类型
     * @return view
     */
    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new RecycleViewHolder(view);
    }

    /**
     * 将数据与每一个item进行绑定
     *
     * @param holder   类型
     * @param position 位置
     */
    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        holder.bindHolder(mUserList.get(position));
    }

    /**
     * 获取item的个数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class RecycleViewHolder extends RecyclerView.ViewHolder {

        private TextView usernameTextView;
        private TextView ageTextView;

        public RecycleViewHolder(View itemView) {
            super(itemView);
            usernameTextView = itemView.findViewById(R.id.username_text_view);
            ageTextView = itemView.findViewById(R.id.age_text_view);
        }

        public void bindHolder(final User user) {
            usernameTextView.setText(user.getUserman());
            ageTextView.setText(user.getAge() + "");
            if (mOnItemClickListener != null) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnItemClickListener.onClick(user);
                    }
                });
            }
        }
    }

    private OnItemClickListener mOnItemClickListener;

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface OnItemClickListener {
        public void onClick(User user);
    }
}