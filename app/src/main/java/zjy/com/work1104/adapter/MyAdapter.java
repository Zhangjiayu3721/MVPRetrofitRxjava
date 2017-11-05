package zjy.com.work1104.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import zjy.com.work1104.R;
import zjy.com.work1104.bean.MyBean;

/**
 * Created by ZhangJiaYu on 2017/11/4.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    List<MyBean.DataBean> list = new ArrayList<>();
    Context context;

    public MyAdapter(List<MyBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder= null;
        View view = View.inflate(context, R.layout.fragment_home_item,null);
        holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(list.get(position).getNews_summary());
        Glide.with(context)
                .load(list.get(position).getPic_url())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
