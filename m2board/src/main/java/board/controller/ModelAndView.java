package board.controller;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
	private Map<String, Object> model = new HashMap<String, Object>();	//Model에서 처리한 결과 데이터를 담기 위한 Map
	private String viewName;	//다음 view의 경로를 저장하기 위한 변수
	
	public ModelAndView() {}	//기본 생성자
	
	public ModelAndView(String viewName) {	//생성자 오버로딩1
		setViewName(viewName);
	}
	
	public ModelAndView(String viewName, String key, Object obj) {	//생성자 오버로딩2
		setViewName(viewName);
		addObject(key, obj);
	}
	
	public Map<String, Object> getModel() {
		return model;
	}
	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
	public void addObject(String key, Object obj) {	//model 맵에 key와 value를 저장하기 위한 메소드
		model.put(key, obj);
	}
	
	@Override
	public String toString() {
		return "ModelAndView [model=" + model + ", viewName=" + viewName + "]";
	}
}
