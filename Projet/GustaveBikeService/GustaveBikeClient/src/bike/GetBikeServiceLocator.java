/**
 * GetBikeServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package bike;

public class GetBikeServiceLocator extends org.apache.axis.client.Service implements bike.GetBikeService {

    public GetBikeServiceLocator() {
    }


    public GetBikeServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GetBikeServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for GetBike
    private java.lang.String GetBike_address = "http://localhost:8080/GustaveBikeService/services/GetBike";

    public java.lang.String getGetBikeAddress() {
        return GetBike_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GetBikeWSDDServiceName = "GetBike";

    public java.lang.String getGetBikeWSDDServiceName() {
        return GetBikeWSDDServiceName;
    }

    public void setGetBikeWSDDServiceName(java.lang.String name) {
        GetBikeWSDDServiceName = name;
    }

    public bike.GetBike getGetBike() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GetBike_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGetBike(endpoint);
    }

    public bike.GetBike getGetBike(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            bike.GetBikeSoapBindingStub _stub = new bike.GetBikeSoapBindingStub(portAddress, this);
            _stub.setPortName(getGetBikeWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGetBikeEndpointAddress(java.lang.String address) {
        GetBike_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (bike.GetBike.class.isAssignableFrom(serviceEndpointInterface)) {
                bike.GetBikeSoapBindingStub _stub = new bike.GetBikeSoapBindingStub(new java.net.URL(GetBike_address), this);
                _stub.setPortName(getGetBikeWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("GetBike".equals(inputPortName)) {
            return getGetBike();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://bike", "GetBikeService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://bike", "GetBike"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("GetBike".equals(portName)) {
            setGetBikeEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
