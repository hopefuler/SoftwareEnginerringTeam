package startislands.team3.softwareenginerringteam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter{

    /* 아이템을 세트로 담기 위한 어레이 */
    private ArrayList<MyItem> mItems = new ArrayList<>();

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public MyItem getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();

        /* 'listview_custom' Layout을 inflate하여 convertView 참조 획득 */
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.pli_listview, parent, false);
        }

        /* 'listview_custom'에 정의된 위젯에 대한 참조 획득 */
        TextView pli_number = (TextView) convertView.findViewById(R.id.pli_number) ;
        TextView pli_date = (TextView) convertView.findViewById(R.id.pli_date) ;
        TextView pli_time = (TextView) convertView.findViewById(R.id.pli_time) ;
        TextView pli_method = (TextView) convertView.findViewById(R.id.pli_method) ;
        TextView pli_totalprice = (TextView) convertView.findViewById(R.id.pli_totalprice) ;

        /* 각 리스트에 뿌려줄 아이템을 받아오는데 mMyItem 재활용 */
        MyItem myItem = getItem(position);

        /* 각 위젯에 세팅된 아이템을 뿌려준다 */
        pli_number.setText(myItem.getNumber());
        pli_date.setText(myItem.getDate());
        pli_time.setText(myItem.getTime());
        pli_method.setText(myItem.getMethod());
        pli_totalprice.setText(myItem.getTotalPrice());

        /* (위젯에 대한 이벤트리스너를 지정하고 싶다면 여기에 작성하면된다..)  */

        return convertView;
    }

    public void addItem(String number, String date, String time, String method, String totalprice) {

        MyItem mItem = new MyItem();

        /* MyItem에 아이템을 setting한다. */
        mItem.setTime(time);
        mItem.setMethod(method);
        mItem.setTotalPrice(totalprice);
        mItem.setDate(date);
        mItem.setNumber(number);

        /* mItems에 MyItem을 추가한다. */
        mItems.add(mItem);

    }
    public void removeAll(){
        mItems.clear();
    }
}
