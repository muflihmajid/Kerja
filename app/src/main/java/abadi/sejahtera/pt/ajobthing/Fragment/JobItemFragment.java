package abadi.sejahtera.pt.ajobthing.Fragment;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import abadi.sejahtera.pt.ajobthing.Adapter.RoundedTransformation;
import abadi.sejahtera.pt.ajobthing.Data.Salary;
import abadi.sejahtera.pt.ajobthing.Data.data;
import abadi.sejahtera.pt.ajobthing.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobItemFragment extends Fragment {
    public static final String JOB_ITEM_NAME = "job_item_name_key";
    public static final String JOB_ITEM_UPAH = "job_item_upah";
    public static final String JOB_ITEM_KAPAN = "job_item_kapan_key";
    public static final String JOB_ITEM_WAKTU = "job_item_waktu_key";
    public static final String JOB_ITEM_KOTA = "job_item_kota_key";
    public static final String JOB_ITEM_DATA = "job_item_data_key";

    private JobItemFragment fragment;
    private Bundle bundle;
    private View view;
    private CardView jobs;
    private ImageView logo;
    private TextView Pekerjaan,kapan,jobTitle,waktu,kota;
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
        jobs = view.findViewById(R.id.job);
        logo = view.findViewById(R.id.Perusahaan);
        Pekerjaan = view.findViewById(R.id.Pekerjaan);
        kapan = view.findViewById(R.id.waktu);
        jobTitle = view.findViewById(R.id.JenisJabatan);
        waktu = view.findViewById(R.id.Jeniskerja);
        kota = view.findViewById(R.id.Tempat);
        Pekerjaan.setText(data.getCompany_name());
        kapan.setText(data.getCreated_at());
        jobTitle.setText(data.getJob_title());
        waktu.setText(data.getJob_type());
        kota.setText(data.getCity());
        Picasso.with(view.getContext())
                .load(data.getLogo())
                .transform(new RoundedTransformation(180, 2))
                .placeholder(R.drawable.ic_person_black_24dp)   // optional
                .error(R.drawable.ic_person_black_24dp)      // optional
                .fit()
                .centerInside()
                .into(logo);
        jobs.setOnClickListener(new View.OnClickListener() {
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
