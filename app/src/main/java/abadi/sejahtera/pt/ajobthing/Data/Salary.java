package abadi.sejahtera.pt.ajobthing.Data;

public class Salary
{
    private String maximum;

    private String currency;

    private String minimum;

    public String getMaximum ()
    {
        return maximum;
    }

    public void setMaximum (String maximum)
    {
        this.maximum = maximum;
    }

    public String getCurrency ()
    {
        return currency;
    }

    public void setCurrency (String currency)
    {
        this.currency = currency;
    }

    public String getMinimum ()
    {
        return minimum;
    }

    public void setMinimum (String minimum)
    {
        this.minimum = minimum;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [maximum = "+maximum+", currency = "+currency+", minimum = "+minimum+"]";
    }
}
