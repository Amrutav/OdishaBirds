package bird.entity;

import java.util.Map;

public class BirdJsonResponse
{

    private String status;
    private Map errorsMap;
    private BirdDetail bird;

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

    public BirdDetail getBird()
    {
        return bird;
    }

    public void setBird(BirdDetail bird)
    {
        this.bird = bird;
    }
}
