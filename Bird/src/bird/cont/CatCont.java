package bird.cont;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bird.entity.Category;
import bird.entity.CategoryJsonResponse;
import bird.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CatCont
{

    @Autowired
	CategoryService categoryServices;
    private MessageSource messages;
    private boolean flag;
    static final Logger logger = Logger.getLogger(Category.class);

    @RequestMapping(value="/addCategory")
    public @ResponseBody CategoryJsonResponse addCategory(@Valid @RequestBody Category category, BindingResult bindingResult)
    {
        CategoryJsonResponse categoryJsonResponse;
        categoryJsonResponse = new CategoryJsonResponse();
        System.out.println("Controller Body");
        if(bindingResult.hasErrors()){
        	Map<String, String> errors = new HashMap<String, String>();
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for(FieldError fieldError : fieldErrors){
				String[] resolveMessageCodes = bindingResult.resolveMessageCodes(fieldError.getCode());
				String string = resolveMessageCodes[0];
				logger.debug("resolveMessageCodes: "+string);
				String message = messages.getMessage(string+"."+fieldError.getField(), new Object[]{fieldError.getRejectedValue()}, null);
				logger.debug("Message"+message);
				errors.put(fieldError.getField(), message);
            }

            categoryJsonResponse.setErrorsMap(errors);
            categoryJsonResponse.setCategory(category);
            categoryJsonResponse.setStatus("ERROR");
            return categoryJsonResponse;
        }else {
        	try{
        	boolean flag = categoryServices.addCategory(category);
            if(flag){
                categoryJsonResponse.setStatus("SUCCESS");
            } else{
                categoryJsonResponse.setStatus("FAILED");
            }
            return categoryJsonResponse;
        	}
		catch (Exception e) {
			// TODO: handle exception
			categoryJsonResponse.setStatus(e.toString());
	        logger.error("Exception Occurs in : ", e);
		}
        return categoryJsonResponse;
    }
   }

    @RequestMapping(value="/categoryList",method=RequestMethod.GET)
    public @ResponseBody List<Category> getCategoryList()
    {
        List<Category> categoryList = new ArrayList<Category>();
        try{
            System.out.println("HELLO");
            categoryList = categoryServices.getCategoryList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return categoryList;
    }
    
    @RequestMapping(value = "/validateCat", method = RequestMethod.GET)
	public @ResponseBody CategoryJsonResponse validateCategory( @RequestParam(value = "categoryName") String catName) {
    	CategoryJsonResponse catJsonResponse=new CategoryJsonResponse();
	    try {
	        Category category = categoryServices.validateCategory(catName);
	        if(category!=null){
	        	catJsonResponse.setStatus("EXIST");
	        }else{
	        	catJsonResponse.setStatus("NOT EXIST");
	        }
	    	return catJsonResponse;
	       } catch (Exception e) {
	    	logger.error("Exception occurs in", e);
	    	catJsonResponse.setStatus(e.toString());
	    }
	   	return catJsonResponse;
	}
    
    @RequestMapping(value = "/deleteCategory", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CategoryJsonResponse deleteCategory(@Valid @RequestBody Category category){
    	CategoryJsonResponse categoryJsonResponse = new CategoryJsonResponse();
		System.out.println(category.getCategoryId());
		try{
			flag = categoryServices.deleteCategory(category);
			if(flag){
				categoryJsonResponse.setStatus("SUCCESS");
			}else{
				categoryJsonResponse.setStatus("FAILED");
			}
			return categoryJsonResponse;
		}catch (Exception e) {
			categoryJsonResponse.setStatus(e.toString());
			logger.error("Exception Occurs in : ", e);
		}
		return categoryJsonResponse;
	}
    
  //Category By Category Id
	
  	@RequestMapping(value = "/categoryListById", method = RequestMethod.GET)
  	public @ResponseBody List<Category> getCategoryListById(@RequestParam(value = "categoryId") int categoryId){
  		List<Category> categoryListById = new ArrayList<Category>();
  		String name=null;
  		try {
  			System.out.println("HELLO");
  			categoryListById = categoryServices.getCategoryListById(categoryId);
  		} catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		return categoryListById;
  	}
  	
  	
  	@RequestMapping(value="/updateCategory", method=RequestMethod.POST)
    public @ResponseBody CategoryJsonResponse updateCategory(@Valid @RequestBody Category category, BindingResult bindingResult)
    {
  		CategoryJsonResponse categoryJsonResponse;
        categoryJsonResponse = new CategoryJsonResponse();
        System.out.println("Controller Body");
        if(bindingResult.hasErrors()){
        	Map<String, String> errors = new HashMap<String, String>();
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for(FieldError fieldError : fieldErrors){
				String[] resolveMessageCodes = bindingResult.resolveMessageCodes(fieldError.getCode());
				String string = resolveMessageCodes[0];
				logger.debug("resolveMessageCodes: "+string);
				String message = messages.getMessage(string+"."+fieldError.getField(), new Object[]{fieldError.getRejectedValue()}, null);
				logger.debug("Message"+message);
				errors.put(fieldError.getField(), message);
            }

            categoryJsonResponse.setErrorsMap(errors);
            categoryJsonResponse.setCategory(category);
            categoryJsonResponse.setStatus("ERROR");
            return categoryJsonResponse;
        }else {
        	try{
        	boolean flag = categoryServices.addCategory(category);
            if(flag){
                categoryJsonResponse.setStatus("SUCCESS");
            } else{
                categoryJsonResponse.setStatus("FAILED");
            }
            return categoryJsonResponse;
        	}
		catch (Exception e) {
			// TODO: handle exception
			categoryJsonResponse.setStatus(e.toString());
	        logger.error("Exception Occurs in : ", e);
		}
        return categoryJsonResponse;
    }
}
}
