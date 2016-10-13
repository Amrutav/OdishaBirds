package bird.entity;

import java.util.Map;

public class BirdJsonResponse
{

    private String status;
    private Map errorsMap;
    private Bird bird;

    public BirdJsonResponse()
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

    public Bird getBird()
    {
        return bird;
    }

    public void setBird(Bird bird)
    {
        this.bird = bird;
    }
}
