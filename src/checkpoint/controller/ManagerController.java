package checkpoint.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import checkpoint.entity.PersonalInfor;

@Controller
public class ManagerController {
	@RequestMapping("/declaration")
	public String showForm(@ModelAttribute("user") PersonalInfor user) {
		return "declaration/form";
	}
	@RequestMapping(value="declaration/form", method=RequestMethod.POST)
	public String saveData(HttpServletRequest request) {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("");
		String IDCard = request.getParameter("IDCard");
		String date = request.getParameter("date");
		
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("IDCard", IDCard);
		request.setAttribute("date", date);
	
		return "declaration/succes";
	}
	

}
