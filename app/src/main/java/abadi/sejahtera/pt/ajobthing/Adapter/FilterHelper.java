package abadi.sejahtera.pt.ajobthing.Adapter;

import android.content.Context;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import abadi.sejahtera.pt.ajobthing.Data.data;

class FilterHelper extends Filter {
    private List<data> currentList;
    private JobListAdapter adapter;
    private Context c;

    public FilterHelper(List<data> currentList, JobListAdapter adapter, Context c) {
        this.currentList = currentList;
        this.adapter = adapter;
        this.c=c;
    }
    /*
    - Perform actual filtering.
     */
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults filterResults=new FilterResults();

        if(constraint != null && constraint.length()>0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();

            //HOLD FILTERS WE FIND
            ArrayList<data> foundFilters=new ArrayList<>();

            data Data=null;

            //ITERATE CURRENT LIST
            for (int i=0;i<currentList.size();i++)
            {
                Data= currentList.get(i);

                //SEARCH
                if(Data.getCompany_name().toUpperCase().contains(constraint) )
                {
                    //ADD IF FOUND
                    foundFilters.add(Data);
                }
            }

            //SET RESULTS TO FILTER LIST
            filterResults.count=foundFilters.size();
            filterResults.values=foundFilters;
        }else
        {
            //NO ITEM FOUND.LIST REMAINS INTACT
            filterResults.count=currentList.size();
            filterResults.values=currentList;
        }

        //RETURN RESULTS
        return filterResults;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        adapter.setSpacecrafts((ArrayList<data>) filterResults.values);
        adapter.refresh();
    }
}
