package productsystem;

import java.sql.Date;

public class productDTO {
	private String proname;
	private String text;
	private int pronum;
	private int proprice;
	private String manager;
	private String orderDate;
	private String typeid1;
	private String typeid2;
	private String type;
	private String typename;
	private String id;

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getPronum() {
		return pronum;
	}

	public void setPronum(int pronum) {
		this.pronum = pronum;
	}

	public int getProprice() {
		return proprice;
	}

	public void setProprice(int proprice) {
		this.proprice = proprice;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	
	

	public String getTypeid1() {
		return typeid1;
	}

	public void setTypeid1(String typeid1) {
		this.typeid1 = typeid1;
	}

	public String getTypeid2() {
		return typeid2;
	}

	public void setTypeid2(String typeid2) {
		this.typeid2 = typeid2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	

	

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public void prt() {
		System.out.println("--------------------------");
		System.out.println("id : "+this.id);
		System.out.println("제품명 : " + this.proname);
		System.out.println("설명 : " + this.text);
		System.out.println("수량 : "+this.pronum);
		System.out.println("단가 : " + this.proprice);
		System.out.println("담당자 : " + this.manager);
		System.out.println("등록일 : " + this.orderDate);
		System.out.println("타입 : " + this.typename);
		System.out.println("--------------------------");
	}
}
