package abadi.sejahtera.pt.ajobthing.Data;

public class dataget {
    private jobs[] data;

    private String header;

    private String status;

    public jobs[] getData ()
    {
        return data;
    }

    public void setData (jobs[] data)
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
