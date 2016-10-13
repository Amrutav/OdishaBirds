package bird.entity;

import java.util.Map;

public class ImageJsonResponse
{

    private String status;
    private Map errorsMap;
    private Image image;

    public ImageJsonResponse()
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

    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }
}
