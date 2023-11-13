package com.EcommerceProject.Ecommerce.com.EcommerceProject.Ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;



@Controller
public class EcommerceController {
	
	@Autowired
	iRegister ir;
	@Autowired
	iproduct ip;
	
	@Autowired
	icart ic;
	 
	
	
	@RequestMapping("home")
	public ModelAndView home(ModelMap mp)
	{
		mp.put("obj", ip.findAll());
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(mp);
		
		mv.setViewName("home.jsp");
		
		return mv;
	}
	
	@RequestMapping("login")
	public String login()
	{
		return "login.jsp";
	}
	
	
	@RequestMapping("addproduct")
	public String addproduct()
	{
		return "addproduct.jsp";
	}
	
	
// for data to be add
	
	@RequestMapping(value = "/additems", method = RequestMethod.GET)
	public String addproduct(String name, String description, String imageUrl, float price, int size)
	{
		product p1 = new product();
		
		p1.setName(name);
		p1.setDescription(description);
		p1.setImageUrl(imageUrl);
		p1.setPrice(price);
		p1.setSize(size);
		
		ir.save(p1);
		
		return "redirect:/products";	
		
	}
	

// For signup

	@RequestMapping("registeration")
	public String register(String name, String email, String password)
	{
		Register r1 = new Register();
		
		
		r1.setName(name);
		r1.setEmail(email);
		r1.setPassword(password);
		ir.save(r1);
		return "redirect:/login";	
		
	}
	
	
	
//for login
	
	@RequestMapping(value = "log", method = RequestMethod.POST)
    public ModelAndView login(HttpSession session, String email, String password) 
	{
		
        Register user = ir.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
        	
        	int i = ic.countByRegister_id(user.getId());
        	ModelAndView mv = new ModelAndView();
        	mv.addObject("qty", i);
        	mv.setViewName("home");
        	session.setAttribute("eid", email);
        	return mv;
             
             
        } else {
            
            ModelAndView mv = new ModelAndView();
            mv.setViewName("login.jsp");
            return mv;
        }
    }
	
	
	
//	for data fetch

	@RequestMapping("products")
	public ModelAndView products(ModelMap mp)
	{
		mp.put("obj", ip.findAll());
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(mp);
		
		mv.setViewName("products.jsp");
		
		return mv;
	}
	
	
	
//	For single page
	@RequestMapping("singlepage")
	public ModelAndView singlepage(ModelMap mo, int id)
	{
		mo.put("prod1", ip.findById(id));
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(mo);
		mv.setViewName("singlepage.jsp");
		return mv;
	}
	
	
	
	//for logout
	
	@RequestMapping("logout")
	public String logout()
	{
		return "logout.jsp";
	}
	


	//Add to cart
	@RequestMapping("addcart")
	public String addcart(int id, String email)
	{
		Register r1 = ir.findByEmail(email);
		product p1 = ip.findById(id);
		
		if (p1 != null)
		{
			cart c = new cart(p1, r1);
			ic.save(c);
		}
		return "cart";
	}
	
	
//	all cart
	
	@RequestMapping("cart")
	public ModelAndView cart(ModelMap mp, String email)
	{
		Register r1 = ir.findByEmail(email);
		int id = r1.getId();
		
		mp.put("car", ic.findAllByRegister_id(id));
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(mp);
		
		mv.setViewName("cart.jsp");
		return mv;
	}
	

//	For delete the data
	@RequestMapping("remove")
	public String remove(int id)
	{
		ic.deleteById(id);
		return "home";
	}
	
	
	
	
	@RequestMapping("about")
	public String about()
	{
		return "about.jsp";
	}
	
	
	
	

	
}
