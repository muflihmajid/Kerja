package abadi.sejahtera.pt.ajobthing;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import abadi.sejahtera.pt.ajobthing.Adapter.SectionsPageAdapter;
import abadi.sejahtera.pt.ajobthing.Fragment.ForYouFragment;
import abadi.sejahtera.pt.ajobthing.Fragment.JobItemFragment;
import abadi.sejahtera.pt.ajobthing.Fragment.SavedFragment;

public class MainActivity extends AppCompatActivity implements ForYouFragment.OnFragmentInteractionListener,SavedFragment.OnFragmentInteractionListener {

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    @Override
    public void onStart(){
        super.onStart();
        EventBus.getDefault().register(MainActivity.this);
    }

    @Override
    public void onStop(){
        super.onStop();
        EventBus.getDefault().unregister(MainActivity.this);
    }

    @Subscribe
    public void onEvent(Bundle bundle){
        if(bundle.containsKey(JobItemFragment.JOB_ITEM_DATA)){
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra(JobItemFragment.JOB_ITEM_DATA, bundle.getParcelable(JobItemFragment.JOB_ITEM_DATA));
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);
        //Set Up tab
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabTextColors(getResources().getColor(R.color.Normal),getResources().getColor(R.color.Selected));
        tabLayout.setupWithViewPager(mViewPager);
    }
    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ForYouFragment(), "For You");
        adapter.addFragment(new SavedFragment(), "Saved");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
