package abadi.sejahtera.pt.ajobthing.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

import abadi.sejahtera.pt.ajobthing.Data.data;
import abadi.sejahtera.pt.ajobthing.Fragment.JobItemFragment;

public class JobListAdapter extends BaseAdapter implements Filterable {
    private Context context;
    private List<data> dataList;
    private List<data> currentList;
    private View view;
    private FilterHelper filterHelper;
    private JobItemFragment fragment;

    public JobListAdapter(Context context, List<data> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        fragment = new JobItemFragment().newInstance(dataList.get(position));
        view = fragment.onCreateView(LayoutInflater.from(context), parent, null);
        return view;
    }

    public void setSpacecrafts(ArrayList<data> filteredSpacecrafts)
    {
        this.dataList=filteredSpacecrafts;
    }
    @Override
    public Filter getFilter() {
        if(filterHelper==null)
        {
            filterHelper=new FilterHelper(currentList,this,context);
        }
        return filterHelper;
    }
    public void refresh(){
        notifyDataSetChanged();
    }
}
