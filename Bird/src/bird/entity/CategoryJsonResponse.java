package bird.entity;

import java.util.Map;

public class CategoryJsonResponse
{

    private String status;
    private Map errorsMap;
    private Category category;

    public CategoryJsonResponse()
    {
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Map getErrorsMap()
    {
        return errorsMap;
    }

    public void setErrorsMap(Map errorsMap)
    {
        this.errorsMap = errorsMap;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }
}
