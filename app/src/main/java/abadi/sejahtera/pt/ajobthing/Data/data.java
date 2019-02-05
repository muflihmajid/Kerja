package abadi.sejahtera.pt.ajobthing.Data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class data implements Parcelable {
    @SerializedName("job_type")
    private String job_type;
    @SerializedName("country")
    private String country;
    @SerializedName("city")
    private String city;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("description")
    private String description;
    @SerializedName("requirement")
    private String requirement;
    @SerializedName("salary")
    private Object salary;
    @SerializedName("responsibility")
    private String responsibility;
    @SerializedName("share_url")
    private String share_url;
    @SerializedName("company_name")
    private String company_name;
    @SerializedName("logo")
    private String logo;
    @SerializedName("id")
    private String id;
    @SerializedName("job_title")
    private String job_title;


    protected data(Parcel in) {
        job_type = in.readString();
        country = in.readString();
        city = in.readString();
        created_at = in.readString();
        description = in.readString();
        requirement = in.readString();
        responsibility = in.readString();
        share_url = in.readString();
        company_name = in.readString();
        logo = in.readString();
        id = in.readString();
        job_title = in.readString();
    }

    public static final Creator<data> CREATOR = new Creator<data>() {
        @Override
        public data createFromParcel(Parcel in) {
            return new data(in);
        }

        @Override
        public data[] newArray(int size) {
            return new data[size];
        }
    };

    public String getJob_type ()
    {
        return job_type;
    }

    public void setJob_type (String job_type)
    {
        this.job_type = job_type;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getRequirement ()
    {
        return requirement;
    }

    public void setRequirement (String requirement)
    {
        this.requirement = requirement;
    }

    public Object getSalary ()
    {
        return salary;
    }

    public void setSalary (Object salary)
    {
        this.salary = salary;
    }

    public String getResponsibility ()
    {
        return responsibility;
    }

    public void setResponsibility (String responsibility)
    {
        this.responsibility = responsibility;
    }

    public String getShare_url ()
    {
        return share_url;
    }

    public void setShare_url (String share_url)
    {
        this.share_url = share_url;
    }

    public String getCompany_name ()
    {
        return company_name;
    }

    public void setCompany_name (String company_name)
    {
        this.company_name = company_name;
    }

    public String getLogo ()
    {
        return logo;
    }

    public void setLogo (String logo)
    {
        this.logo = logo;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getJob_title ()
    {
        return job_title;
    }

    public void setJob_title (String job_title)
    {
        this.job_title = job_title;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [job_type = "+job_type+", country = "+country+", city = "+city+", created_at = "+created_at+", description = "+description+", requirement = "+requirement+", salary = "+salary+", responsibility = "+responsibility+", share_url = "+share_url+", company_name = "+company_name+", logo = "+logo+", id = "+id+", job_title = "+job_title+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(job_type);
        dest.writeString(country);
        dest.writeString(city);
        dest.writeString(created_at);
        dest.writeString(description);
        dest.writeString(requirement);
        dest.writeString(responsibility);
        dest.writeString(share_url);
        dest.writeString(company_name);
        dest.writeString(logo);
        dest.writeString(id);
        dest.writeString(job_title);
    }
}
