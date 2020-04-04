package taller.ninja.demodocker.dto;

public class RespuestaApi{

	private String status;
	private Object body;
	
	public RespuestaApi() {}
	
	public RespuestaApi(String status, Object body) {
		this.status = status;
		this.body = body;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
}
