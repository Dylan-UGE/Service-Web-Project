package bike;

public class GetBikeProxy implements bike.GetBike {
  private String _endpoint = null;
  private bike.GetBike getBike = null;
  
  public GetBikeProxy() {
    _initGetBikeProxy();
  }
  
  public GetBikeProxy(String endpoint) {
    _endpoint = endpoint;
    _initGetBikeProxy();
  }
  
  private void _initGetBikeProxy() {
    try {
      getBike = (new bike.GetBikeServiceLocator()).getGetBike();
      if (getBike != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)getBike)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)getBike)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (getBike != null)
      ((javax.xml.rpc.Stub)getBike)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public bike.GetBike getGetBike() {
    if (getBike == null)
      _initGetBikeProxy();
    return getBike;
  }
  
  public fr.uge.bike.data.Bike[] getBike() throws java.rmi.RemoteException{
    if (getBike == null)
      _initGetBikeProxy();
    return getBike.getBike();
  }
  
  public boolean buyBikes(fr.uge.bike.data.User user, fr.uge.bike.data.Bike[] lst) throws java.rmi.RemoteException{
    if (getBike == null)
      _initGetBikeProxy();
    return getBike.buyBikes(user, lst);
  }
  
  
}