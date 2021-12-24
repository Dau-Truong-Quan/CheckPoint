package checkpoint.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

		// khÃ´ng xÃ i nhÆ°ng mÃ  nÃ³ Ä‘Ã²i thÃ¬ pháº£i cho
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
	
	public int updateUser(PersonalInfor user) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(user);
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
	
	public int updateAddress(Address address) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(address);
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
		public String saveData(ModelMap model, HttpServletRequest request, @ModelAttribute("user") PersonalInfor user, BindingResult errors) {
		  
		  	boolean errorCheck = false;
		  	if(user.getFullName().trim().length() == 0) {
				errors.rejectValue("fullName", "user", "Vui lòng nhập tên!");
			}
		  	
		  	if(user.getPhone().trim().length() == 0) {
				errors.rejectValue("phone", "user", "Vui lòng nhập số điện thoại!");
			}
		  	else if (!user.getPhone().matches("\\d{10,}")) {
				errors.rejectValue("phone", "user", "Số điện thoại không hợp lệ!");
			}
		  	
		  	if(user.getNationality().trim().length() == 0) {
				errors.rejectValue("nationality", "user", "Vui lòng nhập quốc tịch!");
			}
		  	
		  	if(request.getParameter("date").isEmpty() || request.getParameter("date").isBlank()) {
		  		model.addAttribute("dateError", "Vui lòng chọn ngày!");
		  		errorCheck = true;
		  	}
		  	
		  	if(request.getParameter("addressPerson").isEmpty() || request.getParameter("addressPerson").isBlank()) {
		  		model.addAttribute("addressPersonError", "Vui lòng nhập địa chỉ!");
		  		errorCheck = true;
		  	}
		  	
		  	if(request.getParameter("addressBegin").isEmpty() || request.getParameter("addressBegin").isBlank()) {
		  		model.addAttribute("addressBeginError", "Vui lòng nhập nơi khởi hành!");
		  		errorCheck = true;
		  	}
		  	
		  	if(request.getParameter("addressEnd").isEmpty() || request.getParameter("addressEnd").isBlank()) {
		  		model.addAttribute("addressEndError", "Vui lòng nhập nơi đến!");
		  		errorCheck = true;
		  	}	  	
		  	
			
			if(errors.hasErrors() || errorCheck)
			{
				return "declaration/form";
			}
			else
			{
			  Address addressPerson = new Address();
			  addressPerson.setAddressName(request.getParameter("addressPerson"));
			  insertAddress(addressPerson);
			  addressPerson = getLastAddress();
			  
			  user.setIdAddress(addressPerson);
			  insertUser(user);
			  System.out.println(addressPerson.getAddressName());
			  
			  
			  Address addressBegin = new Address();
			  addressBegin.setAddressName(request.getParameter("addressBegin"));
			  insertAddress(addressBegin);
			  addressBegin = getLastAddress();
			  System.out.println(addressBegin.getAddressName());
			  
			  Address addressEnd = new Address();
			  addressEnd.setAddressName(request.getParameter("addressEnd"));
			  insertAddress(addressEnd);
			  addressEnd = getLastAddress();
			  System.out.println(addressEnd.getAddressName());
			  
			  String dateStr = request.getParameter("date");
			  Date date = null;
			  try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
					System.out.println(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			  Declaration declaration = new Declaration();
			  declaration.setDate(date);
			  declaration.setEndAddressCode(addressEnd);
			  declaration.setStartAddressCode(addressBegin);
			  declaration.setNameVehicle(request.getParameter("vehicle"));
			  declaration.setPersonalId(user);
			  declaration.setPhone(user.getPhone());
			  insertDeclaration(declaration);
			  
			  model.addAttribute("date", date);
			}
		  return "declaration/succes";
		}
	  
	  public Declaration getDeclarationByID(Integer id) {
			Session session = factory.openSession();
			String hql = "from Declaration where id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);

			Declaration list = (Declaration) query.list().get(0);
			session.close();
			return list;
		}
	  
	  public int updateDeclaration(Declaration declaration) {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();

			try {
				session.update(declaration);
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
	  
	  @RequestMapping(value = "edit-declaration", method = RequestMethod.GET)
	  public String edit(HttpSession session, ModelMap model, @RequestParam("id") Integer id) {
		  
		  Declaration declaration = getDeclarationByID(id);
		  
		  model.addAttribute("user", declaration.getPersonalId());
		  model.addAttribute("addressPerson", declaration.getPersonalId().getIdAddress().getAddressName());
		  model.addAttribute("addressBegin", declaration.getStartAddressCode().getAddressName());
		  model.addAttribute("addressEnd", declaration.getEndAddressCode().getAddressName());
		  model.addAttribute("date", declaration.getDate());
		  session.setAttribute("declaration", declaration);
		  
		  return "declaration/editDeclaration";
	  }
	  
	  @RequestMapping(value = "edit-declaration", method = RequestMethod.POST)
	  public String saveEdit(HttpSession session, ModelMap model, HttpServletRequest request, @ModelAttribute("user") PersonalInfor user, BindingResult errors) {
		  
		  boolean errorCheck = false;
		  	if(user.getFullName().trim().length() == 0) {
				errors.rejectValue("fullName", "user", "Vui lòng nhập tên!");
			}
		  	
		  	if(user.getPhone().trim().length() == 0) {
				errors.rejectValue("phone", "user", "Vui lòng nhập số điện thoại!");
			}
		  	else if (!user.getPhone().matches("\\d{10,}")) {
				errors.rejectValue("phone", "user", "Số điện thoại không hợp lệ!");
			}
		  	
		  	if(user.getNationality().trim().length() == 0) {
				errors.rejectValue("nationality", "user", "Vui lòng nhập quốc tịch!");
			}
		  	
		  	if(request.getParameter("date").isEmpty() || request.getParameter("date").isBlank()) {
		  		model.addAttribute("dateError", "Vui lòng chọn ngày!");
		  		errorCheck = true;
		  	}
		  	
		  	if(request.getParameter("addressPerson").isEmpty() || request.getParameter("addressPerson").isBlank()) {
		  		model.addAttribute("addressPersonError", "Vui lòng nhập địa chỉ!");
		  		errorCheck = true;
		  	}
		  	
		  	if(request.getParameter("addressBegin").isEmpty() || request.getParameter("addressBegin").isBlank()) {
		  		model.addAttribute("addressBeginError", "Vui lòng nhập nơi khởi hành!");
		  		errorCheck = true;
		  	}
		  	
		  	if(request.getParameter("addressEnd").isEmpty() || request.getParameter("addressEnd").isBlank()) {
		  		model.addAttribute("addressEndError", "Vui lòng nhập nơi đến!");
		  		errorCheck = true;
		  	}	  	
		  	
			
			if(errors.hasErrors() || errorCheck)
			{
				return "declaration/editDeclaration";
			}
			else
			{
			  Declaration declaration = (Declaration) session.getAttribute("declaration");
			  
			  Address addressPerson = declaration.getPersonalId().getIdAddress();
			  addressPerson.setAddressName(request.getParameter("addressPerson"));
			  updateAddress(addressPerson);
			 
			  updateUser(user);
			  System.out.println(addressPerson.getAddressName());
			  
			  
			  Address addressBegin = declaration.getStartAddressCode();
			  addressBegin.setAddressName(request.getParameter("addressBegin"));
			  updateAddress(addressBegin);
			  
			  Address addressEnd = declaration.getEndAddressCode();
			  addressEnd.setAddressName(request.getParameter("addressEnd"));
			  updateAddress(addressEnd);
			  
			  String dateStr = request.getParameter("date");
			  Date date = null;
			  try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
					System.out.println(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			  
			  declaration.setDate(date);
			  declaration.setNameVehicle(request.getParameter("vehicle"));
			  declaration.setPhone(user.getPhone());
			  updateDeclaration(declaration);
			}
		  return "redirect:/declaration-mgr.htm";
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
//	 model.addAttribute("message", "Báº¡n gá»�i delete()"); 
//	 return "declaration-mgr";
//	 }
//	 
//	 @RequestMapping(params = "btnReset") 
//	 public String reset(ModelMap model) {
//	 model.addAttribute("message", "Báº¡n gá»�i reset()"); 
//	 return "declaration-mgr"; }
//	 
//	 @RequestMapping(params = "lnkEdit") 
//	 public String edit(ModelMap model) {
//	 model.addAttribute("message", "Báº¡n gá»�i edit()"); 
//	 return "declaration-mgr"; }
	
}
