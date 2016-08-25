package whq.web;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import whq.model.User1;
import whq.service.imp.IUserService1;


@Controller
@RequestMapping("/My")
public class MyController {
	
	private IUserService1 userService1;

	public IUserService1 getUserService1() {
		return userService1;
	}
	@Resource
	public void setUserService1(IUserService1 userService1) {
		this.userService1 = userService1;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String test(HttpServletRequest req,Model model) {
		
		Cookie[] cookies = req.getCookies();
		//for(Cookie i:cookies){
		//	System.out.println(i.getValue());
		//}
		if(cookies != null){
			for(Cookie i:cookies){
					System.out.println(i.getValue());
				}
			//String userID = cookies[1].getValue();
			//String pw = cookies[2].getValue();
			//model.addAttribute("userID", userID);
			//model.addAttribute("pw", pw);
		}
		System.out.println("测试");
		return "login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String test1(HttpServletRequest req,HttpServletResponse res, int user_id,String password,HttpSession session) 
	{	
		System.out.println("工号"+user_id);
		System.out.println("密碼"+password);
		if(userService1==null){
			System.out.println("asdfds");
		}
		User1 u = userService1.login(user_id,password);
		if(u != null){
			String  getcook = req.getParameter("isLogin");
			if(getcook==null){
				System.out.println("不记住密码");
			}else{
				Cookie cookie1 = new Cookie("user_id",Integer.toString(u.getUser_id()));
				Cookie cookie2 = new Cookie("password", u.getPassword());
				res.addCookie(cookie1);
				res.addCookie(cookie2);
			}
		}
		
		session.setAttribute("name", u);//傳入繪畫
		
		//return "redirect:/File/upload";
		//return "redirect:/Down/load";
		return "main";
		//return "most/index";
	}
	
	/**
	 * 查看个人信息
	 * @return
	 */
	@RequestMapping(value="/findUserInfo")
	public String findUserInfo(HttpSession session) {
		
		System.out.println("查询用户信息");
		User1 u = (User1) session.getAttribute("name");
		if(u ==null){
			System.out.println("用户session 提取异常");
		}else{
			System.out.println(u.getPassword()+ "  "+u.getUser_id()+" "+u.getUser_name()+ " "+ u.getIsAdmin()+" "+u.getProfession());
		}	
		return "findUserInfo";
	}
	/**
	 * 文件上传
	 * @return
	 */
	@RequestMapping(value="/File/upload")
	public String search2() {
		
		System.out.println("文件上传");
		
		return "redirect:/File/upload";
	}
	
	/**
	 * 文件审核
	 * @return
	 */
	@RequestMapping(value="/Down/shenhe")
	public String search3() {
		
		System.out.println("文件审核");
		
		return "redirect:/Down/shenhe";
	}
	/**
	 * 文件下载
	 * @return
	 */
	@RequestMapping(value="/Down/download")
	public String search4() {
		
		System.out.println("文件下载");
		
		return "redirect:/Down/downloadfiles";
	}
	

}
