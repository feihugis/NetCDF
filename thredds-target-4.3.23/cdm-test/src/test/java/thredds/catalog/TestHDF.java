package thredds.catalog;

import ucar.ma2.Array;
import ucar.ma2.InvalidRangeException;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

import java.io.IOException;

/**
 * Created by feihu on 9/11/14.
 */
public class TestHDF {
    public static void main(String args[]) throws IOException{

        NetcdfFile ncfile = NetcdfFile.open("/Users/feihu/Documents/Data/ijE4M20a000001.nc");//ijE4M20a000001.nc,MERRA100.prod.simul.tavgM_2d_mld_Nx.198001.hdf");


        Variable var = ncfile.getVariables().get(1);
        int[] origin = new int[var.getRank()];
        int[] shape = new int[var.getRank()];

        for (int i=0; i<origin.length; i++) {
            origin[i] = 0;
            shape[i] = 1;
        }



        try {
          Array offset = var.getLocalityInformation(origin,shape);
          String num = offset.toString();
          System.out.println(num);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidRangeException e) {
            e.printStackTrace();
        }

    }
}
