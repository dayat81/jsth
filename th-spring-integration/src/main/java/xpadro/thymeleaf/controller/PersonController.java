package xpadro.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import xpadro.thymeleaf.model.Pager;
import xpadro.thymeleaf.model.Person;
import xpadro.thymeleaf.service.PersonService;

/**
 * @author Branislav Lazic
 */
@Controller
public class PersonController {

	private static final int BUTTONS_TO_SHOW = 5;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = {3, 5, 10, 20 };

	private PersonService personService;

	@Autowired
	public PersonController(PersonService studentService) {
		this.personService = studentService;
	}

	/**
	 * Handles all requests
	 * 
	 * @param pageSize
	 * @param page
	 * @return model and view
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showPersonsPage(@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "page", required = false) Integer page) {
		ModelAndView modelAndView = new ModelAndView("persons");

		// Evaluate page size. If requested parameter is null, return initial
		// page size
		int evalPageSize = pageSize == null ? INITIAL_PAGE_SIZE : pageSize;
		// Evaluate page. If requested parameter is null or less than 0 (to
		// prevent exception), return initial size. Otherwise, return value of
		// param. decreased by 1.
		int evalPage = (page == null || page < 1) ? INITIAL_PAGE : page - 1;

		Page<Person> persons = personService.findAllPageable(new PageRequest(evalPage, evalPageSize));
		Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);

		modelAndView.addObject("persons", persons);
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		return modelAndView;
	}

	@RequestMapping(value = "/ajax", method = RequestMethod.GET)
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

		Page<Person> persons = personService.findAllPageable(new PageRequest(evalPage, evalPageSize));
		Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("persons", persons);
		model.addAttribute("selectedPageSize", evalPageSize);
		model.addAttribute("pageSizes", PAGE_SIZES);
		model.addAttribute("pager", pager);
		return "persons :: resultsList";
	}
}
