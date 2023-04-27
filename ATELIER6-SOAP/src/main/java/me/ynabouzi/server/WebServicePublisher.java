package me.ynabouzi.server;

import me.ynabouzi.service.HelloWorldService;

import javax.xml.ws.Endpoint;

public class WebServicePublisher {
	public static void main(String[] args) {
		System.out.println("The server now is running");
		System.out.println("Check this link for wsdl : http://localhost:8080/hello?wsdl");
		Endpoint.publish("http://localhost:8080/hello", new HelloWorldService());
	}
}
