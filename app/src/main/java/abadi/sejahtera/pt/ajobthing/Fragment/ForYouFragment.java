package abadi.sejahtera.pt.ajobthing.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import abadi.sejahtera.pt.ajobthing.API.APIALL;
import abadi.sejahtera.pt.ajobthing.Adapter.JobListAdapter;
import abadi.sejahtera.pt.ajobthing.Adapter.connection;
import abadi.sejahtera.pt.ajobthing.Data.data;
import abadi.sejahtera.pt.ajobthing.Data.jobs;
import abadi.sejahtera.pt.ajobthing.DetailActivity;
import abadi.sejahtera.pt.ajobthing.MainActivity;
import abadi.sejahtera.pt.ajobthing.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ForYouFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ForYouFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForYouFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    GridView listView;
    private OnFragmentInteractionListener mListener;

    public ForYouFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForYouFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForYouFragment newInstance(String param1, String param2) {
        ForYouFragment fragment = new ForYouFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart(){
        super.onStart();
        if(connection.isConnectedToInternet(getActivity()))
        {
            EventBus.getDefault().register(ForYouFragment.this);
        }
        else
        {

        }
    }

    @Override
    public void onStop(){
        super.onStop();
        EventBus.getDefault().unregister(ForYouFragment.this);
    }

    @Subscribe
    public void onEvent(Bundle bundle){
//        if(bundle.containsKey(JobItemFragment.JOB_ITEM_DATA)){
//            Intent intent = new Intent(getActivity(), DetailActivity.class);
//            intent.putExtra(JobItemFragment.JOB_ITEM_DATA, bundle.getParcelable(JobItemFragment.JOB_ITEM_DATA));
//            startActivity(intent);
//        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_for_you, container, false);
        listView = (GridView) v.findViewById(R.id.listViewHeroes1);
        getJob();
        return v;
    }


    private void getJob() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIALL.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        APIALL api = retrofit.create(APIALL.class);

        Call<jobs> call = api.data();
        call.enqueue(new Callback<jobs>() {
            @Override
            public void onResponse(Call<jobs> call, Response<jobs> response) {
                List<data> joblist = response.body().getData();
                Log.d("tes", "cekmasuk: " + response.body().getData());
                //Creating an String array for the ListView
                String[] joblists = new String[joblist.size()];

                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < joblist.size(); i++) {
                    joblists[i] = joblist.get(i).getJob_title();
                    Log.d("tes", "cekmasuk: " + joblist.get(i).getJob_title());
                }

                //displaying the string array into listview
                JobListAdapter adapter = new JobListAdapter(getContext(), joblist);
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<jobs> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("ERRPR", t.getLocalizedMessage());
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
