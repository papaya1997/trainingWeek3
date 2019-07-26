package com.visa.prj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.SearchCriteria;
import com.visa.prj.services.BookingService;

@Controller
public class HotelController {
	@Autowired
	private BookingService service;
	
	@RequestMapping("search.do")
	public String getSearchForm(Model m) {
		m.addAttribute("searchCriteria", new SearchCriteria());
		return "searchForm.jsp";
	}
	
	@RequestMapping("hotels.do")
	public String fetchHotels(@ModelAttribute("searchCriteria") SearchCriteria criteria, Model m) {
		m.addAttribute("hotelList", service.findHotels(criteria.getSearchString()));
		return "searchResults.jsp";
	}
	
	@RequestMapping("viewHotel.do")
	public String viewHotelDetails(@RequestParam("id") long id, Model m) {
		Hotel h = service.findHotelById(id);
		m.addAttribute("hotel",h);
		return "showHotel.jsp";
	} 
}
