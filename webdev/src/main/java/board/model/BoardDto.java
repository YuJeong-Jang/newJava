package board.model;

import java.sql.Date;

public class BoardDto {	//DTO(Data Transfer Object)
						//레코드를 한번에 담아서 한번에 이동하려는 객체(DAO와 다른거)
						// = VO(Value Object)
	private Long no;			// long no;
	private String title;
	private String name;
	private String password;
	private String content;
	private Date writeDay;
	private Integer readCount;	// int readCount;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDay() {
		return writeDay;
	}
	public void setWriteDay(Date writeDay) {
		this.writeDay = writeDay;
	}
	public Integer getReadCount() {
		return readCount;
	}
	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}
	@Override
	public String toString() {
		return "BoardDto [no=" + no + ", title=" + title + ", name=" + name + ", password=" + password + ", content="
				+ content + ", writeDay=" + writeDay + ", readCount=" + readCount + "]";
	}
}
