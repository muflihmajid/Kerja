package abadi.sejahtera.pt.ajobthing.Data;

import android.database.sqlite.SQLiteDatabase;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class jobs {
    private jobs Jobs;
    public List<data> data;

    public String header;

    public String status;

    public List<data> getData ()
    {
        return data;
    }

    public void setData (List<data> data)
    {
        this.data = data;
    }

    public String getHeader ()
    {
        return header;
    }

    public void setHeader (String header)
    {
        this.header = header;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", header = "+header+", status = "+status+"]";
    }
}
