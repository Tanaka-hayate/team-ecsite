package jp.co.internous.kabuki.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.kabuki.model.domain.MstDestination;
import jp.co.internous.kabuki.model.domain.MstUser;
import jp.co.internous.kabuki.model.form.DestinationForm;
import jp.co.internous.kabuki.model.mapper.MstDestinationMapper;
import jp.co.internous.kabuki.model.mapper.MstUserMapper;
import jp.co.internous.kabuki.model.session.LoginSession;

@Controller
@RequestMapping("/kabuki/destination")
public class DestinationController {
	
	@Autowired
	MstDestinationMapper mstDestinationMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	MstUserMapper mstUserMapper;
	private Gson gson=new Gson();
		
	@RequestMapping("/")
	public String index(Model m) {
		MstUser user=mstUserMapper.mstUser(loginSession.getUserId());
		m.addAttribute("familyName",user.getFamilyName());
		m.addAttribute("firstName",user.getFirstName());
		
		return "destination";
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public String register(@RequestBody DestinationForm f) {
		
		MstDestination mstDestination=new MstDestination(f);
		
		long userId = loginSession.getUserId();
		mstDestination.setUserId(userId);
		long count=mstDestinationMapper.insert(mstDestination);
		
		long id = 0;
		if (count > 0) {
			id = mstDestination.getId();
		}
		return Long.toString(id);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/delete")
	@ResponseBody
	public boolean delete(@RequestBody String destinationId) {
		
		Map<String, String> map = gson.fromJson(destinationId, Map.class);
		String id = map.get("destinationId");
		int result = mstDestinationMapper.delete(Long.parseLong(id));

		return result >0;
	}

}
