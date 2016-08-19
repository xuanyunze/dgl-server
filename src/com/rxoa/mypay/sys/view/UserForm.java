package com.rxoa.mypay.sys.view;

import javax.xml.transform.TransformerFactory;

import com.rxoa.mypay.base.view.PageForm;
import com.rxoa.mypay.base.view.form.Input;

public class UserForm extends PageForm{
	private static final long serialVersionUID = 1L;
	public UserForm createForm(){
		try{
			TransformerFactory fac = TransformerFactory.newInstance();
			addItem("username",new Input().setInputName("username"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return this;
	}
}
