package thredds.catalog;

import ucar.ma2.*;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;


import java.io.IOException;

/**
 * Created by feihu on 9/11/14.
 */
public class TestHDF {

    public static void main(String args[]) throws IOException{

        NetcdfFile ncfile = NetcdfFile.open("/Users/feihu/Documents/Data/MERRA100.prod.simul.tavgM_2d_mld_Nx.198001.hdf");//ijE4M20a000001.nc,MERRA100.prod.simul.tavgM_2d_mld_Nx.198001.hdf");
        //NetcdfFile ncfile = NetcdfFile.open("/Users/feihu/Documents/Data/ijE4M20a000001.nc");
        Variable var = ncfile.getVariables().get(6);//6


        int[] origin = new int[var.getRank()];
        int[] shape = new int[var.getShape().length];

        for (int i=0; i<origin.length; i++) {
            origin[i] = 0;
            shape[i] = var.getDimension(i).getLength()-origin[i];
        }

        try {
          ArrayLong offset = var.getLocalityInformation(origin,shape);
          long length = offset.getSize();
          long num = offset.getLong(0);
          System.out.println(num);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidRangeException e) {
            e.printStackTrace();
        }

    }
}
