package com.kuhniverse.web;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class DemoController {
	@RequestMapping(value="/api/hello", method=RequestMethod.GET)
	@ResponseBody
	public String getHello() {
		HelloWorldHandler handler = new HelloWorldHandler();
		return handler.getHello();
	}

	@RequestMapping(value="/api/magic", method=RequestMethod.GET)
	@ResponseBody
	public String getDoMagic() {
		DoMagicHandler handler = new DoMagicHandler();
		return handler.getDoMagic();
	}
}