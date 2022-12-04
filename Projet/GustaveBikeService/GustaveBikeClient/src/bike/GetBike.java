/**
 * GetBike.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package bike;

public interface GetBike extends java.rmi.Remote {
    public boolean buyBikes(fr.uge.bike.data.User user, int money, fr.uge.bike.data.Bike[] lst) throws java.rmi.RemoteException;
    public fr.uge.bike.data.Bike[] getBike() throws java.rmi.RemoteException;
}
