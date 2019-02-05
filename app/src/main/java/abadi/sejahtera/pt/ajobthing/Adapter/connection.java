package abadi.sejahtera.pt.ajobthing.Adapter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class connection {
    public static boolean isConnectedToInternet(Context context)
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivitymanager!=null)
        {
            NetworkInfo[] info = connectivitymanager.getAllNetworkInfo();
            if(info!=null)
            {
                for(int i = 0;i<info.length;i++)
                {
                    if(info[i].getState() == NetworkInfo.State.CONNECTED)
                        return true;
                }
            }
        }
        return false;
    }
}
