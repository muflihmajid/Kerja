package abadi.sejahtera.pt.ajobthing.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import abadi.sejahtera.pt.ajobthing.Data.data;
import abadi.sejahtera.pt.ajobthing.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobItemFragment extends Fragment {
    public static final String JOB_ITEM_NAME = "job_item_name_key";
    public static final String JOB_ITEM_DATA = "job_item_data_key";

    private JobItemFragment fragment;
    private Bundle bundle;
    private View view;
    private TextView jobTitle;
    private String jobTitleName;

    public JobItemFragment() {
        // Required empty public constructor
    }

    public JobItemFragment newInstance(data data){
        fragment = new JobItemFragment();
        bundle = new Bundle();
        bundle.putString(JobItemFragment.JOB_ITEM_NAME, data.getJob_title());
        bundle.putParcelable(JobItemFragment.JOB_ITEM_DATA, data);
        fragment.setArguments(bundle);
        return fragment;
    }

    public void bindViews(final data data){
        jobTitle = view.findViewById(R.id.item_jobs);
        jobTitle.setText(jobTitleName);
        jobTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle = new Bundle();
                bundle.putParcelable(JobItemFragment.JOB_ITEM_DATA, data);
                EventBus.getDefault().post(bundle);
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        EventBus.getDefault().register(JobItemFragment.this);
    }

    @Override
    public void onStop(){
        super.onStop();
        EventBus.getDefault().unregister(JobItemFragment.this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_job_item, container, false);
        bundle = getArguments();
        assert bundle != null;
        jobTitleName = bundle.getString(JobItemFragment.JOB_ITEM_NAME);
        data data = bundle.getParcelable(JOB_ITEM_DATA);
        bindViews(data);
        return view;
    }
}
