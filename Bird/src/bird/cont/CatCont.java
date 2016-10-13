package bird.cont;

import bird.entity.Category;

import bird.entity.CategoryJsonResponse;
import bird.service.CategoryService;
import java.util.*;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/category")
public class CatCont
{

    @Autowired
	CategoryService categoryServices;
    private MessageSource messages;
    static final Logger logger = Logger.getLogger(Category.class);

    @RequestMapping(value="/addCategory")
    public @ResponseBody CategoryJsonResponse addNewBoard(@Valid @RequestBody Category category, BindingResult bindingResult)
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

}
