package checkpoint.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mailer/")
public class MailerController {
	@Autowired
	JavaMailSender mailer;

	@RequestMapping("form2")
	public String index() {
		return "mailer/form2";
	}

	@RequestMapping("send")
	public String send(ModelMap model, @RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("subject") String subject, @RequestParam("body") String body) {

		try {
			// Tạo mail
			MimeMessage mail = mailer.createMimeMessage();
			// Sử dụng lớp trợ giúp
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setFrom(from, from);
			helper.setTo(to);
			helper.setReplyTo(from, from);
			helper.setSubject(subject);
			helper.setText(body, true);

			// Gửi mail
			mailer.send(mail);
			model.addAttribute("message", "Gửi mail thành công!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("message", "Gửi mail thất bại!");
		}
		return "mailer/form2";
	}
}
