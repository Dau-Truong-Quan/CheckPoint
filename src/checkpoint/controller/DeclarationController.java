package checkpoint.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import checkpoint.entity.Address;
import checkpoint.entity.Declaration;
import checkpoint.entity.PersonalInfor;

@Transactional
@Controller
public class DeclarationController {
	@Autowired
	SessionFactory factory;
//	
//	@RequestMapping("saveData")
//	public String declaration(ModelMap model) {
//		Session session = factory.getCurrentSession();
//		String hql = "FROM Declaration";
//		Query query  = session.createQuery(hql);
//		List<Declaration> list = query.list();
//		model.addAttribute("declaration", list);
//		return "declaration/form";
//		
//	}
//	
	public List<Declaration> getStaffs() {
		Session session = factory.getCurrentSession();

		// không xài nhưng mà nó đòi thì phải cho
		Transaction t = session.beginTransaction();
		String hql = "from Declaration";
		Query query = session.createQuery(hql);
		
		List<Declaration> list = query.list();
		return list;
		
	}
	
	public int insertUser(PersonalInfor user) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(user);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public int insertAddress(Address address) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(address);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public int insertDeclaration(Declaration declaration) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(declaration);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public Address getLastAddress() {
		Session session = factory.openSession();
		String hql = "from Address order by id desc";
		Query query = session.createQuery(hql);
		Address list = (Address) query.list().get(0);
		session.close();
		return list;
	}
	  
	  @RequestMapping("/declaration-mgr")
		public String showForm(ModelMap model) {
		  List<Declaration> list = this.getStaffs();
			 
			 model.addAttribute("list", list);
			return "declaration/declaration-mgr";
		}
	  
	  @RequestMapping(value = "/declaration/saveData", method= RequestMethod.POST)
		public String saveDate(ModelMap model, HttpServletRequest request, @ModelAttribute("user") PersonalInfor user) {
		  
		  Address addressPerson = new Address();
		  addressPerson.setAddressName(request.getParameter("addressPerson"));
		  insertAddress(addressPerson);
		  addressPerson = getLastAddress();
		  System.out.println(addressPerson.getAddressName());
		  
		  
		  Address addressBegin = new Address();
		  addressBegin.setAddressName(request.getParameter("addressBegin"));
		  insertAddress(addressBegin);
		  addressBegin = getLastAddress();
		  System.out.println(addressBegin.getAddressName());
		  
			return "declaration/succes";
		}
	  
	  
	 @RequestMapping(params = "btnInsert") public String insert(ModelMap model,
	  
	 @RequestParam("name")String name,
	 
	 @RequestParam("mark")Double mark,
	 
	 @RequestParam("major")String major) { model.addAttribute("name", name);
	 model.addAttribute("mark", mark); model.addAttribute("major", major); 
	 return "success"; 
	 }
//	 
//	 @RequestMapping(params = "btnUpdate") 
//	 public String update(ModelMap model,
//	 Declaration declaration) { model.addAttribute("declaration", declaration);
//	 return "success2"; }
//	 
//	 @RequestMapping(params = "btnDelete")
//	 public String delete(ModelMap model) {
//	 model.addAttribute("message", "Bạn gọi delete()"); 
//	 return "declaration-mgr";
//	 }
//	 
//	 @RequestMapping(params = "btnReset") 
//	 public String reset(ModelMap model) {
//	 model.addAttribute("message", "Bạn gọi reset()"); 
//	 return "declaration-mgr"; }
//	 
//	 @RequestMapping(params = "lnkEdit") 
//	 public String edit(ModelMap model) {
//	 model.addAttribute("message", "Bạn gọi edit()"); 
//	 return "declaration-mgr"; }
	
}
