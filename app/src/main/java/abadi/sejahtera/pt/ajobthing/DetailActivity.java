package abadi.sejahtera.pt.ajobthing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import abadi.sejahtera.pt.ajobthing.Adapter.RoundedTransformation;
import abadi.sejahtera.pt.ajobthing.Data.Salary;
import abadi.sejahtera.pt.ajobthing.Fragment.JobItemFragment;

public class DetailActivity extends AppCompatActivity {
    private abadi.sejahtera.pt.ajobthing.Data.data data;
    private ImageView ivLogo,ivmore;
    private TextView tvCompany, tvJobTitle, tvJobLoc, tvSalary, tvAbout, tvResponsibility, tvRequirements;
    private String salaryMin, salaryMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initViews();
        getData();
        bindViews();
    }

    private void initViews(){
        ivLogo = findViewById(R.id.detail_logo);
        tvCompany = findViewById(R.id.detail_job_company);
        tvJobTitle = findViewById(R.id.detail_job_title);
        tvJobLoc = findViewById(R.id.detail_job_location);
        tvSalary = findViewById(R.id.detail_salary);
        tvAbout = findViewById(R.id.detail_about);
        tvResponsibility = findViewById(R.id.detail_responsibility);
        tvRequirements = findViewById(R.id.detail_requirements);
        ivmore = findViewById(R.id.detail_share_more);
    }

    private void getData(){
        Intent intent = getIntent();
        data = intent.getParcelableExtra(JobItemFragment.JOB_ITEM_DATA);
        assert data != null;
    }

    private void bindViews(){
        // todo add picasso lib
        // todo fetch image logo
        try{
            Salary salary = (Salary) data.getSalary();
            salaryMin = salary.getMinimum();
            salaryMax = salary.getMaximum();
            tvSalary.setText(salaryMin + " - " + salaryMax);
        }catch(Exception e){
            Log.e("Salary Error", e.getMessage());
            salaryMin = "0";
            salaryMax = "0";
            tvSalary.setText(salaryMin + " - " + salaryMax);
        }
        tvCompany.setText(data.getCompany_name());
        tvJobTitle.setText(data.getJob_title());
        tvJobLoc.setText(data.getCountry());
        //tvSalary.setText(salaryMin + " - " + salaryMax);
        tvAbout.setText(data.getDescription());
        tvResponsibility.setText(data.getResponsibility());
        tvRequirements.setText(data.getRequirement());
        ivmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType(data.getShare_url());
                startActivity(Intent.createChooser(share, "Share link!"));
            }
        });
        Picasso.with(this)
                .load(data.getLogo())
                .transform(new RoundedTransformation(180, 2))
                .placeholder(R.drawable.ic_person_black_24dp)   // optional
                .error(R.drawable.ic_person_black_24dp)      // optional
                .fit()
                .centerInside()
                .into(ivLogo);
    }
}
