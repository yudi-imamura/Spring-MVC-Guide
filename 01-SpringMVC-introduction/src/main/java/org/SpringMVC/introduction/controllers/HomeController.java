package org.SpringMVC.introduction.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Yudi Imamura
 * @version 1.0
 * @since 28-08-2018 This class is responsible to monitor the whole flow of
 *        redirection to pages, validation of business rules and information
 *        should be generated in the data coming from the View layer to Model
 *        layer
 **/
@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		System.out.println("Carregado");
		return "home";
	}

	/**
	 * @since 28-08-2018
	 * @return a ModelAndView Object with multiple object coming from model this
	 *         method takes the date coming from view and calculate the Life of time
	 *         in
	 *         Years,Months,weeks,days,hours,minutes,seconds,miliseconds,nanoseconds
	 *         at today.
	 **/
	@RequestMapping("generate")
	public ModelAndView getAgeComplete(@RequestParam("birthday") String c) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse(c);

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(d);

		ModelAndView mv = new ModelAndView();
		LocalDate ld1 = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
				calendar.get(Calendar.DAY_OF_MONTH));
		LocalDate ld2 = LocalDate.now();

		long years = ChronoUnit.YEARS.between(ld1, ld2);
		long months = ChronoUnit.MONTHS.between(ld1, ld2);
		long weeks = ChronoUnit.WEEKS.between(ld1, ld2);
		long days = ChronoUnit.DAYS.between(ld1, ld2);

		mv.addObject("year", years);
		mv.addObject("months", months);
		mv.addObject("weeks", weeks);
		mv.addObject("days", days);

		mv.setViewName("result");
		return mv;
	}

}
