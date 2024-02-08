package com.EcommerceProject.Ecommerce.com.EcommerceProject.Ecommerce;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



import jakarta.servlet.http.HttpSession;




@Controller

public class EcommerceController {
	
	@Autowired
	iRegister ir;
	@Autowired
	iproduct ip;
	
	@Autowired
	icart ic;
	
	@Autowired
	iOrder io;
	 
	
	
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
	
	//Login for admin Page
	@RequestMapping("adminhome")
	public ModelAndView adminhome(ModelMap mp)
	{
		mp.put("obj", ip.findAll());
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(mp);
		
		mv.setViewName("admin/adminhome.jsp");
		
		return mv;
	}
	
	
	@RequestMapping("delete")
	public String delete(@RequestParam Integer id) {
	    if (id != null) {
	        ip.deleteById(id);
	    }
	    return "adminproduct";
	}
	
	
	

	
//	for data fetch by admin in product page

	@RequestMapping("adminproduct")
	public ModelAndView adminproduct(ModelMap mp)
	{
		mp.put("obj", ip.findAll());
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(mp);
		
		mv.setViewName("admin/adminproduct.jsp");
		
		return mv;
	}

	
	
	
	
	@RequestMapping("addproduct")
	public String addproduct()
	{
		return "admin/addproduct.jsp";
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
		
		return "adminproduct";	
		
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
        	
        	if(email.equals("admin@gmail.com"))
        	{
        		session.setAttribute("eid", email);
        		ModelAndView mv = new ModelAndView();
                mv.setViewName("adminhome");
                return mv;
        	}
        	
        	else
        	{
            
            ModelAndView mv = new ModelAndView();
            mv.setViewName("login.jsp");
            return mv;
        
        	}
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
	public ModelAndView addcart(int id, String email)
	{
		Register r1 = ir.findByEmail(email);
		product p1 = ip.findById(id);
		
		int i = ic.countByRegister_id(r1.getId());
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("qty", i);
    	mv.setViewName("cart");
		
		if (p1 != null)
		{
			cart c = new cart(p1, r1);
			ic.save(c);
		}
		return mv;
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
	

//	For delete the data from cart
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
	
	
	@RequestMapping("aboutadmin")
	public String aboutadmin()
	{
		return "admin/aboutadmin.jsp";
	}
	
	
//	for update data by admin

	@RequestMapping("update")
	public String update(int id,ModelMap mp)
	{
		product p1 = ip.findById(id);
		
		
		mp.put("pro", p1);
		return "admin/editproduct.jsp";
		
	
	}
	
	
	
//	For update the data
	@RequestMapping("editproduct")
	public String editproduct(int id, String name, String description, String imageUrl, float price, int size)
	{
		product p1 = ip.findById(id);
		
		
		p1.setId(id);
		p1.setName(name);
		p1.setDescription(description);
		p1.setImageUrl(imageUrl);
		p1.setPrice(price);
		p1.setSize(size);
		ip.save(p1);
		
		return "adminproduct";
		
	}
	
	@RequestMapping("order")
	public ModelAndView order(ModelMap mp)
	{
		mp.put("orders", io.findAll());
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(mp);
		
		mv.setViewName("admin/order.jsp");
		
		return mv;
	}
	
	
	
	
	@RequestMapping("complete")
	public String complete(String email, String pi, float total,String cid)
	{	
		String pid = "";
		Register r1 = ir.findByEmail(email);
		char[] arr = pi.toCharArray();
		for(int i=1; i<arr.length;i++)
		{
			pid = pid + arr[i];
		}
		
		Orderdetails o1=new Orderdetails(r1,total,pid);
		io.save(o1);
		String[] array = cid.split(",");
	    for (String letter : array) {
	      if(letter!="")
	      {
	      int c=Integer.valueOf(letter);
	      ic.deleteById(c);
	      }
	    }
		
		return "home";
	}
		
	
	@RequestMapping("deleteorder")
	public String deleteorder(int id)
	{
		io.deleteById(id);
		return "order";
	}
	
	
}
