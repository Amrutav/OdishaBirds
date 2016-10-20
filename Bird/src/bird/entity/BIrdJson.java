package bird.entity;

import java.util.Map;

public class BIrdJson {
	
	private String status;
    private Map errorsMap;
    private BIrd bird;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Map getErrorsMap() {
		return errorsMap;
	}
	public void setErrorsMap(Map errorsMap) {
		this.errorsMap = errorsMap;
	}
	public BIrd getBird() {
		return bird;
	}
	public void setBird(BIrd bird) {
		this.bird = bird;
	}
}
