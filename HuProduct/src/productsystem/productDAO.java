package productsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class productDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";

	private String id = "system";
	private String pass = "1111";
	private Connection conn = null;
	private static productDAO productdao=null;
	
	private productDAO() {
		init();
	}

	public static productDAO getInstance() {
		if(productdao == null) {
			productdao = new productDAO();
		}
		return productdao;
	}
	private Connection getConnection() {
		try {
			
			conn = DriverManager.getConnection(url,id,pass);
			System.out.println("연결성공");
		} catch (Exception e) {
			System.out.println("연결 실패");
			conn = null;
		}
		return conn;
	}
	private void init() {
		try {
			Class.forName(driver);
			System.out.println("클래스 load 성공");
		} catch (Exception e) {
			System.out.println("클래스 로드 실패");
			e.printStackTrace();
			
		}
	}
	
	public void insert(productDTO p) {
		PreparedStatement stmt = null;
		try {
			if(getConnection() != null) {
				String sql = "insert into product values('a',?,?,?,?,?,default,?)";
				
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, p.getProname());
				stmt.setString(2, p.getText());
				stmt.setInt(3, p.getPronum());
				stmt.setInt(4, p.getProprice());
				stmt.setString(5, p.getManager());
				stmt.setString(6, p.getTypeid1());
				
				int result = stmt.executeUpdate();
				System.out.println(result +"건 삽입");
				
			}
		}catch(Exception e) {
			
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public ArrayList<productDTO> selectAll(){
		ArrayList<productDTO> plist = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			if(getConnection() != null) {
				System.out.println("연결 성공");
                String sql = "select p.id, p.typeid1 ,p.proname,p.text,p.pronum,p.proprice,p.manager,p.orderDate,t.typename from product p join product2 t on p.typeid1 =t.typeid2";
                		
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    productDTO p = new productDTO();
                    p.setId(rs.getString("id"));
                    p.setTypeid1(rs.getString("typeid1"));
                    p.setProname(rs.getString("proname"));
                    p.setText(rs.getString("text"));
                    p.setPronum(rs.getInt("pronum"));
                    p.setProprice(rs.getInt("proprice"));
                    p.setManager(rs.getString("manager"));
                    p.setOrderDate(rs.getString("orderDate"));
                    p.setTypename(rs.getString("typename"));
                    plist.add(p);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return plist;
	}
	public void delete(String deletename) {
		PreparedStatement stmt = null;
		try {
			if(getConnection() != null) {
				String sql = "delete from product where proname = ? ";
				
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, deletename);
				
				int result = stmt.executeUpdate();
				System.out.println(result + "건 삭제");
			}
		}catch(Exception e) {
	
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void update(productDTO p) {
		PreparedStatement stmt = null;
				try {
					if(getConnection() != null) {
						String sql = "UPDATE product SET text = ?, pronum = ?, proprice = ?, manager = ?, "
						           + "typeid1 = ? WHERE proname = ?";
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, p.getText());
						stmt.setInt(2, p.getPronum());
						stmt.setInt(3, p.getProprice());
						stmt.setString(4, p.getManager());
						stmt.setString(5, p.getTypeid1());
						stmt.setString(6, p.getProname());
						
						int result = stmt.executeUpdate();
						System.out.println(result +"건 수정");
					}
				}catch (Exception e) {
					
				}finally {
					try {
						stmt.close();
						conn.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
	}
	public void relatedsearch(String proname) {
		PreparedStatement stmt = null;
		try {
			if(getConnection() != null) {
				String sql = "SELECT p.id, p.typeid1, p.proname, p.text, p.pronum, p.proprice, p.manager, p.orderDate, t.typename FROM product p JOIN product2 t ON p.typeid1 = t.typeid2 WHERE p.proname LIKE ? or p.text LIKE ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%" +proname + "%");
				stmt.setString(2, "%" + proname + "%");
				
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println(
							"id : " + rs.getString("id")+
							"제품 설명 : "+rs.getString("text")+
							"   제품 넘버 : "+rs.getString("pronum")+
							"   가격 : "+rs.getString("proprice")+
							"   담당자 : "+rs.getString("manager")+
							"   등록일 : "+rs.getDate("orderDate")+
							"   id타입 : "+rs.getString("typeid1")	
							);
					System.out.println("---------------------------------------------------------------------------------");
				}
			}
		}catch(Exception e) {
			
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
