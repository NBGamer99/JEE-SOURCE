package me.ynabouzi.service;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class HelloWorldService {
	@WebMethod
	public String sayHello(String name) {
		return "Hello, " + name + "!";
	}
}
