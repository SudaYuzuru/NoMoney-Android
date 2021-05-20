package com.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.R;
import com.test.db.AccountBean;

import java.util.Calendar;
import java.util.List;

public class AccountAdapter extends BaseAdapter {       //继承于BaseAdapter
    Context context;      //传入上下文对象
    List<AccountBean>mDatas;    //传入数据源
    LayoutInflater inflater;    //加载布局
    int year,month,day;         //获取当前日期
    public AccountAdapter(Context context, List<AccountBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        inflater = LayoutInflater.from(context);
        Calendar calendar = Calendar.getInstance();     //得到calendar对象数据
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getCount() {

        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {

        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {    //返回指定View
        ViewHolder holder = null;      //声明ViewHolder
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_mainlv,parent,false);      //为空时，加载item_mainlv的布局
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();         //对控件进行初始化声明
        }
        AccountBean bean = mDatas.get(position);                //得到指定位置的数据源
        holder.typeIv.setImageResource(bean.getsImageId());
        holder.typeTv.setText(bean.getTypename());
        holder.beizhuTv.setText(bean.getBeizhu());
        holder.moneyTv.setText("￥ "+bean.getMoney());             //通过￥ 转换为字符串类型
        if (bean.getYear()==year&&bean.getMonth()==month&&bean.getDay()==day) {          //判断是否为当日
            String time = bean.getTime().split(" ")[1];          //对time进行分割
            holder.timeTv.setText("今天 "+time);
        }else {
            holder.timeTv.setText(bean.getTime());
        }
        return convertView;
    }

    class ViewHolder{     //将每个item都传递进去（item_mainlv
        ImageView typeIv;
        TextView typeTv,beizhuTv,timeTv,moneyTv;
        public ViewHolder(View view){
            typeIv = view.findViewById(R.id.item_mainlv_iv);
            typeTv = view.findViewById(R.id.item_mainlv_tv_title);
            timeTv = view.findViewById(R.id.item_mainlv_tv_time);
            beizhuTv = view.findViewById(R.id.item_mainlv_tv_beizhu);
            moneyTv = view.findViewById(R.id.item_mainlv_tv_money);

        }
    }
}
