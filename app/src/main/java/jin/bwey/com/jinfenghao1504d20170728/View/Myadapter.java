package jin.bwey.com.jinfenghao1504d20170728.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import jin.bwey.com.jinfenghao1504d20170728.Module.bean;
import jin.bwey.com.jinfenghao1504d20170728.R;

/**
 * Created by Administrator on 2017/7/28.
 */

public class Myadapter extends  RecyclerView.Adapter<Myadapter.MyViewHolder>  {
    Context context;
    List<bean.DataBean> list;
    MyItemClickListener mItemClickListener;
    public Myadapter(Context context, List<bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
     View  view = View.inflate(context, R.layout.item,null);
        MyViewHolder myViewHolder = new MyViewHolder(view, mItemClickListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv.setText(list.get(position).getTitle());
            holder.tv2.setText(list.get(position).getIntroduction());
        Glide.with(context).load(list.get(position).getImg()).into(holder.image);



    }

    @Override
    public int getItemCount() {
        return list!=null?list.size():0;
    }




    class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener
    {
        private MyItemClickListener mListener;
        TextView tv;
        TextView tv2;
        ImageView image;
        public MyViewHolder(View view,MyItemClickListener myItemClickListener)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.item_text);
            tv2 = (TextView) view.findViewById(R.id.item_text2);
            image = (ImageView) view.findViewById(R.id.item_image);
            this.mListener = myItemClickListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onItemClick(v, getPosition());
        }
    }

    public interface MyItemClickListener {
        void onItemClick(View view, int Position);
    }
    public void setItemClickListener(MyItemClickListener myItemClickListener) {
        this.mItemClickListener = myItemClickListener;
    }


}
