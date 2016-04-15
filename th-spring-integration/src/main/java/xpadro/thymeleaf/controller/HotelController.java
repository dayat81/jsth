package xpadro.thymeleaf.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import xpadro.thymeleaf.exception.GuestFoundException;
import xpadro.thymeleaf.model.Guest;
import xpadro.thymeleaf.model.HotelData;
import xpadro.thymeleaf.service.HotelService;

@Controller
public class HotelController {
	private static final String HOME_VIEW = "home";
	private static final String RESULTS_FRAGMENT = "results :: resultsList";
	
	@Autowired
	private HotelService hotelService;
	
	@ModelAttribute("guest")
	public Guest prepareGuestModel() {
		return new Guest();
	}
	
	@ModelAttribute("hotelData")
	public HotelData prepareHotelDataModel() {
		return hotelService.getHotelData();
	}
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST) 
    public String importParse(@RequestParam("myFile") MultipartFile myFile) { 
         // ... do whatever you want with 'myFile' 
    	InputStream inputStream;
		try {
			inputStream = myFile.getInputStream();
		   	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			
	    	String line;
	    	while ((line = bufferedReader.readLine()) != null)
	    	{
	    	  // do your processing    
	    		System.out.println(line);
	    	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
         // Redirect to a successful upload page 
         return HOME_VIEW; 
    } 
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHome(Model model) {
		prepareHotelDataModel();
		prepareGuestModel();
		
		return HOME_VIEW;
	}
	
	
	@RequestMapping(value = "/guests/{surname}", method = RequestMethod.GET)
	public String showGuestList(Model model, @PathVariable("surname") String surname) {
		model.addAttribute("guests", hotelService.getGuestsList(surname));

		return RESULTS_FRAGMENT;
	}
	
	@RequestMapping(value = "/guests", method = RequestMethod.GET)
	public String showGuestList(Model model) {
		model.addAttribute("guests", hotelService.getGuestsList());

		return RESULTS_FRAGMENT;
	}
	
	@RequestMapping(value = "/guests/insert", method = RequestMethod.POST)
	public String insertGuest(Guest newGuest, Model model) {
		hotelService.insertNewGuest(newGuest);
		
		return showHome(model);
	}
	
	@ExceptionHandler({GuestFoundException.class})
	public ModelAndView handleDatabaseError(GuestFoundException e) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		modelAndView.addObject("errorMessage", "error.user.exist");
		modelAndView.addObject("guest", prepareGuestModel());
		modelAndView.addObject("hotelData", prepareHotelDataModel());
		
		return modelAndView;
	}
}
