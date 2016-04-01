package xpadro.thymeleaf.controller;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import xpadro.thymeleaf.model.Guest;
import xpadro.thymeleaf.model.Pager;
import xpadro.thymeleaf.service.GuestService;
import xpadro.thymeleaf.service.HotelService;

@Controller
public class GuestController {
	private static final int BUTTONS_TO_SHOW = 5;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = {3, 5, 10, 20 };

	//@Autowired
	private GuestService guestService;

	@Autowired
	public GuestController(GuestService studentService) {
		this.guestService = studentService;
	}
	
	@Autowired
	private HotelService hotelService;
	
	@RequestMapping(value = "/guest", method = RequestMethod.GET)
	public ModelAndView showPersonsPage(@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "page", required = false) Integer page) {
		ModelAndView modelAndView = new ModelAndView("guests");

		// Evaluate page size. If requested parameter is null, return initial
		// page size
		int evalPageSize = pageSize == null ? INITIAL_PAGE_SIZE : pageSize;
		// Evaluate page. If requested parameter is null or less than 0 (to
		// prevent exception), return initial size. Otherwise, return value of
		// param. decreased by 1.
		int evalPage = (page == null || page < 1) ? INITIAL_PAGE : page - 1;

		//guestService.deleteAll();
		List<Guest> lg =  hotelService.getGuestsList();
		for (Iterator<Guest> iterator = lg.iterator(); iterator.hasNext();) {
			Guest guest = (Guest) iterator.next();
			System.out.println(guest.getName());
		}
		guestService.save(lg);

		
		Page<Guest> guests = guestService.findAllPageable(new PageRequest(evalPage, evalPageSize));
		Pager pager = new Pager(guests.getTotalPages(), guests.getNumber(), BUTTONS_TO_SHOW);

		modelAndView.addObject("guests", guests);
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		return modelAndView;
	}

	@RequestMapping(value = "/guest/ajax", method = RequestMethod.GET)
	public String showPersonsPageAjax(Model model,@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "page", required = false) Integer page) {
		//ModelAndView modelAndView = new ModelAndView("persons");

		// Evaluate page size. If requested parameter is null, return initial
		// page size
		int evalPageSize = pageSize == null ? INITIAL_PAGE_SIZE : pageSize;
		// Evaluate page. If requested parameter is null or less than 0 (to
		// prevent exception), return initial size. Otherwise, return value of
		// param. decreased by 1.
		int evalPage = (page == null || page < 1) ? INITIAL_PAGE : page - 1;

		Page<Guest> guests = guestService.findAllPageable(new PageRequest(evalPage, evalPageSize));
		Pager pager = new Pager(guests.getTotalPages(), guests.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("guests", guests);
		model.addAttribute("selectedPageSize", evalPageSize);
		model.addAttribute("pageSizes", PAGE_SIZES);
		model.addAttribute("pager", pager);
		return "guests :: resultsList";
	}
}
