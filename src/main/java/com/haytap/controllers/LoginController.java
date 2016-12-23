package com.haytap.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@com.haytap.util.SessionScoped
public class LoginController {
	
	
	public void register ()
	{
		
	}
	
	public void login()  
	{

    
        try {

            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            RequestDispatcher dispatcher = ((ServletRequest)context.getRequest()).getRequestDispatcher("/j_spring_security_check");

            dispatcher.forward((ServletRequest)context.getRequest(), (ServletResponse)context.getResponse());
            FacesContext.getCurrentInstance().responseComplete();
           
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

        } 

    }
	
	public void authorizedUserControl(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!authentication.getPrincipal().toString().equals("anonymousUser")){

            NavigationHandler nh =  FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
            nh.handleNavigation(FacesContext.getCurrentInstance(), null, "/icerikEkle.xhtml?faces-redirect=true");

        }
    }
}
